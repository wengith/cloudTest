package com.chinacoal.ins.proposal.car.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: wen
 * @date: 2018/10/26 14:53
 * @description:
 */
public class EndorHeadInfoVo {
	/**
	 * policynoforendor
	 */
	private String policyNoForEndor;
	/**
	 * 批改申请号
	 */
	private String endorNo;
	/**
	 * 险别代码
	 */
	private String riskCode;
	/**
	 * 批改类型
	 */
	private String endorType;
	/**
	 * 批改日期
	 */
	private Date endorDate;
	/**
	 * 操作员代码/第一次录入人员代码
	 */
	private String operator;
	/**
	 * 生效日期
	 */
	private Date validDate;
	/**
	 * 批改后保额
	 */
	private BigDecimal sumInsured;
	/**
	 * 批改后保费
	 */
	private BigDecimal grossPremium;
	/**
	 * 批单内容
	 */
	private String content;
	/**
	 * 批改后保单状态
	 */
	private String invalidFlag;

	public String getPolicyNoForEndor() {
		return policyNoForEndor;
	}

	public void setPolicyNoForEndor(String policyNoForEndor) {
		this.policyNoForEndor = policyNoForEndor;
	}

	public String getEndorNo() {
		return endorNo;
	}

	public void setEndorNo(String endorNo) {
		this.endorNo = endorNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getEndorType() {
		return endorType;
	}

	public void setEndorType(String endorType) {
		this.endorType = endorType;
	}

	public Date getEndorDate() {
		return endorDate;
	}

	public void setEndorDate(Date endorDate) {
		this.endorDate = endorDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}

	public BigDecimal getGrossPremium() {
		return grossPremium;
	}

	public void setGrossPremium(BigDecimal grossPremium) {
		this.grossPremium = grossPremium;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(String invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

}
