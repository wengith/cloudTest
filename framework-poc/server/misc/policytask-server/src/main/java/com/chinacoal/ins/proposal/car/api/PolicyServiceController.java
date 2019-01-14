package com.chinacoal.ins.proposal.car.api;

import com.chinacoal.ins.proposal.car.service.PolicyQueryService;
import com.chinacoal.ins.proposal.car.vo.Proposal;
import com.chinacoal.ins.utils.RespCode;
import com.chinacoal.ins.utils.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

/**
 * @author: wen
 * @date: 2018/10/18 15:13
 * @description: PolicyController 保单查询相关接口
 */
@RestController
@RequestMapping("/proposal")
@CrossOrigin
public class PolicyServiceController {

	@Autowired
	PolicyQueryService policyQueryService;

	@RequestMapping("/policySearch")
	@ResponseBody
	public RespEntity policySearch(@RequestBody HashMap<String, Object> reqMap){
		System.out.println("=====policySearch=====");
		Proposal proposal = new Proposal();
		HashMap<String,Object> datas = new HashMap<>(0);
		if(reqMap!=null && reqMap.size()>0){
			//保单号
			String subPolicyNo = (String) reqMap.get("policyNo");
			//证件号码
			String identifyNumber = (String) reqMap.get("identifyNo");
			System.out.println("subPolicyNo===" + subPolicyNo);
			System.out.println("identifyNumber===" + identifyNumber);
			if(subPolicyNo==null || "".equals(subPolicyNo)){
				return new RespEntity(RespCode.ERROR, null);
			}
			if(identifyNumber==null || "".equals(identifyNumber)){
				return new RespEntity(RespCode.ERROR, null);
			}
			//调用处理处理业务逻辑方法
			try {
				proposal = policyQueryService.policyQuery(reqMap);
				datas.put("proposal",proposal);
				return new RespEntity(RespCode.SUCCESS, datas);
			}catch (Exception ex){
				ex.printStackTrace();
				return new RespEntity(RespCode.FAIL, null);
			}
		}else{
			return new RespEntity(RespCode.ERROR, null);
		}
	}
}
