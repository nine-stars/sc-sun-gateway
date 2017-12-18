package com.iyb.ak.service;


import com.iyb.ak.entity.Permission;
import com.iyb.ak.service.base.BaseService;

import java.util.List;

public interface PermissionService extends BaseService<Permission, String> {
    List<Permission> getByUser(String userId, String compId, String versionId);
}