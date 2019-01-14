package com.chinacoal.ins.proposal.car.vo;

/**
 * @author: wen
 * @date: 2018/10/18 11:40
 * @description: Claiminfo 简单理赔信息
 */
public class Claiminfo {

	/** 保单号 */
	private String subPolicyNo;
	/** 报案号 */
	private String registNo;
	/** 立案号 */
	private String claimNo;
	/** 出险时间 */
	private String damageTime;
	/** 案件状态 */
	private String status;
	/** 结案时间 */
	private String endCaseDate;
	/** 赔付金额 */
	private Double payAmount;
	/**
	 * 保单号
	 * @return subPolicyNo 保单号
	 */
	public String getSubPolicyNo() {
		return subPolicyNo;
	}

	/**
	 * 保单号
	 * @param subPolicyNo 保单号
	 */
	public void setSubPolicyNo(String subPolicyNo) {
		this.subPolicyNo = subPolicyNo;
	}

	/**
	 * 报案号
	 * @return registNo 报案号
	 */
	public String getRegistNo() {
		return registNo;
	}

	/**
	 * 报案号
	 * @param registNo 报案号
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	/**
	 * 立案号
	 * @return claimNo 立案号
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * 立案号
	 * @param claimNo 立案号
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * 出险时间
	 * @return damageTime 出险时间
	 */
	public String getDamageTime() {
		return damageTime;
	}

	/**
	 * 出险时间
	 * @param damageTime 出险时间
	 */
	public void setDamageTime(String damageTime) {
		this.damageTime = damageTime;
	}

	/**
	 * 案件状态
	 * @return status 案件状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 案件状态
	 * @param status 案件状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 结案时间
	 * @return endCaseDate 结案时间
	 */
	public String getEndCaseDate() {
		return endCaseDate;
	}

	/**
	 * 结案时间
	 * @param endCaseDate 结案使劲
	 */
	public void setEndCaseDate(String  endCaseDate) {
		this.endCaseDate = endCaseDate;
	}

	/**
	 * 赔付金额
	 * @return payAmount 赔付金额
	 */
	public Double getPayAmount() {
		return payAmount;
	}

	/**
	 * 赔付金额
	 * @param payAmount 赔付金额
	 */
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
}
