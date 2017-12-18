package com.iyb.ak.entity.dto;

import lombok.Data;



@Data
public class CompanyDto {
    private String uuid;
    //营业执照全称
    private String realName;
    private String nickName;
    //公司认证状态
    private String reviewFlg;
    //公司员工数量
    private int empCount;
    //当前用户在公司角色
    private String roleName;
}