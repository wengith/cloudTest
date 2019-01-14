package com.chinacoal.ins.claim.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PrpLbpmMain {
    /**
     * Id
     */
    private BigDecimal id;

    /**
     * processId
     */
    private BigDecimal processId;

    /**
     * 业务ID
     */
    private BigDecimal taskId;

    /**
     * businessNo
     */
    private String businessNo;

    /**
     * 节点ID
     */
    private Integer nodeId;

    /**
     * businessNodeId
     */
    private BigDecimal businessNodeId;

    private String inKey;

    /**
     * 流入时间
     */
    private Date inDate;

    /**
     * 节点状态
     */
    private String state;
    /**
     * 险别代码
     */
    private String riskCode;
    private String comCode;
    private String handlerRole;
    private String userCode;
    private String handlerUser;
    private BigDecimal prepNodeId;
    private BigDecimal prepTaskId;
    private String prepComCode;
    private String prepUser;
    private Date pendingDate;
    private Date outDate;
    private Date acceptDate;
    private String acceptFlag;
    private BigDecimal businessId;
    private String businessTable;
    private String flag;
    private String valid;
    private BigDecimal moveId;
    private String caseTag;
    private BigDecimal transactNodeId;
    private String cancelState;
    private Date cancelDate;
    private Date resumeDate;
    private String cancelUser;
    private String autoTaskFlag;
    private String businessType;
    private String makeCom;
    private String mainNo;
    private String systemCode;
    private String getTaskFlag;
    private String sumLossFee;
    private String inUseFlag;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getProcessId() {
        return processId;
    }

    public void setProcessId(BigDecimal processId) {
        this.processId = processId;
    }

    public BigDecimal getTaskId() {
        return taskId;
    }

    public void setTaskId(BigDecimal taskId) {
        this.taskId = taskId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public BigDecimal getBusinessNodeId() {
        return businessNodeId;
    }

    public void setBusinessNodeId(BigDecimal businessNodeId) {
        this.businessNodeId = businessNodeId;
    }

    public String getInKey() {
        return inKey;
    }

    public void setInKey(String inKey) {
        this.inKey = inKey;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getHandlerRole() {
        return handlerRole;
    }

    public void setHandlerRole(String handlerRole) {
        this.handlerRole = handlerRole;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getHandlerUser() {
        return handlerUser;
    }

    public void setHandlerUser(String handlerUser) {
        this.handlerUser = handlerUser;
    }

    public BigDecimal getPrepNodeId() {
        return prepNodeId;
    }

    public void setPrepNodeId(BigDecimal prepNodeId) {
        this.prepNodeId = prepNodeId;
    }

    public BigDecimal getPrepTaskId() {
        return prepTaskId;
    }

    public void setPrepTaskId(BigDecimal prepTaskId) {
        this.prepTaskId = prepTaskId;
    }

    public String getPrepComCode() {
        return prepComCode;
    }

    public void setPrepComCode(String prepComCode) {
        this.prepComCode = prepComCode;
    }

    public String getPrepUser() {
        return prepUser;
    }

    public void setPrepUser(String prepUser) {
        this.prepUser = prepUser;
    }

    public Date getPendingDate() {
        return pendingDate;
    }

    public void setPendingDate(Date pendingDate) {
        this.pendingDate = pendingDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getAcceptFlag() {
        return acceptFlag;
    }

    public void setAcceptFlag(String acceptFlag) {
        this.acceptFlag = acceptFlag;
    }

    public BigDecimal getBusinessId() {
        return businessId;
    }

    public void setBusinessId(BigDecimal businessId) {
        this.businessId = businessId;
    }

    public String getBusinessTable() {
        return businessTable;
    }

    public void setBusinessTable(String businessTable) {
        this.businessTable = businessTable;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public BigDecimal getMoveId() {
        return moveId;
    }

    public void setMoveId(BigDecimal moveId) {
        this.moveId = moveId;
    }

    public String getCaseTag() {
        return caseTag;
    }

    public void setCaseTag(String caseTag) {
        this.caseTag = caseTag;
    }

    public BigDecimal getTransactNodeId() {
        return transactNodeId;
    }

    public void setTransactNodeId(BigDecimal transactNodeId) {
        this.transactNodeId = transactNodeId;
    }

    public String getCancelState() {
        return cancelState;
    }

    public void setCancelState(String cancelState) {
        this.cancelState = cancelState;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getResumeDate() {
        return resumeDate;
    }

    public void setResumeDate(Date resumeDate) {
        this.resumeDate = resumeDate;
    }

    public String getCancelUser() {
        return cancelUser;
    }

    public void setCancelUser(String cancelUser) {
        this.cancelUser = cancelUser;
    }

    public String getAutoTaskFlag() {
        return autoTaskFlag;
    }

    public void setAutoTaskFlag(String autoTaskFlag) {
        this.autoTaskFlag = autoTaskFlag;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getMainNo() {
        return mainNo;
    }

    public void setMainNo(String mainNo) {
        this.mainNo = mainNo;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getGetTaskFlag() {
        return getTaskFlag;
    }

    public void setGetTaskFlag(String getTaskFlag) {
        this.getTaskFlag = getTaskFlag;
    }

    public String getSumLossFee() {
        return sumLossFee;
    }

    public void setSumLossFee(String sumLossFee) {
        this.sumLossFee = sumLossFee;
    }

    public String getInUseFlag() {
        return inUseFlag;
    }

    public void setInUseFlag(String inUseFlag) {
        this.inUseFlag = inUseFlag;
    }
}