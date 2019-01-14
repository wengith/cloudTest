package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyRisk;
import com.chinacoal.ins.proposal.car.pojo.GuPolicyRiskKey;
import com.chinacoal.ins.proposal.car.vo.ProposalAddFieldVo;

import java.util.List;

public interface GuPolicyRiskMapper {

    /**
     * description:selectByPrimaryKey 根据主键查询
     * @author:  Administrator
     * @date: 2018-10-24
     * @since: 1.0
     */
    GuPolicyRisk selectByPrimaryKey(GuPolicyRiskKey key);
    String findPolicyNoBySubPolicyNo(String subPolicyNo);
    List<GuPolicyRisk> findByPolicyNo(String policyNo);
    /**
     * 功能描述: 查询新增字段
     * @author: wen
     * @date: 2018/10/29 17:42
     * @param: [proposalNo]
     * @return: com.chinacoal.ins.proposal.car.vo.ProposalAddFieldVo
     */
    ProposalAddFieldVo findAddFiledByProposalNo(String proposalNo);
}