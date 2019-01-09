package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.PrplClaim;

import java.util.HashMap;
import java.util.List;

public interface PrplClaimMapper {

	List<PrplClaim> findByPolicy(String subPolicyNo);

	/**
	 * 功能描述: 接口入口-根据参数查询理赔立案信息
	 * @author: wen
	 * @date: 2018/11/2 16:35
	 * @param: [reqMap]
	 * @return: java.util.List<java.lang.String>
	 */
	List<String> findClaimNos(HashMap<String, Object> reqMap);
	 /**
	 * 功能描述: 根据保单号和报案号查询立案信息
	 * @author: wen
	 * @date: 2018/11/16 11:52
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.proposal.car.pojo.PrplClaim
	 */
	PrplClaim findByPolicyAndRegistNo(HashMap<String, String> reqMap);
	 /**
	 * 功能描述: 根据报案号查询立案信息
	 * @author: wen
	 * @date: 2018/11/20 14:20
	 * @param: [registNo]
	 * @return: java.util.List<com.chinacoal.ins.proposal.car.pojo.PrplClaim>
	 */
	List<PrplClaim> findByRegistNo(String registNo);

	List<PrplClaim> findByPolicyInfo(HashMap<String, Object> reqMap);


	PrplClaim findByClaimNo(String claimNo);
}