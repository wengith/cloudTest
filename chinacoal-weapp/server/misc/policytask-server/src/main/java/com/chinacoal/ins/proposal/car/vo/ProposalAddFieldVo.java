package com.chinacoal.ins.proposal.car.vo;

import java.util.Date;

/**
 * @author: wen
 * @date: 2018/10/29 17:29
 * @description: 保单查询增加字段VO
 */
public class ProposalAddFieldVo {
	/**支付方式*/
	private String payWay;
	/**缴费时间*/
	private Date payDate;

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
}
