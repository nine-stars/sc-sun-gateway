package com.iyb.ak.entity;

import com.iyb.ak.entity.base.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_api")
public class Api extends BaseEntity{
    /**
     * 主键
     */
    @Id
    @Column(name = "UUID")
    private String uuid;

    /**
     * api访问地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 排序号
规则：2位模块编号+2位功能编号+2位URL编号
功能编号规则：90-READ；80-WRITE；30-EXPORT；40-CONF
URL编号默认以5的倍数设置，方便插入
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /**
     * http请求方式,多个逗号分隔;留空-任意方法
     */
    @Column(name = "HTTP_METHOD")
    private String httpMethod;

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
     * 获取api访问地址
     *
     * @return URL - api访问地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置api访问地址
     *
     * @param url api访问地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取排序号
规则：2位模块编号+2位功能编号+2位URL编号
功能编号规则：90-READ；80-WRITE；30-EXPORT；40-CONF
URL编号默认以5的倍数设置，方便插入
     *
     * @return ORDER_NUM - 排序号
规则：2位模块编号+2位功能编号+2位URL编号
功能编号规则：90-READ；80-WRITE；30-EXPORT；40-CONF
URL编号默认以5的倍数设置，方便插入
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序号
规则：2位模块编号+2位功能编号+2位URL编号
功能编号规则：90-READ；80-WRITE；30-EXPORT；40-CONF
URL编号默认以5的倍数设置，方便插入
     *
     * @param orderNum 排序号
规则：2位模块编号+2位功能编号+2位URL编号
功能编号规则：90-READ；80-WRITE；30-EXPORT；40-CONF
URL编号默认以5的倍数设置，方便插入
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取http请求方式,多个逗号分隔;留空-任意方法
     *
     * @return HTTP_METHOD - http请求方式,多个逗号分隔;留空-任意方法
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * 设置http请求方式,多个逗号分隔;留空-任意方法
     *
     * @param httpMethod http请求方式,多个逗号分隔;留空-任意方法
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
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