package com.chinacoal.ins.claim.car.vo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/5 11:26
 * @description: 定损清单信息
 */
public class VehicleRepairInfo {

	/** 赔案号 */
	private String caseNo;
	/** 损失类别 */
	private String lossType;
	/** 损失车牌号 */
	private String lossLicenseNo;
	/** 损失车架号 */
	private String lossVinNo;
	/** 修理项目 */
	private String repairItemName;
	/** 损失项目名称 */
	private String componentName;
	/** 理算金额 */
	private BigDecimal veriSumAmount;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
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

	public String getRepairItemName() {
		return repairItemName;
	}

	public void setRepairItemName(String repairItemName) {
		this.repairItemName = repairItemName;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public BigDecimal getVeriSumAmount() {
		return veriSumAmount;
	}

	public void setVeriSumAmount(BigDecimal veriSumAmount) {
		this.veriSumAmount = veriSumAmount;
	}
}
