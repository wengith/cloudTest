package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/2 10:19
 * @description: 定损清单（包括换件、修理等，不对应数据库一张表）
 */
public class VehicleRepairDto {

	/** 赔案号 */
	private String caseNo;
	/** 损失类别(本车：05  三者车：01) */
	private String lossFeeType;
	/** 损失车牌号 */
	private String lossLicenseNo;
	/** 损失车架号 */
	private String lossVinNo;
	/** 修理项目 */
	private String repairItemName;
	/** 配件名称 */
	private String componentName;
	/** 理算金额 */
	private BigDecimal veriSumAmount;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getLossFeeType() {
		return lossFeeType;
	}

	public void setLossFeeType(String lossFeeType) {
		this.lossFeeType = lossFeeType;
	}

	public String getLossLicenseNo() {
		return lossLicenseNo;
	}

	public void setLossLicenseNo(String lossLicenseNo) {
		this.lossLicenseNo = lossLicenseNo;
	}

	public String getLossVinNo() {
		return lossVinNo;
	}

	public void setLossVinNo(String lossVinNo) {
		this.lossVinNo = lossVinNo;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getRepairItemName() {
		return repairItemName;
	}

	public void setRepairItemName(String repairItemName) {
		this.repairItemName = repairItemName;
	}

	public BigDecimal getVeriSumAmount() {
		return veriSumAmount;
	}

	public void setVeriSumAmount(BigDecimal veriSumAmount) {
		this.veriSumAmount = veriSumAmount;
	}
}
