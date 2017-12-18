package com.iyb.ak.security;

import com.google.common.collect.Sets;
import com.iyb.ak.constants.SecurityConstants;
import com.iyb.ak.entity.Permission;
import com.iyb.ak.entity.Role;
import com.iyb.ak.entity.SecUser;
import com.iyb.ak.entity.User;
import com.iyb.ak.mapper.PermissionMapper;
import com.iyb.ak.mapper.RoleMapper;
import com.iyb.ak.mapper.UserMapper;
import com.iyb.ak.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zhangshukang on 2017/12/13.
 */

@Component
public class SecurityComponent {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    public void login(Map<String, Object> profile) {
        String clientId = profile.get(SecurityConstants.CLIENT_ID).toString();
        SecUser secUser = BanbuSessionUtil.getUserInfo();

        User user = userMapper.selectByPrimaryKey(secUser.getUuid());

        accessAuth(profile, secUser.getUuid(), user.getCompUuid(), user.getUuid() == null ? "" : user.getUuid(), false);
    }


    private void accessAuth(Map<String, Object> profile, String userId, String compId, String emplId, boolean isAppLogin) {
        Set<String> roleCodes = Sets.newHashSet();
        Set<String> permissionCodes = Sets.newHashSet();
        Set<String> departments = Sets.newHashSet();
        if (StringUtils.isNotEmpty(compId)) {

            List<Role> roles = roleMapper.getRolesByUserId(userId, compId);
            roleCodes = roles.stream().map(x -> x.getRoleCode().toUpperCase()).collect(Collectors.toSet());


            List<Permission> permissions = permissionMapper.getPermissionsByUser(userId, compId, null);
            permissionCodes = permissions.stream().map(x -> x.getCode().toUpperCase()).collect(Collectors.toSet());


            if (profile != null) {
                if (StringUtils.isNotEmpty(compId)) {
                    profile.put(SecurityConstants.COMPUUID, compId);
                }
                if (emplId != null) {
                    profile.put(SecurityConstants.EMPL_UUID, emplId);
                }
                profile.put(SecurityConstants.ROLES, roleCodes);
                profile.put(SecurityConstants.PERMISSIONS, permissionCodes);
                profile.put(SecurityConstants.DEPARTMENTS, departments);
            } else {
                if (StringUtils.isNotEmpty(compId)) {
                    BanbuSessionUtil.setCurCompUuid(compId);
                }
                if (emplId != null) {
                    BanbuSessionUtil.setEmplUuid(emplId);
                }
                BanbuSessionUtil.setRoles(roleCodes);
                BanbuSessionUtil.setPermissions(permissionCodes);
                BanbuSessionUtil.setDepartments(departments);
            }
        }
    }
}
