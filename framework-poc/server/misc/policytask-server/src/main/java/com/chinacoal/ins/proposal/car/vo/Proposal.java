package com.chinacoal.ins.proposal.car.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/10/18 14:33
 * @description: Proposal
 */
public class Proposal {

	/** 交互类型 */
	private String requestType;
	/** 报价单号 */
	private String quotationNo;
	/** 交强险保单号 */
	private String jqxPolicyNo;
	/** 商业险保单号 */
	private String syxPolicyNo;
	/** 批单号 */
	private String endorsementNo;
	/** 交强险业务类型 */
	private String jqxBusinessType;
	/** 商业险业务类型 */
	private String syxBusinessType;
	/** 出单机构 */
	private String operateComCode;
	/** 归属部门 */
	private String comCode;
	/** 三级机构 */
	private String thirdCompany;
	/** 二级机构 */
	private String secondCompany;
	/** 网点 */
	private String networkPoint;
	/** 业务来源 */
	private String businessNature;
	/** 业务来源细分 */
	private String businessNature1;
	/** 渠道一级 */
	private String channelNature1;
	/** 渠道二级 */
	private String channelNature2;
	/** 渠道三级 */
	private String channelNature3;
	/** 销售团队 */
	private String salesTeam;
	/** 业务员名称 */
	private String handlerName;
	/** 业务员代码 */
	private String handlerCode;
	/** 代理人名称 */
	private String agentName;
	/** 代理人代码 */
	private String agentCode;
	/** 代理协议号 */
	private String agreementNo;
	/** 投保日期 */
	private String operateDate;
	/** 交强险保额 */
	private Double jqxSumAmount;
	/** 交强险标准保费 */
	private Double jqxSumBasePremium;
	/** 交强险签单保费 */
	private Double jqxSumPremium;
	/** 交强险短期费率 */
	private Double jqxShortPeriodRate;
	/** 交强险保险起期 */
	private String jqxStartDate;
	/** 交强险保险止期 */
	private String jqxEndDate;
	/** 商业险保额 */
	private Double syxSumAmount;
	/** 商业险标准保费 */
	private Double syxSumBasePremium;
	/** 商业险签单保费 */
	private Double syxSumPremium;
	/** 商业险短期费率 */
	private Double syxShortPeriodRate;
	/** 商业险保险起期 */
	private String syxStartDate;
	/** 商业险保险止期 */
	private String syxEndDate;
	/** 交强险折扣 */
	private Double jqxPolicyRate;
	/** 商业险折扣 */
	private Double syxPolicyRate;
	/** 投保类型 */
	private String insuranceType;
	/** 交强险种代码 */
	private String jqxRiskCode;
	/** 商业险种代码 */
	private String syxRiskCode;
	/** 交强险保单状态 1:退保  0：正常 2:已失效*/
	private String jqxPolicyStatus;
	/** 商业险保单状态 */
	private String syxPolicyStatus;
	/** 支付方式 */
	private String payWay;
	/** 缴费时间 */
	private String payDate;
	/** 车辆 */
	private Vehicle vehicle;
	/** 车主 */
	private RelatedParty owner;
	/** 投保人 */
	private RelatedParty holder;
	/** 被保人 */
	private RelatedParty insured;
	/** 险别列表 */
	private List<Kind> kindList;
	/** 系数列表 */
	private List<Profit> profitList;
	/** 简单理赔信息列表 */
	private List<Claiminfo> claimList;
	/** 批改信息列表 */
	private List<EndorInfo> endorInfoList;

	/**
	 * 交强险保单状态
	 * @return jqxPolicyStatus 交强险保单状态
	 */
	public String getJqxPolicyStatus() {
		return jqxPolicyStatus;
	}

	/**
	 * 交强险保单状态
	 * @param jqxPolicyStatus 交强险保单状态
	 */
	public void setJqxPolicyStatus(String jqxPolicyStatus) {
		this.jqxPolicyStatus = jqxPolicyStatus;
	}

	/**
	 * 商业险保单状态
	 * @return syxPolicyStatus 商业险保单状态
	 */
	public String getSyxPolicyStatus() {
		return syxPolicyStatus;
	}

	/**
	 * 商业险保单状态
	 * @param syxPolicyStatus 商业险保单状态
	 */
	public void setSyxPolicyStatus(String syxPolicyStatus) {
		this.syxPolicyStatus = syxPolicyStatus;
	}

	/**
	 * 支付方式
	 * @return payWay 支付方式
	 */
	public String getPayWay() {
		return payWay;
	}

	/**
	 * 支付方式
	 * @param payWay 支付方式
	 */
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	/**
	 * 缴费时间
	 * @return payDate 缴费时间
	 */
	public String getPayDate() {
		return payDate;
	}

	/**
	 * 缴费时间
	 * @param payDate 缴费时间
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	/**
	 * 交互类型
	 * @return requestType 交互类型
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * 交互类型 (待确认V01)
	 * @param requestType 交互类型
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * 报价单号
	 * @return quotationNo 报价单号
	 */
	public String getQuotationNo() {
		return quotationNo;
	}

	/**
	 * 报价单号
	 * @param quotationNo 报价单号
	 */
	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	/**
	 * 交强险保单号
	 * @return jqxPolicyNo 交强险保单号
	 */
	public String getJqxPolicyNo() {
		return jqxPolicyNo;
	}

	/**
	 * 交强险保单号
	 * @param jqxPolicyNo 交强险保单号
	 */
	public void setJqxPolicyNo(String jqxPolicyNo) {
		this.jqxPolicyNo = jqxPolicyNo;
	}

	/**
	 * 商业险保单号
	 * @return syxPolicyNo 商业险保单号
	 */
	public String getSyxPolicyNo() {
		return syxPolicyNo;
	}

	/**
	 * 商业险保单号
	 * @param syxPolicyNo 商业险保单号
	 */
	public void setSyxPolicyNo(String syxPolicyNo) {
		this.syxPolicyNo = syxPolicyNo;
	}

	/**
	 * 批单号
	 * @return endorsementNo 批单号
	 */
	public String getEndorsementNo() {
		return endorsementNo;
	}

	/**
	 * 批单号
	 * @param endorsementNo 批单号
	 */
	public void setEndorsementNo(String endorsementNo) {
		this.endorsementNo = endorsementNo;
	}

	/**
	 * 交强险业务类型
	 * @return jqxBusinessType 交强险业务类型
	 */
	public String getJqxBusinessType() {
		return jqxBusinessType;
	}

	/**
	 * 交强险业务类型
	 * @param jqxBusinessType 交强险业务类型
	 */
	public void setJqxBusinessType(String jqxBusinessType) {
		this.jqxBusinessType = jqxBusinessType;
	}

	/**
	 * 商业险业务类型
	 * @return syxBusinessType 商业险业务类型
	 */
	public String getSyxBusinessType() {
		return syxBusinessType;
	}

	/**
	 * 商业险业务类型
	 * @param syxBusinessType 商业险业务类型
	 */
	public void setSyxBusinessType(String syxBusinessType) {
		this.syxBusinessType = syxBusinessType;
	}

	/**
	 * 出单机构
	 * @return operateComCode 出单机构
	 */
	public String getOperateComCode() {
		return operateComCode;
	}

	/**
	 * 出单机构
	 * @param operateComCode 出单机构
	 */
	public void setOperateComCode(String operateComCode) {
		this.operateComCode = operateComCode;
	}

	/**
	 * 归属部门
	 * @return comCode 归属部门
	 */
	public String getComCode() {
		return comCode;
	}

	/**
	 * 归属部门
	 * @param comCode 归属部门
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	/**
	 * 三级机构
	 * @return thirdCompany 三级机构
	 */
	public String getThirdCompany() {
		return thirdCompany;
	}

	/**
	 * 三级机构
	 * @param thirdCompany 三级机构
	 */
	public void setThirdCompany(String thirdCompany) {
		this.thirdCompany = thirdCompany;
	}

	/**
	 * 二级机构
	 * @return secondCompany 二级机构
	 */
	public String getSecondCompany() {
		return secondCompany;
	}

	/**
	 * 二级机构
	 * @param secondCompany 二级机构
	 */
	public void setSecondCompany(String secondCompany) {
		this.secondCompany = secondCompany;
	}

	/**
	 * 网点
	 * @return networkPoint 网点
	 */
	public String getNetworkPoint() {
		return networkPoint;
	}

	/**
	 * 网点
	 * @param networkPoint 网点
	 */
	public void setNetworkPoint(String networkPoint) {
		this.networkPoint = networkPoint;
	}

	/**
	 * 业务来源
	 * @return businessNature 业务来源
	 */
	public String getBusinessNature() {
		return businessNature;
	}

	/**
	 * 业务来源
	 * @param businessNature 业务来源
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	/**
	 * 业务来源细分
	 * @return businessNature1 业务来源细分
	 */
	public String getBusinessNature1() {
		return businessNature1;
	}

	/**
	 * 业务来源细分
	 * @param businessNature1 业务来源细分
	 */
	public void setBusinessNature1(String businessNature1) {
		this.businessNature1 = businessNature1;
	}

	/**
	 * 渠道一级
	 * @return channelNature1 渠道一级
	 */
	public String getChannelNature1() {
		return channelNature1;
	}

	/**
	 * 渠道一级
	 * @param channelNature1 渠道一级
	 */
	public void setChannelNature1(String channelNature1) {
		this.channelNature1 = channelNature1;
	}

	/**
	 * 渠道二级
	 * @return channelNature2 渠道二级
	 */
	public String getChannelNature2() {
		return channelNature2;
	}

	/**
	 * 渠道二级
	 * @param channelNature2 渠道二级
	 */
	public void setChannelNature2(String channelNature2) {
		this.channelNature2 = channelNature2;
	}

	/**
	 * 渠道三级
	 * @return channelNature3 渠道三级
	 */
	public String getChannelNature3() {
		return channelNature3;
	}

	/**
	 * 渠道三级
	 * @param channelNature3 渠道三级
	 */
	public void setChannelNature3(String channelNature3) {
		this.channelNature3 = channelNature3;
	}

	/**
	 * 销售团队
	 * @return salesTeam 销售团队
	 */
	public String getSalesTeam() {
		return salesTeam;
	}

	/**
	 * 销售团队
	 * @param salesTeam 销售团队
	 */
	public void setSalesTeam(String salesTeam) {
		this.salesTeam = salesTeam;
	}

	/**
	 * 业务员名称
	 * @return handlerName 业务员名称
	 */
	public String getHandlerName() {
		return handlerName;
	}

	/**
	 * 业务员名称
	 * @param handlerName 业务员名称
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	/**
	 * 业务员代码
	 * @return handlerCode 业务员代码
	 */
	public String getHandlerCode() {
		return handlerCode;
	}

	/**
	 * 业务员代码
	 * @param handlerCode 业务员代码
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	/**
	 * 代理人名称
	 * @return agentName 代理人名称
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * 代理人名称
	 * @param agentName 代理人名称
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * 代理人代码
	 * @return agentCode 代理人代码
	 */
	public String getAgentCode() {
		return agentCode;
	}

	/**
	 * 代理人代码
	 * @param agentCode 代理人代码
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	/**
	 * 代理协议号
	 * @return agreementNo 代理协议号
	 */
	public String getAgreementNo() {
		return agreementNo;
	}

	/**
	 * 代理协议号
	 * @param agreementNo 代理协议号
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	/**
	 * 投保日期
	 * @return 投保日期
	 */
	public String getOperateDate() {
		return operateDate;
	}

	/**
	 * 投保日期 yyyy-MM-dd HH:mm:ss
	 * @param operateDate 投保日期
	 */
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	/**
	 * 交强险保额
	 * @return jqxSumAmount 交强险保额
	 */
	public Double getJqxSumAmount() {
		return jqxSumAmount;
	}

	/**
	 * 交强险保额
	 * @param jqxSumAmount 交强险保额
	 */
	public void setJqxSumAmount(Double jqxSumAmount) {
		this.jqxSumAmount = jqxSumAmount;
	}

	/**
	 * 交强险标准保费
	 * @return jqxSumBasePremium 交强险标准保费
	 */
	public Double getJqxSumBasePremium() {
		return jqxSumBasePremium;
	}

	/**
	 * 交强险标准保费
	 * @param jqxSumBasePremium 交强险标准保费
	 */
	public void setJqxSumBasePremium(Double jqxSumBasePremium) {
		this.jqxSumBasePremium = jqxSumBasePremium;
	}

	/**
	 * 交强险签单保费
	 * @return jqxSumPremium 交强险签单保费
	 */
	public Double getJqxSumPremium() {
		return jqxSumPremium;
	}

	/**
	 * 交强险签单保费
	 * @param jqxSumPremium 交强险签单保费
	 */
	public void setJqxSumPremium(Double jqxSumPremium) {
		this.jqxSumPremium = jqxSumPremium;
	}

	/**
	 * 交强险短期费率
	 * @return jqxShortPeriodRate 交强险短期费率
	 */
	public Double getJqxShortPeriodRate() {
		return jqxShortPeriodRate;
	}

	/**
	 * 交强险短期费率
	 * @param jqxShortPeriodRate 交强险短期费率
	 */
	public void setJqxShortPeriodRate(Double jqxShortPeriodRate) {
		this.jqxShortPeriodRate = jqxShortPeriodRate;
	}

	/**
	 * 交强险保险起期
	 * @return jqxStartDate 交强险保险起期
	 */
	public String getJqxStartDate() {
		return jqxStartDate;
	}

	/**
	 * 交强险保险起期 (yyyy-MM-dd HH:mm:ss)
	 * @param jqxStartDate 交强险保险起期
	 */
	public void setJqxStartDate(String jqxStartDate) {
		this.jqxStartDate = jqxStartDate;
	}

	/**voucherinfo
	 * 交强险保险止期
	 * @return jqxEndDate 交强险保险止期
	 */
	public String getJqxEndDate() {
		return jqxEndDate;
	}

	/**
	 * 交强险保险止期 (yyyy-MM-dd HH:mm:ss)
	 * @param jqxEndDate 交强险保险止期
	 */
	public void setJqxEndDate(String jqxEndDate) {
		this.jqxEndDate = jqxEndDate;
	}

	/**
	 * 商业险保额
	 * @return syxSumAmount 商业险保额
	 */
	public Double getSyxSumAmount() {
		return syxSumAmount;
	}

	/**
	 * 商业险保额
	 * @param syxSumAmount 商业险保额
	 */
	public void setSyxSumAmount(Double syxSumAmount) {
		this.syxSumAmount = syxSumAmount;
	}

	/**
	 * 商业险标准保费
	 * @return syxSumBasePremium 商业险标准保费
	 */
	public Double getSyxSumBasePremium() {
		return syxSumBasePremium;
	}

	/**
	 * 商业险标准保费
	 * @param syxSumBasePremium 商业险标准保费
	 */
	public void setSyxSumBasePremium(Double syxSumBasePremium) {
		this.syxSumBasePremium = syxSumBasePremium;
	}

	/**
	 * 商业险签单保费
	 * @return syxSumPremium 商业险签单保费
	 */
	public Double getSyxSumPremium() {
		return syxSumPremium;
	}

	/**
	 * 商业险签单保费
	 * @param syxSumPremium 商业险签单保费
	 */
	public void setSyxSumPremium(Double syxSumPremium) {
		this.syxSumPremium = syxSumPremium;
	}

	/**
	 * 商业险短期费率
	 * @return syxShortPeriodRate 商业险短期费率
	 */
	public Double getSyxShortPeriodRate() {
		return syxShortPeriodRate;
	}

	/**
	 * 商业险短期费率
	 * @param syxShortPeriodRate 商业险短期费率
	 */
	public void setSyxShortPeriodRate(Double syxShortPeriodRate) {
		this.syxShortPeriodRate = syxShortPeriodRate;
	}

	/**
	 * 商业险保险起期
	 * @return syxStartDate 商业险保险起期
	 */
	public String getSyxStartDate() {
		return syxStartDate;
	}

	/**
	 * 商业险保险起期 (yyyy-MM-dd HH:mm:ss)
	 * @param syxStartDate 商业险保险起期
	 */
	public void setSyxStartDate(String syxStartDate) {
		this.syxStartDate = syxStartDate;
	}

	/**
	 * 商业险保险止期
	 * @return syxEndDate 商业险保险止期
	 */
	public String getSyxEndDate() {
		return syxEndDate;
	}

	/**
	 * 商业险保险止期 (yyyy-MM-dd HH:mm:ss)
	 * @param syxEndDate 商业险保险止期
	 */
	public void setSyxEndDate(String syxEndDate) {
		this.syxEndDate = syxEndDate;
	}

	/**
	 * 交强险折扣
	 * @return jqxPolicyRate 交强险折扣
	 */
	public Double getJqxPolicyRate() {
		return jqxPolicyRate;
	}

	/**
	 * 交强险折扣
	 * @param jqxPolicyRate 交强险折扣
	 */
	public void setJqxPolicyRate(Double jqxPolicyRate) {
		this.jqxPolicyRate = jqxPolicyRate;
	}

	/**
	 * 商业险折扣
	 * @return syxPolicyRate 商业险折扣
	 */
	public Double getSyxPolicyRate() {
		return syxPolicyRate;
	}

	/**
	 * 商业险折扣
	 * @param syxPolicyRate 商业险折扣
	 */
	public void setSyxPolicyRate(Double syxPolicyRate) {
		this.syxPolicyRate = syxPolicyRate;
	}

	/**
	 * 投保类型
	 * @return insuranceType 投保类型
	 */
	public String getInsuranceType() {
		return insuranceType;
	}

	/**
	 * 投保类型
	 * @param insuranceType 投保类型
	 */
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	/**
	 * 交强险种代码
	 * @return jqxRiskCode 交强险种代码
	 */
	public String getJqxRiskCode() {
		return jqxRiskCode;
	}

	/**
	 * 交强险种代码
	 * @param jqxRiskCode 交强险种代码
	 */
	public void setJqxRiskCode(String jqxRiskCode) {
		this.jqxRiskCode = jqxRiskCode;
	}

	/**
	 * 商业险种代码
	 * @return syxRiskCode 商业险种代码
	 */
	public String getSyxRiskCode() {
		return syxRiskCode;
	}

	/**
	 * 商业险种代码
	 * @param syxRiskCode 商业险种代码
	 */
	public void setSyxRiskCode(String syxRiskCode) {
		this.syxRiskCode = syxRiskCode;
	}

	/**
	 * 车辆信息
	 * @return vehicle 车辆信息
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * 车辆信息
	 * @param vehicle 车辆信息
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * 车主
	 * @return owner 车主
	 */
	public RelatedParty getOwner() {
		return owner;
	}

	/**
	 * 车主
	 * @param owner 车主
	 */
	public void setOwner(RelatedParty owner) {
		this.owner = owner;
	}

	/**
	 * 投保人
	 * @return holder 投保人
	 */
	public RelatedParty getHolder() {
		return holder;
	}

	/**
	 * 投保人
	 * @param holder 投保人
	 */
	public void setHolder(RelatedParty holder) {
		this.holder = holder;
	}

	/**
	 * 被保人
	 * @return insured 被保人
	 */
	public RelatedParty getInsured() {
		return insured;
	}

	/**
	 * 被保人
	 * @param insured 被保人
	 */
	public void setInsured(RelatedParty insured) {
		this.insured = insured;
	}

	/**
	 * 险别列表
	 * @return kindList 险别列表
	 */
	public List<Kind> getKindList() {
		return kindList;
	}

	/**
	 * 险别列表
	 * @param kindList 险别列表
	 */
	public void setKindList(List<Kind> kindList) {
		this.kindList = kindList;
	}

	/**
	 * 系数列表
	 * @return profitList 系数列表
	 */
	public List<Profit> getProfitList() {
		return profitList;
	}

	/**
	 * 系数列表
	 * @param profitList 系数列表
	 */
	public void setProfitList(List<Profit> profitList) {
		this.profitList = profitList;
	}

	/**
	 * 简单理赔信息列表
	 * @return claimList 简单理赔信息列表
	 */
	public List<Claiminfo> getClaimList() {
		return claimList;
	}

	/**
	 * 简单理赔信息列表
	 * @param claimList 简单理赔信息列表
	 */
	public void setClaimList(List<Claiminfo> claimList) {
		this.claimList = claimList;
	}

	/**
	 * 批改信息列表
	 * @return endorInfoList 批改信息列表
	 */
	public List<EndorInfo> getEndorInfoList() {
		return endorInfoList;
	}

	/**
	 * 批改信息列表
	 * @param endorInfoList 批改信息列表
	 */
	public void setEndorInfoList(List<EndorInfo> endorInfoList) {
		this.endorInfoList = endorInfoList;
	}
}
