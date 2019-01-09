package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyMain;
import com.chinacoal.ins.proposal.car.vo.GuPolicyMainVo;

public interface GuPolicyMainMapper {

    /**
     * description:selectByPrimaryKey
     * @author:  Administrator
     * @date: 2018-10-24
     * @since: 1.0
     */
    GuPolicyMain selectByPrimaryKey(String policyno);
     /**
     * 功能描述: 根据保单号查询保单主表信息
     * @author: wen
     * @date: 2018/11/16 14:58
     * @param: [policyNo]
     * @return: com.chinacoal.ins.proposal.car.vo.GuPolicyMainVo
     */
    GuPolicyMainVo findByPolicyNo(String policyNo);

     /**
     * 功能描述: 根据保单分号查询保单主表信息
     * @author: wen
     * @date: 2018/11/16 15:05
     * @param: [subpolicyNo]
     * @return: com.chinacoal.ins.proposal.car.vo.GuPolicyMainVo
     */
     GuPolicyMainVo findBySubpolicyNo(String subpolicyNo);
}