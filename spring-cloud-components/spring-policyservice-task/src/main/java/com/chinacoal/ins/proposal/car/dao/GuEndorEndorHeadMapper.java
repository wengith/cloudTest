package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuEndorEndorHead;
import com.chinacoal.ins.proposal.car.vo.EndorHeadInfoVo;
import java.util.List;

public interface GuEndorEndorHeadMapper {

    /**
     * 
     * description:selectByPrimaryKey
     * @author:  Administrator
     * @date: 2018-10-26
     * @since: 1.0
     */
    GuEndorEndorHead selectByPrimaryKey(String endorno);

    List<EndorHeadInfoVo> findEndorVoByPolicyNo(String policyNo);
}