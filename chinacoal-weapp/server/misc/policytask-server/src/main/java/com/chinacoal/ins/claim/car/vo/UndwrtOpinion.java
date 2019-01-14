package com.chinacoal.ins.claim.car.vo;

/**
 * @author: wen
 * @date: 2018/11/6 17:29
 * @description: 核赔意见列表
 */
public class UndwrtOpinion {

	/** 赔案号 */
	private String caseNo;
	/** 赔付次数 */
	private Integer claimTimes;
	/** 核赔次数 */
	private Integer undwrtTimes;
	/** 核赔意见 */
	private String undwrtOpinions;
	/** 核赔结论(1: 同意赔付  2：其他) */
	private String undwrtConclusion;
	/** 核赔时间(yyyy-MM-dd HH:mm:ss) */
	private String undwrtDate;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Integer getClaimTimes() {
		return claimTimes;
	}

	public void setClaimTimes(Integer claimTimes) {
		this.claimTimes = claimTimes;
	}

	public Integer getUndwrtTimes() {
		return undwrtTimes;
	}

	public void setUndwrtTimes(Integer undwrtTimes) {
		this.undwrtTimes = undwrtTimes;
	}

	public String getUndwrtOpinions() {
		return undwrtOpinions;
	}

	public void setUndwrtOpinions(String undwrtOpinions) {
		this.undwrtOpinions = undwrtOpinions;
	}

	public String getUndwrtConclusion() {
		return undwrtConclusion;
	}

	public void setUndwrtConclusion(String undwrtConclusion) {
		this.undwrtConclusion = undwrtConclusion;
	}

	public String getUndwrtDate() {
		return undwrtDate;
	}

	public void setUndwrtDate(String undwrtDate) {
		this.undwrtDate = undwrtDate;
	}
}
