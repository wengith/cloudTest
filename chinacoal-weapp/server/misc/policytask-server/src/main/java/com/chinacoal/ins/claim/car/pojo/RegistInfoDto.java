package com.chinacoal.ins.claim.car.pojo;

import java.util.Date;

/**
 * @author: wen
 * @date: 2018/11/7 10:16
 * @description:
 */
public class RegistInfoDto {

	/**保单号*/
	private String policyNo;
	/**报案日期*/
	private Date reportDate;
	/**报案时间*/
	private String reportHour;
	/**报案人*/
	private String reportorName;
	/**报案人手机*/
	private String reportorMobile;
	/**出险日期*/
	private Date damageDate;
	/**出险时间*/
	private String damageHour;
	/**出险原因代码*/
	private String damageCode;
	/**出险原因说明*/
	private String damageName;
	/**出险地点*/
	private String damageAddress;
	/**计算机输单日期*/
	private Date inputTime;
	/**出险经过*/
	private String remark;
	/**被保险人代码*/
	private String insuredCode;
	/**被保险人名称*/
	private String insuredName;
	/**被保险人证件号码*/
	private String identifyNumber;
	/**车牌号*/
	private String licenseNo;
	/**车架号*/
	private String vinNo;
	/**发动机号*/
	private String engineNo;
	/**厂牌车型名称*/
	private String brandName;
	/**产品名称*/
	private String proName;

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportHour() {
		return reportHour;
	}

	public void setReportHour(String reportHour) {
		this.reportHour = reportHour;
	}

	public String getReportorName() {
		return reportorName;
	}

	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}

	public String getReportorMobile() {
		return reportorMobile;
	}

	public void setReportorMobile(String reportorMobile) {
		this.reportorMobile = reportorMobile;
	}

	public Date getDamageDate() {
		return damageDate;
	}

	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
	}

	public String getDamageHour() {
		return damageHour;
	}

	public void setDamageHour(String damageHour) {
		this.damageHour = damageHour;
	}

	public String getDamageCode() {
		return damageCode;
	}

	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}

	public String getDamageName() {
		return damageName;
	}

	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}

	public String getDamageAddress() {
		return damageAddress;
	}

	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
}
