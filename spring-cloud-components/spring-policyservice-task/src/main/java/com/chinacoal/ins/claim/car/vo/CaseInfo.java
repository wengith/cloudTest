package com.chinacoal.ins.claim.car.vo;

/**
 * @author: wen
 * @date: 2018/11/23 11:26
 * @description: 基本案件信息
 */
public class CaseInfo {

	/** 立案号 */
	private String claimNo;
	/** 险别代码 */
	private String riskCode;
	/** 报案号 */
	private String registNo;
	/** 出险次数 */
	private Integer damageTimes;
	/** 报案人姓名 */
	private String reportorName;
	/** 出险时间 */
	private String damageDate;
	/** 案件状态 */
	private String caseStatus;
	/** 互碰自赔标识 */
	private String caseFlag;

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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

	public Integer getDamageTimes() {
		return damageTimes;
	}

	public void setDamageTimes(Integer damageTimes) {
		this.damageTimes = damageTimes;
	}

	public String getReportorName() {
		return reportorName;
	}

	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}

	public String getDamageDate() {
		return damageDate;
	}

	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getCaseFlag() {
		return caseFlag;
	}

	public void setCaseFlag(String caseFlag) {
		this.caseFlag = caseFlag;
	}
}
