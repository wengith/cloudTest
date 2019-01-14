package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/21 14:29
 * @description: 小额快赔金额Dto
 */
public class QuickPayInfoDto {

	/**报案号*/
	private String registNo;
	/**车辆定损金额*/
	private BigDecimal sumDefCarLoss;
	/**财产定损金额*/
	private BigDecimal sumDefPropLoss;
	/**人伤定损金额*/
	private BigDecimal sumDefPerLoss;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public BigDecimal getSumDefCarLoss() {
		return sumDefCarLoss;
	}

	public void setSumDefCarLoss(BigDecimal sumDefCarLoss) {
		this.sumDefCarLoss = sumDefCarLoss;
	}

	public BigDecimal getSumDefPropLoss() {
		return sumDefPropLoss;
	}

	public void setSumDefPropLoss(BigDecimal sumDefPropLoss) {
		this.sumDefPropLoss = sumDefPropLoss;
	}

	public BigDecimal getSumDefPerLoss() {
		return sumDefPerLoss;
	}

	public void setSumDefPerLoss(BigDecimal sumDefPerLoss) {
		this.sumDefPerLoss = sumDefPerLoss;
	}
}
