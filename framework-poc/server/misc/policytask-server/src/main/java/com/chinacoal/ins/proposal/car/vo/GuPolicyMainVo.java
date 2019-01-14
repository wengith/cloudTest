package com.chinacoal.ins.proposal.car.vo;

import java.util.Date;

/**
 * @author: wen
 * @date: 2018/10/25 16:04
 * @description: GuPolicyMain数据VO
 */
public class GuPolicyMainVo {
	/**
	 * 业务归属机构代码
	 */
	private String companyCode;

	/**
	 * 归属机构对应传统归属机构（互联网归属机构才有）
	 */
	private String CompanyCodeTradtional;
	/**
	 * 网点代码
	 */
	private String netPointCode;
	/**
	 * 渠道来源
	 */
	private String channelSource;
	/**
	 * 渠道来源细分
	 */
	private String channelSourceSub;

	/**
	 * 销售团队
	 */
	private String teamCode;
	/**
	 * 业务来源细分（一级业务来源）
	 */
	private String businessSourceSub;
	/**
	 * 二级业务来源
	 */
	private String businessDetail;
	/**
	 * 三级业务来源
	 */
	private String businessDetailThree;
	/**
	 * 业务员名称
	 */
	private String handlerName;
	/**
	 * 归属业务员代码
	 */
	private String salesManCode;
	/**
	 * 代理人名称
	 */
	private String agentName;
	/**
	 * 代理人代码
	 */
	private String IntermediaryCode;
	/**
	 * 中介协议号
	 */
	private String agreementNo;
	/**
	 * 签单日期
	 */
	private Date issueDate;
	/**
	 * 投保类型 1 单交强  2单商业 3组合单 4 异步关联
	 */
	private String insuranceType;
	/** 投保单号码 */
	private String proposalNo;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCodeTradtional() {
		return CompanyCodeTradtional;
	}

	public void setCompanyCodeTradtional(String companyCodeTradtional) {
		CompanyCodeTradtional = companyCodeTradtional;
	}

	public String getNetPointCode() {
		return netPointCode;
	}

	public void setNetPointCode(String netPointCode) {
		this.netPointCode = netPointCode;
	}

	public String getChannelSource() {
		return channelSource;
	}

	public void setChannelSource(String channelSource) {
		this.channelSource = channelSource;
	}

	public String getChannelSourceSub() {
		return channelSourceSub;
	}

	public void setChannelSourceSub(String channelSourceSub) {
		this.channelSourceSub = channelSourceSub;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getBusinessSourceSub() {
		return businessSourceSub;
	}

	public void setBusinessSourceSub(String businessSourceSub) {
		this.businessSourceSub = businessSourceSub;
	}

	public String getBusinessDetail() {
		return businessDetail;
	}

	public void setBusinessDetail(String businessDetail) {
		this.businessDetail = businessDetail;
	}

	public String getBusinessDetailThree() {
		return businessDetailThree;
	}

	public void setBusinessDetailThree(String businessDetailThree) {
		this.businessDetailThree = businessDetailThree;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public String getSalesManCode() {
		return salesManCode;
	}

	public void setSalesManCode(String salesManCode) {
		this.salesManCode = salesManCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getIntermediaryCode() {
		return IntermediaryCode;
	}

	public void setIntermediaryCode(String intermediaryCode) {
		IntermediaryCode = intermediaryCode;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

}
