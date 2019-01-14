package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.UndwrtOpinionDto;

import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/6 17:12
 * @description: 理算核赔处理Mapper
 */
public interface UndwrtMapper {

	 /**
	 * 功能描述: 查询核赔意见列表
	 * @author: wen
	 * @date: 2018/11/6 17:26
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.UndwrtOpinionDto>
	 */
	List<UndwrtOpinionDto> findUndwrtOpinions(String claimNo);
}
