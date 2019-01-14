package com.chinacoal.ins.claim.car.service;

import com.chinacoal.ins.claim.car.vo.ClaimData;
import com.chinacoal.ins.claim.car.vo.ClaimInfo;
import com.chinacoal.ins.claim.car.vo.RegistInfo;
import com.chinacoal.ins.claim.car.vo.SimpleClaimVo;
import com.chinacoal.ins.proposal.car.pojo.PrplClaim;
import com.chinacoal.ins.proposal.car.vo.GuPolicyMainVo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @auther: wen
 * @date: 2018/11/1 18:04
 * @description:
 */
public interface ClaimQueryService {

	/**
	 * 功能描述: 理赔信息查询
	 * @author: wen
	 * @date: 2018/11/2 16:52
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.claim.car.vo.ClaimData
	 */
	public ClaimData baseCaseQuery(HashMap<String, Object> reqMap) throws Exception;
	/**
	 * 功能描述: 根据立案号查询出险信息
	 * @author: wen
	 * @date: 2018/11/23 10:56
	 * @param: [claimNo]
	 * @return: com.chinacoal.ins.claim.car.vo.RegistInfo
	 */
	public RegistInfo caseInfoQuery(String claimNo) throws Exception;

	public ClaimInfo claimInfoQuery(String claimNo) throws Exception;
	 /**
	 * 功能描述: 组装案件扩展信息
	 * @author: wen
	 * @date: 2018/11/7 11:07
	 * @param: [map, claimInfo]
	 * @return: void
	 */
	public void transferToRegistInfoModel(HashMap<String, Object> map, ClaimInfo claimInfo) throws Exception;
	 /**
	 * 功能描述: 组装理赔环节相关信息
	 * @author: wen
	 * @date: 2018/11/21 18:05
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	public void transferToMainInfoModel(String claimNo, ClaimInfo claimInfo) throws Exception;
	 /**
	 * 功能描述: 组装定损清单信息
	 * @author: wen
	 * @date: 2018/11/6 16:11
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	public void transferToVehicleRepairModel(String claimNo, ClaimInfo claimInfo) throws Exception;
	/**
	 * 功能描述: 组装人伤理算信息
	 * @author: wen
	 * @date: 2018/11/6 16:13
	 * @param: [registNo, claimInfo]
	 * @return: void
	 */
	public void transferToInjuredListModel(String registNo, ClaimInfo claimInfo) throws Exception;
	 /**
	 * 功能描述: 组装核赔意见列表
	 * @author: wen
	 * @date: 2018/11/6 17:39
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	public void transferToUndwrtOpinionModel(String compensateNo, ClaimInfo claimInfo) throws Exception;
	 /**
	 * 功能描述: 组装财产损失列表
	 * @author: wen
	 * @date: 2018/11/7 17:41
	 * @param: [claimNo, claimInfo]
	 * @return: void
	 */
	public void transferToPropInfoModel(String claimNo, ClaimInfo claimInfo) throws Exception;
	 /**
	 * 功能描述: 组装理赔单证收集列表
	 * @author: wen
	 * @date: 2018/11/12 10:46
	 * @param: [registNo, claimInfo]
	 * @return: void
	 */
	public void transferToDocCollectModel(String registNo, ClaimInfo claimInfo) throws Exception;
	/**
	 * 功能描述: 查询保单出险次数
	 * @author: wen
	 * @date: 2018/11/6 15:20
	 * @param: [policyNo]
	 * @return: java.lang.Integer
	 */
	public Integer getDamageTimes(String policyNo);

	 /**
	 * 功能描述: 简单理赔信息查询（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/15 16:17
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.claim.car.vo.SimpleClaimVo
	 */
	public List<SimpleClaimVo> simpelClaimQuery(HashMap<String, Object> reqMap) throws Exception;

	 /**
	 * 功能描述: 根据报案号和保单号查询理赔信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/15 18:03
	 * @param: [registNo, policyNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.vo.SimpleClaimVo>
	 */
	public List<SimpleClaimVo> simpelClaimQuery(String registNo, String policyNo) throws Exception;
	 /**
	  * 功能描述: 组装保单信息（理赔简单新接口）
	  * @author: wen
	  * @date: 2018/11/20 14:34
	  * @param: [policyNo, claimVo]
	  * @return: void
	  */
	public void transferToPolicyMain(String policyNo, SimpleClaimVo claimVo) throws Exception;
	 /**
	 * 功能描述: 组装简单立案信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/20 14:47
	 * @param: [claimOld, map, claimVo]
	 * @return: void
	 */
	public void transferToClaim(PrplClaim claimOld, HashMap<String, String> map, SimpleClaimVo claimVo) throws Exception;
	 /**
	 * 功能描述: 组装简单出险信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/20 14:51
	 * @param: [registNo, claimVo]
	 * @return: void
	 */
	public void transferToRegistInfo(String registNo, SimpleClaimVo claimVo) throws Exception;
	/**
	 * 功能描述: 组装其他信息（理赔简单新接口）
	 * @author: wen
	 * @date: 2018/11/20 18:24
	 * @param: [claimVo]
	 * @return: void
	 */
	public void transferSimpleClaimToOtherInfo(SimpleClaimVo claimVo) throws Exception;
	/**
	 * 功能描述: 计算当前立案下赔付金额
	 * @author: wen
	 * @date: 2018/11/20 10:46
	 * @param: [claimNo]
	 * @return: java.math.BigDecimal
	 */
	public BigDecimal getSumRealPaid(String claimNo);
}
