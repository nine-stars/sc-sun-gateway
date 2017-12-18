package com.iyb.ak.service.impl;
import com.iyb.ak.entity.User;
import com.iyb.ak.entity.dto.CompanyDto;
import com.iyb.ak.mapper.UserMapper;
import com.iyb.ak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by hezqi on 2017/6/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<CompanyDto> getUserCompanies(String userUuid, boolean isAppLogin) {
        return null;
    }

    @Override
    public Mapper<User> getBaseMapper() {
        return userMapper;
    }
}