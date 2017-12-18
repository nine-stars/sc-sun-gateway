package com.iyb.ak.security;

import com.iyb.ak.entity.SecUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * SpringSecurity的工具类.
 * 
 * 注意. 本类只支持SpringSecurity 4.0.x.
 * 
 * @author fanjun
 */
public class SpringSecurityUtils {
	/**
	 * 取得当前用户, 返回值为SecUser对象, 如果当前用户未登录则返回null.
	 */
	public static SecUser getCurrentUser() {
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			return null;
		}

		Object principal = authentication.getPrincipal();
		if (!(principal instanceof SecUser)) {
			return null;
		}

		return (SecUser) principal;
	}

	/**
	 * 取得Authentication, 如当前SecurityContext为空时返回null.
	 */
	public static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return null;
		}

		return context.getAuthentication();
	}

	/**
	 * 获取当前用户的OAuth2AuthenticationDetails，其中可取到sessionId、remoteAddress、token
	 * @return
	 */
	public static OAuth2AuthenticationDetails getOauth2Details() {
		Authentication authentication = getAuthentication();

		if (authentication == null || authentication.getDetails() == null) {
			return null;
		}

		Object value = authentication.getDetails();
		if(value instanceof OAuth2AuthenticationDetails)
			return (OAuth2AuthenticationDetails)authentication.getDetails();
		else
			return null;
	}

	/**
	 * 获取当前用户的WebAuthenticationDetails，其中可取到sessionId、remoteAddress
	 * @return
	 */
	public static WebAuthenticationDetails getWebDetails() {
		Authentication authentication = getAuthentication();

		if (authentication == null || authentication.getDetails() == null) {
			return null;
		}

		Object value = authentication.getDetails();
		if(value instanceof WebAuthenticationDetails)
			return (WebAuthenticationDetails)authentication.getDetails();
		else
			return null;
	}
	
	/**
	 * 获取用户ID
	 * @return
	 */
	public static String getUserId(){
		String result=null;
		try {
			SecUser secUser = SpringSecurityUtils.getCurrentUser();
			if (secUser!=null) {
				result = secUser.getUuid();
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 取得当前用户的登录名, 如果当前用户未登录则返回空字符串.
	 */
	public static String getCurrentUserName() {
		Authentication authentication = getAuthentication();

		if (authentication == null || authentication.getPrincipal() == null) {
			return "";
		}

		return authentication.getName();
	}
}
