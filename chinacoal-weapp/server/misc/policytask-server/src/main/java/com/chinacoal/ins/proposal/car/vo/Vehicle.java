package com.chinacoal.ins.proposal.car.vo;

import java.util.Date;

/**
 * @author: wen
 * @date: 2018/10/18 13:11
 * @description: Vehicle 车辆信息
 */
public class Vehicle {

	/** 外地车标志 */
	private String carEcdemicVehicleFlag;
	/** 过户车 */
	private Boolean carChgOwnerFlag;
	/** 异型车 */
	private Boolean abnormalCarFlag;
	/** 贷款车 */
	private Boolean carLoanVehicleFlag;
	/** 投保新增设备 */
	private Boolean newDeviceInd;
	/** 特殊车投保标志 */
	private String specialCarFlag;
	/** 车牌号码 */
	private String carLicenseNo;
	/** 车架号 */
	private String carVinNoTemp;
	/** 发动机号 */
	private String carEngineNoTemp;
	/** 使用性质 */
	private String carUseNature1;
	/** 车辆用途 */
	private String carUseNature2;
	/** 车辆大类 */
	private String carType1;
	/** 车辆细类 */
	private String carType2;
	/** 车辆类型 */
	private String carType3;
	/** 品牌型号 */
	private String carModelName;
	/** 品牌型号打印 */
	private String carDealerName;
	/** 行业车型代码 */
	private String platformVehicleCode;
	/** 行业车型名称 */
	private String platformVehicleName;
	/** 号牌种类 */
	private String carLicenseType;
	/** 被保人与车辆关系 */
	private String carInsuredRelation;
	/** 车身颜色 */
	private String carColorCode;
	/** 号牌底色 */
	private String carLicenseColorCode;
	/** 新车购置价 */
	private Double purchasePrice;
	/** 实际价值 */
	private Double carActualValue;
	/** 使用年数 */
	private Integer yearsOfActualUse;
	/** 核定载质量 */
	private Double carTonCount;
	/** 核定载客数 */
	private Integer carSeatCount;
	/** 总质量 */
	private Double allMass;
	/** 整备质量 */
	private Double completeKerbMass;
	/** 排量 */
	private Double exhaustScale;
	/** 功率 */
	private Double power;
	/** 交管车辆类型 */
	private String carVehicleStyle;
	/** 进口车标志 */
	private String countryNature;
	/** 能源类型 */
	private String fuelType;
	/** 初登日期 */
	private String carEnrollDate;
	/** 发证日期 */
	private String carLicenseDate;
	/** 新车购置日期 */
	private String carBookingTime;
	/** 过户日期 */
	private String carTransferDate;
	/** 验车情况 */
	private String carcheckStatus;
	/** 免验原因 */
	private String carcheckReason;
	/** 验车人 */
	private String carChecker;
	/** 验车时间 */
	private Date carCheckTime;

	/**
	 * 外地车标志
	 * @return carEcdemicVehicleFlag 外地车标志
	 */
	public String getCarEcdemicVehicleFlag() {
		return carEcdemicVehicleFlag;
	}

	/**
	 * 外地车标志
	 * @param carEcdemicVehicleFlag 外地车标志
	 */
	public void setCarEcdemicVehicleFlag(String carEcdemicVehicleFlag) {
		this.carEcdemicVehicleFlag = carEcdemicVehicleFlag;
	}

	/**
	 * 过户车
	 * @return carChgOwnerFlag 过户车
	 */
	public Boolean getCarChgOwnerFlag() {
		return carChgOwnerFlag;
	}

	/**
	 * 过户车
	 * @param carChgOwnerFlag 过户车
	 */
	public void setCarChgOwnerFlag(Boolean carChgOwnerFlag) {
		this.carChgOwnerFlag = carChgOwnerFlag;
	}

	/**
	 * 异型车
	 * @return abnormalCarFlag 异型车
	 */
	public Boolean getAbnormalCarFlag() {
		return abnormalCarFlag;
	}

	/**
	 * 异型车
	 * @param abnormalCarFlag 异型车
	 */
	public void setAbnormalCarFlag(Boolean abnormalCarFlag) {
		this.abnormalCarFlag = abnormalCarFlag;
	}

	/**
	 * 贷款车
	 * @return carLoanVehicleFlag 贷款车
	 */
	public Boolean getCarLoanVehicleFlag() {
		return carLoanVehicleFlag;
	}

	/**
	 * 贷款车
	 * @param carLoanVehicleFlag 贷款车
	 */
	public void setCarLoanVehicleFlag(Boolean carLoanVehicleFlag) {
		this.carLoanVehicleFlag = carLoanVehicleFlag;
	}

	/**
	 * 投保新增设备
	 * @return newDeviceInd 投保新增设备
	 */
	public Boolean getNewDeviceInd() {
		return newDeviceInd;
	}

	/**
	 * 投保新增设备
	 * @param newDeviceInd 投保新增设备
	 */
	public void setNewDeviceInd(Boolean newDeviceInd) {
		this.newDeviceInd = newDeviceInd;
	}

	/**
	 * 特殊车投保标志
	 * @return specialCarFlag 特殊车投保标志
	 */
	public String getSpecialCarFlag() {
		return specialCarFlag;
	}

	/**
	 * 特殊车投保标志
	 * @param specialCarFlag 特殊车投保标志
	 */
	public void setSpecialCarFlag(String specialCarFlag) {
		this.specialCarFlag = specialCarFlag;
	}

	/**
	 * 车牌号码
	 * @return carLicenseNo 车牌号码
	 */
	public String getCarLicenseNo() {
		return carLicenseNo;
	}

	/**
	 * 车牌号码
	 * @param carLicenseNo 车牌号码
	 */
	public void setCarLicenseNo(String carLicenseNo) {
		this.carLicenseNo = carLicenseNo;
	}

	/**
	 * 车架号
	 * @return carVinNoTemp 车架号
	 */
	public String getCarVinNoTemp() {
		return carVinNoTemp;
	}

	/**
	 * 车架号
	 * @param carVinNoTemp 车架号
	 */
	public void setCarVinNoTemp(String carVinNoTemp) {
		this.carVinNoTemp = carVinNoTemp;
	}

	/**
	 * 发动机号
	 * @return carEngineNoTemp 发动机号
	 */
	public String getCarEngineNoTemp() {
		return carEngineNoTemp;
	}

	/**
	 * 发动机号
	 * @param carEngineNoTemp 发动机号
	 */
	public void setCarEngineNoTemp(String carEngineNoTemp) {
		this.carEngineNoTemp = carEngineNoTemp;
	}

	/**
	 * 使用性质
	 * @return carUseNature1 使用性质
	 */
	public String getCarUseNature1() {
		return carUseNature1;
	}

	/**
	 * 使用性质
	 * @param carUseNature1 使用性质
	 */
	public void setCarUseNature1(String carUseNature1) {
		this.carUseNature1 = carUseNature1;
	}

	/**
	 * 车辆用途
	 * @return carUseNature2 车辆用途
	 */
	public String getCarUseNature2() {
		return carUseNature2;
	}

	/**
	 * 车辆用途
	 * @param carUseNature2 车辆用途
	 */
	public void setCarUseNature2(String carUseNature2) {
		this.carUseNature2 = carUseNature2;
	}

	/**
	 * 车辆大类
	 * @return carType1 车辆大类
	 */
	public String getCarType1() {
		return carType1;
	}

	/**
	 * 车辆大类
	 * @param carType1 车辆大类
	 */
	public void setCarType1(String carType1) {
		this.carType1 = carType1;
	}

	/**
	 * 车辆细类
	 * @return carType2 车辆细类
	 */
	public String getCarType2() {
		return carType2;
	}

	/**
	 * 车辆细类
	 * @param carType2 车辆细类
	 */
	public void setCarType2(String carType2) {
		this.carType2 = carType2;
	}

	/**
	 * 车辆类型
	 * @return carType3 车辆类型
	 */
	public String getCarType3() {
		return carType3;
	}

	/**
	 * 车辆类型
	 * @param carType3 车辆类型
	 */
	public void setCarType3(String carType3) {
		this.carType3 = carType3;
	}

	/**
	 * 品牌型号
	 * @return carModelName 品牌型号
	 */
	public String getCarModelName() {
		return carModelName;
	}

	/**
	 * 品牌型号
	 * @param carModelName 品牌型号
	 */
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	/**
	 * 品牌型号打印
	 * @return setCarDealerName 品牌型号打印
	 */
	public String getCarDealerName() {
		return carDealerName;
	}

	/**
	 * 品牌型号打印
	 * @param carDealerName 品牌型号打印
	 */
	public void setCarDealerName(String carDealerName) {
		this.carDealerName = carDealerName;
	}

	/**
	 * 行业车型代码
	 * @return platformVehicleCode 行业车型代码
	 */
	public String getPlatformVehicleCode() {
		return platformVehicleCode;
	}

	/**
	 * 行业车型代码
	 * @param platformVehicleCode 行业车型代码
	 */
	public void setPlatformVehicleCode(String platformVehicleCode) {
		this.platformVehicleCode = platformVehicleCode;
	}

	/**
	 * 行业车型名称
	 * @return platformVehicleName 行业车型名称
	 */
	public String getPlatformVehicleName() {
		return platformVehicleName;
	}

	/**
	 * 行业车型名称
	 * @param platformVehicleName 行业车型名称
	 */
	public void setPlatformVehicleName(String platformVehicleName) {
		this.platformVehicleName = platformVehicleName;
	}

	/**
	 * 号牌种类
	 * @return carLicenseType 号牌种类
	 */
	public String getCarLicenseType() {
		return carLicenseType;
	}

	/**
	 * 号牌种类
	 * @param carLicenseType 号牌种类
	 */
	public void setCarLicenseType(String carLicenseType) {
		this.carLicenseType = carLicenseType;
	}

	/**
	 * 被保人与车辆关系
	 * @return carInsuredRelation 被保人与车辆关系
	 */
	public String getCarInsuredRelation() {
		return carInsuredRelation;
	}

	/**
	 * 被保人与车辆关系
	 * @param carInsuredRelation 被保人与车辆关系
	 */
	public void setCarInsuredRelation(String carInsuredRelation) {
		this.carInsuredRelation = carInsuredRelation;
	}

	/**
	 * 车身颜色
	 * @return carColorCode 车身颜色
	 */
	public String getCarColorCode() {
		return carColorCode;
	}

	/**
	 * 车身颜色
	 * @param carColorCode 车身颜色
	 */
	public void setCarColorCode(String carColorCode) {
		this.carColorCode = carColorCode;
	}

	/**
	 * 号牌底色
	 * @return carLicenseColorCode 号牌底色
	 */
	public String getCarLicenseColorCode() {
		return carLicenseColorCode;
	}

	/**
	 * 号牌底色
	 * @param carLicenseColorCode 号牌底色
	 */
	public void setCarLicenseColorCode(String carLicenseColorCode) {
		this.carLicenseColorCode = carLicenseColorCode;
	}

	/**
	 * 新车购置价
	 * @return purchasePrice 新车购置价
	 */
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * 新车购置价
	 * @param purchasePrice 新车购置价
	 */
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * 实际价值
	 * @return carActualValue 实际价值
	 */
	public Double getCarActualValue() {
		return carActualValue;
	}

	/**
	 * 实际价值
	 * @param carActualValue 实际价值
	 */
	public void setCarActualValue(Double carActualValue) {
		this.carActualValue = carActualValue;
	}

	/**
	 * 使用年数
	 * @return yearsOfActualUse 使用年数
	 */
	public Integer getYearsOfActualUse() {
		return yearsOfActualUse;
	}

	/**
	 * 使用年数
	 * @param yearsOfActualUse 使用年数
	 */
	public void setYearsOfActualUse(Integer yearsOfActualUse) {
		this.yearsOfActualUse = yearsOfActualUse;
	}

	/**
	 * 核定载质量
	 * @return carTonCount 核定载质量
	 */
	public Double getCarTonCount() {
		return carTonCount;
	}

	/**
	 * 核定载质量
	 * @param carTonCount 核定载质量
	 */
	public void setCarTonCount(Double carTonCount) {
		this.carTonCount = carTonCount;
	}

	/**
	 * 核定载客数
	 * @return carSeatCount 核定载客数
	 */
	public Integer getCarSeatCount() {
		return carSeatCount;
	}

	/**
	 * 核定载客数
	 * @param carSeatCount 核定载客数
	 */
	public void setCarSeatCount(Integer carSeatCount) {
		this.carSeatCount = carSeatCount;
	}

	/**
	 * 总质量
	 * @return allMass 总质量
	 */
	public Double getAllMass() {
		return allMass;
	}

	/**
	 * 总质量
	 * @param allMass 总质量
	 */
	public void setAllMass(Double allMass) {
		this.allMass = allMass;
	}

	/**
	 * 整备质量
	 * @return completeKerbMass 整备质量
	 */
	public Double getCompleteKerbMass() {
		return completeKerbMass;
	}

	/**
	 * 整备质量
	 * @param completeKerbMass 整备质量
	 */
	public void setCompleteKerbMass(Double completeKerbMass) {
		this.completeKerbMass = completeKerbMass;
	}

	/**
	 * 排量
	 * @return exhaustScale 排量
	 */
	public Double getExhaustScale() {
		return exhaustScale;
	}

	/**
	 * 排量
	 * @param exhaustScale 排量
	 */
	public void setExhaustScale(Double exhaustScale) {
		this.exhaustScale = exhaustScale;
	}

	/**
	 * 功率
	 * @return power 功率
	 */
	public Double getPower() {
		return power;
	}

	/**
	 * 功率
	 * @param power 功率
	 */
	public void setPower(Double power) {
		this.power = power;
	}

	/**
	 * 交管车辆类型
	 * @return carVehicleStyle 交管车辆类型
	 */
	public String getCarVehicleStyle() {
		return carVehicleStyle;
	}

	/**
	 * 交管车辆类型
	 * @param carVehicleStyle 交管车辆类型
	 */
	public void setCarVehicleStyle(String carVehicleStyle) {
		this.carVehicleStyle = carVehicleStyle;
	}

	/**
	 * 进口车标志
	 * @return countryNature 进口车标志
	 */
	public String getCountryNature() {
		return countryNature;
	}

	/**
	 * 进口车标志
	 * @param countryNature 进口车标志
	 */
	public void setCountryNature(String countryNature) {
		this.countryNature = countryNature;
	}

	/**
	 * 能源类型
	 * @return fuelType 能源类型
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * 能源类型
	 * @param fuelType 能源类型
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * 初登日期
	 * @return carEnrollDate 初登日期
	 */
	public String getCarEnrollDate() {
		return carEnrollDate;
	}

	/**
	 * 初登日期 yyyy-MM-dd HH:mm:ss
	 * @param carEnrollDate 初登日期
	 */
	public void setCarEnrollDate(String carEnrollDate) {
		this.carEnrollDate = carEnrollDate;
	}

	/**
	 * 发证日期
	 * @return carLicenseDate 发证日期
	 */
	public String getCarLicenseDate() {
		return carLicenseDate;
	}

	/**
	 * 发证日期 yyyy-MM-dd HH:mm:ss
	 * @param carLicenseDate 发证日期
	 */
	public void setCarLicenseDate(String carLicenseDate) {
		this.carLicenseDate = carLicenseDate;
	}

	/**
	 * 新车购置日期
	 * @return 新车购置日期
	 */
	public String getCarBookingTime() {
		return carBookingTime;
	}

	/**
	 * 新车购置日期 yyyy-MM-dd HH:mm:ss
	 * @param carBookingTime 新车购置日期
	 */
	public void setCarBookingTime(String carBookingTime) {
		this.carBookingTime = carBookingTime;
	}

	/**
	 * 过户日期 yyyy-MM-dd HH:mm:ss
	 * @return carTransferDate 过户日期
	 */
	public String getCarTransferDate() {
		return carTransferDate;
	}

	/**
	 * 过户日期
	 * @param carTransferDate 过户日期
	 */
	public void setCarTransferDate(String carTransferDate) {
		this.carTransferDate = carTransferDate;
	}

	/**
	 * 验车情况
	 * @return carcheckStatus 验车情况
	 */
	public String getCarcheckStatus() {
		return carcheckStatus;
	}

	/**
	 * 验车情况
	 * @param carcheckStatus 验车情况
	 */
	public void setCarcheckStatus(String carcheckStatus) {
		this.carcheckStatus = carcheckStatus;
	}

	/**
	 * 免验原因
	 * @return carcheckReason 免验原因
	 */
	public String getCarcheckReason() {
		return carcheckReason;
	}

	/**
	 * 免验原因
	 * @param carcheckReason 免验原因
	 */
	public void setCarcheckReason(String carcheckReason) {
		this.carcheckReason = carcheckReason;
	}

	/**
	 * 验车人
	 * @return carChecker 验车人
	 */
	public String getCarChecker() {
		return carChecker;
	}

	/**
	 * 验车人
	 * @param carChecker 验车人
	 */
	public void setCarChecker(String carChecker) {
		this.carChecker = carChecker;
	}

	/**
	 * 验车时间
	 * @return carCheckTime 验车时间
	 */
	public Date getCarCheckTime() {
		return carCheckTime;
	}

	/**
	 * 验车时间 yyyy-MM-dd HH:mm:ss
	 * @param carCheckTime 验车时间
	 */
	public void setCarCheckTime(Date carCheckTime) {
		this.carCheckTime = carCheckTime;
	}
}
