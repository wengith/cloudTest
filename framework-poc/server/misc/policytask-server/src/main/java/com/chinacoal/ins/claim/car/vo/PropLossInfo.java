package com.chinacoal.ins.claim.car.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/7 17:35
 * @description: 财产损失项信息
 */
public class PropLossInfo {

	/**序号*/
	private Integer serialNo;
	/**赔案号*/
	private String caseNo;
	/**损失类别*/
	private String lossFeeType;
	/**总核定金额*/
	private BigDecimal sumPropLoss;
	/**损失归属方*/
	private String lossOwner;
	/**损失项详细信息*/
	private List<PropLossFee> propFeeList;

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

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

	public BigDecimal getSumPropLoss() {
		return sumPropLoss;
	}

	public void setSumPropLoss(BigDecimal sumPropLoss) {
		this.sumPropLoss = sumPropLoss;
	}

	public String getLossOwner() {
		return lossOwner;
	}

	public void setLossOwner(String lossOwner) {
		this.lossOwner = lossOwner;
	}

	public List<PropLossFee> getPropFeeList() {
		return propFeeList;
	}

	public void setPropFeeList(List<PropLossFee> propFeeList) {
		this.propFeeList = propFeeList;
	}
}
