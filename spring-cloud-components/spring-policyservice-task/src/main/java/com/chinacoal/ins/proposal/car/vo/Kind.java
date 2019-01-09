package com.chinacoal.ins.proposal.car.vo;

import java.util.Date;

/**
 * @author: wen
 * @date: 2018/10/18 11:08
 * @description: Kind 险别信息
 */
public class Kind {

	/** 险别代码 */
	private String kindCode;
	/** 险别名称 */
	private String kindName;
	/** 保险起始日期 */
	private String kindStartDate;
	/** 保险终止日期 */
	private String kindEndDate;
	/** 短期费率 */
	private Double shortPeriodRate;
	/** 保额 */
	private Double kindAmount;
	/** 费率 */
	private Double kindRate;
	/** 基准纯风险保费 */
	private Double kindBasePremium;
	/** 标准保费 */
	private Double kindBenchMarkPremium;
	/** 签单保费 */
	private Double kindPremium;
	/** 投保不计免赔 */
	private Boolean excludingDeductible;
	/** 主险 */
	private Boolean isMainKind;
	/** 玻璃类型 */
	private String kindGlassType;
	/** 座位数 */
	private Integer kindQuantity;
	/** 每座责任限额 */
	private Double kindUnitAmount;
	/** 免赔额 */
	private Double deductible;
	/** 绝对免赔额系数 */
	private Double franchise;

	/**
	 * 险别代码
	 * @return kindCode 险别代码
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 险别代码
	 * @param kindCode 险别代码
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	/**
	 * 险别名称
	 * @return kindName 险别名称
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 险别名称
	 * @param kindName 险别名称
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	/**
	 * 保险起始日期
	 * @return kindStartDate 保险起始日期
	 */
	public String getKindStartDate() {
		return kindStartDate;
	}
	/**
	 * 保险起始日期 yyyy-MM-dd HH:mm:ss
	 * @param kindStartDate 保险起始日期
	 */
	public void setKindStartDate(String kindStartDate) {
		this.kindStartDate = kindStartDate;
	}
	/**
	 * 保险终止日期
	 * @return kindEndDate 保险终止日期
	 */
	public String getKindEndDate() {
		return kindEndDate;
	}
	/**
	 * 保险终止日期 yyyy-MM-dd HH:mm:ss
	 * @param kindEndDate 保险终止日期
	 */
	public void setKindEndDate(String kindEndDate) {
		this.kindEndDate = kindEndDate;
	}
	/**
	 * 短期费率
	 * @return shortPeriodRate 短期费率
	 */
	public Double getShortPeriodRate() {
		return shortPeriodRate;
	}

	/**
	 * 短期费率
	 * @param shortPeriodRate 短期费率
	 */
	public void setShortPeriodRate(Double shortPeriodRate) {
		this.shortPeriodRate = shortPeriodRate;
	}
	/**
	 * 保额
	 * @return kindAmount
	 */
	public Double getKindAmount() {
		return kindAmount;
	}
	/**
	 * 保额
	 * @param kindAmount
	 */
	public void setKindAmount(Double kindAmount) {
		this.kindAmount = kindAmount;
	}
	/**
	 * 费率
	 * @return kindRate 费率
	 */
	public Double getKindRate() {
		return kindRate;
	}
	/**
	 * 费率
	 * @param kindRate 费率
	 */
	public void setKindRate(Double kindRate) {
		this.kindRate = kindRate;
	}
	/**
	 * 基准纯风险保费
	 * @return kindBasePremium 基准纯风险保费
	 */
	public Double getKindBasePremium() {
		return kindBasePremium;
	}
	/**
	 * 基准纯风险保费
	 * @param kindBasePremium 基准纯风险保费
	 */
	public void setKindBasePremium(Double kindBasePremium) {
		this.kindBasePremium = kindBasePremium;
	}
	/**
	 * 标准保费
	 * @return kindBenchMarkPremium 标准保费
	 */
	public Double getKindBenchMarkPremium() {
		return kindBenchMarkPremium;
	}
	/**
	 * 标准保费
	 * @param kindBenchMarkPremium 标准保费
	 */
	public void setKindBenchMarkPremium(Double kindBenchMarkPremium) {
		this.kindBenchMarkPremium = kindBenchMarkPremium;
	}
	/**
	 * 签单保费
	 * @return kindPremium 签单保费
	 */
	public Double getKindPremium() {
		return kindPremium;
	}
	/**
	 * 签单保费
	 * @param kindPremium 签单保费
	 */
	public void setKindPremium(Double kindPremium) {
		this.kindPremium = kindPremium;
	}
	/**
	 *
	 * @return excludingDeductible 投保不计免赔
	 */
	public Boolean getExcludingDeductible() {
		return excludingDeductible;
	}
	/**
	 * 投保不计免赔
	 * @param excludingDeductible 投保不计免赔
	 */
	public void setExcludingDeductible(Boolean excludingDeductible) {
		this.excludingDeductible = excludingDeductible;
	}
	/**
	 * 主险
	 * @return isMainKind 主险
	 */
	public Boolean getIsMainKind() {
		return isMainKind;
	}
	/**
	 * 主险
	 * @param isMainKind 主险
	 */
	public void setIsMainKind(Boolean isMainKind) {
		this.isMainKind = isMainKind;
	}
	/**
	 * 玻璃类型
	 * @return kindGlassType 玻璃类型
	 */
	public String getKindGlassType() {
		return kindGlassType;
	}
	/**
	 * 玻璃类型
	 * @param kindGlassType 玻璃类型
	 */
	public void setKindGlassType(String kindGlassType) {
		this.kindGlassType = kindGlassType;
	}
	/**
	 * 座位数
	 * @return kindQuantity 座位数
	 */
	public Integer getKindQuantity() {
		return kindQuantity;
	}
	/**
	 * 座位数
	 * @param kindQuantity 座位数
	 */
	public void setKindQuantity(Integer kindQuantity) {
		this.kindQuantity = kindQuantity;
	}
	/**
	 * 每座责任限额
	 * @return kindUnitAmount 每座责任限额
	 */
	public Double getKindUnitAmount() {
		return kindUnitAmount;
	}

	/**
	 * 每座责任限额
	 * @param kindUnitAmount 每座责任限额
	 */
	public void setKindUnitAmount(Double kindUnitAmount) {
		this.kindUnitAmount = kindUnitAmount;
	}

	/**
	 * 免赔额
	 * @return deductible 免赔额
	 */
	public Double getDeductible() {
		return deductible;
	}

	/**
	 * 免赔额
	 * @param deductible 免赔额
	 */
	public void setDeductible(Double deductible) {
		this.deductible = deductible;
	}

	/**
	 * 绝对免赔额系数
	 * @return franchise 绝对免赔额系数
	 */
	public Double getFranchise() {
		return franchise;
	}

	/**
	 * 绝对免赔额系数
	 * @param franchise 绝对免赔额系数
	 */
	public void setFranchise(Double franchise) {
		this.franchise = franchise;
	}
}
