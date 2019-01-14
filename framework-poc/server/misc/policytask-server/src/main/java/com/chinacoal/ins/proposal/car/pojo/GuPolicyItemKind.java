package com.chinacoal.ins.proposal.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GuPolicyItemKind extends GuPolicyItemKindKey {
    /**
     * 标的险别序号
     */
    private Long itemKindNo;

    /**
     * 标的序号
     */
    private Long itemNo;

    /**
     * 标的项目类别代码
     */
    private String itemCode;

    /**
     * 标的物序
     */
    private Long itemDetailNo;

    /**
     * 标的物代码
     */
    private String itemDetailCode;

    /**
     * 标的项目明细名称
     */
    private String itemDetailList;

    /**
     * 方案代码
     */
    private String projectCode;

    /**
     * 责任代码
     */
    private String liabCode;

    /**
     * 险别代码
     */
    private String kindCode;

    /**
     * 险别名称
     */
    private String kindName;

    /**
     * 投保方式代码
     */
    private String modeCode;

    /**
     * 投保方式名称
     */
    private String modeName;

    /**
     * 起保日期
     */
    private Date startDate;

    /**
     * 终保日期
     */
    private Date endDate;

    /**
     * 是否计算保额标志
     */
    private String calculateInd;

    /**
     * 币别
     */
    private String currency;

    /**
     *  单位保险价值
     */
    private BigDecimal unitValue;

    /**
     * 单位保险金额
     */
    private BigDecimal unitInsured;

    /**
     * 单位保费
     */
    private BigDecimal unitPremium;

    /**
     * 数量
     */
    private Long quantity;

    /**
     * 数量单位
     */
    private String unit;

    /**
     * 保险价值
     */
    private BigDecimal sumValue;

    /**
     * 保险金额
     */
    private BigDecimal sumInsured;

    /**
     * 适应费率期数
     */
    private Long ratePeriod;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 短期费率标志
     */
    private String shortRateFlag;

    /**
     * 短期费率
     */
    private BigDecimal shortRate;

    /**
     * 短期费率分子
     */
    private BigDecimal shortRateNumerator;

    /**
     * 短期费率分母
     */
    private Integer shortRateDenominator;

    /**
     *  基础保费
     */
    private BigDecimal basePremium;

    /**
     *  基准保费
     */
    private BigDecimal benchMarkPremium;

    /**
     * 加减费
     */
    private BigDecimal loading;

    /**
     * 毛保费
     */
    private BigDecimal grossPremium;

    /**
     * 折扣率
     */
    private BigDecimal discount;

    /**
     * 保费调整比率
     */
    private BigDecimal adjustRate;

    /**
     * 净保费
     */
    private BigDecimal netPremium;

    /**
     * 免赔率
     */
    private BigDecimal deductibleRate;

    /**
     * 免赔额
     */
    private BigDecimal deductible;

    /**
     * 保费计算公式
     */
    private String premiumFormula;

    /**
     * 年保费
     */
    private BigDecimal yearPremium;

    /**
     * 退保标志
     */
    private String surrenderInd;

    /**
     * 第一损失率
     */
    private BigDecimal firstLossRate;

    /**
     * 主险/附加险标志
     */
    private String kindInd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 份数
     */
    private Long uwCount;

    /**
     * 承保保费
     */
    private BigDecimal uwPremium;

    /**
     * 改前承保保费
     */
    private BigDecimal originUwPremium;

    /**
     * 改前应收保费
     */
    private BigDecimal originGrossPremium;

    /**
     * 基本险是否选择基本险不计免赔特约条款
     */
    private String relatedInd;

    /**
     * 批改保费调整比率
     */
    private BigDecimal endorAdjustRate;

    /**
     * 公共保额标志
     */
    private String pubInsuredInd;

    /**
     * 普通/特殊险别标志位
     */
    private String specialInd;

    /**
     * 分单号
     */
    private String subPolicyNo;

    /**
     * 是否必保标识
     */
    private String mustInsureInd;

    /**
     * 保费计算方式
     */
    private String premiumType;

    /**
     * 价值方式
     */
    private String valueType;

    /**
     * 绝对免赔额系数
     */
    private BigDecimal franchise;

    /**
     * 特殊分保标志
     */
    private String respecialInd;

    /**
     * 上浮比例
     */
    private BigDecimal riseProportion;

    /**
     * 从共保显示的整单保额
     */
    private BigDecimal sumOriginalInsured;

    /**
     * 险种套餐代码
     */
    private String riskPackageCode;

    /**
     * 税后保费
     */
    private BigDecimal noTaxPremium;

    /**
     * 增值税额
     */
    private BigDecimal valueAddedTax;

    public Long getItemKindNo() {
        return itemKindNo;
    }

    public void setItemKindNo(Long itemKindNo) {
        this.itemKindNo = itemKindNo;
    }

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getItemDetailNo() {
        return itemDetailNo;
    }

    public void setItemDetailNo(Long itemDetailNo) {
        this.itemDetailNo = itemDetailNo;
    }

    public String getItemDetailCode() {
        return itemDetailCode;
    }

    public void setItemDetailCode(String itemDetailCode) {
        this.itemDetailCode = itemDetailCode;
    }

    public String getItemDetailList() {
        return itemDetailList;
    }

    public void setItemDetailList(String itemDetailList) {
        this.itemDetailList = itemDetailList;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getLiabCode() {
        return liabCode;
    }

    public void setLiabCode(String liabCode) {
        this.liabCode = liabCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getModeCode() {
        return modeCode;
    }

    public void setModeCode(String modeCode) {
        this.modeCode = modeCode;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCalculateInd() {
        return calculateInd;
    }

    public void setCalculateInd(String calculateInd) {
        this.calculateInd = calculateInd;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(BigDecimal unitValue) {
        this.unitValue = unitValue;
    }

    public BigDecimal getUnitInsured() {
        return unitInsured;
    }

    public void setUnitInsured(BigDecimal unitInsured) {
        this.unitInsured = unitInsured;
    }

    public BigDecimal getUnitPremium() {
        return unitPremium;
    }

    public void setUnitPremium(BigDecimal unitPremium) {
        this.unitPremium = unitPremium;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getSumValue() {
        return sumValue;
    }

    public void setSumValue(BigDecimal sumValue) {
        this.sumValue = sumValue;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public Long getRatePeriod() {
        return ratePeriod;
    }

    public void setRatePeriod(Long ratePeriod) {
        this.ratePeriod = ratePeriod;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getShortRateFlag() {
        return shortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    public BigDecimal getShortRate() {
        return shortRate;
    }

    public void setShortRate(BigDecimal shortRate) {
        this.shortRate = shortRate;
    }

    public BigDecimal getShortRateNumerator() {
        return shortRateNumerator;
    }

    public void setShortRateNumerator(BigDecimal shortRateNumerator) {
        this.shortRateNumerator = shortRateNumerator;
    }

    public Integer getShortRateDenominator() {
        return shortRateDenominator;
    }

    public void setShortRateDenominator(Integer shortRateDenominator) {
        this.shortRateDenominator = shortRateDenominator;
    }

    public BigDecimal getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(BigDecimal basePremium) {
        this.basePremium = basePremium;
    }

    public BigDecimal getBenchMarkPremium() {
        return benchMarkPremium;
    }

    public void setBenchMarkPremium(BigDecimal benchMarkPremium) {
        this.benchMarkPremium = benchMarkPremium;
    }

    public BigDecimal getLoading() {
        return loading;
    }

    public void setLoading(BigDecimal loading) {
        this.loading = loading;
    }

    public BigDecimal getGrossPremium() {
        return grossPremium;
    }

    public void setGrossPremium(BigDecimal grossPremium) {
        this.grossPremium = grossPremium;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getAdjustRate() {
        return adjustRate;
    }

    public void setAdjustRate(BigDecimal adjustRate) {
        this.adjustRate = adjustRate;
    }

    public BigDecimal getNetPremium() {
        return netPremium;
    }

    public void setNetPremium(BigDecimal netPremium) {
        this.netPremium = netPremium;
    }

    public BigDecimal getDeductibleRate() {
        return deductibleRate;
    }

    public void setDeductibleRate(BigDecimal deductibleRate) {
        this.deductibleRate = deductibleRate;
    }

    public BigDecimal getDeductible() {
        return deductible;
    }

    public void setDeductible(BigDecimal deductible) {
        this.deductible = deductible;
    }

    public String getPremiumFormula() {
        return premiumFormula;
    }

    public void setPremiumFormula(String premiumFormula) {
        this.premiumFormula = premiumFormula;
    }

    public BigDecimal getYearPremium() {
        return yearPremium;
    }

    public void setYearPremium(BigDecimal yearPremium) {
        this.yearPremium = yearPremium;
    }

    public String getSurrenderInd() {
        return surrenderInd;
    }

    public void setSurrenderInd(String surrenderInd) {
        this.surrenderInd = surrenderInd;
    }

    public BigDecimal getFirstLossRate() {
        return firstLossRate;
    }

    public void setFirstLossRate(BigDecimal firstLossRate) {
        this.firstLossRate = firstLossRate;
    }

    public String getKindInd() {
        return kindInd;
    }

    public void setKindInd(String kindInd) {
        this.kindInd = kindInd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getUwCount() {
        return uwCount;
    }

    public void setUwCount(Long uwCount) {
        this.uwCount = uwCount;
    }

    public BigDecimal getUwPremium() {
        return uwPremium;
    }

    public void setUwPremium(BigDecimal uwPremium) {
        this.uwPremium = uwPremium;
    }

    public BigDecimal getOriginUwPremium() {
        return originUwPremium;
    }

    public void setOriginUwPremium(BigDecimal originUwPremium) {
        this.originUwPremium = originUwPremium;
    }

    public BigDecimal getOriginGrossPremium() {
        return originGrossPremium;
    }

    public void setOriginGrossPremium(BigDecimal originGrossPremium) {
        this.originGrossPremium = originGrossPremium;
    }

    public String getRelatedInd() {
        return relatedInd;
    }

    public void setRelatedInd(String relatedInd) {
        this.relatedInd = relatedInd;
    }

    public BigDecimal getEndorAdjustRate() {
        return endorAdjustRate;
    }

    public void setEndorAdjustRate(BigDecimal endorAdjustRate) {
        this.endorAdjustRate = endorAdjustRate;
    }

    public String getPubInsuredInd() {
        return pubInsuredInd;
    }

    public void setPubInsuredInd(String pubInsuredInd) {
        this.pubInsuredInd = pubInsuredInd;
    }

    public String getSpecialInd() {
        return specialInd;
    }

    public void setSpecialInd(String specialInd) {
        this.specialInd = specialInd;
    }

    public String getSubPolicyNo() {
        return subPolicyNo;
    }

    public void setSubPolicyNo(String subPolicyNo) {
        this.subPolicyNo = subPolicyNo;
    }

    public String getMustInsureInd() {
        return mustInsureInd;
    }

    public void setMustInsureInd(String mustInsureInd) {
        this.mustInsureInd = mustInsureInd;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public void setPremiumType(String premiumType) {
        this.premiumType = premiumType;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public BigDecimal getFranchise() {
        return franchise;
    }

    public void setFranchise(BigDecimal franchise) {
        this.franchise = franchise;
    }

    public String getRespecialInd() {
        return respecialInd;
    }

    public void setRespecialInd(String respecialInd) {
        this.respecialInd = respecialInd;
    }

    public BigDecimal getRiseProportion() {
        return riseProportion;
    }

    public void setRiseProportion(BigDecimal riseProportion) {
        this.riseProportion = riseProportion;
    }

    public BigDecimal getSumOriginalInsured() {
        return sumOriginalInsured;
    }

    public void setSumOriginalInsured(BigDecimal sumOriginalInsured) {
        this.sumOriginalInsured = sumOriginalInsured;
    }

    public String getRiskPackageCode() {
        return riskPackageCode;
    }

    public void setRiskPackageCode(String riskPackageCode) {
        this.riskPackageCode = riskPackageCode;
    }

    public BigDecimal getNoTaxPremium() {
        return noTaxPremium;
    }

    public void setNoTaxPremium(BigDecimal noTaxPremium) {
        this.noTaxPremium = noTaxPremium;
    }

    public BigDecimal getValueAddedTax() {
        return valueAddedTax;
    }

    public void setValueAddedTax(BigDecimal valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }
}