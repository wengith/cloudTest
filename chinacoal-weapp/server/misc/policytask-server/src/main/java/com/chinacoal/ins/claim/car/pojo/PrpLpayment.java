package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PrpLpayment {
    /** id */
    private Long id;
    /**计算书号*/
    private String compensateNo;
    /** 保单号 */
    private String policyNo;
    private String riskCode;
    private String registNo;
    /** 险别代码 */
    private String kindCode;
    /** 标的序号 */
    private Integer itemKindNo;
    /** 险别名称 */
    private String kindName;
    /** 币别 */
    private String currency;
    /** 计入赔款金额 */
    private BigDecimal sumRealPay;
    /** 标志字段 */
    private String flag;
    /** 备注 */
    private String remark;
    /** 有效标志 */
    private String validFlag;
    /**收款人名称*/
    private String claimName;
    /**客户账号*/
    private String custAccountNo;
    /**开户银行名称*/
    private String bankName;
    private String bankAdress;
    private String errorFlag;
    /**涉农标志*/
    private String agricultureFlag;
    /**收款人类别*/
    private String accepterType;
    /**收款人类别名称*/
    private String accepterTypeName;
    /**合作机构名称*/
    private String partnerComName;
    private String partnerComCode;
    /**收款人类型*/
    private String accepterKind;
    /**收款人类型名称*/
    private String accepterKindName;
    /**是否代位公司代码*/
    private String isReplaceFlag;
    /**是否代位公司*/
    private String isReplaceFlagName;
    /**证件类型*/
    private String documenType;
    /**证件类型代码*/
    private String documenTypeCode;
    /**收款行*/
    private String bankTypeCode;
    /**收款行*/
    private String bankTypeName;
    /**收款行省份*/
    private String areaclCode;
    /**收款行省份*/
    private String areaclName;
    /**收款开户行名称*/
    private String bankBranchName;
    /**收款开户行代码*/
    private String bankBranchCode;
    /**收款清算联行号*/
    private String bankInfoCode;
    /**收款清算联行号名称*/
    private String bankInfoName;
    /**收款行同城交换号*/
    private String bankJhCode;
    /**收款行省份*/
    private String parentCode;
    /**收款行省份名称*/
    private String parentName;
    /**对公/对私*/
    private String isPub;
    /**车牌号*/
    private String licenseNo;
    /**手机号*/
    private String phoneNumber;
    /**收付开户行代码*/
    private String sfBankCode;
    /**收付开户行名称*/
    private String sfBankName;
    /**支付需改审核状态*/
    private String examine;
    /**支付时间*/
    private Date payDate;
    /**支付标识   2代表成功 3代表失败  1支付中*/
    private String payFlag;
    private String payReason;
    /**诉讼处理人代码*/
    private String litigationCode;
    /**客户代码 */
    private String clientCode;
    /**客户类型 */
    private String clientType;
    /**收款行开户省市代码*/
    private String provinceCode;
    /**收款行开户省市名称*/
    private String provinceName;
    /**共保比例*/
    private BigDecimal coinsRate;
    /**共保赔款金额*/
    private BigDecimal coinsPaid;
    /** 共保标志 */
    private String coinsFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public Integer getItemKindNo() {
        return itemKindNo;
    }

    public void setItemKindNo(Integer itemKindNo) {
        this.itemKindNo = itemKindNo;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSumRealPay() {
        return sumRealPay;
    }

    public void setSumRealPay(BigDecimal sumRealPay) {
        this.sumRealPay = sumRealPay;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getClaimName() {
        return claimName;
    }

    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    public String getCustAccountNo() {
        return custAccountNo;
    }

    public void setCustAccountNo(String custAccountNo) {
        this.custAccountNo = custAccountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAdress() {
        return bankAdress;
    }

    public void setBankAdress(String bankAdress) {
        this.bankAdress = bankAdress;
    }

    public String getErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(String errorFlag) {
        this.errorFlag = errorFlag;
    }

    public String getAgricultureFlag() {
        return agricultureFlag;
    }

    public void setAgricultureFlag(String agricultureFlag) {
        this.agricultureFlag = agricultureFlag;
    }

    public String getAccepterType() {
        return accepterType;
    }

    public void setAccepterType(String accepterType) {
        this.accepterType = accepterType;
    }

    public String getAccepterTypeName() {
        return accepterTypeName;
    }

    public void setAccepterTypeName(String accepterTypeName) {
        this.accepterTypeName = accepterTypeName;
    }

    public String getPartnerComName() {
        return partnerComName;
    }

    public void setPartnerComName(String partnerComName) {
        this.partnerComName = partnerComName;
    }

    public String getPartnerComCode() {
        return partnerComCode;
    }

    public void setPartnerComCode(String partnerComCode) {
        this.partnerComCode = partnerComCode;
    }

    public String getAccepterKind() {
        return accepterKind;
    }

    public void setAccepterKind(String accepterKind) {
        this.accepterKind = accepterKind;
    }

    public String getAccepterKindName() {
        return accepterKindName;
    }

    public void setAccepterKindName(String accepterKindName) {
        this.accepterKindName = accepterKindName;
    }

    public String getIsReplaceFlag() {
        return isReplaceFlag;
    }

    public void setIsReplaceFlag(String isReplaceFlag) {
        this.isReplaceFlag = isReplaceFlag;
    }

    public String getIsReplaceFlagName() {
        return isReplaceFlagName;
    }

    public void setIsReplaceFlagName(String isReplaceFlagName) {
        this.isReplaceFlagName = isReplaceFlagName;
    }

    public String getDocumenType() {
        return documenType;
    }

    public void setDocumenType(String documenType) {
        this.documenType = documenType;
    }

    public String getDocumenTypeCode() {
        return documenTypeCode;
    }

    public void setDocumenTypeCode(String documenTypeCode) {
        this.documenTypeCode = documenTypeCode;
    }

    public String getBankTypeCode() {
        return bankTypeCode;
    }

    public void setBankTypeCode(String bankTypeCode) {
        this.bankTypeCode = bankTypeCode;
    }

    public String getBankTypeName() {
        return bankTypeName;
    }

    public void setBankTypeName(String bankTypeName) {
        this.bankTypeName = bankTypeName;
    }

    public String getAreaclCode() {
        return areaclCode;
    }

    public void setAreaclCode(String areaclCode) {
        this.areaclCode = areaclCode;
    }

    public String getAreaclName() {
        return areaclName;
    }

    public void setAreaclName(String areaclName) {
        this.areaclName = areaclName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getBankInfoCode() {
        return bankInfoCode;
    }

    public void setBankInfoCode(String bankInfoCode) {
        this.bankInfoCode = bankInfoCode;
    }

    public String getBankInfoName() {
        return bankInfoName;
    }

    public void setBankInfoName(String bankInfoName) {
        this.bankInfoName = bankInfoName;
    }

    public String getBankJhCode() {
        return bankJhCode;
    }

    public void setBankJhCode(String bankJhCode) {
        this.bankJhCode = bankJhCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getIsPub() {
        return isPub;
    }

    public void setIsPub(String isPub) {
        this.isPub = isPub;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSfBankCode() {
        return sfBankCode;
    }

    public void setSfBankCode(String sfBankCode) {
        this.sfBankCode = sfBankCode;
    }

    public String getSfBankName() {
        return sfBankName;
    }

    public void setSfBankName(String sfBankName) {
        this.sfBankName = sfBankName;
    }

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }

    public String getLitigationCode() {
        return litigationCode;
    }

    public void setLitigationCode(String litigationCode) {
        this.litigationCode = litigationCode;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public BigDecimal getCoinsRate() {
        return coinsRate;
    }

    public void setCoinsRate(BigDecimal coinsRate) {
        this.coinsRate = coinsRate;
    }

    public BigDecimal getCoinsPaid() {
        return coinsPaid;
    }

    public void setCoinsPaid(BigDecimal coinsPaid) {
        this.coinsPaid = coinsPaid;
    }

    public String getCoinsFlag() {
        return coinsFlag;
    }

    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }
}