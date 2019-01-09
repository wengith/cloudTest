package com.chinacoal.ins.proposal.car.pojo;

import java.util.Date;

public class GuEndorEndorHead {
    /**
     * 批改申请号
     */
    private String endorNo;

    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 批单印刷号
     */
    private String printNo;

    /**
     * 语种标志
     */
    private String language;

    /**
     * 保单批改次数
     */
    private Long endorseTimes;

    /**
     * 出单机构代码
     */
    private String issueCompany;

    /**
     * 赔款计算书号
     */
    private String compensateNo;

    /**
     * 被保险人代码
     */
    private String insuredCode;

    /**
     * 被保险人姓名
     */
    private String insuredName;

    /**
     * 保单类型
     */
    private String policyType;

    /**
     * 批改类型
     */
    private String endorType;

    /**
     * 批改日期
     */
    private Date endorDate;

    /**
     * 生效日期
     */
    private Date validDate;

    /**
     * 经办人代码
     */
    private String handlerCode;

    /**
     * 归属业务员代码
     */
    private String salesManCode;

    /**
     * 复核人代码
     */
    private String apprOverCode;

    /**
     * 最终核批人代码
     */
    private String underWriteCode;

    /**
     * 最终核批人名称
     */
    private String underWriteName;

    /**
     * 操作员代码/第一次录入人员代码
     */
    private String operatorCode;

    /**
     * 计算机输单日期
     */
    private Date inputDate;

    /**
     * 计算机输单小时
     */
    private Long inputHour;

    /**
     * 业务归属机构代码
     */
    private String companyCode;

    /**
     * 代理人代码
     */
    private String agentCode;

    /**
     * 批单统计年月
     */
    private Date statisTicsYm;

    /**
     * 核批完成日期
     */
    private Date underWriteEndDate;

    /**
     * 核批标志
     */
    private String underWriteInd;

    /**
     * 最后一次修改人员代码
     */
    private String lastModifierCode;

    /**
     * 最后一次修改日期
     */
    private Date lastModifyDate;

    /**
     * 批改标志
     */
    private String endorInd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 有效标志
     */
    private String validInd;

    /**
     * 冲销标志
     */
    private String counteractInd;

    /**
     * 影像标识
     */
    private String imageInd;

    /**
     * 处理状态
     */
    private String handleStatus;

    /**
     * 复核通过日期
     */
    private Date apprOveEndDate;

    /**
     * 处理人代码
     */
    private String dealerCode;

    /**
     * 承保确认时间
     */
    private Date acceptDate;

    /**
     * 附加暂保单号码
     */
    private String attachcOverNoteNo;

    /**
     * 附加暂保单序号
     */
    private Long attachcOverOoteSeqNo;

    /**
     * 见费出单标志 Y－是 N－否
     */
    private String codInd;

    /**
     * 打印帐单标志
     */
    private String accInd;

    /**
     * 恢复批单标志
     */
    private String reCoverEndorInd;

    /**
     * 恢复的批单号
     */
    private String reCoverEndorNo;

    /**
     * 时区
     */
    private String timeZone;

    /**
     * 批改险种
     */
    private String endorRiskCode;

    /**
     * 产品代码
     */
    private String productCode;

    /**
     * 问题件标示 0 表示没有问题件，1表示有问题件
     */
    private String problemInd;

    /**
     * 问题件回销时间
     */
    private Date cancelTime;

    /**
     * 退保原因
     */
    private String surrenderReason;

    /**
     * 拆分账单标志 Y:拆分 N:不拆分
     */
    private String cmbPrintiVcInd;

    /**
     * flowId
     */
    private String flowId;
    /**
     * 交强险生效日期
     */
    private Date validDate2;
    /**
     * 终止责任方式 1 全单终止责任，不退保费 ;  2  全单终止责任，车险、盗抢及其附加险不退保费，其他按未满期退
     */
    private String terminationLiabilityManner;

    public String getEndorNo() {
        return endorNo;
    }

    public void setEndorNo(String endorNo) {
        this.endorNo = endorNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPrintNo() {
        return printNo;
    }

    public void setPrintNo(String printNo) {
        this.printNo = printNo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getEndorseTimes() {
        return endorseTimes;
    }

    public void setEndorseTimes(Long endorseTimes) {
        this.endorseTimes = endorseTimes;
    }

    public String getIssueCompany() {
        return issueCompany;
    }

    public void setIssueCompany(String issueCompany) {
        this.issueCompany = issueCompany;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getEndorType() {
        return endorType;
    }

    public void setEndorType(String endorType) {
        this.endorType = endorType;
    }

    public Date getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(Date endorDate) {
        this.endorDate = endorDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getSalesManCode() {
        return salesManCode;
    }

    public void setSalesManCode(String salesManCode) {
        this.salesManCode = salesManCode;
    }

    public String getApprOverCode() {
        return apprOverCode;
    }

    public void setApprOverCode(String apprOverCode) {
        this.apprOverCode = apprOverCode;
    }

    public String getUnderWriteCode() {
        return underWriteCode;
    }

    public void setUnderWriteCode(String underWriteCode) {
        this.underWriteCode = underWriteCode;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Long getInputHour() {
        return inputHour;
    }

    public void setInputHour(Long inputHour) {
        this.inputHour = inputHour;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Date getStatisTicsYm() {
        return statisTicsYm;
    }

    public void setStatisTicsYm(Date statisTicsYm) {
        this.statisTicsYm = statisTicsYm;
    }

    public Date getUnderWriteEndDate() {
        return underWriteEndDate;
    }

    public void setUnderWriteEndDate(Date underWriteEndDate) {
        this.underWriteEndDate = underWriteEndDate;
    }

    public String getUnderWriteInd() {
        return underWriteInd;
    }

    public void setUnderWriteInd(String underWriteInd) {
        this.underWriteInd = underWriteInd;
    }

    public String getLastModifierCode() {
        return lastModifierCode;
    }

    public void setLastModifierCode(String lastModifierCode) {
        this.lastModifierCode = lastModifierCode;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getEndorInd() {
        return endorInd;
    }

    public void setEndorInd(String endorInd) {
        this.endorInd = endorInd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getValidInd() {
        return validInd;
    }

    public void setValidInd(String validInd) {
        this.validInd = validInd;
    }

    public String getCounteractInd() {
        return counteractInd;
    }

    public void setCounteractInd(String counteractInd) {
        this.counteractInd = counteractInd;
    }

    public String getImageInd() {
        return imageInd;
    }

    public void setImageInd(String imageInd) {
        this.imageInd = imageInd;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Date getApprOveEndDate() {
        return apprOveEndDate;
    }

    public void setApprOveEndDate(Date apprOveEndDate) {
        this.apprOveEndDate = apprOveEndDate;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getAttachcOverNoteNo() {
        return attachcOverNoteNo;
    }

    public void setAttachcOverNoteNo(String attachcOverNoteNo) {
        this.attachcOverNoteNo = attachcOverNoteNo;
    }

    public Long getAttachcOverOoteSeqNo() {
        return attachcOverOoteSeqNo;
    }

    public void setAttachcOverOoteSeqNo(Long attachcOverOoteSeqNo) {
        this.attachcOverOoteSeqNo = attachcOverOoteSeqNo;
    }

    public String getCodInd() {
        return codInd;
    }

    public void setCodInd(String codInd) {
        this.codInd = codInd;
    }

    public String getAccInd() {
        return accInd;
    }

    public void setAccInd(String accInd) {
        this.accInd = accInd;
    }

    public String getReCoverEndorInd() {
        return reCoverEndorInd;
    }

    public void setReCoverEndorInd(String reCoverEndorInd) {
        this.reCoverEndorInd = reCoverEndorInd;
    }

    public String getReCoverEndorNo() {
        return reCoverEndorNo;
    }

    public void setReCoverEndorNo(String reCoverEndorNo) {
        this.reCoverEndorNo = reCoverEndorNo;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getEndorRiskCode() {
        return endorRiskCode;
    }

    public void setEndorRiskCode(String endorRiskCode) {
        this.endorRiskCode = endorRiskCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProblemInd() {
        return problemInd;
    }

    public void setProblemInd(String problemInd) {
        this.problemInd = problemInd;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getSurrenderReason() {
        return surrenderReason;
    }

    public void setSurrenderReason(String surrenderReason) {
        this.surrenderReason = surrenderReason;
    }

    public String getCmbPrintiVcInd() {
        return cmbPrintiVcInd;
    }

    public void setCmbPrintiVcInd(String cmbPrintiVcInd) {
        this.cmbPrintiVcInd = cmbPrintiVcInd;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public Date getValidDate2() {
        return validDate2;
    }

    public void setValidDate2(Date validDate2) {
        this.validDate2 = validDate2;
    }

    public String getTerminationLiabilityManner() {
        return terminationLiabilityManner;
    }

    public void setTerminationLiabilityManner(String terminationLiabilityManner) {
        this.terminationLiabilityManner = terminationLiabilityManner;
    }
}