package com.iyb.ak.mapper;

import com.iyb.ak.entity.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {


    List<Map<String, String>> getMetaSource();

    List<Map<String, String>> getDefaultMetaSource(@Param("type") String type);

    List<Role> getRolesByUserId(@Param("userId") String userId,
                                @Param("compId") String compId);

}