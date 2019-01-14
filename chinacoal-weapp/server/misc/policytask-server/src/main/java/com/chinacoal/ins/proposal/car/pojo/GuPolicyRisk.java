package com.chinacoal.ins.proposal.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GuPolicyRisk extends GuPolicyRiskKey {
    /**
     * 起保日期
     */
    private Date startDate;

    /**
     * 终保日期
     */
    private Date endDate;

    /**
     * 起保时区
     */
    private String startTimeZone;

    /**
     * 终保时区
     */
    private String endTimeZone;

    /**
     * 投保公司保单开始日
     */
    private Date commenceDate;

    /**
     * 追溯起始日期
     */
    private Date retroActiveStartDate;

    /**
     * 追溯终止日期
     */
    private Date retroActiveEndDate;

    /**
     * 保单币别
     */
    private String currency;

    /**
     * 总保险价值
     */
    private BigDecimal sumValue;

    /**
     * 总保额
     */
    private BigDecimal sumInsured;

    /**
     * 总毛保费
     */
    private BigDecimal sumGrossPremium;

    /**
     * 总佣金/折扣金额
     */
    private BigDecimal commission;

    /**
     * 总佣金/折扣率
     */
    private BigDecimal discount;

    /**
     * 总净保费
     */
    private BigDecimal sumNetPremium;

    /**
     * 加减费
     */
    private BigDecimal loading;

    /**
     * 司法管辖代码
     */
    private String judiCalCode;

    /**
     * 司法管辖
     */
    private String judiCalScope;

    /**
     * 承保年度
     */
    private String uwYear;

    /**
     * 承保地区
     */
    private String geographicalArea;

    /**
     * 申报标志
     */
    private String declarationInd;

    /**
     * 申报时限
     */
    private String declarationInterval;

    /**
     * 最低保费标志
     */
    private String lowestPremiumInd;

    /**
     * 最低保费币别
     */
    private String lowestPremCurrency;

    /**
     * 最低保费金额
     */
    private BigDecimal lowestPremium;

    /**
     * 佣金毛费/净费比例标志
     */
    private String commissionRateInd;

    /**
     * 外部备注
     */
    private String outerRemark;

    /**
     * 备注
     */
    private String remark;

    /**
     * 有效标志
     */
    private String validInd;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 申报保费调整标志
     */
    private String adjustmentInd;

    /**
     * 总承保保费
     */
    private BigDecimal sumUwPremium;

    /**
     * 承保地区描述
     */
    private String geographicalAreaDesc;

    /**
     * 发现起始日期
     */
    private Date discoverStartDate;

    /**
     * 发现中止日期
     */
    private Date discoverEndDate;

    /**
     * 索赔方式
     */
    private String compensationType;

    /**
     * 分单号
     */
    private String subPolicyNo;

    /**
     * 保单单证类型
     */
    private String policyVisaType;

    /**
     * 保单单证流水号
     */
    private String policyVisaSerialNo;

    /**
     * 批单单证类型
     */
    private String endorVisaType;

    /**
     * 批单单证流水号
     */
    private String endorVisaSerialNo;

    /**
     * 保险年度天数
     */
    private String uwYearDays;

    /**
     * 是否合并录单
     */
    private String combineInd;

    /**
     * 倒签天数
     */
    private Long backDays;

    /**
     * 延期后保单终保日期
     */
    private Date delayFinalEndDate;

    /**
     * 延期终止日期
     */
    private Date delayEndDate;

    /**
     * 提奖比例
     */
    private BigDecimal bonusRate;

    /**
     * 参考提奖比例
     */
    private BigDecimal referBonusRate;

    /**
     * 详细承保地区
     */
    private String geographicalAreaDetail;

    /**
     * 延期起始日期
     */
    private Date delayStartDate;

    /**
     * 延期期限(天数)
     */
    private Short delayTime;

    /**
     * 业务分类
     */
    private String businessClass;

    /**
     * 共保标志
     */
    private String coinsInd;

    /**
     * 特殊分保标志
     */
    private String specialReinsInd;

    /**
     * 是否重新匹配佣金
     */
    private String updateCommissionInd;

    /**
     * 退保标志
     */
    private String surrenderInd;

    /**
     * 申报说明
     */
    private String declarationExplain;

    /**
     * 险种适用范围
     */
    private String riskApplyType;

    /**
     * 产品版本
     */
    private String productEdition;

    /**
     * 批改保费计算模式
     */
    private String endorCalculateMode;

    /**
     * 即时生效标志
     */
    private String effectFlag;

    /**
     * 共保份额
     */
    private BigDecimal coinsRate;

    /**
     * 续保旧单号码续保新单号码
     */
    private String renewAlNo;

    /**
     * 自动续保标志
     */
    private String reewInd;

    /**
     * 是否被续保
     */
    private String reewEdInd;

    /**
     * 自动续保标志
     */
    private String autoRenewInd;

    /**
     * 续保新单号码
     */
    private String replacedPolicyNo;

    /**
     * 临分标识
     */
    private String reinsfacInd;

    /**
     * 风险等级代码
     */
    private String riskLevel;

    /**
     * 自留额
     */
    private BigDecimal keepAmount;

    /**
     * 打印次数
     */
    private Long printTimes;

    /**
     *  打印时间
     */
    private Date printDate;

    /**
     * 交强险起保日期
     */
    private Date motorVehicleStartDate;

    /**
     * 交强险终保日期
     */
    private Date motorVehicleEndDate;

    /**
     * 交强保单号
     */
    private String motorVehiclePolicyNo;

    /**
     * 投保公司
     */
    private String motorVehicleCompanyName;
    /**
     * 1-新车 2-续保 3-脱保 4-转保
     */
    private String newFlag;

    /**
     * 起保日期
     * @return startDate 起保日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 起保日期
     * @param startDate 起保日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 终保日期
     * @return endDate 终保日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 终保日期
     * @param endDate 终保日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 起保时区
     * @return startTimeZone 起保时区
     */
    public String getStartTimeZone() {
        return startTimeZone;
    }

    /**
     * 起保时区
     * @param startTimeZone 起保时区
     */
    public void setStartTimeZone(String startTimeZone) {
        this.startTimeZone = startTimeZone;
    }

    /**
     * 终保时区
     * @return endTimeZone 终保时区
     */
    public String getEndTimeZone() {
        return endTimeZone;
    }

    /**
     * 终保时区
     * @param endTimeZone 终保时区
     */
    public void setEndTimeZone(String endTimeZone) {
        this.endTimeZone = endTimeZone;
    }

    /**
     * 投保公司保单开始日
     * @return commenceDate 投保公司保单开始日
     */
    public Date getCommenceDate() {
        return commenceDate;
    }

    /**
     * 投保公司保单开始日
     * @param commenceDate 投保公司保单开始日
     */
    public void setCommenceDate(Date commenceDate) {
        this.commenceDate = commenceDate;
    }

    /**
     * 追溯起始日期
     * @return retroActiveStartDate 追溯起始日期
     */
    public Date getRetroActiveStartDate() {
        return retroActiveStartDate;
    }

    /**
     * 追溯起始日期
     * @param retroActiveStartDate 追溯起始日期
     */
    public void setRetroActiveStartDate(Date retroActiveStartDate) {
        this.retroActiveStartDate = retroActiveStartDate;
    }

    /**
     * 追溯终止日期
     * @return retroActiveEndDate 追溯终止日期
     */
    public Date getRetroActiveEndDate() {
        return retroActiveEndDate;
    }

    /**
     * 追溯终止日期
     * @param retroActiveEndDate 追溯终止日期
     */
    public void setRetroActiveEndDate(Date retroActiveEndDate) {
        this.retroActiveEndDate = retroActiveEndDate;
    }

    /**
     * 保单币别
     * @return currency 保单币别
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 保单币别
     * @param currency 保单币别
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 总保额
     * @return sumValue 总保额
     */
    public BigDecimal getSumValue() {
        return sumValue;
    }

    /**
     * 总保额
     * @param sumValue 总保额
     */
    public void setSumValue(BigDecimal sumValue) {
        this.sumValue = sumValue;
    }

    /**
     * 总毛保费
     * @return sumInsured 总毛保费
     */
    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    /**
     * 总毛保费
     * @param sumInsured 总毛保费
     */
    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public BigDecimal getSumGrossPremium() {
        return sumGrossPremium;
    }

    public void setSumGrossPremium(BigDecimal sumGrossPremium) {
        this.sumGrossPremium = sumGrossPremium;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSumNetPremium() {
        return sumNetPremium;
    }

    public void setSumNetPremium(BigDecimal sumNetPremium) {
        this.sumNetPremium = sumNetPremium;
    }

    public BigDecimal getLoading() {
        return loading;
    }

    public void setLoading(BigDecimal loading) {
        this.loading = loading;
    }

    public String getJudiCalCode() {
        return judiCalCode;
    }

    public void setJudiCalCode(String judiCalCode) {
        this.judiCalCode = judiCalCode;
    }

    public String getJudiCalScope() {
        return judiCalScope;
    }

    public void setJudiCalScope(String judiCalScope) {
        this.judiCalScope = judiCalScope;
    }

    public String getUwYear() {
        return uwYear;
    }

    public void setUwYear(String uwYear) {
        this.uwYear = uwYear;
    }

    public String getGeographicalArea() {
        return geographicalArea;
    }

    public void setGeographicalArea(String geographicalArea) {
        this.geographicalArea = geographicalArea;
    }

    public String getDeclarationInd() {
        return declarationInd;
    }

    public void setDeclarationInd(String declarationInd) {
        this.declarationInd = declarationInd;
    }

    public String getDeclarationInterval() {
        return declarationInterval;
    }

    public void setDeclarationInterval(String declarationInterval) {
        this.declarationInterval = declarationInterval;
    }

    public String getLowestPremiumInd() {
        return lowestPremiumInd;
    }

    public void setLowestPremiumInd(String lowestPremiumInd) {
        this.lowestPremiumInd = lowestPremiumInd;
    }

    public String getLowestPremCurrency() {
        return lowestPremCurrency;
    }

    public void setLowestPremCurrency(String lowestPremCurrency) {
        this.lowestPremCurrency = lowestPremCurrency;
    }

    public BigDecimal getLowestPremium() {
        return lowestPremium;
    }

    public void setLowestPremium(BigDecimal lowestPremium) {
        this.lowestPremium = lowestPremium;
    }

    public String getCommissionRateInd() {
        return commissionRateInd;
    }

    public void setCommissionRateInd(String commissionRateInd) {
        this.commissionRateInd = commissionRateInd;
    }

    public String getOuterRemark() {
        return outerRemark;
    }

    public void setOuterRemark(String outerRemark) {
        this.outerRemark = outerRemark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValidInd() {
        return validInd;
    }

    public void setValidInd(String validInd) {
        this.validInd = validInd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAdjustmentInd() {
        return adjustmentInd;
    }

    public void setAdjustmentInd(String adjustmentInd) {
        this.adjustmentInd = adjustmentInd;
    }

    public BigDecimal getSumUwPremium() {
        return sumUwPremium;
    }

    public void setSumUwPremium(BigDecimal sumUwPremium) {
        this.sumUwPremium = sumUwPremium;
    }

    public String getGeographicalAreaDesc() {
        return geographicalAreaDesc;
    }

    public void setGeographicalAreaDesc(String geographicalAreaDesc) {
        this.geographicalAreaDesc = geographicalAreaDesc;
    }

    public Date getDiscoverStartDate() {
        return discoverStartDate;
    }

    public void setDiscoverStartDate(Date discoverStartDate) {
        this.discoverStartDate = discoverStartDate;
    }

    public Date getDiscoverEndDate() {
        return discoverEndDate;
    }

    public void setDiscoverEndDate(Date discoverEndDate) {
        this.discoverEndDate = discoverEndDate;
    }

    public String getCompensationType() {
        return compensationType;
    }

    public void setCompensationType(String compensationType) {
        this.compensationType = compensationType;
    }

    public String getSubPolicyNo() {
        return subPolicyNo;
    }

    public void setSubPolicyNo(String subPolicyNo) {
        this.subPolicyNo = subPolicyNo;
    }

    public String getPolicyVisaType() {
        return policyVisaType;
    }

    public void setPolicyVisaType(String policyVisaType) {
        this.policyVisaType = policyVisaType;
    }

    public String getPolicyVisaSerialNo() {
        return policyVisaSerialNo;
    }

    public void setPolicyVisaSerialNo(String policyVisaSerialNo) {
        this.policyVisaSerialNo = policyVisaSerialNo;
    }

    public String getEndorVisaType() {
        return endorVisaType;
    }

    public void setEndorVisaType(String endorVisaType) {
        this.endorVisaType = endorVisaType;
    }

    public String getEndorVisaSerialNo() {
        return endorVisaSerialNo;
    }

    public void setEndorVisaSerialNo(String endorVisaSerialNo) {
        this.endorVisaSerialNo = endorVisaSerialNo;
    }

    public String getUwYearDays() {
        return uwYearDays;
    }

    public void setUwYearDays(String uwYearDays) {
        this.uwYearDays = uwYearDays;
    }

    public String getCombineInd() {
        return combineInd;
    }

    public void setCombineInd(String combineInd) {
        this.combineInd = combineInd;
    }

    public Long getBackDays() {
        return backDays;
    }

    public void setBackDays(Long backDays) {
        this.backDays = backDays;
    }

    public Date getDelayFinalEndDate() {
        return delayFinalEndDate;
    }

    public void setDelayFinalEndDate(Date delayFinalEndDate) {
        this.delayFinalEndDate = delayFinalEndDate;
    }

    public Date getDelayEndDate() {
        return delayEndDate;
    }

    public void setDelayEndDate(Date delayEndDate) {
        this.delayEndDate = delayEndDate;
    }

    public BigDecimal getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(BigDecimal bonusRate) {
        this.bonusRate = bonusRate;
    }

    public BigDecimal getReferBonusRate() {
        return referBonusRate;
    }

    public void setReferBonusRate(BigDecimal referBonusRate) {
        this.referBonusRate = referBonusRate;
    }

    public String getGeographicalAreaDetail() {
        return geographicalAreaDetail;
    }

    public void setGeographicalAreaDetail(String geographicalAreaDetail) {
        this.geographicalAreaDetail = geographicalAreaDetail;
    }

    public Date getDelayStartDate() {
        return delayStartDate;
    }

    public void setDelayStartDate(Date delayStartDate) {
        this.delayStartDate = delayStartDate;
    }

    public Short getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Short delayTime) {
        this.delayTime = delayTime;
    }

    public String getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(String businessClass) {
        this.businessClass = businessClass;
    }

    public String getCoinsInd() {
        return coinsInd;
    }

    public void setCoinsInd(String coinsInd) {
        this.coinsInd = coinsInd;
    }

    public String getSpecialReinsInd() {
        return specialReinsInd;
    }

    public void setSpecialReinsInd(String specialReinsInd) {
        this.specialReinsInd = specialReinsInd;
    }

    public String getUpdateCommissionInd() {
        return updateCommissionInd;
    }

    public void setUpdateCommissionInd(String updateCommissionInd) {
        this.updateCommissionInd = updateCommissionInd;
    }

    /**
     * 退保标志 1：退保 其他：正常
     * @return surrenderInd 退保标志 1：退保 其他：正常
     */
    public String getSurrenderInd() {
        return surrenderInd;
    }

    /**
     * 退保标志 1：退保 其他：正常
     * @param surrenderInd 退保标志 1：退保 其他：正常
     */

    public void setSurrenderInd(String surrenderInd) {
        this.surrenderInd = surrenderInd;
    }

    public String getDeclarationExplain() {
        return declarationExplain;
    }

    public void setDeclarationExplain(String declarationExplain) {
        this.declarationExplain = declarationExplain;
    }

    public String getRiskApplyType() {
        return riskApplyType;
    }

    public void setRiskApplyType(String riskApplyType) {
        this.riskApplyType = riskApplyType;
    }

    public String getProductEdition() {
        return productEdition;
    }

    public void setProductEdition(String productEdition) {
        this.productEdition = productEdition;
    }

    public String getEndorCalculateMode() {
        return endorCalculateMode;
    }

    public void setEndorCalculateMode(String endorCalculateMode) {
        this.endorCalculateMode = endorCalculateMode;
    }

    public String getEffectFlag() {
        return effectFlag;
    }

    public void setEffectFlag(String effectFlag) {
        this.effectFlag = effectFlag;
    }

    public BigDecimal getCoinsRate() {
        return coinsRate;
    }

    public void setCoinsRate(BigDecimal coinsRate) {
        this.coinsRate = coinsRate;
    }

    public String getRenewAlNo() {
        return renewAlNo;
    }

    public void setRenewAlNo(String renewAlNo) {
        this.renewAlNo = renewAlNo;
    }

    public String getReewInd() {
        return reewInd;
    }

    public void setReewInd(String reewInd) {
        this.reewInd = reewInd;
    }

    public String getReewEdInd() {
        return reewEdInd;
    }

    public void setReewEdInd(String reewEdInd) {
        this.reewEdInd = reewEdInd;
    }

    public String getAutoRenewInd() {
        return autoRenewInd;
    }

    public void setAutoRenewInd(String autoRenewInd) {
        this.autoRenewInd = autoRenewInd;
    }

    public String getReplacedPolicyNo() {
        return replacedPolicyNo;
    }

    public void setReplacedPolicyNo(String replacedPolicyNo) {
        this.replacedPolicyNo = replacedPolicyNo;
    }

    public String getReinsfacInd() {
        return reinsfacInd;
    }

    public void setReinsfacInd(String reinsfacInd) {
        this.reinsfacInd = reinsfacInd;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public BigDecimal getKeepAmount() {
        return keepAmount;
    }

    public void setKeepAmount(BigDecimal keepAmount) {
        this.keepAmount = keepAmount;
    }

    public Long getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Long printTimes) {
        this.printTimes = printTimes;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Date getMotorVehicleStartDate() {
        return motorVehicleStartDate;
    }

    public void setMotorVehicleStartDate(Date motorVehicleStartDate) {
        this.motorVehicleStartDate = motorVehicleStartDate;
    }

    public Date getMotorVehicleEndDate() {
        return motorVehicleEndDate;
    }

    public void setMotorVehicleEndDate(Date motorVehicleEndDate) {
        this.motorVehicleEndDate = motorVehicleEndDate;
    }

    public String getMotorVehiclePolicyNo() {
        return motorVehiclePolicyNo;
    }

    public void setMotorVehiclePolicyNo(String motorVehiclePolicyNo) {
        this.motorVehiclePolicyNo = motorVehiclePolicyNo;
    }

    public String getMotorVehicleCompanyName() {
        return motorVehicleCompanyName;
    }

    public void setMotorVehicleCompanyName(String motorVehicleCompanyName) {
        this.motorVehicleCompanyName = motorVehicleCompanyName;
    }

    /**
     * 1-新车 2-续保 3-脱保 4-转保
     * @return newFlag 1-新车 2-续保 3-脱保 4-转保
     */
    public String getNewFlag() {
        return newFlag;
    }

    /**
     * 1-新车 2-续保 3-脱保 4-转保
     * @param newFlag 1-新车 2-续保 3-脱保 4-转保
     */
    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }
}