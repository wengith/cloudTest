package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/20 10:33
 * @description: 理赔费用DTO
 */
public class ClaimMoneyDto {

	/**计算书号*/
	private String compensateNo;
	/**赔付金额*/
	private BigDecimal sumPaid;
	/**责任比例*/
	private BigDecimal sumDutyPaid;
	/**费用金额*/
	private BigDecimal chargeAct;

	public BigDecimal getSumPaid() {
		return sumPaid;
	}

	public String getCompensateNo() {
		return compensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	public void setSumPaid(BigDecimal sumPaid) {
		this.sumPaid = sumPaid;
	}

	public BigDecimal getSumDutyPaid() {
		return sumDutyPaid;
	}

	public void setSumDutyPaid(BigDecimal sumDutyPaid) {
		this.sumDutyPaid = sumDutyPaid;
	}

	public BigDecimal getChargeAct() {
		return chargeAct;
	}

	public void setChargeAct(BigDecimal chargeAct) {
		this.chargeAct = chargeAct;
	}
}
