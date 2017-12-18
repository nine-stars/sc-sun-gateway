package com.iyb.ak.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.Set;

@Slf4j
public class SecurityAccessDecisionManager implements AccessDecisionManager {

    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if (configAttributes != null) {
            for (ConfigAttribute ca : configAttributes) {
                String needRole = ca.getAttribute();

                //匿名用户可以访问
                if (needRole.equalsIgnoreCase("anonymous")) return;
                //登录用户可以访问
                if (needRole.equalsIgnoreCase("authenticated") && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal()))
                    return;
                //DenyAll,没有操作权限
                if (needRole.equalsIgnoreCase("denyAll")) break;

                //authority 为当前用户的权限, needRole 为访问相应的资源应该具有的权限。
                try {
                    //选择公司后，用户才有对应权限
                    Set<String> authorities = BanbuSessionUtil.getPermissions();
                    if (authorities != null) {
                        for (String authority : authorities) {
                            if (StringUtils.endsWithIgnoreCase(authority, needRole)) {
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                    log.error("获取用户权限失败：" + e.getMessage(), e);
                }
            }
        }
        String url = "";
        if (object instanceof FilterInvocation) {
            FilterInvocation filterInvocation = (FilterInvocation) object;
            url = filterInvocation.getRequestUrl();
        }
        throw new AccessDeniedException("您没有权限操作该功能:{userId=" + SpringSecurityUtils.getUserId() + ",url=" + url + "}");
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
}
