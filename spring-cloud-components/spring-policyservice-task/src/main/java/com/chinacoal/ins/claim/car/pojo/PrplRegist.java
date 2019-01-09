package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PrplRegist {
    /**
     * 报案号
     */
    private String registNo;

    /**
     * 案件性质:L:正常理赔,T:通赔
     */
    private String lFlag;

    /**
     * BusinessId
     */
    private BigDecimal businessId;

    /**
     * 报案日期
     */
    private Date reportDate;

    /**
     * 报案时间
     */
    private String reportHour;

    /**
     * 报案人
     */
    private String reportorName;

    /**
     * 报案人电话
     */
    private String reportorNumber;

    /**
     * 报案人手机
     */
    private String reportorMobile;

    /**
     * 联系人
     */
    private String linkerName;

    /**
     * 联系人电话
     */
    private String phoneNmber;

    /**
     * 联系人手机
     */
    private String linkerMobile;

    /**
     * 与被保险人关系
     */
    private String relationShip;

    /**
     * 案件紧急状态
     */
    private String mercyFlag;

    /**
     * 出险日期
     */
    private Date damageDate;

    /**
     * 出险时间
     */
    private String damageHour;

    /**
     * 出险原因代码
     */
    private String damageCode;

    /**
     * 出险原因说明
     */
    private String damageName;

    /**
     * 事故原因代码
     */
    private String damageTypeCode;

    /**
     * 事故类型说明
     */
    private String damageTypeName;

    /**
     * 出险区域代码
     */
    private String damageAreaCode;

    /**
     * 出险区域说明
     */
    private String damageAreaName;

    /**
     * 出险地点分类
     */
    private String damageAddressType;

    /**
     * 出险地点
     */
    private String damageAddress;

    /**
     * 查勘地点
     */
    private String checkAddress;

    /**
     * 报案地点
     */
    private String reportAddress;

    /**
     * 查勘属地
     */
    private String checkAreaCode;

    /**
     * 本车责任
     */
    private String obligation;

    /**
     * 损失类别
     */
    private String lossItemTypes;

    /**
     * 快速处理
     */
    private String qdCaseType;

    /**
     * 操作员代码
     */
    private String operatorCode;

    /**
     * 坐席归属机构代码
     */
    private String operatorComCode;

    /**
     * 初登人员代码
     */
    private String firstRegCode;

    /**
     * 初登坐席归属机构代码
     */
    private String firstRegComCode;

    /**
     * 业务操作机构
     */
    private String makeCom;

    /**
     * 计算机输单日期
     */
    private Date inputTime;

    /**
     * 交强保险责任类型
     */
    private BigDecimal ciIndemDuty;

    /**
     * 是否立案标志
     */
    private String claimStatus;

    /**
     * 赔案类别
     */
    private String claimType;

    /**
     * 注销标志
     */
    private String cancelFlag;

    /**
     * 提交次数
     */
    private Short submitNumber;
    /**
     * 有效标志
     */
    private String validFlag;

    /**
     * 出险经过
     */
    private String remark;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 报案方式
     */
    private String registMode;

    /**
     * 报损金额
     */
    private BigDecimal reportLossFee;

    /**
     * 币别代码
     */
    private String currency;

    /**
     * 出险地邮编
     */
    private String damagePostCode;

    /**
     * 单证号
     */
    private String certiNo;

    /**
     * 受理原因
     */
    private String acceptReason;

    /**
     * 案件赔付标识 1:互碰自赔，0：非互碰自赔
     */
    private String caseFlag;

    /**
     * 省份代码
     */
    private String provinceCode;

    /**
     * 市代码
     */
    private String cityCode;

    /**
     * 区代码
     */
    private String regionalCode;

    /**
     * 地点
     */
    private String place;

    /**
     * 是否异地出险
     */
    private String remoteDamageFalg;
    /**
     * 是否现场报案
     */
    private String sceneRegistFalg;
    /**
     * 预约查勘地点
     */
    private String doomCheckPlace;
    /**
     * 快出快赔
     */
    private String fastPay;
    /**
     * 被代位标识0不是,1是
     */
    private String disReplaceRepayFlag;
    /**
     * 代位标识,0不是,1是
     */
    private String replaceRepayFlag;
    /**
     * 被保险人电话
     */
    private String insuredPhoneNumber;
    /**
     * 简易案件标识，1表示是简易案件
     */
    private String simpleCaseFlag;

    /**
     * 事故种类代码
     */
    private String accidentTypeCode;

    /**
     * 事故种类名称
     */
    private String accidentTypeName;

    /**
     * 损失部位
     */
    private String lossPart;

    /**
     * 自动重案标志 1-是 0-否
     */
    private String autoImportantFlag;

    /**
     * 欺诈标识
     */
    private String antiFlag;
    /**
     * 欺诈概率
     */
    private BigDecimal antiValue;
    /**
     * 出险地点类型
     */
    private String riskAddrType;

    /**
     * 有无交警事故认定书
     */
    private String dutyFlag;
    /**
     * 快处快赔-01，交警-02
     */
    private String resourceFlag;

    /**
     * 快赔系统报案号（河南）
     */
    private String quickCaseNo;
    /**
     * 录音关联标志
     */
    private String callState;
    /**
     * 零结标识 1-是 0-不是
     */
    private String zeroClose;

    /**
     * 零结原因
     */
    private String zeroCloseReason;

    /**
     * 理赔直通车路径：0,不走直通车；1,直通车1；2,直通车2；-1,本来可以走直通车1,选择没有走;-2,本来可以走直通车2,选择没有走;1-0,刚开始满足直通车1,后来又不满足了;2-0,刚开始满足直通车2,后来又不满足了;2_0,满足直通车二，但是单证收集环节处理人没有审核权限
     */
    private String claimDirectPath;

    /**
     * 是否符合自助理赔条件 1是 0不是
     */
    private String isSelfSurvey;

    /**
     * 是否可疑案件,1-是,0-否
     */
    private String isKeyiCase;

    /**
     * 报案号
     * @return registNo 报案号
     */
    public String getRegistNo() {
        return registNo;
    }

    /**
     * 报案号
     * @param registNo 报案号
     */
    public void setRegistNo(String registNo) {
        this.registNo = registNo == null ? null : registNo.trim();
    }

    /**
     * 案件性质:L:正常理赔,T:通赔
     * @return lFlag 案件性质:L:正常理赔,T:通赔
     */
    public String getLFlag() {
        return lFlag;
    }

    /**
     * 案件性质:L:正常理赔,T:通赔
     * @param lFlag 案件性质:L:正常理赔,T:通赔
     */
    public void setLFlag(String lFlag) {
        this.lFlag = lFlag == null ? null : lFlag.trim();
    }

    /**
     * businessId
     * @return businessId businessId
     */
    public BigDecimal getBusinessId() {
        return businessId;
    }

    /**
     * businessId
     * @param businessId businessId
     */
    public void setBusinessId(BigDecimal businessId) {
        this.businessId = businessId;
    }
    /**
     * 报案时间
     * @return reportHour 报案时间
     */
    public String getReportHour() {
        return reportHour;
    }

    /**
     * 报案时间
     * @param reportHour 报案时间
     */
    public void setReportHour(String reportHour) {
        this.reportHour = reportHour == null ? null : reportHour.trim();
    }

    /**
     * 报案人
     * @return reportorName 报案人
     */
    public String getReportorname() {
        return reportorName;
    }

    /**
     * 报案人
     * @param reportorName 报案人
     */
    public void setReportorName(String reportorName) {
        this.reportorName = reportorName == null ? null : reportorName.trim();
    }

    /**
     * 报案人电话
     * @return reportorNumber 报案人电话
     */
    public String getReportornumber() {
        return reportorNumber;
    }

    /**
     * 报案人电话
     * @param reportorNumber 报案人电话
     */
    public void setReportorNumber(String reportorNumber) {
        this.reportorNumber = reportorNumber == null ? null : reportorNumber.trim();
    }

    /**
     * 报案人手机
     * @return reportorMobile 报案人手机
     */
    public String getReportorMobile() {
        return reportorMobile;
    }

    /**
     * 报案人手机
     * @param reportorMobile 报案人手机
     */
    public void setReportorMobile(String reportorMobile) {
        this.reportorMobile = reportorMobile == null ? null : reportorMobile.trim();
    }

    /**
     * 联系人
     * @return linkerName 联系人
     */
    public String getLinkerName() {
        return linkerName;
    }

    /**
     * 联系人
     * @param linkerName 联系人
     */
    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName == null ? null : linkerName.trim();
    }
    /**
     * 联系人手机
     * @return linkerMobile 联系人手机
     */
    public String getLinkerMobile() {
        return linkerMobile;
    }

    /**
     * 联系人手机
     * @param linkerMobile 联系人手机
     */
    public void setLinkerMobile(String linkerMobile) {
        this.linkerMobile = linkerMobile == null ? null : linkerMobile.trim();
    }

    /**
     * 与被保险人关系
     * @return relationShip 与被保险人关系
     */
    public String getRelationShip() {
        return relationShip;
    }

    /**
     * 与被保险人关系
     * @param relationShip 与被保险人关系
     */
    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip == null ? null : relationShip.trim();
    }
    /**
     * 案件紧急状态
     * @return mercyFlag 案件紧急状态
     */
    public String getMercyFlag() {
        return mercyFlag;
    }

    /**
     * 案件紧急状态
     * @param mercyFlag 案件紧急状态
     */
    public void setMercyFlag(String mercyFlag) {
        this.mercyFlag = mercyFlag == null ? null : mercyFlag.trim();
    }

    /**
     * 出险日期
     * @return damageDate 出险日期
     */
    public Date getDamageDate() {
        return damageDate;
    }
    /**
     * 出险日期
     * @param damageDate 出险日期
     */
    public void setDamageDate(Date damageDate) {
        this.damageDate = damageDate;
    }

    /**
     * 出险时间
     * @return damageHour 出险时间
     */
    public String getDamageHour() {
        return damageHour;
    }

    /**
     * 出险时间
     * @param damageHour 出险时间
     */
    public void setDamageHour(String damageHour) {
        this.damageHour = damageHour == null ? null : damageHour.trim();
    }

    /**
     * 出险原因代码
     * @return damageCode 出险原因代码
     */
    public String getDamageCode() {
        return damageCode;
    }

    /**
     * 出险原因代码
     * @param damageCode 出险原因代码
     */
    public void setDamageCode(String damageCode) {
        this.damageCode = damageCode == null ? null : damageCode.trim();
    }

    /**
     * 出险原因说明
     * @return damageName 出险原因说明
     */
    public String getDamageName() {
        return damageName;
    }

    /**
     * 出险原因说明
     * @param damageName 出险原因说明
     */
    public void setDamageName(String damageName) {
        this.damageName = damageName == null ? null : damageName.trim();
    }

    /**
     * 事故原因代码
     * @return damageTypeCode 事故原因代码
     */
    public String getDamageTypeCode() {
        return damageTypeCode;
    }

    /**
     * 事故原因代码
     * @param damageTypeCode 事故原因代码
     */
    public void setDamageTypeCode(String damageTypeCode) {
        this.damageTypeCode = damageTypeCode == null ? null : damageTypeCode.trim();
    }

    /**
     * 事故类型说明
     * @return DAMAGETYPENAME 事故类型说明
     */
    public String getDamageTypeName() {
        return damageTypeName;
    }

    /**
     * 事故类型说明
     * @param damageTypeName 事故类型说明
     */
    public void setDamageTypeName(String damageTypeName) {
        this.damageTypeName = damageTypeName == null ? null : damageTypeName.trim();
    }

    /**
     * 出险区域代码
     * @return damageAreaCode 出险区域代码
     */
    public String getDamageAreaCode() {
        return damageAreaCode;
    }

    /**
     * 出险区域代码
     * @param damageAreaCode 出险区域代码
     */
    public void setDamageAreaCode(String damageAreaCode) {
        this.damageAreaCode = damageAreaCode == null ? null : damageAreaCode.trim();
    }

    /**
     * 出险区域说明
     * @return damageAreaName 出险区域说明
     */
    public String getDamageAreaName() {
        return damageAreaName;
    }

    /**
     * 出险区域说明
     * @param damageAreaName 出险区域说明
     */
    public void setDamageAreaName(String damageAreaName) {
        this.damageAreaName = damageAreaName == null ? null : damageAreaName.trim();
    }

    /**
     * 出险地点分类
     * @return damageAddressType 出险地点分类
     */
    public String getDamageAddressType() {
        return damageAddressType;
    }

    /**
     * 出险地点分类
     * @param damageAddressType 出险地点分类
     */
    public void setDamageAddressType(String damageAddressType) {
        this.damageAddressType = damageAddressType == null ? null : damageAddressType.trim();
    }

    /**
     * 出险地点
     * @return damageAddress 出险地点
     */
    public String getDamageAddress() {
        return damageAddress;
    }

    /**
     * 出险地点
     * @param damageAddress 出险地点
     */
    public void setDamageAddress(String damageAddress) {
        this.damageAddress = damageAddress == null ? null : damageAddress.trim();
    }

    /**
     * 查勘地点
     * @return checkAddress 查勘地点
     */
    public String getCheckAddress() {
        return checkAddress;
    }

    /**
     * 查勘地点
     * @param checkAddress 查勘地点
     */
    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress == null ? null : checkAddress.trim();
    }

    /**
     * 报案地点
     * @return reportAddress 报案地点
     */
    public String getReportAddress() {
        return reportAddress;
    }

    /**
     * 报案地点
     * @param reportAddress 报案地点
     */
    public void setReportAddress(String reportAddress) {
        this.reportAddress = reportAddress == null ? null : reportAddress.trim();
    }

    /**
     * 查勘属地
     * @return checkAreaCode 查勘属地
     */
    public String getCheckAreaCode() {
        return checkAreaCode;
    }

    /**
     * 查勘属地
     * @param checkAreaCode 查勘属地
     */
    public void setCheckAreaCode(String checkAreaCode) {
        this.checkAreaCode = checkAreaCode == null ? null : checkAreaCode.trim();
    }

    /**
     * 本车责任
     * @return OBLIGATION 本车责任
     */
    public String getObligation() {
        return obligation;
    }

    /**
     * 本车责任
     * @param obligation 本车责任
     */
    public void setObligation(String obligation) {
        this.obligation = obligation == null ? null : obligation.trim();
    }

    /**
     * 损失类别
     * @return lossItemTypes 损失类别
     */
    public String getLossItemTypes() {
        return lossItemTypes;
    }

    /**
     * 损失类别
     * @param lossItemTypes 损失类别
     */
    public void setLossItemTypes(String lossItemTypes) {
        this.lossItemTypes = lossItemTypes == null ? null : lossItemTypes.trim();
    }

    /**
     * 快速处理
     * @return qdCaseType 快速处理
     */
    public String getQdCaseType() {
        return qdCaseType;
    }

    /**
     * 快速处理
     * @param qdCaseType 快速处理
     */
    public void setQdCaseType(String qdCaseType) {
        this.qdCaseType = qdCaseType == null ? null : qdCaseType.trim();
    }
    /**
     * 操作员代码
     * @return operatorCode 操作员代码
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * 操作员代码
     * @param operatorCode 操作员代码
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == operatorCode ? null : operatorCode.trim();
    }

    /**
     * 坐席归属机构代码
     * @return operatorComCode 坐席归属机构代码
     */
    public String getOperatorComCode() {
        return operatorComCode;
    }

    /**
     * 坐席归属机构代码
     * @param operatorComCode 坐席归属机构代码
     */
    public void setOperatorComCode(String operatorComCode) {
        this.operatorComCode = operatorComCode == null ? null : operatorComCode.trim();
    }

    /**
     * 初登人员代码
     * @return firstRegCode 初登人员代码
     */
    public String getFirstRegCode() {
        return firstRegCode;
    }

    /**
     * 初登人员代码
     * @param firstRegCode 初登人员代码
     */
    public void setFirstRegCode(String firstRegCode) {
        this.firstRegCode = firstRegCode == null ? null : firstRegCode.trim();
    }

    /**
     * 初登坐席归属机构代码
     * @return firstRegComCode 初登坐席归属机构代码
     */
    public String getFirstRegComCode() {
        return firstRegComCode;
    }

    /**
     * 初登坐席归属机构代码
     * @param firstRegComCode 初登坐席归属机构代码
     */
    public void setFirstRegComCode(String firstRegComCode) {
        this.firstRegComCode = firstRegComCode == null ? null : firstRegComCode.trim();
    }

    /**
     * 业务操作机构
     * @return makeCom 业务操作机构
     */
    public String getMakeCom() {
        return makeCom;
    }

    /**
     * 业务操作机构
     * @param makeCom 业务操作机构
     */
    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom == null ? null : makeCom.trim();
    }

    /**
     * 计算机输单日期
     * @return inputTime 计算机输单日期
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * 计算机输单日期
     * @param inputTime 计算机输单日期
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * 交强保险责任类型
     * @return ciIndemDuty 交强保险责任类型
     */
    public BigDecimal getCiIndemDuty() {
        return ciIndemDuty;
    }

    /**
     * 交强保险责任类型
     * @param ciIndemDuty 交强保险责任类型
     */
    public void setCiIndemDuty(BigDecimal ciIndemDuty) {
        this.ciIndemDuty = ciIndemDuty;
    }

    /**
     * 是否立案标志
     * @return claimStatus 是否立案标志
     */
    public String getClaimStatus() {
        return claimStatus;
    }

    /**
     * 是否立案标志
     * @param claimStatus 是否立案标志
     */
    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus == null ? null : claimStatus.trim();
    }

    /**
     * 赔案类别
     * @return claimType 赔案类别
     */
    public String getClaimType() {
        return claimType;
    }

    /**
     * 赔案类别
     * @param claimType 赔案类别
     */
    public void setClaimType(String claimType) {
        this.claimType = claimType == null ? null : claimType.trim();
    }

    /**
     * 注销标志
     * @return cancelFlag 注销标志
     */
    public String getCancelFlag() {
        return cancelFlag;
    }

    /**
     * 注销标志
     * @param cancelFlag 注销标志
     */
    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag == null ? null : cancelFlag.trim();
    }

    /**
     * 提交次数
     * @return submitNumber 提交次数
     */
    public Short getSubmitNumber() {
        return submitNumber;
    }

    /**
     * 提交次数
     * @param submitNumber 提交次数
     */
    public void setSubmitNumber(Short submitNumber) {
        this.submitNumber = submitNumber;
    }

    /**
     * 有效标志
     * @return validFlag 有效标志
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * 有效标志
     * @param validFlag 有效标志
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    /**
     * 出险经过
     * @return remark 出险经过
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 出险经过
     * @param remark 出险经过
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 标志字段
     * @return flag 标志字段
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 标志字段
     * @param flag 标志字段
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 报案方式
     * @return registMode 报案方式
     */
    public String getRegistMode() {
        return registMode;
    }

    /**
     * 报案方式
     * @param registMode 报案方式
     */
    public void setRegistMode(String registMode) {
        this.registMode = registMode == null ? null : registMode.trim();
    }

    /**
     * 报损金额
     * @return reportLossFee 报损金额
     */
    public BigDecimal getReportLossFee() {
        return reportLossFee;
    }

    /**
     * 报损金额
     * @param reportLossFee 报损金额
     */
    public void setReportLossFee(BigDecimal reportLossFee) {
        this.reportLossFee = reportLossFee;
    }

    /**
     * 币别代码
     * @return CURRENCY 币别代码
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 币别代码
     * @param currency 币别代码
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * 出险地邮编
     * @return damagePostCode 出险地邮编
     */
    public String getDamagePostCode() {
        return damagePostCode;
    }

    /**
     * 出险地邮编
     * @param damagePostCode 出险地邮编
     */
    public void setDamagePostCode(String damagePostCode) {
        this.damagePostCode = damagePostCode == null ? null : damagePostCode.trim();
    }

    /**
     * 单证号
     * @return certiNo 单证号
     */
    public String getCertiNo() {
        return certiNo;
    }

    /**
     * 单证号
     * @param certiNo 单证号
     */
    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo == null ? null : certiNo.trim();
    }

    /**
     * 受理原因
     * @return acceptReason 受理原因
     */
    public String getAcceptReason() {
        return acceptReason;
    }

    /**
     * 受理原因
     * @param acceptReason 受理原因
     */
    public void setAcceptReason(String acceptReason) {
        this.acceptReason = acceptReason == null ? null : acceptReason.trim();
    }

    /**
     * 案件赔付标识 1:互碰自赔，0：非互碰自赔
     * @return caseFlag 案件赔付标识 1:互碰自赔，0：非互碰自赔
     */
    public String getCaseFlag() {
        return caseFlag;
    }

    /**
     * 案件赔付标识 1:互碰自赔，0：非互碰自赔
     * @param caseFlag 案件赔付标识 1:互碰自赔，0：非互碰自赔
     */
    public void setCaseFlag(String caseFlag) {
        this.caseFlag = caseFlag == null ? null : caseFlag.trim();
    }
    /**
     * 地点
     * @return PLACE 地点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 地点
     * @param place 地点
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * 是否异地出险
     * @return remoteDamageFalg 是否异地出险
     */
    public String getRemoteDamageFalg() {
        return remoteDamageFalg;
    }

    /**
     * 是否异地出险
     * @param remoteDamageFalg 是否异地出险
     */
    public void setRemoteDamageFalg(String remoteDamageFalg) {
        this.remoteDamageFalg = remoteDamageFalg == null ? null : remoteDamageFalg.trim();
    }

    /**
     * 是否现场报案
     * @return sceneRegistFalg 是否现场报案
     */
    public String getSceneRegistFalg() {
        return sceneRegistFalg;
    }

    /**
     * 是否现场报案
     * @param sceneRegistFalg 是否现场报案
     */
    public void setSceneRegistFalg(String sceneRegistFalg) {
        this.sceneRegistFalg = sceneRegistFalg == null ? null : sceneRegistFalg.trim();
    }

    /**
     * 预约查勘地点
     * @return doomCheckPlace 预约查勘地点
     */
    public String getDoomCheckPlace() {
        return doomCheckPlace;
    }

    /**
     * 预约查勘地点
     * @param doomCheckPlace 预约查勘地点
     */
    public void setDoomCheckPlace(String doomCheckPlace) {
        this.doomCheckPlace = doomCheckPlace == null ? null : doomCheckPlace.trim();
    }
    /**
     * 快出快赔
     * @return fastPay 快出快赔
     */
    public String getFastPay() {
        return fastPay;
    }

    /**
     * 快出快赔
     * @param fastPay 快出快赔
     */
    public void setFastPay(String fastPay) {
        this.fastPay = fastPay == null ? null : fastPay.trim();
    }

    /**
     * 被代位标识0不是,1是
     * @return disReplaceRepayFlag 被代位标识0不是,1是
     */
    public String getDisReplaceRepayFlag() {
        return disReplaceRepayFlag;
    }

    /**
     * 被代位标识0不是,1是
     * @param disReplaceRepayFlag 被代位标识0不是,1是
     */
    public void setDisReplaceRepayFlag(String disReplaceRepayFlag) {
        this.disReplaceRepayFlag = disReplaceRepayFlag == null ? null : disReplaceRepayFlag.trim();
    }
    /**
     * 代位标识,0不是,1是
     * @return disReplaceRepayFlag 代位标识,0不是,1是
     */
    public String getReplaceRepayFlag() {
        return replaceRepayFlag;
    }

    /**
     * 代位标识,0不是,1是
     * @param replaceRepayFlag 代位标识,0不是,1是
     */
    public void setReplacerepayflag(String replaceRepayFlag) {
        this.replaceRepayFlag = replaceRepayFlag == null ? null : replaceRepayFlag.trim();
    }

    /**
     * 被保险人电话
     * @return insuredPhoneNumber 被保险人电话
     */
    public String getInsuredPhoneNumber() {
        return insuredPhoneNumber;
    }

    /**
     * 被保险人电话
     * @param insuredPhoneNumber 被保险人电话
     */
    public void setInsuredPhoneNumber(String insuredPhoneNumber) {
        this.insuredPhoneNumber = insuredPhoneNumber == null ? null : insuredPhoneNumber.trim();
    }

    /**
     * 简易案件标识，1表示是简易案件
     * @return simpleCaseFlag 简易案件标识，1表示是简易案件
     */
    public String getSimpleCaseFlag() {
        return simpleCaseFlag;
    }

    /**
     * 简易案件标识，1表示是简易案件
     * @param simpleCaseFlag 简易案件标识，1表示是简易案件
     */
    public void setSimpleCaseFlag(String simpleCaseFlag) {
        this.simpleCaseFlag = simpleCaseFlag == null ? null : simpleCaseFlag.trim();
    }

    /**
     * 事故种类代码
     * @return accidentTypeCode 事故种类代码
     */
    public String getAccidentTypeCode() {
        return accidentTypeCode;
    }

    /**
     * 事故种类代码
     * @param accidentTypeCode 事故种类代码
     */
    public void setAccidentTypeCode(String accidentTypeCode) {
        this.accidentTypeCode = accidentTypeCode == null ? null : accidentTypeCode.trim();
    }

    /**
     * 事故种类名称
     * @return accidentTypeName 事故种类名称
     */
    public String getAccidenttypename() {
        return accidentTypeName;
    }

    /**
     * 事故种类名称
     * @param accidentTypeName 事故种类名称
     */
    public void setAccidenttypename(String accidentTypeName) {
        this.accidentTypeName = accidentTypeName == null ? null : accidentTypeName.trim();
    }

    /**
     * 损失部位
     * @return lossPart 损失部位
     */
    public String getLossPart() {
        return lossPart;
    }

    /**
     * 损失部位
     * @param lossPart 损失部位
     */
    public void setLossPart(String lossPart) {
        this.lossPart = lossPart == null ? null : lossPart.trim();
    }

    /**
     * 自动重案标志
     * @return autoImportantFlag 自动重案标志
     */
    public String getAutoImportantFlag() {
        return autoImportantFlag;
    }

    /**
     * 自动重案标志
     * @param autoImportantFlag 自动重案标志
     */
    public void setAutoImportantFlag(String autoImportantFlag) {
        this.autoImportantFlag = autoImportantFlag == null ? null : autoImportantFlag.trim();
    }

    /**
     * 欺诈标志
     * @return antiFlag 欺诈标志
     */
    public String getAntiFlag() {
        return antiFlag;
    }

    /**
     * 欺诈标志
     * @param antiFlag 欺诈标志
     */
    public void setAntiFlag(String antiFlag) {
        this.antiFlag = antiFlag == null ? null : antiFlag.trim();
    }

    /**
     * 欺诈概率
     * @return antiValue 欺诈概率
     */
    public BigDecimal getAntiValue() {
        return antiValue;
    }

    /**
     * 欺诈概率
     * @param antiValue 欺诈概率
     */
    public void setAntiValue(BigDecimal antiValue) {
        this.antiValue = antiValue;
    }

    /**
     * 出险地点类型
     * @return riskAddrType 出险地点类型
     */
    public String getRiskAddrType() {
        return riskAddrType;
    }

    /**
     * 出险地点类型
     * @param riskAddrType 出险地点类型
     */
    public void setRiskAddrType(String riskAddrType) {
        this.riskAddrType = riskAddrType == null ? null : riskAddrType.trim();
    }

    /**
     * 有无交警事故认定书
     * @return dutyFlag 有无交警事故认定书
     */
    public String getDutyFlag() {
        return dutyFlag;
    }

    /**
     * 有无交警事故认定书
     * @param dutyFlag 有无交警事故认定书
     */
    public void setDutyFlag(String dutyFlag) {
        this.dutyFlag = dutyFlag == null ? null : dutyFlag.trim();
    }

    /**
     * 案件来源标志 快处快赔-01，交警-02
     * @return resourceFlag 案件来源标志 快处快赔-01，交警-02
     */
    public String getResourceFlag() {
        return resourceFlag;
    }

    /**
     * 案件来源标志 快处快赔-01，交警-02
     * @param resourceFlag 案件来源标志 快处快赔-01，交警-02
     */
    public void setResourceFlag(String resourceFlag) {
        this.resourceFlag = resourceFlag == null ? null : resourceFlag.trim();
    }

    /**
     * 快赔系统报案号（河南）
     * @return quickCaseNo 快赔系统报案号（河南）
     */
    public String getQuickCaseNo() {
        return quickCaseNo;
    }

    /**
     * 快赔系统报案号（河南）
     * @param quickCaseNo 快赔系统报案号（河南）
     */
    public void setQuickCaseNo(String quickCaseNo) {
        this.quickCaseNo = quickCaseNo == null ? null : quickCaseNo.trim();
    }

    /**
     * 录音关联标志
     * @return callState 录音关联标志
     */
    public String getCallState() {
        return callState;
    }

    /**
     * 录音关联标志
     * @param callState 录音关联标志
     */
    public void setCallState(String callState) {
        this.callState = callState == null ? null : callState.trim();
    }

    /**
     * 零结标识
     * @return zeroClose 零结标识
     */
    public String getZeroClose() {
        return zeroClose;
    }

    /**
     * 零结标识
     * @param zeroClose 零结标识
     */
    public void setZeroClose(String zeroClose) {
        this.zeroClose = zeroClose == null ? null : zeroClose.trim();
    }

    /**
     * 零结标识原因
     * @return zeroCloseReason 零结标识原因
     */
    public String getZeroCloseReason() {
        return zeroCloseReason;
    }

    /**
     * 零结标识原因
     * @param zeroCloseReason 零结标识原因
     */
    public void setZeroCloseReason(String zeroCloseReason) {
        this.zeroCloseReason = zeroCloseReason == null ? null : zeroCloseReason.trim();
    }

    /**
     * 理赔直通车路径：0,不走直通车；1,直通车1；2,直通车2；-1,本来可以走直通车1,选择没有走;-2,本来可以走直通车2,选择没有走;1-0,刚开始满足直通车1,后来又不满足了;2-0,刚开始满足直通车2,后来又不满足了;2_0,满足直通车二，但是单证收集环节处理人没有审核权限
     * @return claimDirectPath 理赔直通车路径：0,不走直通车；1,直通车1；2,直通车2；-1,本来可以走直通车1,选择没有走;-2,本来可以走直通车2,选择没有走;1-0,刚开始满足直通车1,后来又不满足了;2-0,刚开始满足直通车2,后来又不满足了;2_0,满足直通车二，但是单证收集环节处理人没有审核权限
     */
    public String getClaimDirectPath() {
        return claimDirectPath;
    }

    /**
     * 理赔直通车路径：0,不走直通车；1,直通车1；2,直通车2；-1,本来可以走直通车1,选择没有走;-2,本来可以走直通车2,选择没有走;1-0,刚开始满足直通车1,后来又不满足了;2-0,刚开始满足直通车2,后来又不满足了;2_0,满足直通车二，但是单证收集环节处理人没有审核权限
     * @param claimDirectPath 理赔直通车路径：0,不走直通车；1,直通车1；2,直通车2；-1,本来可以走直通车1,选择没有走;-2,本来可以走直通车2,选择没有走;1-0,刚开始满足直通车1,后来又不满足了;2-0,刚开始满足直通车2,后来又不满足了;2_0,满足直通车二，但是单证收集环节处理人没有审核权限
     */
    public void setClaimDirectPath(String claimDirectPath) {
        this.claimDirectPath = claimDirectPath == null ? null : claimDirectPath.trim();
    }

    /**
     * 是否符合自助理赔条件 1是 0不是
     * @return isSelfSurvey 是否符合自助理赔条件 1是 0不是
     */
    public String getIsSelfSurvey() {
        return isSelfSurvey;
    }

    /**
     * 是否符合自助理赔条件 1是 0不是
     * @param isSelfSurvey 是否符合自助理赔条件 1是 0不是
     */
    public void setIsSelfSurvey(String isSelfSurvey) {
        this.isSelfSurvey = isSelfSurvey == null ? null : isSelfSurvey.trim();
    }

    /**
     * 是否可疑案件,1-是,0-否
     * @return isKeyiCase 是否可疑案件,1-是,0-否
     */
    public String getIsKeyiCase() {
        return isKeyiCase;
    }

    /**
     * 是否可疑案件,1-是,0-否
     * @param isKeyiCase 是否可疑案件,1-是,0-否
     */
    public void setIsKeyiCase(String isKeyiCase) {
        this.isKeyiCase = isKeyiCase == null ? null : isKeyiCase.trim();
    }
    public String getlFlag() {
        return lFlag;
    }

    public void setlFlag(String lFlag) {
        this.lFlag = lFlag;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportorName() {
        return reportorName;
    }

    public String getReportorNumber() {
        return reportorNumber;
    }

    public String getPhoneNmber() {
        return phoneNmber;
    }

    public void setPhoneNmber(String phoneNmber) {
        this.phoneNmber = phoneNmber;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    public void setReplaceRepayFlag(String replaceRepayFlag) {
        this.replaceRepayFlag = replaceRepayFlag;
    }

    public String getAccidentTypeName() {
        return accidentTypeName;
    }

    public void setAccidentTypeName(String accidentTypeName) {
        this.accidentTypeName = accidentTypeName;
    }
}