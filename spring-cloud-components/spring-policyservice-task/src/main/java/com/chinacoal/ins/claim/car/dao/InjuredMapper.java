package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.InjuredFeeDto;
import com.chinacoal.ins.claim.car.pojo.InjuredInfoDto;

import java.util.HashMap;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/5 16:11
 * @description: 人伤理算信息Mapper
 */
public interface InjuredMapper {

	public List<InjuredInfoDto> findInjuredList(String registNo);

	public List<InjuredFeeDto> findInjuredFees(HashMap<String, Object> map);

}
