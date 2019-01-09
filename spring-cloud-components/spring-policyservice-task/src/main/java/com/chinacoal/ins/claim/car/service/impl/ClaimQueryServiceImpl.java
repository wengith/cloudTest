package com.chinacoal.ins.claim.car.service.impl;

import com.chinacoal.ins.claim.car.dao.*;
import com.chinacoal.ins.claim.car.pojo.*;
import com.chinacoal.ins.claim.car.service.ClaimQueryService;
import com.chinacoal.ins.claim.car.vo.*;
import com.chinacoal.ins.common.service.impl.ServiceBaseImpl;
import com.chinacoal.ins.proposal.car.dao.GuPolicyMainMapper;
import com.chinacoal.ins.proposal.car.dao.PrplClaimMapper;
import com.chinacoal.ins.proposal.car.pojo.PrplClaim;
import com.chinacoal.ins.proposal.car.vo.GuPolicyMainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @auther: wen
 * @date: 2018/11/1 18:05
 * @description: 理赔查询Service实现
 */
@Service
public class ClaimQueryServiceImpl extends ServiceBaseImpl implements ClaimQueryService {

	@Autowired
	private PrplRegistMapper registMapper;
	@Autowired
	private PrplClaimMapper prplClaimMapper;
	@Autowired
	private VehicleRepairMapper vehicleRepairMapper;
	@Autowired
	private InjuredMapper injuredMapper;
	@Autowired
	private UndwrtMapper undwrtMapper;
	@Autowired
	private PropLossMapper propLossMapper;
	@Autowired
	private PrplDocCollectGuideMapper docCollectGuideMapper;
	@Autowired
	private GuPolicyMainMapper guPolicyMainMapper;
	@Autowired
	private PrpLbpmMainMapper prpLbpmMainMapper;
	@Autowired
	private ClaimMoneyMapper claimMoneyMapper;
	@Autowired
	private PrpLpaymentMapper prpLpaymentMapper;
	@Autowired
	private QuickPayCaseMapper quickPayCaseMapper;
	@Autowired
	private PrpLcompensateMapper compensateMapper;

	 /**
	 * 功能描述: 理赔案件基本查询
	 * @author: wen
	 * @date: 2018/11/2 16:52
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.claim.car.vo.ClaimData
	 */
	@Override
	public ClaimData baseCaseQuery(HashMap<String,Object> reqMap) throws Exception{
		if(reqMap!=null && reqMap.size()>0){
			String policyNo = (String) reqMap.get("policyNo");
			ClaimData claimData = new ClaimData();
			//先验证有没有理赔立案信息
			List<String> claimNos = prplClaimMapper.findClaimNos(reqMap);
			if(claimNos!=null && claimNos.size()>0){
				List<CaseInfo> caseList = new ArrayList<>();
				//开始组装数据
				claimData.setRequestType("V01");
				claimData.setPolicyNo(convertToString(policyNo));
				for(String claimNo : claimNos){
					CaseInfo caseInfo = new CaseInfo();
					String registNo = "";
					String riskCode = "";
					BaseCaseInfoDto baseCaseInfoDto = registMapper.findByClaimNo(claimNo);
					if(baseCaseInfoDto!=null){
						registNo = baseCaseInfoDto.getRegistNo();
						riskCode = baseCaseInfoDto.getRiskCode();
						//组织案件基本信息
						caseInfo.setClaimNo(convertToString(baseCaseInfoDto.getClaimNo()));
						caseInfo.setRiskCode(convertToString(baseCaseInfoDto.getRiskCode()));
						caseInfo.setRegistNo(convertToString(baseCaseInfoDto.getRegistNo()));
						caseInfo.setReportorName(convertToString(baseCaseInfoDto.getReportorName()));
						caseInfo.setDamageDate(convertToString(baseCaseInfoDto.getDamageDate()));
						caseInfo.setCaseStatus(convertToCaseStatus(baseCaseInfoDto.getEndCaseDate()));
						caseInfo.setCaseFlag(convertToString(baseCaseInfoDto.getCaseFlag()));
						//计算出险次数
						int damageTimes = this.getDamageTimes(policyNo);
						caseInfo.setDamageTimes(damageTimes);
					}
					caseList.add(caseInfo);
				}
				claimData.setCaseInfoList(caseList);
			}
			return claimData;
		}else{
			return null;
		}
	}

	/**
	 * 功能描述: 根据立案号查询出险扩展信息
	 * @author: wen
	 * @date: 2018/11/23 11:00
	 * @param: [claimNo]
	 * @return: com.chinacoal.ins.claim.car.vo.RegistInfo
	 */
	@Override
	public RegistInfo caseInfoQuery(String claimNo) throws Exception {
		RegistInfo registInfo = new RegistInfo();
		if(claimNo!=null && !"".equals(claimNo)){
			PrplClaim claim = prplClaimMapper.findByClaimNo(claimNo);
			if(claim!=null){
				HashMap<String,Object> map = new HashMap<>();
				map.put("registNo", claim.getRegistNo());
				map.put("riskCode", claim.getRiskCode());
				RegistInfoDto registInfoDto = registMapper.findRegistDto(map);
				if(registInfoDto!=null){
					//开始组装
					registInfo.setPolicyNo(convertToString(registInfoDto.getPolicyNo()));
					registInfo.setCaseNo(convertToString(map.get("claimNo")));
					String damageDate = convertToString(registInfoDto.getDamageDate());
					if(!"".equals(damageDate) && !"".equals(registInfoDto.getDamageHour())){
						String[] date = damageDate.split(" ");
						damageDate = date[0] + " " + convertToString(registInfoDto.getDamageHour());
					}
					registInfo.setDamageDate(damageDate);
					registInfo.setDamageAddress(convertToString(registInfoDto.getDamageAddress()));
					registInfo.setDamageCode(convertToString(registInfoDto.getDamageCode()));
					registInfo.setDamageName(convertToString(registInfoDto.getDamageName()));
					registInfo.setDamageRemark(convertToString(registInfoDto.getRemark()));
					String reportDate = convertToString(registInfoDto.getReportDate());
					if(!"".equals(reportDate) && !"".equals(registInfoDto.getReportHour())){
						String[] date = reportDate.split(" ");
						reportDate = date[0] + " " + convertToString(registInfoDto.getReportHour());
					}
					registInfo.setReportDate(reportDate);
					registInfo.setReportorName(convertToString(registInfoDto.getReportorName()));
					registInfo.setReportorPhone(convertToString(registInfoDto.getReportorMobile()));
					registInfo.setInsuriedCode(convertToString(registInfoDto.getInsuredCode()));
					registInfo.setInsuriedName(convertToString(registInfoDto.getInsuredName()));
					registInfo.setInsuredIdentifyNo(convertToString(registInfoDto.getIdentifyNumber()));
					registInfo.setLicenseNo(convertToString(registInfoDto.getLicenseNo()));
					registInfo.setVinNo(convertToString(registInfoDto.getVinNo()));
					registInfo.setEngineNo(convertToString(registInfoDto.getEngineNo()));
					registInfo.setBrandName(convertToString(registInfoDto.getBrandName()));
					registInfo.setReportorDelDate(convertToString(registInfoDto.getInputTime()));
					registInfo.setProductName(convertToString(registInfoDto.getProName()));
				}
			}
		}
		return registInfo;
	}

	 /**
	 * 功能描述: 查询案件理赔信息
	 * @author: wen
	 * @date: 2018/11/23 11:36
	 * @param: [claimNo]
	 * @return: com.chinacoal.ins.claim.car.vo.ClaimInfo
	 */
	@Override
	public ClaimInfo claimInfoQuery(String claimNo) throws Exception {
		ClaimInfo claimInfo = new ClaimInfo();
		if(claimNo!=null && !"".equals(claimNo)){
			String riskCode = "";
			String registNo = "";
			PrplClaim claim = prplClaimMapper.findByClaimNo(claimNo);
			if(claim!=null){
				riskCode = claim.getRiskCode();
				registNo = claim.getRegistNo();
				HashMap<String, Object> map = new HashMap<>();
				map.put("registNo", registNo);
				map.put("riskCode", riskCode);
				map.put("claimNo", claimNo);
				claimInfo.setClaimNo(convertToString(claimNo));
				claimInfo.setRegistNo(convertToString(registNo));
				claimInfo.setRiskCode(convertToString(riskCode));
				claimInfo.setPolicyNo(convertToString(claim.getPolicyNo()));
				claimInfo.setInsuredName(convertToString(claim.getInsuredName()));
				//this.transferToRegistInfoModel(map, claimInfo);//组织案件扩展信息
				//组织理赔各环节信相关息
				this.transferToMainInfoModel(claimNo,claimInfo);
				//组织人伤理算信息列表
				this.transferToInjuredListModel(registNo, claimInfo);
				//组织定损清单列表
				this.transferToVehicleRepairModel(claimNo, claimInfo);
				//组织核赔意见列表
				this.transferToUndwrtOpinionModel(claimNo, claimInfo);
				//组织财产损失列表
				this.transferToPropInfoModel(claimNo, claimInfo);
				//组织理赔单证收集列表
				this.transferToDocCollectModel(registNo, claimInfo);
			}
		}
		return claimInfo;
	}

	/**
	 * 功能描述: 组装案件扩展信息
	 * @author: wen
	 * @date: 2018/11/7 11:08
	 * @param: [map, claimInfo]
	 * @return: void
	 */
	@Override
	public void transferToRegistInfoModel(HashMap<String, Object> map, ClaimInfo claimInfo) throws Exception {
		RegistInfo registInfo = new RegistInfo();
		//查询案件扩展信息
		if(map!=null && map.size()>0){
			if(map.get("registNo")!=null && !"".equals(map.get("registNo")) && map.get("riskCode")!=null && !"".equals(map.get("riskCode"))){
				RegistInfoDto registInfoDto = registMapper.findRegistDto(map);
				if(registInfoDto!=null){
					//开始组装
					registInfo.setPolicyNo(convertToString(registInfoDto.getPolicyNo()));
					registInfo.setCaseNo(convertToString(map.get("claimNo")));
					String damageDate = convertToString(registInfoDto.getDamageDate());
					if(!"".equals(damageDate) && !"".equals(registInfoDto.getDamageHour())){
						String[] date = damageDate.split(" ");
						damageDate = date[0] + " " + convertToString(registInfoDto.getDamageHour());
					}
					registInfo.setDamageDate(damageDate);
					registInfo.setDamageAddress(convertToString(registInfoDto.getDamageAddress()));
					registInfo.setDamageCode(convertToString(registInfoDto.getDamageCode()));
					registInfo.setDamageName(convertToString(registInfoDto.getDamageName()));
					registInfo.setDamageRemark(convertToString(registInfoDto.getRemark()));
					String reportDate = convertToString(registInfoDto.getReportDate());
					if(!"".equals(reportDate) && !"".equals(registInfoDto.getReportHour())){
						String[] date = reportDate.split(" ");
						reportDate = date[0] + " " + convertToString(registInfoDto.getReportHour());
					}
					registInfo.setReportDate(reportDate);
					registInfo.setReportorName(convertToString(registInfoDto.getReportorName()));
					registInfo.setReportorPhone(convertToString(registInfoDto.getReportorMobile()));
					registInfo.setInsuriedCode(convertToString(registInfoDto.getInsuredCode()));
					registInfo.setInsuriedName(convertToString(registInfoDto.getInsuredName()));
					registInfo.setInsuredIdentifyNo(convertToString(registInfoDto.getIdentifyNumber()));
					registInfo.setLicenseNo(convertToString(registInfoDto.getLicenseNo()));
					registInfo.setVinNo(convertToString(registInfoDto.getVinNo()));
					registInfo.setEngineNo(convertToString(registInfoDto.getEngineNo()));
					registInfo.setBrandName(convertToString(registInfoDto.getBrandName()));
					registInfo.setReportorDelDate(convertToString(registInfoDto.getInputTime()));
					registInfo.setProductName(convertToString(registInfoDto.getProName()));
				}
			}
		}
		//claimInfo.setRegistInfo(registInfo);
	}

	/**
	* 功能描述: 组装理赔环节相关信息
	* @author: wen
	* @date: 2018/11/21 18:06
	* @param: [claimNo, claimInfo]
	* @return: void
	*/
	@Override
	public void transferToMainInfoModel(String claimNo, ClaimInfo claimInfo) throws Exception {
		ClaimMainInfo mainInfo = new ClaimMainInfo();
		if(claimNo!=null && !"".equals(claimNo)){
			/** 1. 基本信息 */
			mainInfo.setClaimTypeCode("904001");//赔案类型
			mainInfo.setSubStatusCode("Z");//辅状态
			mainInfo.setSubStatusName("Z");//辅状态名称
			mainInfo.setProdKindCode("03");//产品大类号
			String policyNo = "";
			String riskCode = "";
			String registNo = "";
			String compensateNo = "";
			//资料收集齐全标志
			boolean collAllDocFlag = false;
			//立案信息（注意71小时延迟立案）
			PrplClaim claim = prplClaimMapper.findByClaimNo(claimNo);
			if(claim!=null){
				registNo = convertToString(claim.getRegistNo());
				policyNo = convertToString(claim.getPolicyNo());
				mainInfo.setRegistNo(convertToString(claim.getRegistNo()));
				mainInfo.setCaseNo(convertToString(claim.getClaimNo()));
				mainInfo.setPolicyNo(convertToString(claim.getPolicyNo()));
				mainInfo.setProdCode(convertToString(claim.getRiskCode()));//产品号
				//mainInfo.setProdName();//产品名称，与产品号对应
				mainInfo.setRegistComCode(convertToString(claim.getComCode()));//立案机构
				if("1".equals(convertToString(claim.getValidFlag()))){
					mainInfo.setRegistDate(convertToString(claim.getClaimDate()));//立案时间
				}
				//受理报案人员信息
				mainInfo.setReceiverCode(convertToString(claim.getOperatorCode()));
				String operatorName = prpLbpmMainMapper.findHandlerName(convertToString(claim.getOperatorCode()));
				mainInfo.setReceiverName(convertToString(operatorName));
				//案件注销信息

				//资料收集齐全标志
				if(claim.getDocAllSelectFlag()!=null && "1".equals(claim.getDocAllSelectFlag())){
					collAllDocFlag = true;
				}
				/** 2. 查询当前案件节点信息，目前只给客户展示四个状态（立案、定损(小额处理)、理算计算书（小额审核）、结案）*/
				String mainNodeCode = "";//赔案主状态码
				String userCode = "";//节点处理人代码
				String userName = "";//节点处理人名称
				String state = "";//节点状态 1：已处理 0：未处理 2：正处理
				String comCode = "";//机构代码
				String undwrtHanlderCode = "";//核赔人代码
				String undwrtHanlderName = "";//核赔人名称
				List<String> noList = new ArrayList<>();//businessNo集合
				noList.add(claimNo);
				noList.add(registNo);
				//结案标志
				boolean isEndCase = false;
				//当前立案有理算信息标志
				boolean hasCompensateFlag = false;
				//已核赔标志
				boolean undwrtFlag = false;
				//赔付被保险人金额
				BigDecimal insuredPayAmt = new BigDecimal(0);
				//实付被保险人金额
				BigDecimal insuredRealPayAmt = new BigDecimal(0);
				//本次总赔付金额
				BigDecimal sumPayAct = new BigDecimal(0);
				Date compensateDate = null;//理算时间
				Date undwrtDate = null;//核赔时间
				//理算任务标志 1-正常理算 0-分项理算
				String compensateType = "1";
				///2-1 查询是否有理算信息（若有，理算节点非未处理），目前只考虑正常理算和分项理算
				List<PrpLcompensate> lCompensates = compensateMapper.findByClaimNo(claimNo);
				if(lCompensates!=null && lCompensates.size()>0){//有理算信息(注意分项理算)
					hasCompensateFlag = true;
					for(PrpLcompensate lcompensate : lCompensates){
						noList.add(lcompensate.getCompensateNo());
						insuredPayAmt = insuredPayAmt.add(lcompensate.getSumThisPaid());
						insuredRealPayAmt = insuredRealPayAmt.add(lcompensate.getSumThisPaid());
						sumPayAct = sumPayAct.add(lcompensate.getSumPaid());
					}
				}
				//2-2 查询是否结案
				HashMap<String, Object> nodeMap = new HashMap<>();
				nodeMap.put("registNo", registNo);
				nodeMap.put("noList", noList);
				List<PrpLbpmMain> lbpmMains = prpLbpmMainMapper.findByRegistNoAndBusinessNo(nodeMap);
				if(lbpmMains!=null && lbpmMains.size()>0){
					PrpLbpmMain lbpmMain = lbpmMains.get(0);//取最新节点，为理赔最新状态
					int nodeId = lbpmMain.getNodeId();//最新节点ID
					state = lbpmMain.getState();
					comCode = lbpmMain.getComCode();
					userCode = lbpmMain.getUserCode();
					userName = prpLbpmMainMapper.findHandlerName(convertToString(userCode));
					if (18 == nodeId) {//结案状态，结案之前的数据均可取
						mainNodeCode = "9";//结案状态码
						//目前均为自动结案，传system
						mainInfo.setEndCaseHandlerCode("system");
						mainInfo.setEndCaseHandlerName("system");
						if (claim != null) {
							mainInfo.setEndCaseDate(convertToString(claim.getEndCaseDate()));//结案时间
						}
						isEndCase = true;//结案
						//理算、核赔
						if(lCompensates!=null && lCompensates.size()>0){
							PrpLcompensate prpLcompensate = lCompensates.get(lCompensates.size()-1);
							compensateDate = prpLcompensate.getInputTime();
							//是否核赔
							if("1".equals(prpLcompensate.getUnderWriteFlag()) || "3".equals(prpLcompensate.getUnderWriteFlag())){
								undwrtDate = prpLcompensate.getUnderwriteEndDate();//核赔时间
								undwrtHanlderCode = prpLcompensate.getUnderwriteCode();
								undwrtHanlderName = prpLcompensate.getUnderwriteName();
								undwrtFlag = true;
							}
						}
					}
					if(16 == nodeId){//理算环节
						mainNodeCode = "6";
						//考虑最新理算节点未处理情况，业务表中没有数据
						PrpLcompensate prpLcompensate = compensateMapper.findByCompensateNo(lbpmMain.getBusinessNo());
						if(prpLcompensate!=null){
							compensateDate = prpLcompensate.getInputTime();
							//是否核赔
							if("1".equals(prpLcompensate.getUnderWriteFlag()) || "3".equals(prpLcompensate.getUnderWriteFlag())){
								undwrtDate = prpLcompensate.getUnderwriteEndDate();//核赔时间
								undwrtHanlderCode = prpLcompensate.getUnderwriteCode();
								undwrtHanlderName = prpLcompensate.getUnderwriteName();
								undwrtFlag = true;
							}
						}
					} else if(51 == nodeId){//小额车财审核
						mainNodeCode = "6";
					} else if(7 == nodeId || 5 == nodeId || 10 == nodeId){//车辆定损/财产定损/人伤定损
						mainNodeCode = "4";
					} else if(50 == nodeId){//小额处理
						mainNodeCode = "4";
					} else if (3 == nodeId) {//立案状态，其他状态数据则不需要取d
						mainNodeCode = "3";
					}
					//单证收集信息
					nodeMap.clear();
					nodeMap.put("registNo",registNo);
					nodeMap.put("nodeId",14);
					if(collAllDocFlag){
						mainInfo.setCollectFlag("1");//1-资料收集齐全
					}
					List<PrpLbpmMain> docMains = prpLbpmMainMapper.findByRegistNoAndNodeId(nodeMap);
					if(docMains!=null && docMains.size()>0){
						PrpLbpmMain main = docMains.get(0);
						mainInfo.setCollectDealDate(convertToString(main.getInDate()));
						mainInfo.setCollHandlerCode(convertToString(main.getUserCode()));
						if(main.getUserCode()!=null){
							String handlerName = prpLbpmMainMapper.findHandlerName(main.getUserCode());
							mainInfo.setCollHandlerName(convertToString(handlerName));
						}
					}
				}
					/*if (94 <= nodeId && nodeId <= 101) {//核赔
						mainInfo.setMainStatusCode("8");
						mainInfo.setMainStatusName(convertToCaseStatus("8"));
						mainInfo.setUndwrtHanlderCode(convertToString(userCode));//核赔人代码
						mainInfo.setUndwrtHanlderName(convertToString(userName));//核赔人名称
						mainInfo.setUndwrtDate(convertToString(undwrtDate));//核赔时间
					} else if (7 == nodeId) {//定损状态，取定损状态之前环节的数据
						mainInfo.setMainStatusCode("4");
						mainInfo.setMainStatusName(convertToCaseStatus("4"));

					} else if (4 == nodeId || 8 == nodeId) {//人伤查勘或者车财查勘
						mainInfo.setMainStatusCode("1");//派工
						mainInfo.setMainStatusName(convertToCaseStatus("1"));
					} else if (1 == nodeId) {//报案
						mainInfo.setMainStatusCode("0");//报案
						mainInfo.setMainStatusName(convertToCaseStatus("0"));
					} else if (3 == nodeId) {//立案状态，其他状态数据则不需要取
						mainInfo.setMainStatusCode("3");
						mainInfo.setMainStatusName(convertToCaseStatus("3"));
					}*/
				mainInfo.setCompensateDate(convertToString(compensateDate));//理算时间
				mainInfo.setInsuredPayAmt(insuredPayAmt);
				mainInfo.setInsuredRealPayAmt(insuredRealPayAmt);
				mainInfo.setSumPayAct(sumPayAct);
				mainInfo.setUndwrtDate(convertToString(undwrtDate));//核赔时间
				mainInfo.setUndwrtHanlderCode(convertToString(undwrtHanlderCode));//核赔人代码
				mainInfo.setUndwrtHanlderName(convertToString(undwrtHanlderName));//核赔人名称
				mainInfo.setMainStatusCode(convertToString(mainNodeCode));//主状态码
				mainInfo.setMainStatusName(convertToCaseStatus(mainNodeCode));//主状态码名称
				mainInfo.setComCode(convertToString(comCode));//机构代码
				mainInfo.setNodeState(convertToString(state));//案件节点状态
			}
		}
		claimInfo.setClaimMainInfo(mainInfo);
	}

	/**
	 * 功能描述: 组装定损清单信息
	 * @author: wen
	 * @date: 2018/11/6 16:10
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	@Override
	public void transferToVehicleRepairModel(String claimNo, ClaimInfo claimInfo) throws Exception {
		List<VehicleRepairInfo> vehicleRepairList = new ArrayList<>();
		//换件
		List<VehicleRepairDto> componentDtos = vehicleRepairMapper.findComponents(claimNo);
		for(VehicleRepairDto dto : componentDtos){
			VehicleRepairInfo repairInfo = new VehicleRepairInfo();
			repairInfo.setCaseNo(convertToString(dto.getCaseNo()));
			repairInfo.setComponentName(convertToString(dto.getComponentName()));
			repairInfo.setLossType(convertToString(dto.getLossFeeType()));
			repairInfo.setLossLicenseNo(convertToString(dto.getLossLicenseNo()));
			repairInfo.setLossVinNo(convertToString(dto.getLossVinNo()));
			repairInfo.setVeriSumAmount(dto.getVeriSumAmount());
			vehicleRepairList.add(repairInfo);
		}
		//维修
		List<VehicleRepairDto> repairDtos = vehicleRepairMapper.findRepairs(claimNo);
		for(VehicleRepairDto dto : componentDtos){
			VehicleRepairInfo repairInfo = new VehicleRepairInfo();
			repairInfo.setCaseNo(convertToString(dto.getCaseNo()));
			repairInfo.setRepairItemName(convertToString(dto.getRepairItemName()));
			repairInfo.setLossType(convertToString(dto.getLossFeeType()));
			repairInfo.setLossLicenseNo(convertToString(dto.getLossLicenseNo()));
			repairInfo.setLossVinNo(convertToString(dto.getLossVinNo()));
			repairInfo.setVeriSumAmount(dto.getVeriSumAmount());
			vehicleRepairList.add(repairInfo);
		}
		//辅料
		List<VehicleRepairDto> MaterialsDtos = vehicleRepairMapper.findMaterials(claimNo);
		for(VehicleRepairDto dto : componentDtos){
			VehicleRepairInfo repairInfo = new VehicleRepairInfo();
			repairInfo.setCaseNo(convertToString(dto.getCaseNo()));
			repairInfo.setRepairItemName(convertToString(dto.getRepairItemName()));
			repairInfo.setLossType(convertToString(dto.getLossFeeType()));
			repairInfo.setLossLicenseNo(convertToString(dto.getLossLicenseNo()));
			repairInfo.setLossVinNo(convertToString(dto.getLossVinNo()));
			repairInfo.setVeriSumAmount(dto.getVeriSumAmount());
			vehicleRepairList.add(repairInfo);
		}
		//外修
		List<VehicleRepairDto> outRepairDtos = vehicleRepairMapper.findOuterRepairs(claimNo);
		for(VehicleRepairDto dto : componentDtos){
			VehicleRepairInfo repairInfo = new VehicleRepairInfo();
			repairInfo.setCaseNo(convertToString(dto.getCaseNo()));
			repairInfo.setRepairItemName(convertToString(dto.getRepairItemName()));
			repairInfo.setLossType(convertToString(dto.getLossFeeType()));
			repairInfo.setLossLicenseNo(convertToString(dto.getLossLicenseNo()));
			repairInfo.setLossVinNo(convertToString(dto.getLossVinNo()));
			repairInfo.setVeriSumAmount(dto.getVeriSumAmount());
			vehicleRepairList.add(repairInfo);
		}
		claimInfo.setVehicleRepairList(vehicleRepairList);
	}
	/**
	 * 功能描述:  组装人伤理算信息
	 * @author: wen
	 * @date: 2018/11/6 16:14
	 * @param: [registNo, claimInfo]
	 * @return: void
	 */
	@Override
	public void transferToInjuredListModel(String registNo, ClaimInfo claimInfo) throws Exception {
		List<InjuredInfo> injuredInfos = new ArrayList<>();
		//人伤信息
		List<InjuredInfoDto> injuredInfoDtos = injuredMapper.findInjuredList(registNo);
		HashMap<String,Object> map = new HashMap<>();
		int i=1;
		for(InjuredInfoDto injuredDto : injuredInfoDtos){
			InjuredInfo injuredInfo = new InjuredInfo();
			injuredInfo.setSerialNo(i);
			injuredInfo.setCaseNo(convertToString(injuredDto.getCaseNo()));
			injuredInfo.setInjuredName(convertToString(injuredDto.getInjuredName()));
			injuredInfo.setInjuredSex(convertToString(injuredDto.getInjuredSex()));
			injuredInfo.setInjuredLossType(convertToString(injuredDto.getInjuredLossType()));
			//暂未提供
			injuredInfo.setDiagnose(convertToString(injuredDto.getDiagnose()));
			//暂未提供
			injuredInfo.setContactName(convertToString(injuredDto.getContactName()));
			injuredInfo.setInjuredAge(injuredDto.getInjuredAge());
			injuredInfo.setSumAmount(injuredDto.getSumAmount());
			injuredInfo.setCheckTimes(injuredDto.getCheckTimes());
			injuredInfo.setClaimTimes(injuredDto.getClaimTimes());
			//组织人伤明细信息
			map.clear();
			map.put("compensateNo", injuredDto.getCompenstaeNo());
			map.put("claimNo", injuredDto.getCaseNo());
			map.put("injuredId", injuredDto.getInjuredId());
			List<InjuredFeeDto> injuredFeeDtos = injuredMapper.findInjuredFees(map);
			List<InjuredFee> injuredFees = new ArrayList<>();
			int j=1;
			for(InjuredFeeDto feeDto : injuredFeeDtos){
				InjuredFee fee = new InjuredFee();
				fee.setCaseNo(convertToString(injuredDto.getCaseNo()));
				fee.setInjuredSerialNo(j);
				fee.setFeeClaimTimes(feeDto.getFeeClaimTimes());
				fee.setFeeCheckTimes(feeDto.getFeeCheckTimes());
				fee.setInjuredFeeCode(convertToString(feeDto.getInjuredFeeCode()));
				fee.setInjuredFeeName(convertToString(feeDto.getInjuredFeeName()));
				fee.setPolAmount(feeDto.getPolAmount());
				fee.setRealAmount(feeDto.getRealAmount());
				injuredFees.add(fee);
				j++;
			}
			injuredInfo.setInjuredFeeList(injuredFees);
			injuredInfos.add(injuredInfo);
			i++;
		}
		claimInfo.setInjuredList(injuredInfos);
	}
	 /**
	 * 功能描述: 组装核赔意见列表
	 * @author: wen
	 * @date: 2018/11/6 17:38
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	@Override
	public void transferToUndwrtOpinionModel(String claimNo, ClaimInfo claimInfo) throws Exception {
		if(claimNo!=null && !"".equals(claimNo)){
			List<UndwrtOpinionDto> opinionDtos = undwrtMapper.findUndwrtOpinions(claimNo);
			List<UndwrtOpinion> opinionsList = new ArrayList<>();
			//组装核赔意见列表
			for(UndwrtOpinionDto opinionDto : opinionDtos){
				UndwrtOpinion opinion = new UndwrtOpinion();
				opinion.setCaseNo(convertToString(opinionDto.getCaseNo()));
				opinion.setClaimTimes(convertToInteger(opinionDto.getPayTimes()));
				opinion.setUndwrtTimes(convertToInteger(opinionDto.getUndwrtTimes()));
				opinion.setUndwrtOpinions(convertToString(opinionDto.getOpinopns()));
				opinion.setUndwrtConclusion(convertToString(opinionDto.getConclusion()));
				opinion.setUndwrtDate(convertToString(opinionDto.getUndwrtDate()));
				opinionsList.add(opinion);
			}
			claimInfo.setUndwrtOpinionList(opinionsList);
		}else{
			claimInfo.setUndwrtOpinionList(null);
		}

	}
	 /**
	 * 功能描述: 组装财产损失列表
	 * @author: wen
	 * @date: 2018/11/7 17:42
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	@Override
	public void transferToPropInfoModel(String claimNo, ClaimInfo claimInfo) throws Exception {
		HashMap<String,Object> map = new HashMap<>();
		List<PropLossInfo> lossInfos = new ArrayList<>();
		if(claimNo!=null && !"".equals(claimNo)){
			//财产损失信息查询
			List<PropInfoDto> propDtos = propLossMapper.findPropLosses(claimNo);
			int i = 1;
			for(PropInfoDto propInfoDto : propDtos){
				PropLossInfo propLossInfo = new PropLossInfo();
				propLossInfo.setSerialNo(i);
				propLossInfo.setCaseNo(convertToString(propInfoDto.getCaseNo()));
				propLossInfo.setLossFeeType(convertToString(propInfoDto.getLossFeeType()));
				propLossInfo.setSumPropLoss(propInfoDto.getSumVeriLoss());
				//损失归属方暂未提供
				propLossInfo.setLossOwner(convertToString("暂未提供"));
				List<PropLossFee> propLossFees = new ArrayList<>();
				//组织损失财产明细信息
				map.clear();
				map.put("registNo", propInfoDto.getRegistNo());
				map.put("propMainId", propInfoDto.getPropMainId());
				List<PropLossFeeDto> feeDtos = propLossMapper.findPropFees(map);
				int j = 1;
				for(PropLossFeeDto feeDto : feeDtos){
					PropLossFee propLossFee = new PropLossFee();
					propLossFee.setLossFeeSerialNo(j);
					propLossFee.setCaseNo(convertToString(propInfoDto.getCaseNo()));
					propLossFee.setItemKindCode(convertToString(feeDto.getItemKindCode()));
					propLossFee.setItemKindName(convertToString(feeDto.getItemKindName()));
					propLossFee.setLossItemName(convertToString(feeDto.getLossItemName()));
					propLossFee.setLossSpeciesCode(convertToString(feeDto.getLossSpeciesCode()));
					propLossFee.setLossSpeciesName(convertToString(feeDto.getLossSpeciesName()));
					propLossFee.setLossRate(feeDto.getLossRate());
					propLossFee.setUnitPrice(feeDto.getUnitPrice());
					propLossFee.setLossQuantity(feeDto.getLossQuantity());
					propLossFee.setSunVeriLoss(feeDto.getSumVeriLoss());
					propLossFees.add(propLossFee);
					j++;
				}
				propLossInfo.setPropFeeList(propLossFees);
				lossInfos.add(propLossInfo);
				i++;
			}
		}
		claimInfo.setPropLossList(lossInfos);
	}
	 /**
	 * 功能描述: 组装理赔单证收集列表
	 * @author: wen
	 * @date: 2018/11/12 10:47
	 * @param: [registNo, claimInfo]
	 * @return: void
	 */
	@Override
	public void transferToDocCollectModel(String registNo, ClaimInfo claimInfo) throws Exception {
		List<ClaimDocInfo> docInfoList = new ArrayList<>();
		if(registNo!=null && !"".equals(registNo)){
			//查询当前案件的理赔单证信息
			List<PrplDocCollectGuide> docCollectGuides = docCollectGuideMapper.findDocCollects(registNo);
			for(PrplDocCollectGuide docCollect : docCollectGuides){
				ClaimDocInfo docInfo = new ClaimDocInfo();
				//对应产品大类代码（默认‘03’）
				docInfo.setProNo("03");
				docInfo.setDocCode(convertToString(docCollect.getDocCode()));
				docInfo.setDocName(convertToString(docCollect.getDocName()));
				docInfo.setRiskCode(convertToString(docCollect.getRiskCode()));
				docInfo.setCreatorName(convertToString(docCollect.getOperatorCode()));
				docInfo.setCreateDate(convertToString(docCollect.getOperateDate()));
				docInfo.setModifierCode(convertToString(docCollect.getOperatorCode()));
				docInfo.setModifyDate(convertToString(docCollect.getOperateDate()));
				docInfo.setExpiryDate("");
				docInfo.setAddDocs("");
				docInfoList.add(docInfo);
			}
		}
		claimInfo.setClaimDocList(docInfoList);
	}

	/**
	 * 功能描述: 查询保单出险次数
	 * @author: wen
	 * @date: 2018/11/6 15:25
	 * @param: [policyNo]
	 * @return: java.lang.Integer
	 */
	@Override
	public Integer getDamageTimes(String policyNo) {
		HashMap<String,Object> map = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);
		String firstDay = "01-01";
		String lastDay = "12-31";
		String startDate = thisYear + "-" + firstDay;
		String endDate = thisYear + "-" + lastDay;
		map.put("policyNo", policyNo);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		int times = registMapper.getDamageTimes(map);
		return times;
	}

	/**
	* 功能描述: 查询理赔简单信息（理赔简单新接口）
	* @author: wen
	* @date: 2018/11/15 16:24
	* @param: [reqMap]
	* @return: java.util.List<com.chinacoal.ins.claim.car.vo.SimpleClaimVo>
	*/
	@Override
	public List<SimpleClaimVo> simpelClaimQuery(HashMap<String, Object> reqMap) throws Exception {
		if(reqMap!=null && reqMap.size()>0){
			List<SimpleClaimVo> claimVos = new ArrayList<>();
			List<PrplClaim> claims = prplClaimMapper.findByPolicyInfo(reqMap);
			if(claims!=null && claims.size()>0){
				String subPolicyNo = "";
				String registNo = "";
				for(PrplClaim claim : claims){
					SimpleClaimVo claimVo = new SimpleClaimVo();
					subPolicyNo = claim.getPolicyNo();
					registNo = claim.getRegistNo();
					/**组织保单相关信息*/
					this.transferToPolicyMain(subPolicyNo, claimVo);
					/**组织立案信息*/
					HashMap<String, String> map = new HashMap<>();
					map.put("registNo", registNo);
					map.put("policyNo", subPolicyNo);
					this.transferToClaim(claim, map, claimVo);
					/**组织出险信息*/
					this.transferToRegistInfo(registNo, claimVo);
					/**组织其他信息*/
					this.transferSimpleClaimToOtherInfo(claimVo);
					claimVos.add(claimVo);
				}
			}
			return claimVos;
		}else{
			return null;
		}

	}

	/**
	 * 功能描述: 根据报案号和保单号查询理赔信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/15 18:03
	 * @param: [registNo, policyNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.vo.SimpleClaimVo>
	 */
	@Override
	public List<SimpleClaimVo> simpelClaimQuery(String registNo, String policyNo) throws Exception {
		List<SimpleClaimVo> claimVos = new ArrayList<>();
		if(registNo!=null && !"".equals(registNo) && policyNo!=null && !"".equals(policyNo)){//根据报案号、保单号查询
			SimpleClaimVo claimVo = new SimpleClaimVo();
			//查询立案信息
			HashMap<String, String> map = new HashMap<>();
			map.put("registNo", registNo);
			map.put("policyNo", policyNo);
			PrplClaim claim = prplClaimMapper.findByPolicyAndRegistNo(map);
			if(claim!=null && claim.getClaimNo()!=null && !"".equals(claim.getClaimNo())){
				/**组织立案信息*/
				this.transferToClaim(claim, map, claimVo);
				/**组织保单相关信息*/
				this.transferToPolicyMain(policyNo, claimVo);
				/**组织出险信息*/
				this.transferToRegistInfo(registNo, claimVo);
				/**组织其他信息*/
				this.transferSimpleClaimToOtherInfo(claimVo);
				claimVos.add(claimVo);
			}

		} else if(registNo!=null && !"".equals(registNo) && (policyNo==null || "".equals(policyNo))){//根据报案号查询
			//根据报案号查询立案信息
			List<PrplClaim> claims = prplClaimMapper.findByRegistNo(registNo);
			String subPolicyNo = "";
			for(PrplClaim claim : claims){
				SimpleClaimVo claimVo1 = new SimpleClaimVo();
				subPolicyNo = claim.getPolicyNo();
				/**组织保单相关信息*/
				this.transferToPolicyMain(subPolicyNo, claimVo1);
				/**组织立案信息*/
				HashMap<String, String> map = new HashMap<>();
				map.put("registNo", registNo);
				map.put("policyNo", subPolicyNo);
				this.transferToClaim(claim, map, claimVo1);
				/**组织出险信息*/
				this.transferToRegistInfo(registNo, claimVo1);
				/**组织其他信息*/
				this.transferSimpleClaimToOtherInfo(claimVo1);
				claimVos.add(claimVo1);
			}
		}
		return claimVos;
	}

	/**
	 * 功能描述: 组装保单信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/20 14:45
	 * @param: [policyNo, claimVo]
	 * @return: void
	 */
	@Override
	public void transferToPolicyMain(String policyNo, SimpleClaimVo claimVo) throws Exception {
		/**组织保单相关信息*/
		GuPolicyMainVo policyMainVo = guPolicyMainMapper.findBySubpolicyNo(policyNo);
		if(policyMainVo!=null){
			//承保机构代码
			if(policyMainVo.getCompanyCodeTradtional()!=null && !"".equals(policyMainVo.getCompanyCodeTradtional())){
				claimVo.setInsuredComCode(policyMainVo.getCompanyCodeTradtional());
			}else{
				claimVo.setInsuredComCode(convertToString(policyMainVo.getCompanyCode()));
			}
			//业务员
			claimVo.setOperaterCode(convertToString(policyMainVo.getSalesManCode()));
			claimVo.setOperaterName(convertToString(policyMainVo.getHandlerName()));
			//代理人
			claimVo.setAgentCode(convertToString(policyMainVo.getIntermediaryCode()));
			claimVo.setAgentName(convertToString(policyMainVo.getAgentName()));
		}
	}
	 /**
	 * 功能描述: 组装简单立案信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/20 14:49
	 * @param: [claimOld, map, claimVo]
	 * @return: void
	 */
	@Override
	public void transferToClaim(PrplClaim claimOld, HashMap<String, String> map, SimpleClaimVo claimVo) throws Exception {
		PrplClaim claim = null;
		if(claimOld!=null && claimOld.getClaimNo()!=null && !"".equals(claimOld.getClaimNo())){
			claim = claimOld;
		} else if(map!=null && map.size()>0){
			claim = prplClaimMapper.findByPolicyAndRegistNo(map);
		}
		if(claim!=null){
			claimVo.setRegistNo(convertToString(claim.getRegistNo()));
			claimVo.setRiskCode(convertToString(claim.getRiskCode()));
			claimVo.setPolicyNo(convertToString(claim.getPolicyNo()));
			claimVo.setClaimDate(convertToString(claim.getClaimDate()));
			claimVo.setEndCaseDate(convertToString(claim.getEndCaseDate()));
		}
	}
	 /**
	 * 功能描述: 组装简单出险信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/20 14:51
	 * @param: [registNo, claimVo]
	 * @return: void
	 */
	@Override
	public void transferToRegistInfo(String registNo, SimpleClaimVo claimVo) throws Exception {
		PrplRegist regist = registMapper.findByRegistNo(registNo);
		if(regist!=null){
			claimVo.setReportorName(convertToString(regist.getReportorName()));
			String reportDate = convertToString(regist.getReportDate());
			if(!"".equals(reportDate) && !"".equals(regist.getReportHour())){
				String[] date = reportDate.split(" ");
				reportDate = date[0] + " " + convertToString(regist.getReportHour());
			}
			claimVo.setReportDate(reportDate);
			claimVo.setReporterMobile(convertToString(regist.getReportorMobile()));
			String damageDate = convertToString(regist.getDamageDate());
			if(!"".equals(damageDate) && !"".equals(regist.getDamageHour())){
				String[] date = damageDate.split(" ");
				damageDate = date[0] + " " + convertToString(regist.getDamageHour());
			}
			claimVo.setDamageDate(damageDate);
			claimVo.setDamageAddress(convertToString(regist.getDamageAddress()));
			claimVo.setDamageReason(convertToString(regist.getDamageName()));
		}
	}
	/**
	* 功能描述: 组装其他信息（理赔简单新接口）
	* @author: wen
	* @date: 2018/11/20 18:24
	* @param: [claimVo]
	* @return: void
	*/
	@Override
	public void transferSimpleClaimToOtherInfo(SimpleClaimVo claimVo) throws Exception {
		String registNo = claimVo.getRegistNo();
		String riskCode = claimVo.getRiskCode();
		String policyNo = claimVo.getPolicyNo();
		BigDecimal sumPaid = null; //估损/赔款金额
		HashMap<String, Object> quickPayMap = new HashMap<>();
		quickPayMap.put("registNo", registNo);
		quickPayMap.put("nodeId", 50);
		//需要区分小额案件和普通案件(小额案件查勘、定损取业务表数据)
		List<PrpLbpmMain> quickPayMains = prpLbpmMainMapper.findByRegistNoAndNodeId(quickPayMap);
		if(quickPayMains!=null && quickPayMains.size()>0){//小额案件
			List<String> prplchecktaskids = quickPayCaseMapper.findInjuredTasks(registNo);
			if(prplchecktaskids!=null && prplchecktaskids.size()>0){
				//有人伤
				claimVo.setInjuredInd("1");
			}else {
				claimVo.setInjuredInd("0");
			}
			List<String> checkers = quickPayCaseMapper.findChecker(registNo);
			if(checkers!=null && checkers.size()>0){
				String checker = checkers.get(0);//第一个查勘任务的
				claimVo.setCheckPerosn(convertToString(checker));
			}
		}else {//正常案件
			//查勘员，暂取第一个查勘任务
			HashMap<String, Object> checkMap = new HashMap<>();
			checkMap.put("registNo", registNo);
			checkMap.put("nodeId", 4);
			List<PrpLbpmMain> carPropBpmMains = prpLbpmMainMapper.findByRegistNoAndNodeId(checkMap);
			if(carPropBpmMains!=null && carPropBpmMains.size()>0){
				PrpLbpmMain carBpmMain = carPropBpmMains.get(0);
				if(carBpmMain.getUserCode()!=null && !"".equals(carBpmMain.getUserCode())){
					String handlerName = prpLbpmMainMapper.findHandlerName(carBpmMain.getUserCode());
					if(handlerName!=null && !"".equals(handlerName)){
						claimVo.setCheckPerosn(handlerName);
					}else {
						claimVo.setCheckPerosn(convertToString(carBpmMain.getUserCode()));
					}
				}
			}
			//是否有人伤信息，暂根据人伤查勘判断
			checkMap.clear();
			checkMap.put("registNo", registNo);
			checkMap.put("nodeId", 8);
			List<PrpLbpmMain> personBpmMains = prpLbpmMainMapper.findByRegistNoAndNodeId(checkMap);
			if(personBpmMains!=null && personBpmMains.size()>0){
				//有人伤
				claimVo.setInjuredInd("1");
			}else{
				claimVo.setInjuredInd("0");
			}
		}
		//查询案件最新节点【环节：立案 核赔】
		HashMap<String, String> nodeMap = new HashMap<>();
		nodeMap.put("registNo", registNo);
		nodeMap.put("riskCode", claimVo.getRiskCode());
		List<PrpLbpmMain> lbpmMains = prpLbpmMainMapper.findByRegistNoAndRiskCode(nodeMap);
		//结案节点需要单独查询（根据报案号和立案号查询）
		nodeMap.clear();
		nodeMap.put("registNo", registNo);
		nodeMap.put("policyNo", policyNo);
		List<PrpLbpmMain> endCaseMains = prpLbpmMainMapper.findByRegistNoAndPolicyNo(nodeMap);
		if(endCaseMains!=null && endCaseMains.size()>0){//结案状态
			claimVo.setCaseStatus(convertToCaseStatus("9"));
			PrplClaim endCaseClaim = prplClaimMapper.findByPolicyAndRegistNo(nodeMap);
			if(endCaseClaim!=null){
				//结案号
				claimVo.setEndCaseNo(convertToString(endCaseClaim.getCaseNo()));
				sumPaid = endCaseClaim.getSumPaid();//对应险别的结案金额（暂取结案后立案表中sumpaid）
			}
			//支付时间
			List<PrpLpayment> prpLpayments = prpLpaymentMapper.findPayMent(nodeMap);
			if(prpLpayments!=null && prpLpayments.size()>0){
				claimVo.setPayDate(convertToString(prpLpayments.get(0).getPayDate()));//支付时间
					/*for(PrpLpayment prpLpayment : prpLpayments){
						sumPaid.add(prpLpayment.getSumRealPay());//赔付成功则取赔付金额
					}*/
			}
		}else if(lbpmMains!=null && lbpmMains.size()>0){//未结案：取最新节点，在两个节点之间则取上一个节点
			BigDecimal businessId = null;
			HashMap<String, String> pidMap = new HashMap<>();
			pidMap.put("registNo", registNo);
			PrpLbpmMain lbpmMain = lbpmMains.get(0);
			if(lbpmMain.getNodeId()==null || "".equals(lbpmMain.getNodeId())) {
				claimVo.setCaseStatus("");
			} else if(3 == lbpmMain.getNodeId()){ //立案
				claimVo.setCaseStatus(convertToCaseStatus("3"));
			} else if(50 == lbpmMain.getNodeId()){ //小额
				claimVo.setCaseStatus(convertToCaseStatus("4"));
				List<QuickPayInfoDto> quickPayInfoDtos = quickPayCaseMapper.querySumPaid(registNo);
				BigDecimal quickPaid = new BigDecimal(0);
				for (QuickPayInfoDto quickPayInfoDto : quickPayInfoDtos){
					if(quickPayInfoDto.getSumDefCarLoss()!=null){
						quickPaid = quickPaid.add(quickPayInfoDto.getSumDefCarLoss());
					}
					if(quickPayInfoDto.getSumDefPerLoss()!=null){
						quickPaid = quickPaid.add(quickPayInfoDto.getSumDefPerLoss());
					}
					if(quickPayInfoDto.getSumDefPropLoss()!=null){
						quickPaid = quickPaid.add(quickPayInfoDto.getSumDefPropLoss());
					}
				}
				sumPaid = quickPaid;
			} else if(7 == lbpmMain.getNodeId()){ //定损
				claimVo.setCaseStatus(convertToCaseStatus("4"));
				//定损金额
				businessId = lbpmMain.getBusinessId();
				if(businessId!=null){
					sumPaid = claimMoneyMapper.querySumPaidForLoss(businessId);
				}
			} else { //核赔
				claimVo.setCaseStatus(convertToCaseStatus("8"));
				pidMap.put("riskCode", lbpmMain.getRiskCode());
				//金额
				sumPaid = claimMoneyMapper.querySumPaidForUndwrt(pidMap);
			}
		}
		claimVo.setSumLoss(sumPaid);
	}

	/**
	 * 功能描述: 计算当前立案下的赔付金额
	 * @author: wen
	 * @date: 2018/11/20 11:06
	 * @param: [claimNo]
	 * @return: java.math.BigDecimal
	 */
	@Override
	public BigDecimal getSumRealPaid(String claimNo) {
		BigDecimal sumdutypaid = new BigDecimal(0);//立案下的所有赔款金额
		if(claimNo!=null && !"".equals(claimNo)){
			List<ClaimMoneyDto> moneyDtos = claimMoneyMapper.findByClaimNo(claimNo);
			for(ClaimMoneyDto moneyDto : moneyDtos){
				sumdutypaid = sumdutypaid.add(moneyDto.getSumDutyPaid());
				for(ClaimMoneyDto moneyDto1 : moneyDtos){
					if(moneyDto.getCompensateNo()!=null && !"".equals(moneyDto.getCompensateNo()) &&
							moneyDto1.getCompensateNo()!=null && !"".equals(moneyDto1.getCompensateNo()) &&
							moneyDto.getCompensateNo().equals(moneyDto1.getCompensateNo())){
						sumdutypaid = sumdutypaid.subtract(moneyDto1.getChargeAct());
					}
				}
			}
		}
		return sumdutypaid;
	}
}
