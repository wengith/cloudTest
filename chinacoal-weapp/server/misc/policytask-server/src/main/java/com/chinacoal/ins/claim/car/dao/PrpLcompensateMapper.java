package com.chinacoal.ins.claim.car.dao;


import com.chinacoal.ins.claim.car.pojo.PrpLcompensate;

import java.util.List;


public interface PrpLcompensateMapper {

	List<PrpLcompensate> findByClaimNo(String claimNo);

	PrpLcompensate findByCompensateNo(String compensateNo);
}