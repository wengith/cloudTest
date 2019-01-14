package com.chinacoal.ins.proposal.car.dao;

import com.chinacoal.ins.proposal.car.pojo.GuPolicyItemMotor;
import com.chinacoal.ins.proposal.car.pojo.GuPolicyItemMotorKey;

import java.math.BigDecimal;

public interface GuPolicyItemMotorMapper {

    /**
     * description:selectByPrimaryKey
     * @author:  wen
     * @date: 2018-10-23
     * @since: 1.0
     */
    GuPolicyItemMotor selectByPrimaryKey(GuPolicyItemMotorKey key);

    GuPolicyItemMotor findOwnerBySubPolicyNo(String subPolicyNo);

    GuPolicyItemMotor findBySubPolicyNo(String subPolicyNo);

    BigDecimal findAllMass(String policyNo);

}