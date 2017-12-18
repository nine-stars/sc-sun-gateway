package com.iyb.ak.entity;

import com.iyb.ak.entity.base.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_permission")
public class Permission extends BaseEntity{
    /**
     * 主键
     */
    @Id
    @Column(name = "UUID")
    private String uuid;

    /**
     * 权限编号
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 权限名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 是否可用:0-不可用;1-可用
     */
    @Column(name = "ENABLE")
    private Boolean enable;

    /**
     * 上级权限
     */
    @Column(name = "P_UUID")
    private String pUuid;

    /**
     * 权限等级:0-系统运维,2-业务管理
     */
    @Column(name = "PERMISSION_LEVEL")
    private Integer permissionLevel;

    @Column(name = "INSERT_USER")
    private String insertUser;

    /**
     * 创建时间
     */
    @Column(name = "INSERT_TIME")
    private Date insertTime;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "DELETE_FLAG")
    private Boolean deleteFlag;

    /**
     * 获取主键
     *
     * @return UUID - 主键
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置主键
     *
     * @param uuid 主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取权限编号
     *
     * @return CODE - 权限编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置权限编号
     *
     * @param code 权限编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取权限名称
     *
     * @return NAME - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否可用:0-不可用;1-可用
     *
     * @return ENABLE - 是否可用:0-不可用;1-可用
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * 设置是否可用:0-不可用;1-可用
     *
     * @param enable 是否可用:0-不可用;1-可用
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * 获取上级权限
     *
     * @return P_UUID - 上级权限
     */
    public String getpUuid() {
        return pUuid;
    }

    /**
     * 设置上级权限
     *
     * @param pUuid 上级权限
     */
    public void setpUuid(String pUuid) {
        this.pUuid = pUuid;
    }

    /**
     * 获取权限等级:0-系统运维,2-业务管理
     *
     * @return PERMISSION_LEVEL - 权限等级:0-系统运维,2-业务管理
     */
    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * 设置权限等级:0-系统运维,2-业务管理
     *
     * @param permissionLevel 权限等级:0-系统运维,2-业务管理
     */
    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    /**
     * @return INSERT_USER
     */
    public String getInsertUser() {
        return insertUser;
    }

    /**
     * @param insertUser
     */
    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    /**
     * 获取创建时间
     *
     * @return INSERT_TIME - 创建时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置创建时间
     *
     * @param insertTime 创建时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return UPDATE_USER
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return DELETE_FLAG
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}