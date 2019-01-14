package com.chinacoal.ins.claim.car.dao;


import com.chinacoal.ins.claim.car.pojo.PrpLbpmMain;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface PrpLbpmMainMapper {


     /**
     * 功能描述: 根据报案号和节点ID查询节点信息
     * @author: wen
     * @date: 2018/11/16 17:51
     * @param: [queryMap]
     * @return: com.chinacoal.ins.claim.car.pojo.PrpLbpmMain
     */
    List<PrpLbpmMain> findByRegistNoAndNodeId(HashMap<String, Object> queryMap);
     /**
     * 功能描述: 查询处理人名称
     * @author: wen
     * @date: 2018/11/19 9:57
     * @param: [userCode]
     * @return: java.lang.String
     */
    String findHandlerName(String userCode);
     /**
     * 功能描述: 根据报案号和险别查询节点信息（立案、定损）
     * @author: wen
     * @date: 2018/11/19 11:06
     * @param: [map]
     * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.PrpLbpmMain>
     */
    List<PrpLbpmMain> findByRegistNoAndRiskCode(HashMap<String, String> map);
     /**
	 * 功能描述: 根据报案号和保单号查询结案节点（结案）
	 * @author: wen
	 * @date: 2018/11/20 9:20
	 * @param: [map]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.PrpLbpmMain>
	 */
	List<PrpLbpmMain> findByRegistNoAndPolicyNo(HashMap<String, String> map);
	 /**
	 * 功能描述: 查询支付时间
	 * @author: wen
	 * @date: 2018/11/20 11:12
	 * @param: [map]
	 * @return: java.util.Date
	 */
	Date findPayDate(HashMap<String, String> map);

	List<PrpLbpmMain> findByRegistNoAndBusinessNo(HashMap<String, Object> queryMap);

	List<PrpLbpmMain> findByClaimNo(String claimNo);

	List<PrpLbpmMain> findByBusinessNoAndNodeId(HashMap<String, Object> queryMap);

	List<PrpLbpmMain> findByRegistNoAndInNodeId(HashMap<String, Object> queryMap);

}