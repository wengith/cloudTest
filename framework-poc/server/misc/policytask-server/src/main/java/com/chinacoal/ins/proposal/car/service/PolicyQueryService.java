package com.chinacoal.ins.proposal.car.service;

import com.chinacoal.ins.proposal.car.pojo.*;
import com.chinacoal.ins.proposal.car.vo.EndorHeadInfoVo;
import com.chinacoal.ins.proposal.car.vo.Proposal;

import java.util.HashMap;
import java.util.List;

/**
 * @auther: wen
 * @date: 2018/10/23 10:32
 * @description: 保单查询Service
 */
public interface PolicyQueryService {
	/**
	 * 功能描述:保单查询
	 * @author: wen
	 * @date: 2018/10/27 17:40
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.proposal.car.vo.Proposal
	 */
	public Proposal policyQuery(HashMap<String, Object> reqMap) throws Exception;
	/**
	 * 功能描述:查询被保人信息
	 * @author: wen
	 * @date: 2018/10/24 11:30
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.proposal.car.pojo.Gupolicyriskrelatedparty
	 */
	public GuPolicyRiskRelatedParty findInsured(HashMap<String, Object> reqMap);
	/**
	 * 功能描述: 保单查询接口报文组装
	 * @author: wen
	 * @date: 2018/10/27 17:32
	 * @param: [subPolicyNo, policyNo, proposal, guPolicyRiskDtos, reqMap]
	 * @return: void
	 */
	public void transferToProposal(String subPolicyNo, String policyNo, Proposal proposal, List<GuPolicyRisk> guPolicyRiskDtos, HashMap<String, Object> reqMap) throws Exception;
	/**
	 * 功能描述: 报文车辆节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:38
	 * @param: [policyNo, proposal, vehicleMotor]
	 * @return: void
	 */
	public void transferToVehicleModel(String policyNo, Proposal proposal, GuPolicyItemMotor vehicleMotor) throws Exception;
	/**
	 * 功能描述:  报文险别列表节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:38
	 * @param: [proposal, kinds]
	 * @return: void
	 */
	public void transferToKindModel(Proposal proposal, List<GuPolicyItemKind> kinds) throws Exception;
	/**
	 * 功能描述: 报文车主节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:37
	 * @param: [proposal, itemMotor]
	 * @return: void
	 */
	public void transferToOwnerModel(Proposal proposal, GuPolicyItemMotor itemMotor) throws Exception;
	/**
	 * 功能描述: 报文投保人节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:37
	 * @param: [proposal, relatedParties]
	 * @return: void
	 */
	public void transferToHolderModel(Proposal proposal, List<GuPolicyRelatedParty> relatedParties) throws Exception;
	/**
	 * 功能描述: 报文被保险人节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:36
	 * @param: [proposal, riskRelatedParty]
	 * @return: void
	 */
	public void transferToInsuredModel(Proposal proposal, GuPolicyRiskRelatedParty riskRelatedParty) throws Exception;
	/**
	 * 功能描述: 报文系数节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:36
	 * @param: [proposal, profits]
	 * @return: void
	 */
	public void transferToProfitModel(Proposal proposal, List<GuPolicyRiskProfit> profits) throws Exception;
	/**
	 * 功能描述: 报文批改信息节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:35
	 * @param: [proposal, endorInfos]
	 * @return: void
	 */
	public void transferToEndorListModel(Proposal proposal, List<EndorHeadInfoVo> endorInfos) throws Exception;
	/**
	 * 功能描述: 报文根节点Kind部分封装
	 * @author: wen
	 * @date: 2018/10/27 17:34
	 * @param: [riskCode, subPolicyNo, proposal]
	 * @return: void
	 */
	public void transferToProposalWithKind(String riskCode, String subPolicyNo, Proposal proposal) throws Exception;
	/**
	 * 功能描述: 报文理赔信息节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:33
	 * @param: [proposal, claimList]
	 * @return: void
	 */
	public void transferToClaimModel(Proposal proposal, List<PrplClaim> jqClaimList, List<PrplClaim> syClaimList) throws Exception;
}
