package com.iyb.ak.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_role")
public class UserRole {
    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "COMP_UUID")
    private String compUuid;

    @Column(name = "USER_UUID")
    private String userUuid;

    @Column(name = "ROLE_UUID")
    private String roleUuid;

    /**
     * 员工编号
     */
    @Column(name = "EMPL_UUID")
    private String emplUuid;

    /**
     * 启/禁标示,0:启用;1:禁用
     */
    @Column(name = "ON_OFF_FLAG")
    private String onOffFlag;

    /**
     * 关联状态:0未关联;1已关联;
     */
    @Column(name = "RELA_STATUS")
    private String relaStatus;

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
     * @return UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return COMP_UUID
     */
    public String getCompUuid() {
        return compUuid;
    }

    /**
     * @param compUuid
     */
    public void setCompUuid(String compUuid) {
        this.compUuid = compUuid;
    }

    /**
     * @return USER_UUID
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * @param userUuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * @return ROLE_UUID
     */
    public String getRoleUuid() {
        return roleUuid;
    }

    /**
     * @param roleUuid
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    /**
     * 获取员工编号
     *
     * @return EMPL_UUID - 员工编号
     */
    public String getEmplUuid() {
        return emplUuid;
    }

    /**
     * 设置员工编号
     *
     * @param emplUuid 员工编号
     */
    public void setEmplUuid(String emplUuid) {
        this.emplUuid = emplUuid;
    }

    /**
     * 获取启/禁标示,0:启用;1:禁用
     *
     * @return ON_OFF_FLAG - 启/禁标示,0:启用;1:禁用
     */
    public String getOnOffFlag() {
        return onOffFlag;
    }

    /**
     * 设置启/禁标示,0:启用;1:禁用
     *
     * @param onOffFlag 启/禁标示,0:启用;1:禁用
     */
    public void setOnOffFlag(String onOffFlag) {
        this.onOffFlag = onOffFlag;
    }

    /**
     * 获取关联状态:0未关联;1已关联;
     *
     * @return RELA_STATUS - 关联状态:0未关联;1已关联;
     */
    public String getRelaStatus() {
        return relaStatus;
    }

    /**
     * 设置关联状态:0未关联;1已关联;
     *
     * @param relaStatus 关联状态:0未关联;1已关联;
     */
    public void setRelaStatus(String relaStatus) {
        this.relaStatus = relaStatus;
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