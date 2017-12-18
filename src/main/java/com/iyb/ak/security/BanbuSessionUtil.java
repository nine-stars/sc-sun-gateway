package com.iyb.ak.security;

import com.iyb.ak.constants.SecurityConstants;
import com.iyb.ak.entity.SecUser;
import com.iyb.ak.exception.BusinessException;
import com.iyb.ak.utils.SpringUtils;
import com.iyb.ak.utils.StringUtils;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by yc096 on 2017/2/17.
 */
public class BanbuSessionUtil {

    public static SecUser getUserInfo() {
        return SpringSecurityUtils.getCurrentUser();
    }

    public static String getUserUuid() {
        return SpringSecurityUtils.getUserId();
    }

    public static String getCurCompUuid() {
        String compUuid = (String) getProfile(SecurityConstants.COMPUUID);
        if ("GLOBAL".equalsIgnoreCase(compUuid))
            return null;
        else
            return compUuid;
    }

    public static void setCurCompUuid(String compuuid) {
        setProfile(SecurityConstants.COMPUUID, compuuid);
    }

    public static String getCurCompName() {
        String compUuid = (String) getProfile(SecurityConstants.COMPUUID);
        if ("GLOBAL".equalsIgnoreCase(compUuid))
            return null;
        else {
            String compName = (String) getProfile(SecurityConstants.COMPNAME);
            return compName;
        }
    }

    public static void setCurCompName(String compName) {
        setProfile(SecurityConstants.COMPNAME, compName);
    }

    public static boolean isAppLogin(String... clientId) {
        Object clientid = (clientId != null && clientId.length > 0) ? clientId[0] : getProfile(SecurityConstants.CLIENT_ID);
        switch (clientid == null ? "" : clientid.toString()) {
            case SecurityConstants.CLIENT_ID_WEB:
                return false;
            case SecurityConstants.CLIENT_ID_ISP:
                return false;
            case SecurityConstants.CLIENT_ID_IOS:
                return true;
            case SecurityConstants.CLIENT_ID_ANDROID:
                return true;
            default:
                throw new BusinessException("error client_id", BanbuSessionUtil.class);
        }
    }

    public static void setEmplUuid(String emplUuid) {
        setProfile(SecurityConstants.EMPL_UUID, emplUuid);
    }

    public static String getEmplUuid() {
        return (String) getProfile(SecurityConstants.EMPL_UUID);
    }

    public static void setMultiCompany(boolean multiCompany) {
        setProfile(SecurityConstants.IS_MULTI_COMPANY, multiCompany);
    }

    public static Boolean getMultiCompany() {
        return (Boolean) getProfile(SecurityConstants.IS_MULTI_COMPANY);
    }

    public static Set<String> getRoles() {
        return (Set<String>) getProfile(SecurityConstants.ROLES);
    }

    public static void setRoles(Set<String> roles) {
        setProfile(SecurityConstants.ROLES, roles);
    }

    public static Set<String> getPermissions() {
        return (Set<String>) getProfile(SecurityConstants.PERMISSIONS);
    }

    public static void setPermissions(Set<String> perms) {
        setProfile(SecurityConstants.PERMISSIONS, perms);
    }

    public static Set<String> getDepartments() {
        return (Set<String>) getProfile(SecurityConstants.DEPARTMENTS);
    }

    public static void setDepartments(Set<String> depts) {
        setProfile(SecurityConstants.DEPARTMENTS, depts);
    }

    public static String getVersionUuid() {
        String version = (String) getProfile(SecurityConstants.VERSIONUUID);
        if (StringUtils.isBlank(version)) {
            throw new BusinessException("error.9995", BanbuSessionUtil.class);
        }
        return version;
    }

    public static void setVersionUuid(String versionUuid) {
        setProfile(SecurityConstants.VERSIONUUID, versionUuid);
    }

    public static String getVersionName() {
        String versionName = (String) getProfile(SecurityConstants.VERSIONNAME);
        return versionName;
    }

    public static void setVersionName(String versionName) {
        setProfile(SecurityConstants.VERSIONNAME, versionName);
    }

    private static final String REDIS_NAMESPACE = "token_profile:";
    private static final String LOGIN_NAMESPACE = "login_profile:";

    public static String getToken() {
        OAuth2AuthenticationDetails oa = SpringSecurityUtils.getOauth2Details();
        if (oa == null) return null;
        return oa.getTokenValue();
    }

    public static Object getProfile(String key) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        String token = getToken();
        if (StringUtils.isEmpty(token)) return null;
        RMap<String, Object> map = redisson.getMap(REDIS_NAMESPACE + token);
        return map.get(key);
    }

    public static void setProfile(String key, Object value) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        String token = getToken();
        if (!StringUtils.isEmpty(token)) {
            RMap<String, Object> map = redisson.getMap(REDIS_NAMESPACE + token);
            map.put(key, value);
        }
    }

    public static Object getLoginProfile(String loginId, String key) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        if (StringUtils.isEmpty(loginId)) return null;
        RMap<String, Object> map = redisson.getMap(LOGIN_NAMESPACE + loginId);
        return map.get(key);
    }

    public static void setLoginProfile(String loginId, String key, Object value, long seconds) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        if (!StringUtils.isEmpty(loginId)) {
            RMap<String, Object> map = redisson.getMap(LOGIN_NAMESPACE + loginId);
            map.put(key, value);
            map.expire(seconds, TimeUnit.SECONDS);
        }
    }

    public static void rmLoginProfileKey(String loginId, String key) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        if (!StringUtils.isEmpty(loginId)) {
            RMap<String, Object> map = redisson.getMap(LOGIN_NAMESPACE + loginId);
            map.remove(key);
        }
    }

    public static Map<String, Object> createProfile(String token, int timeout) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        if (StringUtils.isEmpty(token)) return null;
        RMap<String, Object> map = redisson.getMap(REDIS_NAMESPACE + token);
        map.put("loginDate", new Date());
        map.expire(timeout, TimeUnit.SECONDS);
        return map;
    }

    public static void removeProfile(String token) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        RKeys key = redisson.getKeys();
        key.delete(REDIS_NAMESPACE + token);
    }

    public static void removeProfile() {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
        RKeys key = redisson.getKeys();
        key.delete(REDIS_NAMESPACE + getToken());
    }

    public static void removeLoginProfile(String loginId) {
        RedissonClient redisson = SpringUtils.getBean(RedissonClient.class);
         RKeys key = redisson.getKeys();
        key.delete(LOGIN_NAMESPACE + loginId);
    }
}
