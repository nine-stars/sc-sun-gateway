package com.iyb.ak.mapper;

import com.iyb.ak.entity.Permission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<Permission> getPermissionsByUser(@Param("userId") String userId,
                                          @Param("compId") String compId,
                                          @Param("versionId") String versionId);

}