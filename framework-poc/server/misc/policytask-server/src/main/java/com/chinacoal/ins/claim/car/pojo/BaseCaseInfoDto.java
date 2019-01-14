package com.chinacoal.ins.claim.car.pojo;

import java.util.Date;
/**
 * @author: wen
 * @date: 2018/11/2 17:10
 * @description: 案件基本信息（不对应数据库一张表）
 */
public class BaseCaseInfoDto {

	private String claimNo;
	private String riskCode;
	private String registNo;
	private Integer damageTimes;
	private String reportorName;
	private Date damageDate;
	private String caseStatus;
	private String caseFlag;
	private Date endCaseDate;

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

	public Date getDamageDate() {
		return damageDate;
	}

	public void setDamageDate(Date damageDate) {
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

	public Date getEndCaseDate() {
		return endCaseDate;
	}

	public void setEndCaseDate(Date endCaseDate) {
		this.endCaseDate = endCaseDate;
	}
}
