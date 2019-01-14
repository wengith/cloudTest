package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.VehicleRepairDto;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/2 09:31
 * @description: 定损清单信息Mapper
 */
public interface VehicleRepairMapper {

	/**
	 * 功能描述: 根据立案号查询定损换件清单
	 * @author: wen
	 * @date: 2018/11/2 15:49
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.VehicleRepairDto>
	 */
	List<VehicleRepairDto> findComponents(String claimNo);
	/**
	 * 功能描述:
	 * @author: wen
	 * @date: 2018/11/2 15:53
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.VehicleRepairDto>
	 */
	List<VehicleRepairDto> findRepairs(String claimNo);
	/**
	 * 功能描述: 根据立案号查询定损辅料清单
	 * @author: wen
	 * @date: 2018/11/2 16:12
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.VehicleRepairDto>
	 */
	List<VehicleRepairDto> findMaterials(String claimNo);
	/**
	 * 功能描述: 根据立案号查询定损外修清单
	 * @author: wen
	 * @date: 2018/11/2 16:13
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.VehicleRepairDto>
	 */
	List<VehicleRepairDto> findOuterRepairs(String claimNo);
}
