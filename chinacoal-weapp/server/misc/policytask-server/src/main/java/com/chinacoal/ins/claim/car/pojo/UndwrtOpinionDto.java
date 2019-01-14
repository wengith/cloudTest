package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: wen
 * @date: 2018/11/6 17:13
 * @description: 核赔意见DTO
 */
public class UndwrtOpinionDto {

	/** 赔案号 */
	private String caseNo;
	/** 赔付次数 */
	private BigDecimal payTimes;
	/** 核赔次数 */
	private BigDecimal undwrtTimes;
	/** 核赔意见 */
	private String opinopns;
	/** 核赔结论(1: 同意赔付  2：其他) */
	private String conclusion;
	/** 核赔时间 */
	private Date undwrtDate;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public BigDecimal getPayTimes() {
		return payTimes;
	}

	public void setPayTimes(BigDecimal payTimes) {
		this.payTimes = payTimes;
	}

	public BigDecimal getUndwrtTimes() {
		return undwrtTimes;
	}

	public void setUndwrtTimes(BigDecimal undwrtTimes) {
		this.undwrtTimes = undwrtTimes;
	}

	public String getOpinopns() {
		return opinopns;
	}

	public void setOpinopns(String opinopns) {
		this.opinopns = opinopns;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Date getUndwrtDate() {
		return undwrtDate;
	}

	public void setUndwrtDate(Date undwrtDate) {
		this.undwrtDate = undwrtDate;
	}
}
