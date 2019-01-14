package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyRelatedParty;
import com.chinacoal.ins.proposal.car.pojo.GuPolicyRelatedPartyKey;

import java.util.List;

public interface GuPolicyRelatedPartyMapper {

    /**
     * 
     * description:selectByPrimaryKey
     * @author:  Administrator
     * @date: 2018-10-24
     * @since: 1.0
     */
    GuPolicyRelatedParty selectByPrimaryKey(GuPolicyRelatedPartyKey key);

    List<GuPolicyRelatedParty> findByPolicyNo(String policyNo);
}