package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/5 16:34
 * @description: 人伤理算返回信息
 */
public class InjuredInfoDto {

	/**立案号*/
	private String caseNo;
	private String injuredName;
	private String injuredSex;
	private Integer injuredAge;
	private String injuredLossType;
	private String diagnose;
	private String contactName;
	private BigDecimal sumAmount;
	private Integer claimTimes;
	private Integer checkTimes;
	/**计算书号*/
	private String compenstaeNo;
	/**涉案伤者id*/
	private BigDecimal injuredId;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getInjuredName() {
		return injuredName;
	}

	public void setInjuredName(String injuredName) {
		this.injuredName = injuredName;
	}

	public String getInjuredSex() {
		return injuredSex;
	}

	public void setInjuredSex(String injuredSex) {
		this.injuredSex = injuredSex;
	}

	public Integer getInjuredAge() {
		return injuredAge;
	}

	public void setInjuredAge(Integer injuredAge) {
		this.injuredAge = injuredAge;
	}

	public String getInjuredLossType() {
		return injuredLossType;
	}

	public void setInjuredLossType(String injuredLossType) {
		this.injuredLossType = injuredLossType;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public BigDecimal getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Integer getClaimTimes() {
		return claimTimes;
	}

	public void setClaimTimes(Integer claimTimes) {
		this.claimTimes = claimTimes;
	}

	public Integer getCheckTimes() {
		return checkTimes;
	}

	public void setCheckTimes(Integer checkTimes) {
		this.checkTimes = checkTimes;
	}

	public String getCompenstaeNo() {
		return compenstaeNo;
	}

	public void setCompenstaeNo(String compenstaeNo) {
		this.compenstaeNo = compenstaeNo;
	}

	public BigDecimal getInjuredId() {
		return injuredId;
	}

	public void setInjuredId(BigDecimal injuredId) {
		this.injuredId = injuredId;
	}
}
