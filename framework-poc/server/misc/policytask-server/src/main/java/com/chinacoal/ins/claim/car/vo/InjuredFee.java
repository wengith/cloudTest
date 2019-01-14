package com.chinacoal.ins.claim.car.vo;

import sun.nio.cs.ext.Big5;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/5 14:06
 * @description: 人伤费用明细信息
 */
public class InjuredFee {

	/** 赔案号 */
	private String caseNo;
	/** 人伤明细编号 */
	private Integer injuredSerialNo;
	/** 赔付次数 */
	private Integer feeClaimTimes;
	/** 查勘次数 */
	private Integer feeCheckTimes;
	/**人伤费用代码*/
	private String injuredFeeCode;
	/** 人伤费用名称 */
	private String injuredFeeName;
	/** 交警裁定金额 */
	private BigDecimal polAmount;
	/** 我司裁定金额 */
	private BigDecimal realAmount;


	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Integer getInjuredSerialNo() {
		return injuredSerialNo;
	}

	public void setInjuredSerialNo(Integer injuredSerialNo) {
		this.injuredSerialNo = injuredSerialNo;
	}

	public Integer getFeeClaimTimes() {
		return feeClaimTimes;
	}

	public void setFeeClaimTimes(Integer feeClaimTimes) {
		this.feeClaimTimes = feeClaimTimes;
	}

	public Integer getFeeCheckTimes() {
		return feeCheckTimes;
	}

	public void setFeeCheckTimes(Integer feeCheckTimes) {
		this.feeCheckTimes = feeCheckTimes;
	}

	public String getInjuredFeeCode() {
		return injuredFeeCode;
	}

	public void setInjuredFeeCode(String injuredFeeCode) {
		this.injuredFeeCode = injuredFeeCode;
	}

	public String getInjuredFeeName() {
		return injuredFeeName;
	}

	public void setInjuredFeeName(String injuredFeeName) {
		this.injuredFeeName = injuredFeeName;
	}

	public BigDecimal getPolAmount() {
		return polAmount;
	}

	public void setPolAmount(BigDecimal polAmount) {
		this.polAmount = polAmount;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}
}
