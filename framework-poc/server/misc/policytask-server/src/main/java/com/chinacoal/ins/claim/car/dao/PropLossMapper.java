package com.chinacoal.ins.claim.car.dao;

import java.util.HashMap;
import java.util.List;
import com.chinacoal.ins.claim.car.pojo.PropInfoDto;
import com.chinacoal.ins.claim.car.pojo.PropLossFeeDto;

/**
 * @author: wen
 * @date: 2018/11/7 16:47
 * @description:
 */
public interface PropLossMapper {

	 /**
	 * 功能描述: 查询财产损失信息
	 * @author: wen
	 * @date: 2018/11/7 17:07
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.PropInfoDto>
	 */
	List<PropInfoDto> findPropLosses(String claimNo);
	 /**
	 * 功能描述: 查询财产损失项明细
	 * @author: wen
	 * @date: 2018/11/7 17:26
	 * @param: [map]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.PropLossFeeDto>
	 */
	List<PropLossFeeDto> findPropFees(HashMap<String, Object> map);
}
