package com.iyb.ak.entity;

import com.iyb.ak.entity.base.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_permission_api")
public class PermissionApi extends BaseEntity{
    /**
     * 主键
     */
    @Id
    @Column(name = "UUID")
    private String uuid;

    /**
     * api主键
     */
    @Column(name = "API_UUID")
    private String apiUuid;

    /**
     * 权限主键
     */
    @Column(name = "PERMISSION_UUID")
    private String permissionUuid;

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
     * 获取api主键
     *
     * @return API_UUID - api主键
     */
    public String getApiUuid() {
        return apiUuid;
    }

    /**
     * 设置api主键
     *
     * @param apiUuid api主键
     */
    public void setApiUuid(String apiUuid) {
        this.apiUuid = apiUuid;
    }

    /**
     * 获取权限主键
     *
     * @return PERMISSION_UUID - 权限主键
     */
    public String getPermissionUuid() {
        return permissionUuid;
    }

    /**
     * 设置权限主键
     *
     * @param permissionUuid 权限主键
     */
    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid;
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