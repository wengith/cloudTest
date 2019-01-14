package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyItemKind;
import com.chinacoal.ins.proposal.car.pojo.GuPolicyItemKindKey;
import com.chinacoal.ins.proposal.car.vo.GuPolicyItemKindVo;

import java.util.List;

public interface GuPolicyItemKindMapper {

    /**
     * 
     * description:selectByPrimaryKey
     * @author:  Administrator
     * @date: 2018-10-24
     * @since: 1.0
     */
    GuPolicyItemKind selectByPrimaryKey(GuPolicyItemKindKey key);
    GuPolicyItemKindVo findSyxBySubPolicyNo(String subPolicyNo);
    GuPolicyItemKindVo findJqxBySubPolicyNo(String subPolicyNo);
    List<GuPolicyItemKind> findKindsByPolicyNo(String policyNo);

}