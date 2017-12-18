package com.iyb.ak.config;

import com.iyb.ak.security.BanbuTokenServices;
import com.iyb.ak.security.SecurityAccessDecisionManager;
import com.iyb.ak.security.SecurityMetadataSourceService;
import com.iyb.ak.security.SecurityTokenEndpointAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.sql.DataSource;

@Configuration
public class OAuth2ServerConfig {
    private static final String RESOURCE_ID = "banbu_v3";

    //配置授权资源路径
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(RESOURCE_ID);
        }

        @Bean
        public SecurityAccessDecisionManager accessDecisionManager() {
            return new SecurityAccessDecisionManager();
        }

        @Bean
        public SecurityMetadataSourceService securityMetadataSource() {
            SecurityMetadataSourceService metaSource = new SecurityMetadataSourceService();
            return metaSource;
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.requestMatchers().antMatchers("/**")
                    .and()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                        public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                            fsi.setAccessDecisionManager(accessDecisionManager());
                            fsi.setSecurityMetadataSource(securityMetadataSource());
                            return fsi;
                        }
                    });
            // @formatter:on
        }
    }


    //配置授权服务
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        @Qualifier(value = "authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Autowired
        private DataSource dataSource;

        private OAuth2RequestFactory oAuth2RequestFactory;

        @Bean
        public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }

        @Bean
        public ClientDetailsService clientDetailsService() {
            return new JdbcClientDetailsService(dataSource);
        }

        @Bean
        protected AuthorizationCodeServices authorizationCodeServices() {
            return new JdbcAuthorizationCodeServices(dataSource);
        }

        @Autowired
        private UserDetailsService userDetailsService;


        /*配置授权服务器的安全性，这实际上意味着/ oauth / token端点。/ oauth / authorize端点也需要安全，但这是一个正常的面向用户的端点，
        应该与您的UI的其余部分保持一致，所以这里不在这里。默认设置涵盖了最常见的要求，遵循OAuth2规范的建议，因此您无需在此处执行任何操作即可使基本服务器正常运行。*/
        //声明安全约束，哪些允许访问，哪些不允许访问
        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.allowFormAuthenticationForClients();
            oauthServer.addTokenEndpointAuthenticationFilter(new SecurityTokenEndpointAuthenticationFilter(authenticationManager, oAuth2RequestFactory));
        }

        /*配置ClientDetailsService，例如声明个别客户端及其属性。请注意，密码授予未启用（即使允许某些客户端），
        除非AuthenticationManager提供给AuthorizationServerConfigurer.configure(AuthorizationServerEndpointsConfigurer)。
        ClientDetailsService必须声明至少一个客户端或完全形成的自定义，否则服务器将无法启动。*/
        /*在ClientDetailsServiceConfigurer类里面进行配置，可以有in-memory、jdbc等多种读取方式。
        jdbc需要调用JdbcClientDetailsService类，此类需要传入相应的DataSource.*/
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.jdbc(dataSource).clients(clientDetailsService());
        }

        /*配置授权服务器端点的非安全功能，如令牌存储，令牌自定义，用户批准和授权类型。默认情况下，
        您不需要执行任何操作，除非您需要密码授权，否则您需要提供密码AuthenticationManager。*/
        /*声明授权和token的端点以及token的服务的一些配置信息，比如采用什么存储方式、token的有效期等*/
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager);
            endpoints.tokenStore(tokenStore());
            endpoints.userDetailsService(userDetailsService);
            endpoints.tokenServices(tokenServices());
            oAuth2RequestFactory = endpoints.getOAuth2RequestFactory();
        }

        @Bean
        @Primary
        public BanbuTokenServices tokenServices() {
            BanbuTokenServices tokenServices = new BanbuTokenServices();
            tokenServices.setTokenStore(tokenStore());
            tokenServices.setSupportRefreshToken(true);
            tokenServices.setClientDetailsService(clientDetailsService());
            return tokenServices;
        }
    }
}
