package com.chinacoal.ins.proposal.car.vo;

/**
 * @author: wen
 * @date: 2018/10/18 12:58
 * @description: Profit 相关系数信息
 */
public class Profit {

	/** 名称 */
	private String profitName;
	/** 类型 */
	private String profitCode;
	/** 值 */
	private Double profitValue;
	/** 上限 */
	private Double profitMax;
	/** 下限 */
	private Double profitMin;

	/**
	 * 名称
	 * @return profitName 名称
	 */
	public String getProfitName() {
		return profitName;
	}

	/**
	 * 名称
	 * @param profitName 名称
	 */
	public void setProfitName(String profitName) {
		this.profitName = profitName;
	}

	/**
	 * 类型
	 * @return profitCode 类型
	 */
	public String getProfitCode() {
		return profitCode;
	}

	/**
	 * 类型
	 * @param profitCode 类型
	 */
	public void setProfitCode(String profitCode) {
		this.profitCode = profitCode;
	}

	/**
	 * 值
	 * @return profitValue 值
	 */
	public Double getProfitValue() {
		return profitValue;
	}

	/**
	 * 值
	 * @param profitValue 值
	 */
	public void setProfitValue(Double profitValue) {
		this.profitValue = profitValue;
	}

	/**
	 * 上限
	 * @return profitMax 上限
	 */
	public Double getProfitMax() {
		return profitMax;
	}

	/**
	 * 上限
	 * @param profitMax 上限
	 */
	public void setProfitMax(Double profitMax) {
		this.profitMax = profitMax;
	}

	/**
	 * 下限
	 * @return profitMin 下限
	 */
	public Double getProfitMin() {
		return profitMin;
	}

	/**
	 * 下限
	 * @param profitMin 下限
	 */
	public void setProfitMin(Double profitMin) {
		this.profitMin = profitMin;
	}
}
