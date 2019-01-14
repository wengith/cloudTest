package com.chinacoal.ins.proposal.car.pojo;

import java.util.Date;

public class GuPolicyRiskRelatedParty extends GuPolicyRiskrelatedpartyKey {

    /** 分保单号 */
    private String subPolicyNo;

    /** 关系人类型 */
    private String insuredType;

    /**
     * 关系人代码
     */
    private String insuredCode;

    /**
     * 关系人名称
     */
    private String insuredName;

    /**
     * 联系人地址
     */
    private String insuredAddress;

    /**
     * 关系人营业性质
     */
    private String insuredBusinessSource;

    /**
     * 1 投保人/2 被保险人/3 连带被保险人/4 受益人
     */
    private String insuredFlag;

    /**
     * 0 次承包商/1 主承包商
     */
    private String insuredRole;

    /**
     * 身份证类型
     */
    private String identifyType;

    /**
     * 证件号码
     */
    private String identifyNumber;

    /**
     * 代码维护字段
     */
    private String insuredRelation;

    /**
     * 关联人序号
     */
    private Long relateSerialNo;

    /**
     * 0 否/1 是
     */
    private String insuredInd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 性别
     */
    private String insuredSex;

    /**
     * 出生日期
     */
    private Date insuredBirthDate;

    /**
     * 邮政编码
     */
    private String insuredPostCode;

    /**
     * 办公电话
     */
    private String insuredOfficePhone;

    /**
     * 手机号
     */
    private String insuredMobilePhone;

    /**
     * 家庭电话
     */
    private String insuredHomePhone;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系人电话
     */
    private String contactPhone;

    /**
     * 婚姻状况
     */
    private String marriageStatus;

    /**
     * 学历
     */
    private String educationBackground;

    /**
     * 被保险人与投保人关系
     */
    private String relationWithHolder;

    /**
     * 联系人性别
     */
    private String contactSex;

    /**
     * 联系人类型
     */
    private String contactType;

    /**
     * 联系人部门
     */
    private String contactDepartment;

    /**
     * 联系人职务
     */
    private String contactPosition;

    /**
     * 联系人个人办公电话
     */
    private String contactOfficeNumber;

    /**
     * 联系人手机
     */
    private String contactMobile;

    /**
     * 关系人类型
     */
    private String relatedType;

    /**
     * 省份代码
     */
    private String itemProvinceCode;

    /**
     * 城市代码
     */
    private String itemCityCode;

    /**
     * 省份名称
     */
    private String itemProvincecName;

    /**
     * 城市名称
     */
    private String itemCitycName;

    /**
     * 洗钱风险 1-高，2-中，3-低 ggcode.codecode where codetype=?moneylaunderingind?
     */
    private String moneyLaunderingInd;

    /**
     * 客户星级
     */
    private String starLevel;

    /**
     * 被保险人与车辆关系
     */
    private String carInsuredRelation;

    /**
     * 客户类型标识
     */
    private String clientTypeIdentity;

    /**
     * msn号码
     */
    private String msnNo;

    /**
     * QQ号码
     */
    private String qqNo;

    /**
     * email
     */
    private String email;

    /**
     * 被保险人地址
     */
    private String address;

    /**
     * 被保险人电话
     */
    private String contactPhoneNo;

    /**
     * 国家代码
     */
    private String countryCode;

    /**
     * 索赔权益人名称
     */
    private String claimRightsName;

    /**
     * 索赔权益人证件号码
     */
    private String claimRightsIdentifyNumber;

    /**
     * 是否索赔权益人
     */
    private String isClaimRights;

    /**
     * 分保单号
     * @return subPolicyNo 分保单号
     */
    public String getSubPolicyNo() {
        return subPolicyNo;
    }

    /**
     * 分保单号
     * @param subPolicyNo 分保单号
     */
    public void setSubPolicyNo(String subPolicyNo) {
        this.subPolicyNo = subPolicyNo == null ? null : subPolicyNo.trim();
    }

    /**
     * 关系人类型
     * @return insuredType 关系人类型
     */
    public String getInsuredType() {
        return insuredType;
    }

    /**
     * 关系人类型
     * @param insuredType 关系人类型
     */
    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType == null ? null : insuredType.trim();
    }

    /**
     * 关系人代码
     * @return insuredCode 关系人代码
     */
    public String getInsuredCode() {
        return insuredCode;
    }

    /**
     * 关系人代码
     * @param insuredCode 关系人代码
     */
    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode == null ? null : insuredCode.trim();
    }

    /**
     * 关系人名称
     * @return insuredName 关系人名称
     */
    public String getInsuredName() {
        return insuredName;
    }

    /**
     * 关系人名称
     * @param insuredName 关系人名称
     */
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    /**
     * 联系人地址
     * @return insuredAddress 联系人地址
     */
    public String getInsuredAddress() {
        return insuredAddress;
    }

    /**
     * 联系人地址
     * @param insuredAddress 联系人地址
     */
    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress == null ? null : insuredAddress.trim();
    }

    /**
     * 关系人营业性质
     * @return insuredBusinessSource 关系人营业性质
     */
    public String getInsuredBusinessSource() {
        return insuredBusinessSource;
    }

    /**
     * 关系人营业性质
     * @param insuredBusinessSource 关系人营业性质
     */
    public void setInsuredBusinessSource(String insuredBusinessSource) {
        this.insuredBusinessSource = insuredBusinessSource == null ? null : insuredBusinessSource.trim();
    }

    /**
     * 1 投保人/2 被保险人/3 连带被保险人/4 受益人
     * @return insuredFlag 1 投保人/2 被保险人/3 连带被保险人/4 受益人
     */
    public String getInsuredFlag() {
        return insuredFlag;
    }

    /**
     * 1 投保人/2 被保险人/3 连带被保险人/4 受益人
     * @param insuredFlag 1 投保人/2 被保险人/3 连带被保险人/4 受益人
     */
    public void setInsuredFlag(String insuredFlag) {
        this.insuredFlag = insuredFlag == null ? null : insuredFlag.trim();
    }

    /**
     * 0 次承包商/1 主承包商
     * @return insuredRole 0 次承包商/1 主承包商
     */
    public String getInsuredRole() {
        return insuredRole;
    }

    /**
     * 0 次承包商/1 主承包商
     * @param insuredRole 0 次承包商/1 主承包商
     */
    public void setInsuredRole(String insuredRole) {
        this.insuredRole = insuredRole == null ? null : insuredRole.trim();
    }

    /**
     * 身份证类型
     * @return identifyType 身份证类型
     */
    public String getIdentifyType() {
        return identifyType;
    }

    /**
     * 身份证类型
     * @param identifyType 身份证类型
     */
    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType == null ? null : identifyType.trim();
    }

    /**
     * 证件号码
     * @return identifyNumber 证件号码
     */
    public String getIdentifyNumber() {
        return identifyNumber;
    }

    /**
     * 证件号码
     * @param identifyNumber 证件号码
     */
    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber == null ? null : identifyNumber.trim();
    }

    /**
     * 代码维护字段
     * @return insuredRelation 代码维护字段
     */
    public String getInsuredRelation() {
        return insuredRelation;
    }

    /**
     * 代码维护字段
     * @param insuredRelation 代码维护字段
     */
    public void setInsuredRelation(String insuredRelation) {
        this.insuredRelation = insuredRelation == null ? null : insuredRelation.trim();
    }

    /**
     * 关联人序号
     * @return relateSerialNo 关联人序号
     */
    public Long getRelateSerialNo() {
        return relateSerialNo;
    }

    /**
     * 关联人序号
     * @param relateSerialNo 关联人序号
     */
    public void setRelateSerialNo(Long relateSerialNo) {
        this.relateSerialNo = relateSerialNo;
    }

    /**
     * 0 否/1 是
     * @return insuredInd 0 否/1 是
     */
    public String getInsuredInd() {
        return insuredInd;
    }

    /**
     * 0 否/1 是
     * @param insuredInd 0 否/1 是
     */
    public void setInsuredInd(String insuredInd) {
        this.insuredInd = insuredInd == null ? null : insuredInd.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 标志字段
     * @return flag 标志字段
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 标志字段
     * @param flag 标志字段
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getInsuredSex() {
        return insuredSex;
    }

    public void setInsuredSex(String insuredSex) {
        this.insuredSex = insuredSex;
    }

    public Date getInsuredBirthDate() {
        return insuredBirthDate;
    }

    public void setInsuredBirthDate(Date insuredBirthDate) {
        this.insuredBirthDate = insuredBirthDate;
    }

    public String getInsuredPostCode() {
        return insuredPostCode;
    }

    public void setInsuredPostCode(String insuredPostCode) {
        this.insuredPostCode = insuredPostCode;
    }

    public String getInsuredOfficePhone() {
        return insuredOfficePhone;
    }

    public void setInsuredOfficePhone(String insuredOfficePhone) {
        this.insuredOfficePhone = insuredOfficePhone;
    }

    public String getInsuredMobilePhone() {
        return insuredMobilePhone;
    }

    public void setInsuredMobilePhone(String insuredMobilePhone) {
        this.insuredMobilePhone = insuredMobilePhone;
    }

    public String getInsuredHomePhone() {
        return insuredHomePhone;
    }

    public void setInsuredHomePhone(String insuredHomePhone) {
        this.insuredHomePhone = insuredHomePhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getRelationWithHolder() {
        return relationWithHolder;
    }

    public void setRelationWithHolder(String relationWithHolder) {
        this.relationWithHolder = relationWithHolder;
    }

    public String getContactSex() {
        return contactSex;
    }

    public void setContactSex(String contactSex) {
        this.contactSex = contactSex;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactDepartment() {
        return contactDepartment;
    }

    public void setContactDepartment(String contactDepartment) {
        this.contactDepartment = contactDepartment;
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public String getContactOfficeNumber() {
        return contactOfficeNumber;
    }

    public void setContactOfficeNumber(String contactOfficeNumber) {
        this.contactOfficeNumber = contactOfficeNumber;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    public String getItemProvinceCode() {
        return itemProvinceCode;
    }

    public void setItemProvinceCode(String itemProvinceCode) {
        this.itemProvinceCode = itemProvinceCode;
    }

    public String getItemCityCode() {
        return itemCityCode;
    }

    public void setItemCityCode(String itemCityCode) {
        this.itemCityCode = itemCityCode;
    }

    public String getItemProvincecName() {
        return itemProvincecName;
    }

    public void setItemProvincecName(String itemProvincecName) {
        this.itemProvincecName = itemProvincecName;
    }

    public String getItemCitycName() {
        return itemCitycName;
    }

    public void setItemCitycName(String itemCitycName) {
        this.itemCitycName = itemCitycName;
    }

    public String getMoneyLaunderingInd() {
        return moneyLaunderingInd;
    }

    public void setMoneyLaunderingInd(String moneyLaunderingInd) {
        this.moneyLaunderingInd = moneyLaunderingInd;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getCarInsuredRelation() {
        return carInsuredRelation;
    }

    public void setCarInsuredRelation(String carInsuredRelation) {
        this.carInsuredRelation = carInsuredRelation;
    }

    public String getClientTypeIdentity() {
        return clientTypeIdentity;
    }

    public void setClientTypeIdentity(String clientTypeIdentity) {
        this.clientTypeIdentity = clientTypeIdentity;
    }

    public String getMsnNo() {
        return msnNo;
    }

    public void setMsnNo(String msnNo) {
        this.msnNo = msnNo;
    }

    public String getQqNo() {
        return qqNo;
    }

    public void setQqNo(String qqNo) {
        this.qqNo = qqNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 被保险人地址
     * @return address 被保险人地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 被保险人地址
     * @param address 被保险人地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 被保险人电话
     * @return contactPhoneNo 被保险人电话
     */
    public String getContactPhoneNo() {
        return contactPhoneNo;
    }

    /**
     * 被保险人电话
     * @param contactPhoneNo 被保险人电话
     */
    public void setContactPhoneNo(String contactPhoneNo) {
        this.contactPhoneNo = contactPhoneNo == null ? null : contactPhoneNo.trim();
    }

    /**
     * 国家代码
     * @return countryCode 国家代码
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 国家代码
     * @param countryCode 国家代码
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * 索赔权益人名称
     * @return claimRightsName 索赔权益人名称
     */
    public String getClaimRightsName() {
        return claimRightsName;
    }

    /**
     * 索赔权益人名称
     * @param claimRightsName 索赔权益人名称
     */
    public void setClaimRightsName(String claimRightsName) {
        this.claimRightsName = claimRightsName == null ? null : claimRightsName.trim();
    }

    /**
     * 索赔权益人证件号码
     * @return claimRightsIdentifyNumber 索赔权益人证件号码
     */
    public String getClaimRightsIdentifyNumber() {
        return claimRightsIdentifyNumber;
    }

    /**
     * 索赔权益人证件号码
     * @param claimRightsIdentifyNumber 索赔权益人证件号码
     */
    public void setClaimRightsIdentifyNumber(String claimRightsIdentifyNumber) {
        this.claimRightsIdentifyNumber = claimRightsIdentifyNumber == null ? null : claimRightsIdentifyNumber.trim();
    }

    /**
     * 是否索赔权益人
     * @return isClaimRights 是否索赔权益人
     */
    public String getIsClaimRights() {
        return isClaimRights;
    }

    /**
     * 是否索赔权益人
     * @param isClaimRights 是否索赔权益人
     */
    public void setIsClaimRights(String isClaimRights) {
        this.isClaimRights = isClaimRights == null ? null : isClaimRights.trim();
    }
}