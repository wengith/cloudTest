package com.chinacoal.ins.claim.car.vo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/15 15:28
 * @description: 理赔查询简单接口报文VO
 */
public class SimpleClaimVo {

	/**报案号*/
	private String registNo;
	/**保单号*/
	private String policyNo;
	/**出单业务人员代码*/
	private String operaterCode;
	/**出单业务人员名称*/
	private String operaterName;
	/**代理人代码*/
	private String agentCode;
	/**代理人名称*/
	private String agentName;
	/**承保机构代码*/
	private String insuredComCode;
	/**险种代码*/
	private String riskCode;
	/**案件状态(案件当前最新环节)*/
	private String caseStatus;
	/**报案人*/
	private String reportorName;
	/**报案时间*/
	private String reportDate;
	/**报案人电话*/
	private String reporterMobile;
	/**出险时间*/
	private String damageDate;
	/**出险地点*/
	private String damageAddress;
	/**出险原因*/
	private String damageReason;
	/**查勘员(暂默认标的查勘)*/
	private String checkPerosn;
	/**立案时间*/
	private String claimDate;
	/**结案时间*/
	private String endCaseDate;
	/**支付时间*/
	private String payDate;
	/**估损/赔款金额*/
	private BigDecimal sumLoss;
	/**是否有人伤*/
	private String injuredInd;
	/**结案号*/
	private String endCaseNo;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getOperaterCode() {
		return operaterCode;
	}

	public void setOperaterCode(String operaterCode) {
		this.operaterCode = operaterCode;
	}

	public String getOperaterName() {
		return operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getInsuredComCode() {
		return insuredComCode;
	}

	public void setInsuredComCode(String insuredComCode) {
		this.insuredComCode = insuredComCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getReportorName() {
		return reportorName;
	}

	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}

	/**
	 * 报案时间
	 * @return reportDate 报案时间
	 */
	public String getReportDate() {
		return reportDate;
	}

	/**
	 * 报案时间 格式：yyyy-MM-dd HH:mm:ss
	 * @param reportDate 报案时间
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReporterMobile() {
		return reporterMobile;
	}

	public void setReporterMobile(String reporterMobile) {
		this.reporterMobile = reporterMobile;
	}

	public String getDamageDate() {
		return damageDate;
	}

	/**
	 * 出险时间 格式：yyyy-MM-dd HH:mm:ss
	 * @param damageDate 出险时间
	 */
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}

	public String getDamageAddress() {
		return damageAddress;
	}

	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}

	public String getDamageReason() {
		return damageReason;
	}

	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}

	public String getCheckPerosn() {
		return checkPerosn;
	}

	public void setCheckPerosn(String checkPerosn) {
		this.checkPerosn = checkPerosn;
	}

	public String getClaimDate() {
		return claimDate;
	}

	/**
	 * 立案时间 格式：yyyy-MM-dd HH:mm:ss
	 * @param claimDate 立案时间
	 */
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getEndCaseDate() {
		return endCaseDate;
	}

	/**
	 * 结案时间 格式：yyyy-MM-dd HH:mm:ss
	 * @param endCaseDate 结案时间
	 */
	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}

	public String getPayDate() {
		return payDate;
	}

	/**
	 * 支付时间 格式：yyyy-MM-dd HH:mm:ss
	 * @param payDate 支付时间
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getSumLoss() {
		return sumLoss;
	}

	public void setSumLoss(BigDecimal sumLoss) {
		this.sumLoss = sumLoss;
	}

	public String getInjuredInd() {
		return injuredInd;
	}

	public void setInjuredInd(String injuredInd) {
		this.injuredInd = injuredInd;
	}

	public String getEndCaseNo() {
		return endCaseNo;
	}

	public void setEndCaseNo(String endCaseNo) {
		this.endCaseNo = endCaseNo;
	}
}
