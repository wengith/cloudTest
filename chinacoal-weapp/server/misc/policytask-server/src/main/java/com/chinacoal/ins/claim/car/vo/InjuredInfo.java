package com.chinacoal.ins.claim.car.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/5 11:06
 * @description: 伤者理算信息
 */
public class InjuredInfo {

	/** 赔案号 */
	private String caseNo;
	/** 伤者姓名 */
	private String injuredName;
	/** 伤者性别 */
	private String injuredSex;
	/** 伤者年龄 */
	private Integer injuredAge;
	/** 损失类型 */
	private String  injuredLossType;
	/** 诊断情况 */
	private String diagnose;
	/** 联系人 */
	private String contactName;
	/** 合计费用 */
	private BigDecimal sumAmount;
	/** 序号 */
	private Integer serialNo;
	/** 赔付次数 */
	private Integer claimTimes;
	/** 查勘次数 */
	private Integer checkTimes;
	/** 人伤费用明细列表 */
	private List<InjuredFee> injuredFeeList;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getInjuredName() {
		return injuredName;
	}

	public void setInjuredName(String injuredName) {
		this.injuredName = injuredName;
	}

	public String getInjuredSex() {
		return injuredSex;
	}

	public void setInjuredSex(String injuredSex) {
		this.injuredSex = injuredSex;
	}

	public Integer getInjuredAge() {
		return injuredAge;
	}

	public void setInjuredAge(Integer injuredAge) {
		this.injuredAge = injuredAge;
	}

	public String getInjuredLossType() {
		return injuredLossType;
	}

	public void setInjuredLossType(String injuredLossType) {
		this.injuredLossType = injuredLossType;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public BigDecimal getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getClaimTimes() {
		return claimTimes;
	}

	public void setClaimTimes(Integer claimTimes) {
		this.claimTimes = claimTimes;
	}

	public Integer getCheckTimes() {
		return checkTimes;
	}

	public void setCheckTimes(Integer checkTimes) {
		this.checkTimes = checkTimes;
	}

	public List<InjuredFee> getInjuredFeeList() {
		return injuredFeeList;
	}

	public void setInjuredFeeList(List<InjuredFee> injuredFeeList) {
		this.injuredFeeList = injuredFeeList;
	}
}
