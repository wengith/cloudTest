package com.chinacoal.ins.claim.car.vo;

import java.math.BigDecimal;

/**
 * @author: wen
 * @date: 2018/11/5 10:06
 * @description: 理赔节点信息列表(当前节点以及以前节点信息)
 */
public class ClaimMainInfo {

	/** 案件号 */
	private String registNo;
	/** 赔案号 */
	private String caseNo;
	/** 保单号 */
	private String policyNo;
	/** 赔付次数 */
	private Integer claimTimes;
	/** 赔案类型 */
	private String claimTypeCode;
	/** 理赔类型名称 */
	private String claimTypeName;
	/** 主状态代码 */
	private String mainStatusCode;
	/** 赔案主状态名称 */
	private String mainStatusName;
	/**节点状态*/
	private String nodeState;
	/** 辅状态 */
	private String subStatusCode;
	/** 赔案辅状态名称 */
	private String subStatusName;
	/** 产品号 */
	private String prodCode;
	/** 产品大类号 */
	private String prodKindCode;
	/** 产品名称 */
	private String prodName;
	/** 赔付被保险人金额 */
	private BigDecimal insuredPayAmt;
	/** 实付被保险人金额 */
	private BigDecimal insuredRealPayAmt;
	/** 本次总赔付金额 */
	private BigDecimal sumPayAct;
	/** 核赔人代码 */
	private String undwrtHanlderCode;
	/** 核赔人名称 */
	private String undwrtHanlderName;
	/** 核赔时间 */
	private String undwrtDate;
	/** 结案人代码 */
	private String endCaseHandlerCode;
	/** 结案人名称 */
	private String endCaseHandlerName;
	/** 结案时间 */
	private String endCaseDate;
	/** 核损处理人代码 */
	private String operatorCode;
	/** 核损处理人名称 */
	private String operatorName;
	/** 核损处理时间 */
	private String chkLossDealDate;
	/** 索赔资料收齐标志 */
	private String collectFlag;
	/** 资料收集处理人 */
	private String collHandlerCode;
	/** 资料收集处理人名称 */
	private String collHandlerName;
	/** 资料收集处理时间 */
	private String collectDealDate;
	/** 受理人代码 */
	private String receiverCode;
	/** 受理人名称 */
	private String receiverName;
	/** 拒赔理由 */
	private String rejectedReason;
	/** 机构代码 */
	private String comCode;
	/** 撤案意见 */
	private String cancelCaseOpinion;
	/** 立案机构 */
	private String registComCode;
	/** 立案时间 */
	private String registDate;
	/** 撤案时间 */
	private String cancelCaseDate;
	/** 理算时间 */
	private String compensateDate;
	/** 核损时间 */
	private String checkLossDate;
	/** 查勘时间 */
	private String checkDate;
	/** 派工时间 */
	private String scheduleDate;
	/** 赔案创建时间*/
	private String claimCreatDate;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Integer getClaimTimes() {
		return claimTimes;
	}

	public void setClaimTimes(Integer claimTimes) {
		this.claimTimes = claimTimes;
	}

	public String getClaimTypeCode() {
		return claimTypeCode;
	}

	public void setClaimTypeCode(String claimTypeCode) {
		this.claimTypeCode = claimTypeCode;
	}

	public String getClaimTypeName() {
		return claimTypeName;
	}

	public void setClaimTypeName(String claimTypeName) {
		this.claimTypeName = claimTypeName;
	}

	public String getMainStatusCode() {
		return mainStatusCode;
	}

	public void setMainStatusCode(String mainStatusCode) {
		this.mainStatusCode = mainStatusCode;
	}

	public String getMainStatusName() {
		return mainStatusName;
	}

	public void setMainStatusName(String mainStatusName) {
		this.mainStatusName = mainStatusName;
	}
	public String getNodeState() {
		return nodeState;
	}
	public void setNodeState(String nodeState) {
		this.nodeState = nodeState;
	}
	public String getSubStatusCode() {
		return subStatusCode;
	}

	public void setSubStatusCode(String subStatusCode) {
		this.subStatusCode = subStatusCode;
	}

	public String getSubStatusName() {
		return subStatusName;
	}

	public void setSubStatusName(String subStatusName) {
		this.subStatusName = subStatusName;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdKindCode() {
		return prodKindCode;
	}

	public void setProdKindCode(String prodKindCode) {
		this.prodKindCode = prodKindCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public BigDecimal getInsuredPayAmt() {
		return insuredPayAmt;
	}

	public void setInsuredPayAmt(BigDecimal insuredPayAmt) {
		this.insuredPayAmt = insuredPayAmt;
	}

	public BigDecimal getInsuredRealPayAmt() {
		return insuredRealPayAmt;
	}

	public void setInsuredRealPayAmt(BigDecimal insuredRealPayAmt) {
		this.insuredRealPayAmt = insuredRealPayAmt;
	}

	public BigDecimal getSumPayAct() {
		return sumPayAct;
	}

	public void setSumPayAct(BigDecimal sumPayAct) {
		this.sumPayAct = sumPayAct;
	}

	public String getUndwrtHanlderCode() {
		return undwrtHanlderCode;
	}

	public void setUndwrtHanlderCode(String undwrtHanlderCode) {
		this.undwrtHanlderCode = undwrtHanlderCode;
	}

	public String getUndwrtHanlderName() {
		return undwrtHanlderName;
	}

	public void setUndwrtHanlderName(String undwrtHanlderName) {
		this.undwrtHanlderName = undwrtHanlderName;
	}

	/**
	 * 核赔时间
	 * @return undwrtDate 核赔时间
	 */
	public String getUndwrtDate() {
		return undwrtDate;
	}

	/**
	 * 核赔时间 (yyyy-MM-dd HH:mm:ss)
	 * @param undwrtDate 核赔时间
	 */
	public void setUndwrtDate(String undwrtDate) {
		this.undwrtDate = undwrtDate;
	}

	public String getEndCaseHandlerCode() {
		return endCaseHandlerCode;
	}

	public void setEndCaseHandlerCode(String endCaseHandlerCode) {
		this.endCaseHandlerCode = endCaseHandlerCode;
	}

	public String getEndCaseHandlerName() {
		return endCaseHandlerName;
	}

	public void setEndCaseHandlerName(String endCaseHandlerName) {
		this.endCaseHandlerName = endCaseHandlerName;
	}

	public String getEndCaseDate() {
		return endCaseDate;
	}

	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getChkLossDealDate() {
		return chkLossDealDate;
	}

	public void setChkLossDealDate(String chkLossDealDate) {
		this.chkLossDealDate = chkLossDealDate;
	}

	public String getCollectFlag() {
		return collectFlag;
	}

	public void setCollectFlag(String collectFlag) {
		this.collectFlag = collectFlag;
	}

	public String getCollHandlerCode() {
		return collHandlerCode;
	}

	public void setCollHandlerCode(String collHandlerCode) {
		this.collHandlerCode = collHandlerCode;
	}

	public String getCollHandlerName() {
		return collHandlerName;
	}

	public void setCollHandlerName(String collHandlerName) {
		this.collHandlerName = collHandlerName;
	}

	public String getCollectDealDate() {
		return collectDealDate;
	}

	public void setCollectDealDate(String collectDealDate) {
		this.collectDealDate = collectDealDate;
	}

	public String getReceiverCode() {
		return receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getCancelCaseOpinion() {
		return cancelCaseOpinion;
	}

	public void setCancelCaseOpinion(String cancelCaseOpinion) {
		this.cancelCaseOpinion = cancelCaseOpinion;
	}

	public String getRegistComCode() {
		return registComCode;
	}

	public void setRegistComCode(String registComCode) {
		this.registComCode = registComCode;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getCancelCaseDate() {
		return cancelCaseDate;
	}

	public void setCancelCaseDate(String cancelCaseDate) {
		this.cancelCaseDate = cancelCaseDate;
	}

	public String getCompensateDate() {
		return compensateDate;
	}

	public void setCompensateDate(String compensateDate) {
		this.compensateDate = compensateDate;
	}

	public String getCheckLossDate() {
		return checkLossDate;
	}

	public void setCheckLossDate(String checkLossDate) {
		this.checkLossDate = checkLossDate;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getClaimCreatDate() {
		return claimCreatDate;
	}

	public void setClaimCreatDate(String claimCreatDate) {
		this.claimCreatDate = claimCreatDate;
	}
}
