package com.chinacoal.ins.claim.car.vo;

import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/5 09:35
 * @description: 理赔信息ClaimInfo
 */
public class ClaimInfo {

	/** 立案号 */
	private String claimNo;
	/** 险别代码 */
	private String riskCode;
	/** 报案号 */
	private String registNo;
	/**保单号 */
	private String policyNo;
	/** 被保险人名称 */
	private String insuredName;
	/** 理赔节点信息 */
	private ClaimMainInfo claimMainInfo;
	/** 定损清单列表 */
	private List<VehicleRepairInfo> vehicleRepairList;
	/** 人伤理算列表 */
	private List<InjuredInfo> injuredList;
	/** 理算核赔意见列表 */
	private List<UndwrtOpinion> undwrtOpinionList;
	/**财产损失信息列表*/
	private List<PropLossInfo> propLossList;
	/** 理赔单证收集列表 */
	private List<ClaimDocInfo> claimDocList;

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public ClaimMainInfo getClaimMainInfo() {
		return claimMainInfo;
	}

	public void setClaimMainInfo(ClaimMainInfo claimMainInfo) {
		this.claimMainInfo = claimMainInfo;
	}

	public List<VehicleRepairInfo> getVehicleRepairList() {
		return vehicleRepairList;
	}

	public void setVehicleRepairList(List<VehicleRepairInfo> vehicleRepairList) {
		this.vehicleRepairList = vehicleRepairList;
	}

	public List<InjuredInfo> getInjuredList() {
		return injuredList;
	}

	public void setInjuredList(List<InjuredInfo> injuredList) {
		this.injuredList = injuredList;
	}

	public List<UndwrtOpinion> getUndwrtOpinionList() {
		return undwrtOpinionList;
	}

	public void setUndwrtOpinionList(List<UndwrtOpinion> undwrtOpinionList) {
		this.undwrtOpinionList = undwrtOpinionList;
	}

	public List<PropLossInfo> getPropLossList() {
		return propLossList;
	}

	public void setPropLossList(List<PropLossInfo> propLossList) {
		this.propLossList = propLossList;
	}

	public List<ClaimDocInfo> getClaimDocList() {
		return claimDocList;
	}

	public void setClaimDocList(List<ClaimDocInfo> claimDocList) {
		this.claimDocList = claimDocList;
	}
}
