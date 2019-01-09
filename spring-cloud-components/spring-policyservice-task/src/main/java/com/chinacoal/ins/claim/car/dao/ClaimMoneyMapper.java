package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.ClaimMoneyDto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/20 10:47
 * @description: 理赔相关金额Mapper
 */
public interface ClaimMoneyMapper {

	 /**
	 * 功能描述: 查询当前立案下的相关金额
	 * @author: wen
	 * @date: 2018/11/20 10:48
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.ClaimMoneyDto>
	 */
	List<ClaimMoneyDto> findByClaimNo(String claimNo);
	/**
	 * 功能描述: 查询核赔环节的赔款金额
	 * @author: wen
	 * @date: 2018/11/19 15:27
	 * @param: [queryMap]
	 * @return: java.math.BigDecimal
	 */
	BigDecimal querySumPaidForUndwrt(HashMap<String,String> queryMap);
	/**
	 * 功能描述: 查询定损金额
	 * @author: wen
	 * @date: 2018/11/19 16:08
	 * @param: [id]
	 * @return: java.math.BigDecimal
	 */
	BigDecimal querySumPaidForLoss(BigDecimal id);
	/**
	 * 功能描述: 查询结案环节赔款金额
	 * @author: wen
	 * @date: 2018/11/20 10:02
	 * @param: [queryMap]
	 * @return: java.math.BigDecimal
	 */
	BigDecimal querySumpaidForEndCase(HashMap<String,String> queryMap);
}
