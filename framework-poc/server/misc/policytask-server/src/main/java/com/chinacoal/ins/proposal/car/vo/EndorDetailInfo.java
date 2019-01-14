package com.chinacoal.ins.proposal.car.vo;

/**
 * @author: wen
 * @date: 2018/10/25 10:23
 * @description: EndorDetailInfo 批改变化项
 */
public class EndorDetailInfo {

	/** 批改项 */
	private String endorName;
	/** 原值 */
	private String oldValue;
	/** 新值 */
	private String newValue;

	/**
	 * 批改项
	 * @return endorName 批改项
	 */
	public String getEndorName() {
		return endorName;
	}

	/**
	 * 批改项
	 * @param endorName 批改项
	 */
	public void setEndorName(String endorName) {
		this.endorName = endorName;
	}

	/**
	 * 原值
	 * @return oldValue 原值
	 */
	public String getOldValue() {
		return oldValue;
	}

	/**
	 * 原值
	 * @param oldValue 原值
	 */
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	/**
	 * 新值
	 * @return newValue 新值
	 */
	public String getNewValue() {
		return newValue;
	}

	/**
	 * 新值
	 * @param newValue 新值
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
}
