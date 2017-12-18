package com.iyb.ak.controller;

import com.iyb.ak.entity.base.Result;
import com.iyb.ak.entity.dto.CompanyDto;
import com.iyb.ak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/users")
public class UserController{
    @Autowired
    UserService userService;
//    @Autowired
//    UserRoleService userRoleService;



    @RequestMapping(value = "/is_ispuser", method = RequestMethod.GET)
    public Result<Boolean> isISPuser(@RequestParam("userUuid") String userUuid) {

        return Result.ofSuccess(false);
    }


    @RequestMapping(value = "/get_companies", method = RequestMethod.GET)
    public Result<List<CompanyDto>> getUserCompanies(@RequestParam("userUuid") String userUuid,
                                                     @RequestParam("isAppLogin") boolean isAppLogin) {
        return Result.ofSuccess(userService.getUserCompanies(userUuid, isAppLogin));
    }

}