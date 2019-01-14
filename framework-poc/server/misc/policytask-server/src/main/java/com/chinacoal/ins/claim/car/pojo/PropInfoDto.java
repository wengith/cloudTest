package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/7 16:33
 * @description: 财产损失信息DTO
 */
public class PropInfoDto {

	/**赔案号*/
	private String caseNo;
	/**损失项id*/
	private BigDecimal propMainId;
	/**报案号*/
	private String registNo;
	/**损失类别*/
	private String lossFeeType;
	/**总核定金额*/
	private BigDecimal sumVeriLoss;
	/**损失归属方*/
	private BigDecimal lossOwnerId;
	/**险种代码*/
	private String riskCode;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public BigDecimal getPropMainId() {
		return propMainId;
	}

	public void setPropMainId(BigDecimal propMainId) {
		this.propMainId = propMainId;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getLossFeeType() {
		return lossFeeType;
	}

	public void setLossFeeType(String lossFeeType) {
		this.lossFeeType = lossFeeType;
	}

	public BigDecimal getSumVeriLoss() {
		return sumVeriLoss;
	}

	public void setSumVeriLoss(BigDecimal sumVeriLoss) {
		this.sumVeriLoss = sumVeriLoss;
	}

	public BigDecimal getLossOwnerId() {
		return lossOwnerId;
	}

	public void setLossOwnerId(BigDecimal lossOwnerId) {
		this.lossOwnerId = lossOwnerId;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
}
