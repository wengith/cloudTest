package com.chinacoal.ins.claim.car.vo;

import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/1 18:33
 * @description: 理赔接口数据
 */
public class ClaimData {

	/** 交互类型 */
	private String requestType;
	/** 查询单号 */
	private String policyNo;
	/**理赔信息列表*/
	private List<CaseInfo> caseInfoList;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public List<CaseInfo> getCaseInfoList() {
		return caseInfoList;
	}

	public void setCaseInfoList(List<CaseInfo> caseInfoList) {
		this.caseInfoList = caseInfoList;
	}
}
