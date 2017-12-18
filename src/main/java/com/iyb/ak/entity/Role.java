package com.iyb.ak.entity;

import com.iyb.ak.entity.base.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_role")
public class Role extends BaseEntity{
    /**
     * 主键
     */
    @Id
    @Column(name = "UUID")
    private String uuid;

    /**
     * 公司主键
     */
    @Column(name = "COMP_UUID")
    private String compUuid;

    /**
     * 角色编号
     */
    @Column(name = "ROLE_CODE")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 0-系统运维,2-集团管理员,4-公司管理员,16-普通角色。低级的角色不能给他人设置高等级的角色。
     */
    @Column(name = "ROLE_LEVEL")
    private Short roleLevel;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

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
     * 获取公司主键
     *
     * @return COMP_UUID - 公司主键
     */
    public String getCompUuid() {
        return compUuid;
    }

    /**
     * 设置公司主键
     *
     * @param compUuid 公司主键
     */
    public void setCompUuid(String compUuid) {
        this.compUuid = compUuid;
    }

    /**
     * 获取角色编号
     *
     * @return ROLE_CODE - 角色编号
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编号
     *
     * @param roleCode 角色编号
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取0-系统运维,2-集团管理员,4-公司管理员,16-普通角色。低级的角色不能给他人设置高等级的角色。
     *
     * @return ROLE_LEVEL - 0-系统运维,2-集团管理员,4-公司管理员,16-普通角色。低级的角色不能给他人设置高等级的角色。
     */
    public Short getRoleLevel() {
        return roleLevel;
    }

    /**
     * 设置0-系统运维,2-集团管理员,4-公司管理员,16-普通角色。低级的角色不能给他人设置高等级的角色。
     *
     * @param roleLevel 0-系统运维,2-集团管理员,4-公司管理员,16-普通角色。低级的角色不能给他人设置高等级的角色。
     */
    public void setRoleLevel(Short roleLevel) {
        this.roleLevel = roleLevel;
    }

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
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