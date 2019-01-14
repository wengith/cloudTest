package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.BaseCaseInfoDto;
import com.chinacoal.ins.claim.car.pojo.PrplRegist;
import com.chinacoal.ins.claim.car.pojo.RegistInfoDto;

import java.util.HashMap;


public interface PrplRegistMapper {

	 /**
	 * 功能描述: 根据报案号查询报案信息
	 * @author: wen
	 * @date: 2018/11/16 14:42
	 * @param: [registNo]
	 * @return: com.chinacoal.ins.claim.car.pojo.PrplRegist
	 */
	PrplRegist findByRegistNo(String registNo);
	 /**
	 * 功能描述: 根据立案号查询案件信息
	 * @author: wen
	 * @date: 2018/11/6 18:04
	 * @param: [claimNo]
	 * @return: com.chinacoal.ins.claim.car.pojo.BaseCaseInfoDto
	 */
	BaseCaseInfoDto findByClaimNo(String claimNo);
	/**
	 * 功能描述: 计算出险次数
	 * @author: wen
	 * @date: 2018/11/6 14:46
	 * @param: [map]
	 * @return: java.lang.Integer
	 */
	Integer getDamageTimes(HashMap<String, Object> map);
	 /**
	 * 功能描述: 查询案件扩展信息
	 * @author: wen
	 * @date: 2018/11/7 10:47
	 * @param: [map]
	 * @return: com.chinacoal.ins.claim.car.pojo.RegistInfoDto
	 */
	RegistInfoDto findRegistDto(HashMap<String, Object> map);

}
