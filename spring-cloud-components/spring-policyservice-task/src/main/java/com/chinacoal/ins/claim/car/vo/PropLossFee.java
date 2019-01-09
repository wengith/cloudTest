package com.chinacoal.ins.claim.car.vo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/7 17:37
 * @description: 财产损失明细信息
 */
public class PropLossFee {

	/**损失项编号*/
	private Integer lossFeeSerialNo;
	/**赔案号*/
	private String caseNo;
	/**险别代码*/
	private String itemKindCode;
	/**险别名称*/
	private String itemKindName;
	/**财产名称*/
	private String lossItemName;
	/**损失种类代码*/
	private String lossSpeciesCode;
	/**损失种类名称*/
	private String lossSpeciesName;
	/**损失比例（核损）*/
	private BigDecimal lossRate;
	/**核定单价*/
	private BigDecimal unitPrice;
	/**受损数量（核损）*/
	private Integer lossQuantity;
	/**核定金额*/
	private BigDecimal sunVeriLoss;

	public Integer getLossFeeSerialNo() {
		return lossFeeSerialNo;
	}

	public void setLossFeeSerialNo(Integer lossFeeSerialNo) {
		this.lossFeeSerialNo = lossFeeSerialNo;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getItemKindCode() {
		return itemKindCode;
	}

	public void setItemKindCode(String itemKindCode) {
		this.itemKindCode = itemKindCode;
	}

	public String getItemKindName() {
		return itemKindName;
	}

	public void setItemKindName(String itemKindName) {
		this.itemKindName = itemKindName;
	}

	public String getLossItemName() {
		return lossItemName;
	}

	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}

	public String getLossSpeciesCode() {
		return lossSpeciesCode;
	}

	public void setLossSpeciesCode(String lossSpeciesCode) {
		this.lossSpeciesCode = lossSpeciesCode;
	}

	public String getLossSpeciesName() {
		return lossSpeciesName;
	}

	public void setLossSpeciesName(String lossSpeciesName) {
		this.lossSpeciesName = lossSpeciesName;
	}

	public BigDecimal getLossRate() {
		return lossRate;
	}

	public void setLossRate(BigDecimal lossRate) {
		this.lossRate = lossRate;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getLossQuantity() {
		return lossQuantity;
	}

	public void setLossQuantity(Integer lossQuantity) {
		this.lossQuantity = lossQuantity;
	}

	public BigDecimal getSunVeriLoss() {
		return sunVeriLoss;
	}

	public void setSunVeriLoss(BigDecimal sunVeriLoss) {
		this.sunVeriLoss = sunVeriLoss;
	}
}
