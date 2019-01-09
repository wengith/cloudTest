package com.chinacoal.ins.claim.car.vo;

/**
 * @author: wen
 * @date: 2018/11/2 17:44
 * @description: 关联案件简单信息
 */
public class RelateCaseInfo {

	/** 关联立案号 */
	private String relateClaimNo;
	/** 险别代码 */
	private String relateRiskCode;
	/** 关联单出险次数 */
	private Integer relateDamageTimes;
	/** 关联案件报案人 */
	private String relateReportorName;
	/** 关联案件出险时间 */
	private String relateDamageDate;
	/** 关联案件状态 */
	private String relateCaseStatus;
	/** 关联案件互碰自赔标识 */
	private String relateCaseFlag;

	public String getRelateClaimNo() {
		return relateClaimNo;
	}

	public void setRelateClaimNo(String relateClaimNo) {
		this.relateClaimNo = relateClaimNo;
	}

	public String getRelateRiskCode() {
		return relateRiskCode;
	}

	public void setRelateRiskCode(String relateRiskCode) {
		this.relateRiskCode = relateRiskCode;
	}

	public Integer getRelateDamageTimes() {
		return relateDamageTimes;
	}

	public void setRelateDamageTimes(Integer relateDamageTimes) {
		this.relateDamageTimes = relateDamageTimes;
	}

	public String getRelateReportorName() {
		return relateReportorName;
	}

	public void setRelateReportorName(String relateReportorName) {
		this.relateReportorName = relateReportorName;
	}

	/**
	 * 出险时间 (yyyy-MM-dd HH:mm:ss)
	 * @return relateDamageDate 出险时间
	 */
	public String getRelateDamageDate() {
		return relateDamageDate;
	}

	/**
	 * 出险时间 (yyyy-MM-dd HH:mm:ss)
	 * @param relateDamageDate 出险时间
	 */
	public void setRelateDamageDate(String relateDamageDate) {
		this.relateDamageDate = relateDamageDate;
	}

	public String getRelateCaseStatus() {
		return relateCaseStatus;
	}

	public void setRelateCaseStatus(String relateCaseStatus) {
		this.relateCaseStatus = relateCaseStatus;
	}

	public String getRelateCaseFlag() {
		return relateCaseFlag;
	}

	public void setRelateCaseFlag(String relateCaseFlag) {
		this.relateCaseFlag = relateCaseFlag;
	}
}
