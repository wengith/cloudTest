package com.chinacoal.ins.claim.car.api;

import com.chinacoal.ins.claim.car.service.ClaimQueryService;
import com.chinacoal.ins.claim.car.vo.ClaimData;
import com.chinacoal.ins.claim.car.vo.ClaimInfo;
import com.chinacoal.ins.claim.car.vo.RegistInfo;
import com.chinacoal.ins.claim.car.vo.SimpleClaimVo;
import com.chinacoal.ins.utils.RespCode;
import com.chinacoal.ins.utils.RespEntity;
import ins.framework.common.ResultPage;
import ins.framework.mybatis.MybatisApiUtils;
import ins.framework.mybatis.PageParam;
import ins.framework.mybatis.util.Pages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wen
 * @date: 2018/11/2 16:41
 * @description: 理赔查询接口Controller
 */
@RestController
@RequestMapping("/claim")
@CrossOrigin
@Api(value = "ClaimServerApi |理赔信息查询接口的控制器")
public class ClaimServerApi {

	@Autowired
	ClaimQueryService claimQueryService;

	 /**
	 * 功能描述: 理赔信息查询入口
	 * @author: wen
	 * @date: 2018/11/15 16:10
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.utils.RespEntity
	 */
	@RequestMapping(value = "/claimSearch", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="根据保单号和证件号码查询出险列表信息", notes="code返回200时请求成功" )
	public RespEntity claimSearch(@RequestBody HashMap<String, Object> reqMap){
		ClaimData claimData = new ClaimData();
		if(reqMap!=null && reqMap.size()>0){
			//保单号
			String subPolicyNo = (String) reqMap.get("policyNo");
			//证件号码
			String identifyNumber = (String) reqMap.get("identifyNo");
			if(subPolicyNo==null || "".equals(subPolicyNo)){
				return new RespEntity(RespCode.ERROR, null);
			}
			if(identifyNumber==null || "".equals(identifyNumber)){
				return new RespEntity(RespCode.ERROR, null);
			}
			//调用处理处理业务逻辑方法
			try {
				claimData = claimQueryService.baseCaseQuery(reqMap);
				return new RespEntity(RespCode.SUCCESS, claimData);
			}catch (Exception ex){
				ex.printStackTrace();
				return new RespEntity(RespCode.FAIL, null);
			}
		}else{
			return new RespEntity(RespCode.ERROR, null);
		}
	}

	 /**
	 * 功能描述: 点击立案号返回报案扩展信息
	 * @author: wen
	 * @date: 2018/11/21 18:22
	 * @param: [claimNo]
	 * @return: com.chinacoal.ins.utils.RespEntity
	 */
	@RequestMapping(value = "/caseInfoSearch", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="根据立案号查询案件扩展信息", notes="code返回200时请求成功" )
	public RespEntity caseInfoSearch(@RequestBody HashMap<String, Object> reqMap) throws Exception {
		if(reqMap!=null && reqMap.size()>0){
			String claimNo = (String) reqMap.get("claimNo");
			RegistInfo registInfo = new RegistInfo();
			if(claimNo!=null && !"".equals(claimNo)){
				try {
					registInfo = claimQueryService.caseInfoQuery(claimNo);
					return new RespEntity(RespCode.SUCCESS, registInfo);
				} catch (Exception ex){
					ex.printStackTrace();
					return new RespEntity(RespCode.FAIL, null);
				}
			} else {
				return new RespEntity(RespCode.ERROR, null);
			}
		} else {
			return new RespEntity(RespCode.ERROR, null);
		}
	}

	/**
	 * 功能描述: 案件理赔信息
	 * @author: wen
	 * @date: 2018/11/23 11:48
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.utils.RespEntity
	 */
	@RequestMapping(value = "/claimInfoSearch", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="根据立案号查询理赔基本信息", notes="code返回200时请求成功" )
	public RespEntity claimInfoSearch(@RequestBody HashMap<String, Object> reqMap) throws Exception {
		if(reqMap!=null && reqMap.size()>0){
			String claimNo = (String) reqMap.get("claimNo");
			ClaimInfo claimInfo = new ClaimInfo();
			if(claimNo!=null && !"".equals(claimNo)){
				try {
					claimInfo = claimQueryService.claimInfoQuery(claimNo);
					return new RespEntity(RespCode.SUCCESS, claimInfo);
				} catch (Exception ex){
					ex.printStackTrace();
					return new RespEntity(RespCode.FAIL, null);
				}
			} else {
				return new RespEntity(RespCode.ERROR, null);
			}
		} else {
			return new RespEntity(RespCode.ERROR, null);
		}
	}
	 /**
	 * 功能描述: 理赔查询（简单版）入口
	 * @author: wen
	 * @date: 2018/11/15 16:10
	 * @param: [reqMap]
	 * @return: com.chinacoal.ins.utils.RespEntity
	 */
	@RequestMapping(value = "/simpleSearch", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="查询理赔简单信息", notes="code返回0000时请求成功" )
	public RespEntity simpleClaimSearch(HttpServletRequest request, @RequestBody HashMap<String, Object> reqMap) {
		Map<String, String[]> map =  request.getParameterMap();
		ResultPage<SimpleClaimVo> claimVos = null;
		if (reqMap != null && reqMap.size() > 0) {
			try {
				/**校验查询规则 start*/
				String registNo = (String) reqMap.get("registNo");
				String policyNo = (String) reqMap.get("policyNo");
				String startDate = (String) reqMap.get("startDate");
				String endDate = (String) reqMap.get("endDate");
				String operaterCode = (String) reqMap.get("operaterCode");
				String agentCode = (String) reqMap.get("agentCode");
				String comCode = (String) reqMap.get("comCode");
				//参数校验
				if (registNo != null && policyNo != null && startDate != null && endDate != null
						&& operaterCode != null && agentCode != null && comCode != null) {
					//1. 根据报案号和保单号查询
					if (!"".equals(registNo)) {
						PageParam pageParam = MybatisApiUtils.getPageParam();
						List<SimpleClaimVo> claimVo1s = claimQueryService.simpelClaimQuery(registNo, policyNo);
						return new RespEntity(RespCode.SUCCESS1, claimVo1s);
					} else if ((!"".equals(startDate) && !"".equals(endDate))
							&& (!"".equals(operaterCode) || !"".equals(agentCode) || !"".equals(comCode))) {
						//2. 根据出险时间查询
						PageParam pageParam = MybatisApiUtils.getPageParam();
						claimVos = claimQueryService.simpelClaimQuery(reqMap, pageParam);

						return new RespEntity(RespCode.SUCCESS1, claimVos);
					} else {
						return new RespEntity(RespCode.ERROR1, null);
					}
					/**校验查询规则 end*/
				} else {
					return new RespEntity(RespCode.ERROR1, null);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return new RespEntity(RespCode.FAIL, null);
			}
		} else {
			return new RespEntity(RespCode.ERROR1, null);
		}
	}
}
