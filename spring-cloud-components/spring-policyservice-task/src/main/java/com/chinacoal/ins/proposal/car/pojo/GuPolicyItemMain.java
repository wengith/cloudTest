package com.chinacoal.ins.proposal.car.pojo;

import java.math.BigDecimal;

public class GuPolicyItemMain extends GuPolicyItemMainKey {
    /**
     * 标的代码
     */
    private String itemCode;

    /**
     * 标的名称
     */
    private String itemName;

    /**
     * 危险单位类型
     */
    private String dangerUnitType;

    /**
     * 危险单位代码
     */
    private String dangerUnitCode;

    /**
     * 风险类型
     */
    private String riskKind;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 分单号
     */
    private String subPolicyNo;

    /**
     * 币种
     */
    private String currency;

    /**
     * 风险等级
     */
    private String riskLevel;

    /**
     * 最高自留额
     */
    private BigDecimal reTentValue;

    /**
     * 上年出险次数
     */
    private Short damagedTimes;

    /**
     * 风险等级描述
     */
    private String riskLevelDesc;

    /**
     * 标的代码
     * @return itemCode 标的代码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 标的代码
     * @param itemCode 标的代码
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    /**
     * 标的名称
     * @return itemName 标的名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 标的名称
     * @param itemName 标的名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 危险单位类型
     * @return dangerUnitType 危险单位类型
     */
    public String getDangerUnitType() {
        return dangerUnitType;
    }

    /**
     * 危险单位类型
     * @param dangerUnitType 危险单位类型
     */
    public void setDangerUnitType(String dangerUnitType) {
        this.dangerUnitType = dangerUnitType == null ? null : dangerUnitType.trim();
    }

    /**
     * 危险单位代码
     * @return dangerUnitCode 危险单位代码
     */
    public String getDangerUnitCode() {
        return dangerUnitCode;
    }

    /**
     * 危险单位代码
     * @param dangerUnitCode 危险单位代码
     */
    public void setDangerUnitCode(String dangerUnitCode) {
        this.dangerUnitCode = dangerUnitCode == null ? null : dangerUnitCode.trim();
    }

    /**
     * 风险类型
     * @return riskKind 风险类型
     */
    public String getRiskKind() {
        return riskKind;
    }

    /**
     * 风险类型
     * @param riskKind 风险类型
     */
    public void setRiskKind(String riskKind) {
        this.riskKind = riskKind == null ? null : riskKind.trim();
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

    /**
     * 分单号
     * @return subPolicyNo 分单号
     */
    public String getSubPolicyNo() {
        return subPolicyNo;
    }

    /**
     * 分单号
     * @param subPolicyNo 分单号
     */
    public void setSubPolicyNo(String subPolicyNo) {
        this.subPolicyNo = subPolicyNo == null ? null : subPolicyNo.trim();
    }

    /**
     * 币种
     * @return CURRENCY 币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 币种
     * @param currency 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * 风险等级
     * @return riskLevel 风险等级
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * 风险等级
     * @param riskLevel 风险等级
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * 最高自留额
     * @return reTentValue 最高自留额
     */
    public BigDecimal getReTentValue() {
        return reTentValue;
    }

    /**
     * 最高自留额
     * @param reTentValue 最高自留额
     */
    public void setReTentValue(BigDecimal reTentValue) {
        this.reTentValue = reTentValue;
    }

    /**
     * 上年出险次数
     * @return damagedTimes 上年出险次数
     */
    public Short getDamagedTimes() {
        return damagedTimes;
    }

    /**
     * 上年出险次数
     * @param damagedTimes 上年出险次数
     */
    public void setDamagedTimes(Short damagedTimes) {
        this.damagedTimes = damagedTimes;
    }

    /**
     * 风险等级描述
     * @return riskLevelDesc 风险等级描述
     */
    public String getRiskLevelDesc() {
        return riskLevelDesc;
    }

    /**
     * 风险等级描述
     * @param riskLevelDesc 风险等级描述
     */
    public void setRiskLevelDesc(String riskLevelDesc) {
        this.riskLevelDesc = riskLevelDesc == null ? null : riskLevelDesc.trim();
    }
}