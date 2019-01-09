package com.chinacoal.ins.proposal.car.vo;

import java.util.Date;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/10/25 10:17
 * @description: EndorInfo 批改信息
 */
public class EndorInfo {

	/** 批单号 */
	private String endorNo;
	/** 险别代码 */
	private String riskCode;
	/** 批改类型 */
	private String endorType;
	/** 批改日期 */
	private String endorDate;
	/** 批改生效日期 */
	private String validDate;
	/** 批改后保额 */
	private Double suminsured;
	/** 批改后保费 */
	private Double grossPremium;
	/** 批改内容 */
	private String content;
	/** 批改申请人 */
	private String operator;
	/** 批改后保单状态 */
	private String invalidFlag;
	/** 批改变化项 */
	private List<EndorDetailInfo> endorInfoDetail;

	/**
	 * 批单号
	 * @return endorNo 批单号
	 */
	public String getEndorNo() {
		return endorNo;
	}

	/**
	 * 批单号
	 * @param endorNo 批单号
	 */
	public void setEndorNo(String endorNo) {
		this.endorNo = endorNo;
	}

	/**
	 * 险别代码
	 * @return riskCode 险别代码
	 */
	public String getRiskCode() {
		return riskCode;
	}

	/**
	 * 险别代码
	 * @param riskCode 险别代码
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 批改类型
	 * @return endorType 批改类型
	 */
	public String getEndorType() {
		return endorType;
	}

	/**
	 * 批改类型
	 * @param endorType 批改类型
	 */
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	}

	/**
	 * 批改日期
	 * @return endorDate 批改日期
	 */
	public String getEndorDate() {
		return endorDate;
	}

	/**
	 * 批改日期
	 * @param endorDate 批改日期
	 */
	public void setEndorDate(String endorDate) {
		this.endorDate = endorDate;
	}

	/**
	 * 批改生效日期
	 * @return validDate 批改生效日期
	 */
	public String getValidDate() {
		return validDate;
	}

	/**
	 * 批改生效日期
	 * @param validDate 批改生效日期
	 */
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	/**
	 * 批改后保额
	 * @return suminsured 批改后保额
	 */
	public Double getSuminsured() {
		return suminsured;
	}

	/**
	 * 批改后保额
	 * @param suminsured 批改后保额
	 */
	public void setSuminsured(Double suminsured) {
		this.suminsured = suminsured;
	}

	/**
	 * 批改后保费
	 * @return grossPremium 批改后保费
	 */
	public Double getGrossPremium() {
		return grossPremium;
	}

	/**
	 * 批改后保费
	 * @param grossPremium 批改后保费
	 */
	public void setGrossPremium(Double grossPremium) {
		this.grossPremium = grossPremium;
	}

	/**
	 * 批改内容
	 * @return content 批改内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 批改内容
	 * @param content 批改内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 批改申请人
	 * @return operator 批改申请人
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 批改申请人
	 * @param operator 批改申请人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 批改后保单状态
	 * @return invalidFlag 批改后保单状态
	 */
	public String getInvalidFlag() {
		return invalidFlag;
	}

	/**
	 * 批改后保单状态
	 * @param invalidFlag 批改后保单状态
	 */
	public void setInvalidFlag(String invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	/**
	 * 批改变化项
	 * @return endorInfoDetail 批改变化项
	 */
	public List<EndorDetailInfo> getEndorInfoDetail() {
		return endorInfoDetail;
	}

	/**
	 * 批改变化项
	 * @param endorInfoDetail 批改变化项
	 */
	public void setEndorInfoDetail(List<EndorDetailInfo> endorInfoDetail) {
		this.endorInfoDetail = endorInfoDetail;
	}
}
