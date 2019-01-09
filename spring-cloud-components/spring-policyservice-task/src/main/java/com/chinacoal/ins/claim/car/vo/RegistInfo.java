package com.chinacoal.ins.claim.car.vo;

/**
 * @author: wen
 * @date: 2018/11/5 09:45
 * @description: 报案详情信息RegistInfo
 */
public class RegistInfo {

	/** 赔案号 */
	private String caseNo;
	/** 保单号 */
	private String policyNo;
	/** 出险时间 */
	private String damageDate;
	/** 出险地点 */
	private String damageAddress;
	/** 出险原因代码 */
	private String damageCode;
	/** 出险原因名称 */
	private String damageName;
	/** 出险经过 */
	private String damageRemark;
	/** 报案时间 */
	private String reportDate;
	/** 报案人姓名 */
	private String reportorName;
	/** 报案人电话 */
	private String reportorPhone;
	/** 被保人代码 */
	private String insuriedCode;
	/** 被保人姓名 */
	private String insuriedName;
	/** 被保人证件号码 */
	private String insuredIdentifyNo;
	/** 车牌号 */
	private String licenseNo;
	/** 车架号 */
	private String vinNo;
	/** 发动机号 */
	private String engineNo;
	/** 厂牌车型名称 */
	private String brandName;
	/** 报案处理时间 */
	private String reportorDelDate;
	/** 产品名称 */
	private String productName;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * 出险时间
	 * @return damageDate 出险时间
	 */
	public String getDamageDate() {
		return damageDate;
	}

	/**
	 * 出险时间 （yyyy-MM-dd HH:mm:ss）
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

	public String getDamageRemark() {
		return damageRemark;
	}

	public void setDamageRemark(String damageRemark) {
		this.damageRemark = damageRemark;
	}

	/**
	 * 报案时间
	 * @return reportDate 报案时间
	 */
	public String getReportDate() {
		return reportDate;
	}

	/**
	 * 报案时间（yyyy-MM-dd HH:mm:ss）
	 * @param reportDate 报案时间
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportorName() {
		return reportorName;
	}

	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}

	public String getReportorPhone() {
		return reportorPhone;
	}

	public void setReportorPhone(String reportorPhone) {
		this.reportorPhone = reportorPhone;
	}

	public String getInsuriedCode() {
		return insuriedCode;
	}

	public void setInsuriedCode(String insuriedCode) {
		this.insuriedCode = insuriedCode;
	}

	public String getInsuriedName() {
		return insuriedName;
	}

	public void setInsuriedName(String insuriedName) {
		this.insuriedName = insuriedName;
	}

	public String getInsuredIdentifyNo() {
		return insuredIdentifyNo;
	}

	public void setInsuredIdentifyNo(String insuredIdentifyNo) {
		this.insuredIdentifyNo = insuredIdentifyNo;
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

	/**
	 * 报案处理时间
	 * @return reportorDelDate 报案处理时间
	 */
	public String getReportorDelDate() {
		return reportorDelDate;
	}

	/**
	 * 报案处理时间 （yyyy-MM-dd HH:mm:ss）
	 * @param reportorDelDate 报案处理时间
	 */
	public void setReportorDelDate(String reportorDelDate) {
		this.reportorDelDate = reportorDelDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
