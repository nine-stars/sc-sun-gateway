package com.iyb.ak.entity;

import com.iyb.ak.entity.base.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User extends BaseEntity{
    /**
     * 加密
     */
    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SALT")
    private String salt;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "CRYPT_VER")
    private Integer cryptVer;

    @Column(name = "USER_PHOTO")
    private String userPhoto;

    /**
     * 加密
     */
    @Column(name = "NAME")
    private String name;

    @Column(name = "SHOW_NAME")
    private String showName;

    @Column(name = "ENGLISH_NAME")
    private String englishName;

    @Column(name = "SPELLING")
    private String spelling;

    @Column(name = "FIRST_LETTER")
    private String firstLetter;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CITIZEN_SHIP")
    private String citizenShip;

    @Column(name = "ID_TYPE")
    private String idType;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "ID_NUMBER_FORWARD_FILE")
    private String idNumberForwardFile;

    @Column(name = "ID_NUMBER_BACK_FILE")
    private String idNumberBackFile;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "ZODIAC")
    private String zodiac;

    @Column(name = "BLOOD_TYPE")
    private String bloodType;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "POLI_STATUS")
    private String poliStatus;

    @Column(name = "NATI_PLACE")
    private String natiPlace;

    @Column(name = "REGI_CITY")
    private String regiCity;

    @Column(name = "REGI_PROPERTY")
    private String regiProperty;

    @Column(name = "MARI_STATUS")
    private String mariStatus;

    /**
     * 生育状况
     */
    @Column(name = "FERT_MEMO")
    private String fertMemo;

    /**
     * 是否已育
     */
    @Column(name = "FERT_STATUS")
    private String fertStatus;

    @Column(name = "CONTACT_TELE")
    private String contactTele;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "QQ")
    private String qq;

    @Column(name = "WEIXIN")
    private String weixin;

    @Column(name = "ADDENDA_PROV_FUND_ACCOUNT")
    private String addendaProvFundAccount;

    @Column(name = "PROV_FUND_ACCOUNT")
    private String provFundAccount;

    @Column(name = "PERSONNEL_FILE_LOCATION")
    private String personnelFileLocation;

    @Column(name = "SOCIAL_ACCOUNT")
    private String socialAccount;

    @Column(name = "RESI_PERMIT")
    private String resiPermit;

    @Column(name = "REGI_ADDRESS")
    private String regiAddress;

    @Column(name = "RESI_NUMBER")
    private String resiNumber;

    @Column(name = "RESI_VALID_DATE")
    private Date resiValidDate;

    @Column(name = "LIVE_ADDRESS")
    private String liveAddress;

    @Column(name = "LIVE_ZIP")
    private String liveZip;

    @Column(name = "EDU_LEVEL")
    private String eduLevel;

    @Column(name = "WORK_START_DATE")
    private Date workStartDate;

    @Column(name = "HEIGHT")
    private String height;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "INJU_DECIDE")
    private String injuDecide;

    @Column(name = "INJU_APPRAISAL")
    private String injuAppraisal;

    @Column(name = "INJU_LEVEL")
    private String injuLevel;

    /**
     * 是否有健康证
     */
    @Column(name = "HEALTH_CERTIFICATE")
    private String healthCertificate;

    /**
     * 失效时间
     */
    @Column(name = "HEALTH_VALID_DATE")
    private Date healthValidDate;

    @Column(name = "CRIT_DISEASES")
    private String critDiseases;

    @Column(name = "DISABILITY")
    private String disability;

    @Column(name = "QUALIFICATION")
    private String qualification;

    /**
     * 最后切公司UUID
     */
    @Column(name = "COMP_UUID")
    private String compUuid;

    /**
     * APP最后切公司UUID
     */
    @Column(name = "APP_COMP_UUID")
    private String appCompUuid;

    @Column(name = "TECH_TITLE")
    private String techTitle;

    @Column(name = "INIT_FLAG")
    private String initFlag;

    /**
     * 详细信息完成率
     */
    @Column(name = "DETAIL_RATE")
    private String detailRate;

    /**
     * 设备号
     */
    @Column(name = "DEV_ID")
    private String devId;

    @Column(name = "INSERT_USER")
    private String insertUser;

    @Column(name = "INSERT_TIME")
    private Date insertTime;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "DELETE_FLAG")
    private Boolean deleteFlag;

    /**
     * 最后登录时间
     */
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
     * JSON格式，字段：
company,
workTitle,
titleStartTime.
titleEndTime,
reference,
refTel,
workMemo
     */
    @Column(name = "WORK_EXPERIENCE")
    private String workExperience;

    /**
     * JSON结构，字段有：
educCollege，
educStartTime，
educEndTime，
educMajor，
qualification, 学历
degree, 学位
graduationCer, 毕业证
degreeCer, 学位证
     */
    @Column(name = "EDUC_EXPERIENCE")
    private String educExperience;

    /**
     * JSON结构，字段有
traiOrganization，
traiStartTime，
trialEndTime，
traiContent
     */
    @Column(name = "TRAI_EXPERIENCE")
    private String traiExperience;

    /**
     * JSON结构，字段有
name,
relationship,
telno,
address
     */
    @Column(name = "EMERGENCY_CONTACT")
    private String emergencyContact;

    /**
     * 获取加密
     *
     * @return UUID - 加密
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置加密
     *
     * @param uuid 加密
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return SALT
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return IS_ACTIVE
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return CRYPT_VER
     */
    public Integer getCryptVer() {
        return cryptVer;
    }

    /**
     * @param cryptVer
     */
    public void setCryptVer(Integer cryptVer) {
        this.cryptVer = cryptVer;
    }

    /**
     * @return USER_PHOTO
     */
    public String getUserPhoto() {
        return userPhoto;
    }

    /**
     * @param userPhoto
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    /**
     * 获取加密
     *
     * @return NAME - 加密
     */
    public String getName() {
        return name;
    }

    /**
     * 设置加密
     *
     * @param name 加密
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return SHOW_NAME
     */
    public String getShowName() {
        return showName;
    }

    /**
     * @param showName
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * @return ENGLISH_NAME
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @param englishName
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    /**
     * @return SPELLING
     */
    public String getSpelling() {
        return spelling;
    }

    /**
     * @param spelling
     */
    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    /**
     * @return FIRST_LETTER
     */
    public String getFirstLetter() {
        return firstLetter;
    }

    /**
     * @param firstLetter
     */
    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    /**
     * @return GENDER
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return CITIZEN_SHIP
     */
    public String getCitizenShip() {
        return citizenShip;
    }

    /**
     * @param citizenShip
     */
    public void setCitizenShip(String citizenShip) {
        this.citizenShip = citizenShip;
    }

    /**
     * @return ID_TYPE
     */
    public String getIdType() {
        return idType;
    }

    /**
     * @param idType
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * @return ID_NUMBER
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return ID_NUMBER_FORWARD_FILE
     */
    public String getIdNumberForwardFile() {
        return idNumberForwardFile;
    }

    /**
     * @param idNumberForwardFile
     */
    public void setIdNumberForwardFile(String idNumberForwardFile) {
        this.idNumberForwardFile = idNumberForwardFile;
    }

    /**
     * @return ID_NUMBER_BACK_FILE
     */
    public String getIdNumberBackFile() {
        return idNumberBackFile;
    }

    /**
     * @param idNumberBackFile
     */
    public void setIdNumberBackFile(String idNumberBackFile) {
        this.idNumberBackFile = idNumberBackFile;
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return ZODIAC
     */
    public String getZodiac() {
        return zodiac;
    }

    /**
     * @param zodiac
     */
    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    /**
     * @return BLOOD_TYPE
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return NATIONALITY
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return POLI_STATUS
     */
    public String getPoliStatus() {
        return poliStatus;
    }

    /**
     * @param poliStatus
     */
    public void setPoliStatus(String poliStatus) {
        this.poliStatus = poliStatus;
    }

    /**
     * @return NATI_PLACE
     */
    public String getNatiPlace() {
        return natiPlace;
    }

    /**
     * @param natiPlace
     */
    public void setNatiPlace(String natiPlace) {
        this.natiPlace = natiPlace;
    }

    /**
     * @return REGI_CITY
     */
    public String getRegiCity() {
        return regiCity;
    }

    /**
     * @param regiCity
     */
    public void setRegiCity(String regiCity) {
        this.regiCity = regiCity;
    }

    /**
     * @return REGI_PROPERTY
     */
    public String getRegiProperty() {
        return regiProperty;
    }

    /**
     * @param regiProperty
     */
    public void setRegiProperty(String regiProperty) {
        this.regiProperty = regiProperty;
    }

    /**
     * @return MARI_STATUS
     */
    public String getMariStatus() {
        return mariStatus;
    }

    /**
     * @param mariStatus
     */
    public void setMariStatus(String mariStatus) {
        this.mariStatus = mariStatus;
    }

    /**
     * 获取生育状况
     *
     * @return FERT_MEMO - 生育状况
     */
    public String getFertMemo() {
        return fertMemo;
    }

    /**
     * 设置生育状况
     *
     * @param fertMemo 生育状况
     */
    public void setFertMemo(String fertMemo) {
        this.fertMemo = fertMemo;
    }

    /**
     * 获取是否已育
     *
     * @return FERT_STATUS - 是否已育
     */
    public String getFertStatus() {
        return fertStatus;
    }

    /**
     * 设置是否已育
     *
     * @param fertStatus 是否已育
     */
    public void setFertStatus(String fertStatus) {
        this.fertStatus = fertStatus;
    }

    /**
     * @return CONTACT_TELE
     */
    public String getContactTele() {
        return contactTele;
    }

    /**
     * @param contactTele
     */
    public void setContactTele(String contactTele) {
        this.contactTele = contactTele;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return WEIXIN
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * @param weixin
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * @return ADDENDA_PROV_FUND_ACCOUNT
     */
    public String getAddendaProvFundAccount() {
        return addendaProvFundAccount;
    }

    /**
     * @param addendaProvFundAccount
     */
    public void setAddendaProvFundAccount(String addendaProvFundAccount) {
        this.addendaProvFundAccount = addendaProvFundAccount;
    }

    /**
     * @return PROV_FUND_ACCOUNT
     */
    public String getProvFundAccount() {
        return provFundAccount;
    }

    /**
     * @param provFundAccount
     */
    public void setProvFundAccount(String provFundAccount) {
        this.provFundAccount = provFundAccount;
    }

    /**
     * @return PERSONNEL_FILE_LOCATION
     */
    public String getPersonnelFileLocation() {
        return personnelFileLocation;
    }

    /**
     * @param personnelFileLocation
     */
    public void setPersonnelFileLocation(String personnelFileLocation) {
        this.personnelFileLocation = personnelFileLocation;
    }

    /**
     * @return SOCIAL_ACCOUNT
     */
    public String getSocialAccount() {
        return socialAccount;
    }

    /**
     * @param socialAccount
     */
    public void setSocialAccount(String socialAccount) {
        this.socialAccount = socialAccount;
    }

    /**
     * @return RESI_PERMIT
     */
    public String getResiPermit() {
        return resiPermit;
    }

    /**
     * @param resiPermit
     */
    public void setResiPermit(String resiPermit) {
        this.resiPermit = resiPermit;
    }

    /**
     * @return REGI_ADDRESS
     */
    public String getRegiAddress() {
        return regiAddress;
    }

    /**
     * @param regiAddress
     */
    public void setRegiAddress(String regiAddress) {
        this.regiAddress = regiAddress;
    }

    /**
     * @return RESI_NUMBER
     */
    public String getResiNumber() {
        return resiNumber;
    }

    /**
     * @param resiNumber
     */
    public void setResiNumber(String resiNumber) {
        this.resiNumber = resiNumber;
    }

    /**
     * @return RESI_VALID_DATE
     */
    public Date getResiValidDate() {
        return resiValidDate;
    }

    /**
     * @param resiValidDate
     */
    public void setResiValidDate(Date resiValidDate) {
        this.resiValidDate = resiValidDate;
    }

    /**
     * @return LIVE_ADDRESS
     */
    public String getLiveAddress() {
        return liveAddress;
    }

    /**
     * @param liveAddress
     */
    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    /**
     * @return LIVE_ZIP
     */
    public String getLiveZip() {
        return liveZip;
    }

    /**
     * @param liveZip
     */
    public void setLiveZip(String liveZip) {
        this.liveZip = liveZip;
    }

    /**
     * @return EDU_LEVEL
     */
    public String getEduLevel() {
        return eduLevel;
    }

    /**
     * @param eduLevel
     */
    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    /**
     * @return WORK_START_DATE
     */
    public Date getWorkStartDate() {
        return workStartDate;
    }

    /**
     * @param workStartDate
     */
    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    /**
     * @return HEIGHT
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return WEIGHT
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return INJU_DECIDE
     */
    public String getInjuDecide() {
        return injuDecide;
    }

    /**
     * @param injuDecide
     */
    public void setInjuDecide(String injuDecide) {
        this.injuDecide = injuDecide;
    }

    /**
     * @return INJU_APPRAISAL
     */
    public String getInjuAppraisal() {
        return injuAppraisal;
    }

    /**
     * @param injuAppraisal
     */
    public void setInjuAppraisal(String injuAppraisal) {
        this.injuAppraisal = injuAppraisal;
    }

    /**
     * @return INJU_LEVEL
     */
    public String getInjuLevel() {
        return injuLevel;
    }

    /**
     * @param injuLevel
     */
    public void setInjuLevel(String injuLevel) {
        this.injuLevel = injuLevel;
    }

    /**
     * 获取是否有健康证
     *
     * @return HEALTH_CERTIFICATE - 是否有健康证
     */
    public String getHealthCertificate() {
        return healthCertificate;
    }

    /**
     * 设置是否有健康证
     *
     * @param healthCertificate 是否有健康证
     */
    public void setHealthCertificate(String healthCertificate) {
        this.healthCertificate = healthCertificate;
    }

    /**
     * 获取失效时间
     *
     * @return HEALTH_VALID_DATE - 失效时间
     */
    public Date getHealthValidDate() {
        return healthValidDate;
    }

    /**
     * 设置失效时间
     *
     * @param healthValidDate 失效时间
     */
    public void setHealthValidDate(Date healthValidDate) {
        this.healthValidDate = healthValidDate;
    }

    /**
     * @return CRIT_DISEASES
     */
    public String getCritDiseases() {
        return critDiseases;
    }

    /**
     * @param critDiseases
     */
    public void setCritDiseases(String critDiseases) {
        this.critDiseases = critDiseases;
    }

    /**
     * @return DISABILITY
     */
    public String getDisability() {
        return disability;
    }

    /**
     * @param disability
     */
    public void setDisability(String disability) {
        this.disability = disability;
    }

    /**
     * @return QUALIFICATION
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * 获取最后切公司UUID
     *
     * @return COMP_UUID - 最后切公司UUID
     */
    public String getCompUuid() {
        return compUuid;
    }

    /**
     * 设置最后切公司UUID
     *
     * @param compUuid 最后切公司UUID
     */
    public void setCompUuid(String compUuid) {
        this.compUuid = compUuid;
    }

    /**
     * 获取APP最后切公司UUID
     *
     * @return APP_COMP_UUID - APP最后切公司UUID
     */
    public String getAppCompUuid() {
        return appCompUuid;
    }

    /**
     * 设置APP最后切公司UUID
     *
     * @param appCompUuid APP最后切公司UUID
     */
    public void setAppCompUuid(String appCompUuid) {
        this.appCompUuid = appCompUuid;
    }

    /**
     * @return TECH_TITLE
     */
    public String getTechTitle() {
        return techTitle;
    }

    /**
     * @param techTitle
     */
    public void setTechTitle(String techTitle) {
        this.techTitle = techTitle;
    }

    /**
     * @return INIT_FLAG
     */
    public String getInitFlag() {
        return initFlag;
    }

    /**
     * @param initFlag
     */
    public void setInitFlag(String initFlag) {
        this.initFlag = initFlag;
    }

    /**
     * 获取详细信息完成率
     *
     * @return DETAIL_RATE - 详细信息完成率
     */
    public String getDetailRate() {
        return detailRate;
    }

    /**
     * 设置详细信息完成率
     *
     * @param detailRate 详细信息完成率
     */
    public void setDetailRate(String detailRate) {
        this.detailRate = detailRate;
    }

    /**
     * 获取设备号
     *
     * @return DEV_ID - 设备号
     */
    public String getDevId() {
        return devId;
    }

    /**
     * 设置设备号
     *
     * @param devId 设备号
     */
    public void setDevId(String devId) {
        this.devId = devId;
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
     * @return INSERT_TIME
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime
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

    /**
     * 获取最后登录时间
     *
     * @return LAST_LOGIN_TIME - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取JSON格式，字段：
company,
workTitle,
titleStartTime.
titleEndTime,
reference,
refTel,
workMemo
     *
     * @return WORK_EXPERIENCE - JSON格式，字段：
company,
workTitle,
titleStartTime.
titleEndTime,
reference,
refTel,
workMemo
     */
    public String getWorkExperience() {
        return workExperience;
    }

    /**
     * 设置JSON格式，字段：
company,
workTitle,
titleStartTime.
titleEndTime,
reference,
refTel,
workMemo
     *
     * @param workExperience JSON格式，字段：
company,
workTitle,
titleStartTime.
titleEndTime,
reference,
refTel,
workMemo
     */
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    /**
     * 获取JSON结构，字段有：
educCollege，
educStartTime，
educEndTime，
educMajor，
qualification, 学历
degree, 学位
graduationCer, 毕业证
degreeCer, 学位证
     *
     * @return EDUC_EXPERIENCE - JSON结构，字段有：
educCollege，
educStartTime，
educEndTime，
educMajor，
qualification, 学历
degree, 学位
graduationCer, 毕业证
degreeCer, 学位证
     */
    public String getEducExperience() {
        return educExperience;
    }

    /**
     * 设置JSON结构，字段有：
educCollege，
educStartTime，
educEndTime，
educMajor，
qualification, 学历
degree, 学位
graduationCer, 毕业证
degreeCer, 学位证
     *
     * @param educExperience JSON结构，字段有：
educCollege，
educStartTime，
educEndTime，
educMajor，
qualification, 学历
degree, 学位
graduationCer, 毕业证
degreeCer, 学位证
     */
    public void setEducExperience(String educExperience) {
        this.educExperience = educExperience;
    }

    /**
     * 获取JSON结构，字段有
traiOrganization，
traiStartTime，
trialEndTime，
traiContent
     *
     * @return TRAI_EXPERIENCE - JSON结构，字段有
traiOrganization，
traiStartTime，
trialEndTime，
traiContent
     */
    public String getTraiExperience() {
        return traiExperience;
    }

    /**
     * 设置JSON结构，字段有
traiOrganization，
traiStartTime，
trialEndTime，
traiContent
     *
     * @param traiExperience JSON结构，字段有
traiOrganization，
traiStartTime，
trialEndTime，
traiContent
     */
    public void setTraiExperience(String traiExperience) {
        this.traiExperience = traiExperience;
    }

    /**
     * 获取JSON结构，字段有
name,
relationship,
telno,
address
     *
     * @return EMERGENCY_CONTACT - JSON结构，字段有
name,
relationship,
telno,
address
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * 设置JSON结构，字段有
name,
relationship,
telno,
address
     *
     * @param emergencyContact JSON结构，字段有
name,
relationship,
telno,
address
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}