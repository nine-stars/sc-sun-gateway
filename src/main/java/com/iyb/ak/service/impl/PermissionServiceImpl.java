package com.iyb.ak.service.impl;

import com.iyb.ak.entity.Permission;
import com.iyb.ak.mapper.PermissionMapper;
import com.iyb.ak.service.PermissionService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hezqi on 2017/6/26.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    @Getter
    PermissionMapper baseMapper;

    @Override
    public List<Permission> getByUser(String userId, String compId, String versionId) {
        List<Permission> entities = baseMapper.getPermissionsByUser(userId, compId, versionId);
        return entities;
    }
}