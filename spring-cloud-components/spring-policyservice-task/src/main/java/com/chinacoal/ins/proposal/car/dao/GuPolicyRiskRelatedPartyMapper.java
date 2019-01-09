package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyRiskRelatedParty;
import com.chinacoal.ins.proposal.car.pojo.GuPolicyRiskrelatedpartyKey;

import java.util.HashMap;
import java.util.List;

public interface GuPolicyRiskRelatedPartyMapper {
    /**
     * 
     * description:selectByPrimaryKey
     * @author:  wen
     * @date: 2018-10-23
     * @since: 1.0
     */
    GuPolicyRiskRelatedParty selectByPrimaryKey(GuPolicyRiskrelatedpartyKey key);

    List<GuPolicyRiskRelatedParty> selectByPolicynoAndIdentifyno(HashMap<String, Object> reqMap);

    List<GuPolicyRiskRelatedParty> findBySubPolicyNo(String subPolicyNo);



}