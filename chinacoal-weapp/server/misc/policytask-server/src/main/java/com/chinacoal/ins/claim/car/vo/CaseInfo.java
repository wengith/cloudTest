package com.chinacoal.ins.claim.car.vo;

/**
 * @author: wen
 * @date: 2018/11/23 11:26
 * @description: ����������Ϣ
 */
public class CaseInfo {

	/** ������ */
	private String claimNo;
	/** �ձ���� */
	private String riskCode;
	/** ������ */
	private String registNo;
	/** ���մ��� */
	private Integer damageTimes;
	/** ���������� */
	private String reportorName;
	/** ����ʱ�� */
	private String damageDate;
	/** ����״̬ */
	private String caseStatus;
	/** ���������ʶ */
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
