package com.iyb.ak.security;

import com.iyb.ak.constants.SecurityConstants;
import com.iyb.ak.utils.NumberUtils;
import com.iyb.ak.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpointAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fanjun on 2017/6/28.
 */
@Slf4j
public class SecurityTokenEndpointAuthenticationFilter extends TokenEndpointAuthenticationFilter {

    public SecurityTokenEndpointAuthenticationFilter(AuthenticationManager authenticationManager, OAuth2RequestFactory oAuth2RequestFactory) {
        super(authenticationManager, oAuth2RequestFactory);
    }

    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String remoteAddr = WebUtil.getRemoteAddr(request);
//        String username = request.getParameter("username");
        String sessionId = remoteAddr;//remoteAddr.concat(":").concat(username);

        BanbuSessionUtil.removeLoginProfile(sessionId);
        response.setHeader("jcaptchaNeed", "false");
    }

    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        String remoteAddr = WebUtil.getRemoteAddr(request);
//        String username = request.getParameter("username");
        String sessionId = remoteAddr;//remoteAddr.concat(":").concat(username);

        Object failureCount = BanbuSessionUtil.getLoginProfile(sessionId, SecurityConstants.CODE_JCAPTCHA_NEED);
        int count = 0;
        if (failureCount != null) {
            count = NumberUtils.getIntValue(failureCount);
        }
        BanbuSessionUtil.setLoginProfile(sessionId, SecurityConstants.CODE_JCAPTCHA_NEED, ++count, 60 * 3);

//        Boolean jcaptchaNeed = JCaptchaServiceImpl.getJcaptchaEbabled(sessionId);
        response.setHeader("jcaptchaNeed", "JD8a");
    }
}