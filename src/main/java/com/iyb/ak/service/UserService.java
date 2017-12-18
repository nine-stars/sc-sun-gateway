package com.iyb.ak.service;


import com.iyb.ak.entity.User;
import com.iyb.ak.entity.dto.CompanyDto;
import com.iyb.ak.service.base.BaseService;

import java.util.List;


public interface UserService extends BaseService<User, String> {

    List<CompanyDto> getUserCompanies(String userUuid, boolean isAppLogin);

}