package com.chinacoal.ins.proposal.car.service.impl;

import com.chinacoal.ins.common.service.impl.ServiceBaseImpl;
import com.chinacoal.ins.proposal.car.dao.*;
import com.chinacoal.ins.proposal.car.pojo.*;
import com.chinacoal.ins.proposal.car.service.PolicyQueryService;
import com.chinacoal.ins.proposal.car.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @auther: wen
 * @date: 2018/10/23 10:33
 * @description: 保单查询Service实现
 */
@Service
public class PolicyQueryServiceImpl extends ServiceBaseImpl implements PolicyQueryService {

	@Autowired
	private GuPolicyRiskRelatedPartyMapper gprrpMapper;
	@Autowired
	private GuPolicyRiskMapper guPolicyRiskMapper;
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	@Autowired
	private GuPolicyItemKindMapper guPolicyItemKindMapper;
	@Autowired
	private GuPolicyItemMotorMapper guPolicyItemMotorMapper;
	@Autowired
	private GuPolicyRelatedPartyMapper guPolicyRelatedPartyMapper;
	@Autowired
	private GuPolicyRiskRelatedPartyMapper riskRelatedPartyMapper;
	@Autowired
	private GuPolicyRiskProfitMapper riskProfitMapper;
	@Autowired
	private GuEndorEndorHeadMapper guEndorEndorHeadMapper;
	@Autowired
	private GuEndorEndorTextDetailMapper endorTextDetailMapper;
	@Autowired
	private PrplClaimMapper prplClaimMapper;
	/**
	 * 功能描述: 保单查询
	 * @author: wen
	 * @date: 2018/10/27 17:31
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.proposal.car.vo.Proposal
	 */
	@Override
	public Proposal policyQuery(HashMap<String,Object> reqMap) throws Exception{
		String subPolicyNo = (String)reqMap.get("policyNo");
		String identifyNumber = (String) reqMap.get("identifyNo");
		//首先根据分单号查询guPolicyRisk表数据，根据分单号获取总单号
		String policyNo = guPolicyRiskMapper.findPolicyNoBySubPolicyNo(subPolicyNo);
		if(policyNo!=null && !"".equals(policyNo)){
			//根据单号查询GuPolicyRisk数据
			List<GuPolicyRisk> guPolicyRiskDtos = guPolicyRiskMapper.findByPolicyNo(policyNo);
			Proposal proposal = new Proposal();
			//组装报文数据
			transferToProposal(subPolicyNo, policyNo, proposal, guPolicyRiskDtos, reqMap);
			return proposal;
		} else {//单号不存在，直接返回空
			return null;
		}
	}
	/**
	 * 功能描述:查询被保人信息
	 * @author: wen
	 * @date: 2018/10/24 11:30
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.proposal.car.pojo.Gupolicyriskrelatedparty
	 */
	@Override
	public GuPolicyRiskRelatedParty findInsured(HashMap<String,Object> reqMap){
		List<GuPolicyRiskRelatedParty> riskRelatedParties = gprrpMapper.selectByPolicynoAndIdentifyno(reqMap);
		GuPolicyRiskRelatedParty riskRelatedParty = new GuPolicyRiskRelatedParty();
		if(riskRelatedParties!=null && riskRelatedParties.size()>0){
			riskRelatedParty = riskRelatedParties.get(0);
		}
		return riskRelatedParty;
	}
	/**
	 * 功能描述: 保单查询接口报文组装
	 * @author: wen
	 * @date: 2018/10/27 17:32
	 * @param: [subPolicyNo, policyNo, proposal, guPolicyRiskDtos, reqMap]
	 * @return: void
	 */
	@Override
	public void transferToProposal(String subPolicyNo, String policyNo, Proposal proposal, List<GuPolicyRisk> guPolicyRiskDtos, HashMap<String, Object> reqMap) throws Exception {
		String isSingleRisk="3";//1 单交强  2单商业 3组合单 4 异步关联
		String jqxRiskCode="";
		String syxRiskCode="";
		String jqPolicyNo="";
		String syPolicyNo="";
		String relatePolicyNo="";
		String jqBusinessType="";
		String syBusinessType="";
		Date syxStartDate=null;
		Date syxEndDate=null;
		Date jqxStartDate=null;
		Date jqxEndDate=null;
		String syxPolicyStatus = "";
		String jqxPolicyStatus = "";
		String proposalNo = "";//投保单号
		//根节点risk表数据
		if(guPolicyRiskDtos!=null && guPolicyRiskDtos.size()>1){
			isSingleRisk="3";//组合单
			for(GuPolicyRisk guPolicyRisk : guPolicyRiskDtos){
				if(guPolicyRisk.getRiskCode()!=null && !"0330".equals(guPolicyRisk.getRiskCode())){//商业
					syPolicyNo = guPolicyRisk.getSubPolicyNo();
					syBusinessType = convertToBusinessType(guPolicyRisk.getNewFlag());
					syxRiskCode = convertToString(guPolicyRisk.getRiskCode());
					syxStartDate = guPolicyRisk.getStartDate();
					syxEndDate = guPolicyRisk.getEndDate();
					syxPolicyStatus = guPolicyRisk.getSurrenderInd();//保单状态
				}else{
					jqPolicyNo = guPolicyRisk.getSubPolicyNo();
					jqBusinessType = convertToBusinessType(guPolicyRisk.getNewFlag());
					jqxRiskCode = convertToString(guPolicyRisk.getRiskCode());
					jqxStartDate = guPolicyRisk.getStartDate();
					jqxEndDate = guPolicyRisk.getEndDate();
					jqxPolicyStatus = guPolicyRisk.getSurrenderInd();
				}
			}
		}else if(guPolicyRiskDtos!=null && guPolicyRiskDtos.size() == 1){
			for(GuPolicyRisk guPolicyRisk : guPolicyRiskDtos){
				if(guPolicyRisk.getRiskCode()!=null && !"0330".equals(guPolicyRisk.getRiskCode())){
					isSingleRisk = "2";//单商业
					syPolicyNo = guPolicyRisk.getSubPolicyNo();
					syBusinessType = convertToBusinessType(guPolicyRisk.getNewFlag());
					syxRiskCode = convertToString(guPolicyRisk.getRiskCode());
					syxStartDate = guPolicyRisk.getStartDate();
					syxEndDate = guPolicyRisk.getEndDate();
					syxPolicyStatus = guPolicyRisk.getSurrenderInd();
				}else{
					isSingleRisk = "1";//单交强
					jqPolicyNo = guPolicyRisk.getSubPolicyNo();
					jqBusinessType = convertToBusinessType(guPolicyRisk.getNewFlag());
					jqxRiskCode = convertToString(guPolicyRisk.getRiskCode());
					jqxStartDate = guPolicyRisk.getStartDate();
					jqxEndDate = guPolicyRisk.getEndDate();
					jqxPolicyStatus = guPolicyRisk.getSurrenderInd();
				}
			}
		}
		proposal.setRequestType("V01");//暂时写死
		proposal.setJqxPolicyNo(convertToString(jqPolicyNo));
		proposal.setSyxPolicyNo(convertToString(syPolicyNo));
		proposal.setJqxBusinessType(jqBusinessType);
		proposal.setSyxBusinessType(syBusinessType);
		if(jqxRiskCode!=null && !"".equals(jqxRiskCode)){
			transferToProposalWithKind(jqxRiskCode, jqPolicyNo, proposal);
		}
		if(syxRiskCode!=null && !"".equals(syxRiskCode)){
			transferToProposalWithKind(syxRiskCode, syPolicyNo, proposal);
		}
		//根节点main表数据
		GuPolicyMainVo mainVo = guPolicyMainMapper.findByPolicyNo(policyNo);
		if(mainVo!=null){
			if(mainVo.getCompanyCodeTradtional()!=null && !"".equals(mainVo.getCompanyCodeTradtional())){
				proposal.setOperateComCode(convertToString(mainVo.getCompanyCodeTradtional()));
				proposal.setComCode(convertToString(mainVo.getCompanyCodeTradtional()));
				proposal.setSecondCompany(convertToString(mainVo.getCompanyCodeTradtional().substring(0,2)));
				proposal.setThirdCompany(convertToString(mainVo.getCompanyCodeTradtional().substring(0, 4)));
			} else if(mainVo.getCompanyCode()!=null && !"".equals(mainVo.getCompanyCode())){
				proposal.setOperateComCode(convertToString(mainVo.getCompanyCode()));
				proposal.setComCode(convertToString(mainVo.getCompanyCode()));
				proposal.setSecondCompany(convertToString(mainVo.getCompanyCode().substring(0,2)));
				proposal.setThirdCompany(convertToString(mainVo.getCompanyCode().substring(0, 4)));
			}
			proposal.setNetworkPoint(convertToString(mainVo.getNetPointCode()));
			proposal.setBusinessNature(convertToString(mainVo.getChannelSource()));
			proposal.setBusinessNature1(convertToString(mainVo.getChannelSourceSub()));
			proposal.setChannelNature1(convertToString(mainVo.getBusinessSourceSub()));
			proposal.setChannelNature2(convertToString(mainVo.getBusinessDetail()));
			proposal.setChannelNature3(convertToString(mainVo.getBusinessDetailThree()));
			proposal.setSalesTeam(convertToString(mainVo.getTeamCode()));
			proposal.setHandlerName(convertToString(mainVo.getHandlerName()));
			proposal.setHandlerCode(convertToString(mainVo.getSalesManCode()));
			proposal.setAgentName(convertToString(mainVo.getAgentName()));
			proposal.setAgentCode(convertToString(mainVo.getIntermediaryCode()));
			proposal.setAgreementNo(convertToString(mainVo.getAgreementNo()));
			proposal.setOperateDate(convertToString(mainVo.getIssueDate()));
			//暂时不传值
			proposal.setInsuranceType(convertToString(mainVo.getInsuranceType()));

			proposalNo = mainVo.getProposalNo();
		}
		proposal.setJqxStartDate(convertToString(jqxStartDate));
		proposal.setJqxEndDate(convertToString(jqxEndDate));
		proposal.setSyxStartDate(convertToString(syxStartDate));
		proposal.setSyxEndDate(convertToString(syxEndDate));

		proposal.setJqxRiskCode(convertToString(jqxRiskCode));
		proposal.setSyxRiskCode(convertToString(syxRiskCode));
		proposal.setSyxPolicyStatus(convertToString(syxPolicyStatus));
		proposal.setJqxPolicyStatus(convertToString(jqxPolicyStatus));

		//新增字段
		if(proposalNo!=null && !"".equals(proposalNo)){
			ProposalAddFieldVo addVo = guPolicyRiskMapper.findAddFiledByProposalNo(proposalNo);
			if(addVo!=null){
				//支付方式
				proposal.setPayWay(convertToString(addVo.getPayWay()));
				//缴费时间
				proposal.setPayDate(convertToString(addVo.getPayDate()));
			}
		}
		//组织车辆vehicle节点数据
		GuPolicyItemMotor vehicleMotor = guPolicyItemMotorMapper.findBySubPolicyNo(subPolicyNo);
		transferToVehicleModel(policyNo, proposal, vehicleMotor);
		//组织车主owner节点数据
		GuPolicyItemMotor motors = guPolicyItemMotorMapper.findOwnerBySubPolicyNo(subPolicyNo);
		transferToOwnerModel(proposal, motors);
		//组织承保人holder节点数据
		List<GuPolicyRelatedParty> holders = guPolicyRelatedPartyMapper.findByPolicyNo(policyNo);
		transferToHolderModel(proposal, holders);
		//组织被保人insured节点数据
		GuPolicyRiskRelatedParty riskRelatedParty = this.findInsured(reqMap);
		transferToInsuredModel(proposal, riskRelatedParty);
		//组织险别kindList节点数据
		List<GuPolicyItemKind> kinds = guPolicyItemKindMapper.findKindsByPolicyNo(policyNo);
		transferToKindModel(proposal, kinds);
		//系数列表profitList节点数据
		List<GuPolicyRiskProfit> profits = riskProfitMapper.findByPolicyNo(policyNo);
		transferToProfitModel(proposal, profits);
		//简单理赔信息列表claimList节点数据
		List<PrplClaim> jqClaimInfoList = new ArrayList<>();
		List<PrplClaim> syClaimInfoList = new ArrayList<>();
		if(jqPolicyNo!=null && !"".equals(jqPolicyNo)){
			jqClaimInfoList = prplClaimMapper.findByPolicy(jqPolicyNo);
		}
		if(syPolicyNo!=null && !"".equals(syPolicyNo)){
			syClaimInfoList = prplClaimMapper.findByPolicy(syPolicyNo);
		}
		transferToClaimModel(proposal, jqClaimInfoList, syClaimInfoList);
		//批改信息列表endorInfoList节点数据
		List<EndorHeadInfoVo> endorInfos = guEndorEndorHeadMapper.findEndorVoByPolicyNo(policyNo);
		transferToEndorListModel(proposal, endorInfos);
	}
	/**
	 * 功能描述: 报文车辆节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:38
	 * @param: [policyNo, proposal, vehicleMotor]
	 * @return: void
	 */
	@Override
	public void transferToVehicleModel(String policyNo, Proposal proposal, GuPolicyItemMotor vehicleMotor) throws Exception {
		Vehicle vehicle = new Vehicle();
		if(vehicleMotor!=null){
			//外地车标识
			vehicle.setCarEcdemicVehicleFlag(convertToString(vehicleMotor.getNoLocalCarFlag()));
			//过户车标识
			vehicle.setCarChgOwnerFlag(convertToBoolean(vehicleMotor.getChgOwnerFlag()));
			//异型车
			vehicle.setAbnormalCarFlag(null);
			//贷款车
			vehicle.setCarLoanVehicleFlag(convertToBoolean(vehicleMotor.getLoanVehicleFlag()));
			//投保新增设备
			vehicle.setNewDeviceInd(convertToBoolean(vehicleMotor.getNewDeviceInd()));
			//特殊车投保标志 1 车辆所有权转移重新投保 2 临时入境的境外机动车
			vehicle.setSpecialCarFlag(null);
			//车牌号码
			vehicle.setCarLicenseNo(convertToString(vehicleMotor.getLicenseNo()));
			//车架号
			vehicle.setCarVinNoTemp(convertToString(vehicleMotor.getFrameNo()));
			//发动机号
			vehicle.setCarEngineNoTemp(convertToString(vehicleMotor.getEngineNo()));
			//使用性质
			vehicle.setCarUseNature1(convertToString(vehicleMotor.getNewUseNatureShow()));
			//车辆用途
			vehicle.setCarUseNature2(convertToString(vehicleMotor.getNewCarUseType()));
			//车辆大类
			vehicle.setCarType1(convertToString(vehicleMotor.getNewCarkind()));
			//车辆细类
			vehicle.setCarType2(convertToString(vehicleMotor.getNewCarkindSub()));
			//车辆类型
			vehicle.setCarType3(convertToString(vehicleMotor.getNewCarkindCodeShow()));
			//品牌型号
			vehicle.setCarModelName(convertToString(vehicleMotor.getBrandName()));
			//品牌型号打印
			vehicle.setCarDealerName(convertToString(vehicleMotor.getPrintBrandName()));
			//行业车型代码
			vehicle.setPlatformVehicleCode(convertToString(vehicleMotor.getPlatModelCode()));
			//行业车型名称
			vehicle.setPlatformVehicleName(null);
			//号牌种类
			vehicle.setCarLicenseType(convertTCarLicenseType(vehicleMotor.getLicenseTypeCode(),vehicleMotor.getPlanCode()));
			//被保人与车辆关系
			vehicle.setCarInsuredRelation(convertToString(vehicleMotor.getCarInsuredRelation()));
			//车身颜色
			vehicle.setCarColorCode(convertToString(vehicleMotor.getColorCode()));
			//号牌底色
			vehicle.setCarLicenseColorCode(convertToString(vehicleMotor.getLicenseColorCode()));
			//新车购置价
			vehicle.setPurchasePrice(convertToDouble(vehicleMotor.getPurchasePrice()));
			//实际价值
			vehicle.setCarActualValue(convertToDouble(vehicleMotor.getActualValue()));
			//使用年数
			vehicle.setYearsOfActualUse(convertToInteger(vehicleMotor.getUseYears()));
			//核定载质量
			vehicle.setCarTonCount(convertToDouble(vehicleMotor.getTonCount().divide(BigDecimal.valueOf(1000))));
			//核定载客数
			vehicle.setCarSeatCount(convertToInteger(vehicleMotor.getSeatCount()));
			BigDecimal allMass = guPolicyItemMotorMapper.findAllMass(policyNo);
			//总质量
			vehicle.setAllMass(convertToDouble(allMass));
			//整备质量
			vehicle.setCompleteKerbMass(convertToDouble(vehicleMotor.getCompleteKerbMass()));
			//排量
			vehicle.setExhaustScale(convertToDouble(vehicleMotor.getExhaustScale()));
			//功率功率
			vehicle.setPower(convertToDouble(vehicleMotor.getPower()));
			//交管车辆类型
			vehicle.setCarVehicleStyle(convertToString(vehicleMotor.getVehicleCategory()));
			//进口车标志
			vehicle.setCountryNature(convertToString(vehicleMotor.getCountryNature()));
			//能源类型
			vehicle.setFuelType(convertToString(vehicleMotor.getEnergyTypeCode()));
			//初登日期
			vehicle.setCarEnrollDate(convertToString(vehicleMotor.getEnrollDate()));
			//发证日期
			vehicle.setCarLicenseDate(convertToString(vehicleMotor.getIssueDate()));
			//新车购置日期
			vehicle.setCarBookingTime(convertToString(vehicleMotor.getSingeInDate()));
			//过户日期
			vehicle.setCarTransferDate(convertToString(vehicleMotor.getTransferDate()));
			//过户日期
			vehicle.setCarTransferDate(convertToString(vehicleMotor.getTransferDate()));
			//验车情况
			vehicle.setCarcheckStatus(convertToString(vehicleMotor.getCarCheckStatus()));
			//免验原因
			vehicle.setCarcheckReason("2".equals(vehicleMotor.getCarCheckStatus())?convertToString(vehicleMotor.getCarCheckReason()):"");
			//验车人
			vehicle.setCarChecker("3".equals(vehicleMotor.getCarCheckStatus())?convertToString(vehicleMotor.getCarChecker()):"");
			//验车时间
			vehicle.setCarCheckTime("3".equals(vehicleMotor.getCarCheckStatus())?convertToDate(vehicleMotor.getCarCheckTime()):null);
		}
		proposal.setVehicle(vehicle);
	}
	/**
	 * 功能描述:  报文险别列表节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:38
	 * @param: [proposal, kinds]
	 * @return: void
	 */
	@Override
	public void transferToKindModel(Proposal proposal, List<GuPolicyItemKind> kinds) throws Exception {
		List<Kind> kindList = new ArrayList<>(0);
		for (GuPolicyItemKind itemKind : kinds){
			Kind kind = new Kind();
			kind.setKindName(convertToString(itemKind.getKindName()));
			kind.setKindCode(convertToString(itemKind.getKindCode()));
			kind.setKindStartDate(convertToString(itemKind.getStartDate()));
			kind.setKindEndDate(convertToString(itemKind.getEndDate()));
			kind.setShortPeriodRate(convertToDouble(itemKind.getShortRate().divide(BigDecimal.valueOf(100))));
			kind.setKindAmount(convertToDouble(itemKind.getSumInsured()));
			kind.setKindRate(convertToDouble(itemKind.getRate()));
			kind.setKindBasePremium(itemKind.getRemark()!=null&&!"".equals(itemKind.getRemark())?convertToDouble(itemKind.getRemark()): (Double) convertToDouble(itemKind.getBasePremium()));
			kind.setKindBenchMarkPremium(convertToDouble(itemKind.getBenchMarkPremium()));
			kind.setKindPremium(convertToDouble(itemKind.getGrossPremium()));
			//交强没有不计免
			if(!"BZ".equals(itemKind.getKindCode())){
				kind.setExcludingDeductible(convertToBoolean(itemKind.getRelatedInd()));
			}else{
				kind.setExcludingDeductible(convertToBoolean("0"));
			}
			if(itemKind.getKindCode()!=null && "1".equals(itemKind.getKindInd())){
				kind.setIsMainKind(convertToBoolean("1"));//主险
			}else{
				kind.setIsMainKind(convertToBoolean("0"));
			}
			//只有玻璃险时有该字段的值
			if(itemKind.getKindCode()!=null && "11".equals(itemKind.getKindCode())){
				kind.setKindGlassType(convertToString(itemKind.getValueType()));//玻璃类型
			}else{
				kind.setKindGlassType(null);//玻璃类型
			}
			kind.setKindQuantity(convertToInteger(itemKind.getQuantity()));
			kind.setKindUnitAmount(convertToDouble(itemKind.getUnitInsured()));
			kind.setDeductible(convertToDouble(itemKind.getDeductible()));
			kind.setFranchise(convertToDouble(itemKind.getFranchise()));
			kindList.add(kind);
		}
		proposal.setKindList(kindList);
	}
	/**
	 * 功能描述: 报文车主节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:37
	 * @param: [proposal, itemMotor]
	 * @return: void
	 */
	@Override
	public void transferToOwnerModel(Proposal proposal, GuPolicyItemMotor itemMotor) throws Exception {
		RelatedParty owner = new RelatedParty();
		if(itemMotor!=null){
			owner.setRpInsuredNatureRadio(convertToString(itemMotor.getCarOwnerType()));
			owner.setRpName(convertToString(itemMotor.getCarOwner()));
			owner.setRpSex(convertToString(""));
			owner.setRpPersonAge(null);
			owner.setRpIdentifyType(convertToString(itemMotor.getIdentifyType()));
			owner.setRpIdentifyNumber(convertToString(itemMotor.getIdentifyNumber()));
			owner.setRpBirthDate(null);
			owner.setRpOccupationCode(convertToString(""));
		}
		proposal.setOwner(owner);
	}
	/**
	 * 功能描述: 报文投保人节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:37
	 * @param: [proposal, relatedParties]
	 * @return: void
	 */
	@Override
	public void transferToHolderModel(Proposal proposal, List<GuPolicyRelatedParty> relatedParties) throws Exception {
		RelatedParty holder = new RelatedParty();
		if(relatedParties!=null && relatedParties.size()>0){
			GuPolicyRelatedParty relatedPartyHolder = relatedParties.get(0);
			holder.setRpInsuredNatureRadio(convertToString(relatedPartyHolder.getInsuredType()));
			holder.setRpName(convertToString(relatedPartyHolder.getInsuredName()));
			holder.setRpSex(convertToString(""));
			holder.setRpPersonAge(convertToString(0));
			holder.setRpIdentifyType(convertToString(relatedPartyHolder.getIdentifyType()));
			holder.setRpIdentifyNumber(convertToString(relatedPartyHolder.getIdentifyNumber()));
			holder.setRpBirthDate(convertToString(relatedPartyHolder.getBirthDate()));
			holder.setRpOccupationCode(convertToString(""));
		}
		proposal.setHolder(holder);
	}
	/**
	 * 功能描述: 报文被保险人节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:36
	 * @param: [proposal, riskRelatedParty]
	 * @return: void
	 */
	@Override
	public void transferToInsuredModel(Proposal proposal, GuPolicyRiskRelatedParty riskRelatedParty) throws Exception {
		RelatedParty insured = new RelatedParty();
		if(riskRelatedParty!=null){
			insured.setRpInsuredNatureRadio(convertToString(riskRelatedParty.getInsuredType()));
			insured.setRpName(convertToString(riskRelatedParty.getInsuredName()));
			insured.setRpSex(convertToString(""));
			insured.setRpPersonAge(convertToString(0));
			insured.setRpIdentifyType(convertToString(riskRelatedParty.getIdentifyType()));
			insured.setRpIdentifyNumber(convertToString(riskRelatedParty.getIdentifyNumber()));
			insured.setRpBirthDate(convertToString(riskRelatedParty.getInsuredBirthDate()));
			insured.setRpOccupationCode(convertToString(""));
		}
		proposal.setInsured(insured);
	}
	/**
	 * 功能描述: 报文系数节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:36
	 * @param: [proposal, profits]
	 * @return: void
	 */
	@Override
	public void transferToProfitModel(Proposal proposal, List<GuPolicyRiskProfit> profits) throws Exception {
		List<Profit> profitList = new ArrayList<>();
		if(profits!=null && profits.size()>0){
			for(GuPolicyRiskProfit riskProfit : profits){
				Profit profit = new Profit();
				profit.setProfitName(convertToString(riskProfit.getProfitname()));
				profit.setProfitCode(convertToString(riskProfit.getProfitCode()));
				profit.setProfitValue(convertToDouble(riskProfit.getRate().divide(BigDecimal.valueOf(100))));
				profit.setProfitMin(convertToDouble(riskProfit.getLowerrate().divide(BigDecimal.valueOf(100))));
				profit.setProfitMax(convertToDouble(riskProfit.getUpperrate().divide(BigDecimal.valueOf(100))));
				profitList.add(profit);
			}
		}
		proposal.setProfitList(profitList);
	}
	/**
	 * 功能描述: 报文批改信息节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:35
	 * @param: [proposal, endorInfos]
	 * @return: void
	 */
	@Override
	public void transferToEndorListModel(Proposal proposal, List<EndorHeadInfoVo> endorInfos) throws Exception {
		List<EndorInfo> endorList = new ArrayList<>();
		if(endorInfos!=null && endorInfos.size()>0){
			for(EndorHeadInfoVo vo : endorInfos){
				EndorInfo endorInfo = new EndorInfo();
				endorInfo.setEndorNo(convertToString(vo.getPolicyNoForEndor()));
				endorInfo.setRiskCode(convertToString(vo.getRiskCode()));
				endorInfo.setEndorType(convertToString(vo.getEndorType()));
				endorInfo.setEndorDate(convertToString(vo.getEndorDate()));
				endorInfo.setValidDate(convertToString(vo.getValidDate()));
				endorInfo.setSuminsured(convertToDouble(vo.getSumInsured()));
				endorInfo.setGrossPremium(convertToDouble(vo.getGrossPremium()));
				endorInfo.setContent(convertToString(vo.getContent()));
				endorInfo.setOperator(convertToString(vo.getOperator()));
				endorInfo.setInvalidFlag(convertToString(vo.getInvalidFlag()));
				//查询对应的批改变化项，组装内部endorInfoDetail节点数据
				List<EndorDetailInfo> detailList = new ArrayList<>();
				if(vo.getEndorNo()!=null && !"".equals(vo.getEndorNo())){
					List<GuEndorEndorTextDetail> details = endorTextDetailMapper.findByEndorInfo(vo);
					if(details!=null && details.size()>0){
						for(GuEndorEndorTextDetail detail : details){
							EndorDetailInfo info = new EndorDetailInfo();
							info.setEndorName(convertToString(detail.getFieldName()));
							info.setOldValue(convertToString(detail.getOldValue()));
							info.setNewValue(convertToString(detail.getNewValue()));
							detailList.add(info);
						}
					}
				}
				endorInfo.setEndorInfoDetail(detailList);
				endorList.add(endorInfo);
			}
		}
		proposal.setEndorInfoList(endorList);
	}
	/**
	 * 功能描述: 报文根节点Kind部分封装
	 * @author: wen
	 * @date: 2018/10/27 17:34
	 * @param: [riskCode, subPolicyNo, proposal]
	 * @return: void
	 */
	@Override
	public void transferToProposalWithKind(String riskCode, String subPolicyNo, Proposal proposal) throws Exception {
		GuPolicyItemKindVo kindVo = new GuPolicyItemKindVo();
		if(subPolicyNo!=null && !"".equals(subPolicyNo)
			&& riskCode!=null && !"0330".equals(riskCode)){//商业
			kindVo = guPolicyItemKindMapper.findSyxBySubPolicyNo(subPolicyNo);
			if(kindVo!=null){
				proposal.setSyxSumAmount(convertToDouble(kindVo.getJqxSumAmount()));
				proposal.setSyxSumBasePremium(convertToDouble(kindVo.getJqxSumBasePremium()));
				proposal.setSyxSumPremium((convertToDouble(kindVo.getJqxSumPremium())));
				proposal.setSyxShortPeriodRate(convertToDouble(kindVo.getJqxShortPeriodRate().divide(BigDecimal.valueOf(100))));
				proposal.setSyxPolicyRate(convertToDouble(kindVo.getJqxPolicyRate().divide(BigDecimal.valueOf(100))));
			}
		}else if(subPolicyNo!=null && !"".equals(subPolicyNo)
				&& riskCode!=null && !"".equals(riskCode)){//交强
			kindVo = guPolicyItemKindMapper.findJqxBySubPolicyNo(subPolicyNo);
			if(kindVo!=null){
				proposal.setJqxSumAmount(convertToDouble(kindVo.getJqxSumAmount()));
				proposal.setJqxSumBasePremium((convertToDouble(kindVo.getJqxSumBasePremium())));
				proposal.setJqxSumPremium(convertToDouble(kindVo.getJqxSumPremium()));
				proposal.setJqxShortPeriodRate(convertToDouble(kindVo.getJqxShortPeriodRate().divide(BigDecimal.valueOf(100))));
				proposal.setJqxPolicyRate(convertToDouble(kindVo.getJqxPolicyRate().divide(BigDecimal.valueOf(100))));
			}
		}

	}
	/**
	 * 功能描述: 报文理赔信息节点封装
	 * @author: wen
	 * @date: 2018/10/27 17:33
	 * @param: [proposal, claimList]
	 * @return: void
	 */
	@Override
	public void transferToClaimModel(Proposal proposal, List<PrplClaim> jqClaimList, List<PrplClaim> syClaimList) throws Exception {
		List<Claiminfo> claimInfoList = new ArrayList<>();
		if(jqClaimList!=null && jqClaimList.size()>0){//交强
			for (PrplClaim prplClaim : jqClaimList){
				Claiminfo claim = new Claiminfo();
				claim.setSubPolicyNo(convertToString(prplClaim.getPolicyNo()));
				claim.setRegistNo(convertToString(prplClaim.getRegistNo()));
				claim.setClaimNo(convertToString(prplClaim.getClaimNo()));
				claim.setDamageTime(convertToString(prplClaim.getDamageStartDate()));
				//1：已结案  0：未结案
				claim.setStatus("".equals(convertToString(prplClaim.getEndCaseDate()))? "0" : "1");
				claim.setEndCaseDate(convertToString(prplClaim.getEndCaseDate()));
				claim.setPayAmount(convertToDouble(prplClaim.getSumPaid()));
				claimInfoList.add(claim);
			}
		}
		if(syClaimList!=null && syClaimList.size()>0){//商业
			for (PrplClaim prplClaim : syClaimList){
				Claiminfo claim = new Claiminfo();
				claim.setSubPolicyNo(convertToString(prplClaim.getPolicyNo()));
				claim.setRegistNo(convertToString(prplClaim.getRegistNo()));
				claim.setClaimNo(convertToString(prplClaim.getClaimNo()));
				claim.setDamageTime(convertToString(prplClaim.getDamageStartDate()));
				//1：已结案  0：未结案
				claim.setStatus("".equals(convertToString(prplClaim.getEndCaseDate()))? "0" : "1");
				claim.setEndCaseDate(convertToString(prplClaim.getEndCaseDate()));
				claim.setPayAmount(convertToDouble(prplClaim.getSumPaid()));
				claimInfoList.add(claim);
			}
		}
		proposal.setClaimList(claimInfoList);
	}
}
