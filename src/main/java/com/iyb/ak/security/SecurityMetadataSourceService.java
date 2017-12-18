package com.iyb.ak.security;

import com.google.common.collect.Lists;
import com.iyb.ak.dto.UrlDto;
import com.iyb.ak.mapper.RoleMapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 此类在初始化时，应该取到所有资源及其对应权限的定义。
 *
 * @author fanjun
 */
//@Component
public class SecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private static List<UrlDto> resourceMap = Lists.newArrayList();
    private static List<UrlDto> defaultMap = Lists.newArrayList();
    private static List<UrlDto> holdUpMap = Lists.newArrayList();

    @Autowired
    private RoleMapper roleMapper;

    public synchronized void loadMetadataSource() {
        try {

            // 加载默认策略
            List<Map<String, String>> defaultMetaSources = roleMapper.getDefaultMetaSource("0");
            defaultMap = parseMetaSource(defaultMetaSources);
            defaultMap.stream().forEach(x->{
                System.out.println("加载默认策略：url:"+x.getUrl()+"------>permissions:"+x.getPermissions().size()+"------>method："+x.getMethod());
            });
            System.out.println("-----------------------------");


            // 加载API策略
            List<Map<String, String>> permsMetaSources = roleMapper.getMetaSource();
            resourceMap = parseMetaSource(permsMetaSources);

            resourceMap.stream().forEach(x->{
                System.out.println("加载API策略：url:"+x.getUrl()+"------>permissions:"+x.getPermissions().size()+"------>method："+x.getMethod());
            });
            System.out.println("-----------------------------");


            // 加载兜底策略
            List<Map<String, String>> holdUpMetaSources = roleMapper.getDefaultMetaSource("1");
            holdUpMap = parseMetaSource(holdUpMetaSources);
            holdUpMap.stream().forEach(x->{
                System.out.println("加载兜底策略：url:"+x.getUrl()+"------>permissions:"+x.getPermissions().size()+"------>method："+x.getMethod());
            });

        } catch (Exception e) {
            log.error("访问策略加载失败.", e);
        }

        log.info("loadMetadataSource finish.");
    }

    // 根据URL，找到相关的权限配置。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (holdUpMap.size() == 0 && defaultMap.size() == 0 && resourceMap.size() == 0) {
            loadMetadataSource();
        }

        FilterInvocation filterInvocation = (FilterInvocation) object;
        HttpServletRequest httpRequest = filterInvocation.getHttpRequest();


        // 兜底策略
        for (UrlDto url : holdUpMap) {
            RequestMatcher requestMatcher = new AntPathRequestMatcher(url.getUrl(), url.getMethod());
            if (requestMatcher.matches(httpRequest)) {
                // TODO 用于检验通过/v1/co/**放行的url，以便在T_API表中配置，将来需要删除
                if (httpRequest.getRequestURI().startsWith("/v1/co/"))
                    log.debug("URL PERM - URL:{} ; Method:{}", httpRequest.getRequestURI(), httpRequest.getMethod());
                return convertCollection(url.getPermissions());
            }
        }

        return Lists.newArrayList();
    }

    private Collection<ConfigAttribute> convertCollection(Set<String> list) {
        Collection<ConfigAttribute> result = list.stream().map(SecurityConfig::new).collect(Collectors.toList());
        return result;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }



    private List<UrlDto> parseMetaSource(List<Map<String, String>> metaSources) {
        Map<String, Set<String>> methodPerms = new LinkedHashMap<>();
        //url=url-1  methods=GET,PUT  perms=EMPL_EXPORT,ATTE_CONF
        for (Map<String, String> metaSource : metaSources) {

            String url = metaSource.get("url");
            if ("/v1/co/*/socialFund-scheme/**".equals(url)) {
                System.out.println(url);
            }


            String methods = metaSource.get("methods") == null ? "" : metaSource.get("methods");
            for (String method : methods.split(",")) {
                String key = url.concat(",").concat(method);
                Set<String> perms = null;
                if (methodPerms.containsKey(key)) {
                    perms = methodPerms.get(key);
                } else {
                    perms = new HashSet<>();
                    methodPerms.put(key, perms);
                }
                String permsStr = metaSource.get("perms");
                CollectionUtils.addAll(perms, permsStr.split(","));
            }
        }
        List<UrlDto> urlDtos = new ArrayList<>();
        for (String key : methodPerms.keySet()) {
            UrlDto urlDto = new UrlDto();
            urlDto.setUrl(key.split(",")[0]);
            urlDto.setMethod(key.split(",").length > 1 ? key.split(",")[1] : "");
            urlDto.setPermissions(methodPerms.get(key));
            urlDtos.add(urlDto);
        }
        return urlDtos;
    }

    /**
     * 刷新 url-权限 缓存
     */
    public void refreshMetaSource() {
        loadMetadataSource();
    }
}
