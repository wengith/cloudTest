package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PrplDocCollectGuide {
    /**
     * Id
     */
    private BigDecimal id;

    /**
     * 报案号码
     */
    private String registNo;

    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 险种代码
     */
    private String riskCode;

    /**
     * 损失项目类型
     */
    private String docItemType;

    /**
     * 损失项目Id
     */
    private BigDecimal lossItemId;

    /**
     * 单证代码
     */
    private String docCode;

    /**
     * 单证名称
     */
    private String docName;

    /**
     * 单证大类类型
     */
    private String parentTypeCode;

    /**
     * 单证份数
     */
    private String picCount;

    /**
     * 单证开始收集日期
     */
    private Date startDate;

    /**
     * 单证结束收集日期
     */
    private Date endDate;

    /**
     * 是否已上传单证
     */
    private String provideInd;

    /**
     * 收集标志
     */
    private String collectInd;

    /**
     * 调整收集标志操作员
     */
    private String operatorCode;

    /**
     * 调整收集标志日期
     */
    private Date operateDate;

    /**
     * 扩充字段内容
     */
    private String columnValue;

    /**
     * 业务归属机构
     */
    private String comCode;

    /**
     * 理赔处理机构
     */
    private String makeCom;

    /**
     * 有效标志
     */
    private String validFlag;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 组合保险类型
     */
    private String mixType;

    /**
     * 1-人伤单证,2-车损单证,3-物损单证
     */
    private String docType;

    /**
     * Id
     * @return ID Id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Id
     * @param id Id
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * 报案号码
     * @return registNo 报案号码
     */
    public String getRegistNo() {
        return registNo;
    }

    /**
     * 报案号码
     * @param registNo 报案号码
     */
    public void setRegistNo(String registNo) {
        this.registNo = registNo == null ? null : registNo.trim();
    }

    /**
     * 保单号码
     * @return policyNo 保单号码
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 保单号码
     * @param policyNo 保单号码
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    /**
     * 险种代码
     * @return riskCode 险种代码
     */
    public String getRiskCode() {
        return riskCode;
    }

    /**
     * 险种代码
     * @param riskCode 险种代码
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode == null ? null : riskCode.trim();
    }

    /**
     * 损失项目类型
     * @return docItemType 损失项目类型
     */
    public String getDocItemType() {
        return docItemType;
    }

    /**
     * 损失项目类型
     * @param docItemType 损失项目类型
     */
    public void setDocItemType(String docItemType) {
        this.docItemType = docItemType == null ? null : docItemType.trim();
    }

    /**
     * 损失项目Id
     * @return lossItemId 损失项目Id
     */
    public BigDecimal getLossItemId() {
        return lossItemId;
    }

    /**
     * 损失项目Id
     * @param lossItemId 损失项目Id
     */
    public void setLossItemId(BigDecimal lossItemId) {
        this.lossItemId = lossItemId;
    }

    /**
     * 单证代码
     * @return docCode 单证代码
     */
    public String getDocCode() {
        return docCode;
    }

    /**
     * 单证代码
     * @param docCode 单证代码
     */
    public void setDocCode(String docCode) {
        this.docCode = docCode == null ? null : docCode.trim();
    }

    /**
     * 单证名称
     * @return docName 单证名称
     */
    public String getDocName() {
        return docName;
    }

    /**
     * 单证名称
     * @param docName 单证名称
     */
    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    /**
     * 单证大类类型
     * @return parentTypeCode 单证大类类型
     */
    public String getParentTypeCode() {
        return parentTypeCode;
    }

    /**
     * 单证大类类型
     * @param parentTypeCode 单证大类类型
     */
    public void setParentTypeCode(String parentTypeCode) {
        this.parentTypeCode = parentTypeCode == null ? null : parentTypeCode.trim();
    }

    /**
     * 单证份数
     * @return picCount 单证份数
     */
    public String getPicCount() {
        return picCount;
    }

    /**
     * 单证份数
     * @param picCount 单证份数
     */
    public void setPicCount(String picCount) {
        this.picCount = picCount == null ? null : picCount.trim();
    }

    /**
     * 单证开始收集日期
     * @return startDate 单证开始收集日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 单证开始收集日期
     * @param startDate 单证开始收集日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 单证结束收集日期
     * @return endDate 单证结束收集日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 单证结束收集日期
     * @param endDate 单证结束收集日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 是否已上传单证
     * @return provideInd 是否已上传单证
     */
    public String getProvideInd() {
        return provideInd;
    }

    /**
     * 是否已上传单证
     * @param provideInd 是否已上传单证
     */
    public void setProvideInd(String provideInd) {
        this.provideInd = provideInd == null ? null : provideInd.trim();
    }

    /**
     * 收集标志
     * @return collectInd 收集标志
     */
    public String getCollectInd() {
        return collectInd;
    }

    /**
     * 收集标志
     * @param collectInd 收集标志
     */
    public void setCollectInd(String collectInd) {
        this.collectInd = collectInd == null ? null : collectInd.trim();
    }

    /**
     * 调整收集标志操作员
     * @return operatorCode 调整收集标志操作员
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * 调整收集标志操作员
     * @param operatorCode 调整收集标志操作员
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }

    /**
     * 调整收集标志日期
     * @return operateDate 调整收集标志日期
     */
    public Date getOperateDate() {
        return operateDate;
    }

    /**
     * 调整收集标志日期
     * @param operateDate 调整收集标志日期
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * 扩充字段内容
     * @return columnValue 扩充字段内容
     */
    public String getColumnValue() {
        return columnValue;
    }

    /**
     * 扩充字段内容
     * @param columnValue 扩充字段内容
     */
    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue == null ? null : columnValue.trim();
    }

    /**
     * 业务归属机构
     * @return comCode 业务归属机构
     */
    public String getComCode() {
        return comCode;
    }

    /**
     * 业务归属机构
     * @param comCode 业务归属机构
     */
    public void setComCode(String comCode) {
        this.comCode = comCode == null ? null : comCode.trim();
    }

    /**
     * 理赔处理机构
     * @return makeCom 理赔处理机构
     */
    public String getMakeCom() {
        return makeCom;
    }

    /**
     * 理赔处理机构
     * @param makeCom 理赔处理机构
     */
    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom == null ? null : makeCom.trim();
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
     * 标志字段
     * @return FLAG 标志字段
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
     * 备注
     * @return REMARK 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 组合保险类型
     * @return mixType 组合保险类型
     */
    public String getMixType() {
        return mixType;
    }

    /**
     * 组合保险类型
     * @param mixType 组合保险类型
     */
    public void setMixType(String mixType) {
        this.mixType = mixType == null ? null : mixType.trim();
    }

    /**
     * 1-人伤单证,2-车损单证,3-物损单证
     * @return docType 1-人伤单证,2-车损单证,3-物损单证
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 1-人伤单证,2-车损单证,3-物损单证
     * @param docType 1-人伤单证,2-车损单证,3-物损单证
     */
    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }
}