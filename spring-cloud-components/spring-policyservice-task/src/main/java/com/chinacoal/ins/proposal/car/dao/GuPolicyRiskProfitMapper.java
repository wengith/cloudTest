package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyRiskProfit;
import com.chinacoal.ins.proposal.car.pojo.GuPolicyRiskProfitKey;

import java.util.List;

public interface GuPolicyRiskProfitMapper {

    /**
     * 
     * description:selectByPrimaryKey
     * @author:  Administrator
     * @date: 2018-10-26
     * @since: 1.0
     */
    GuPolicyRiskProfit selectByPrimaryKey(GuPolicyRiskProfitKey key);

    List<GuPolicyRiskProfit> findByPolicyNo(String policyNo);
}