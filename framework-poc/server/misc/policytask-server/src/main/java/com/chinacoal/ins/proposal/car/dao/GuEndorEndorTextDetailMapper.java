package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuEndorEndorTextDetail;
import com.chinacoal.ins.proposal.car.pojo.GuEndorEndorTextDetailKey;
import com.chinacoal.ins.proposal.car.vo.EndorHeadInfoVo;

import java.util.List;

public interface GuEndorEndorTextDetailMapper {

    /**
     * 
     * description:selectByPrimaryKey
     * @author:  Administrator
     * @date: 2018-10-26
     * @since: 1.0
     */
    GuEndorEndorTextDetail selectByPrimaryKey(GuEndorEndorTextDetailKey key);
    List<GuEndorEndorTextDetail> findByEndorInfo(EndorHeadInfoVo endorHeadInfoVo);
}