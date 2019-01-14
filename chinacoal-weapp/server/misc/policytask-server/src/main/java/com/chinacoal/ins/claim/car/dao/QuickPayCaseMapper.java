package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.QuickPayInfoDto;

import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/21 11:32
 * @description: 理赔小额案件相关Mapper
 */
public interface QuickPayCaseMapper {

	 /**
	 * 功能描述: 查询人伤信息查勘任务
	 * @author: wen
	 * @date: 2018/11/21 11:40
	 * @param: [registNo]
	 * @return: java.util.List<java.lang.String>
	 */
	public List<String> findInjuredTasks(String registNo);
	/**
	 * 功能描述: 查询查勘任务中查勘员
	 * @author: wen
	 * @date: 2018/11/21 11:47
	 * @param: [registNo]
	 * @return: java.util.List<java.lang.String>
	 */
	public List<String> findChecker(String registNo);
	/**
	 * 功能描述: 查询当前小额案件的定损金额（车辆、财产、人伤）
	 * @author: wen
	 * @date: 2018/11/21 14:59
	 * @param: [registNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.QuickPayInfoDto>
	 */
	List<QuickPayInfoDto> querySumPaid(String registNo);
}
