package com.chinacoal.ins.proposal.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PrplClaim {
    /**
     * 立案号
     */
    private String claimNo;
    /**
     * 险种代码
     */
    private String riskCode;
    /**
     * 报案号
     */
    private String registNo;
    /**
     * 保单号码
     */
    private String policyNo;
    /**
     * 出险日期起
     */
    private Date damageStartDate;
    /**
     * 总赔付金额
     */
    private BigDecimal sumPaid;

    /**
     * 结案日期
     */
    private Date endCaseDate;
    /**
     * 立案日期
     */
    private Date claimDate;

    /**
     * 结案号
     */
    private String caseNo;
    /**
     * 总估损金额
     */
    private BigDecimal sumClaim;
    /** 有效标志 1-有效 0-无效*/
    private String validFlag;

    private String comCode;

    /**操作员代码*/
    private String operatorCode;
    /**资料收集齐全标志（1：收集齐全）*/
    private String docAllSelectFlag;

    /**被保人名称*/
    private String insuredName;

    /**
     * 立案号
     * @return claimNo 立案号
     */
    public String getClaimNo() {
        return claimNo;
    }
    /**
     * 立案号
     * @param claimNo 立案号
     */
    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo == null ? null : claimNo.trim();
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
     * 出险日期起
     * @return damageStartDate 出险日期起
     */
    public Date getDamageStartDate() {
        return damageStartDate;
    }

    /**
     * 出险日期起
     * @param damageStartDate 出险日期起
     */
    public void setDamageStartDate(Date damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public BigDecimal getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(BigDecimal sumPaid) {
        this.sumPaid = sumPaid;
    }

    public Date getEndCaseDate() {
        return endCaseDate;
    }

    public void setEndCaseDate(Date endCaseDate) {
        this.endCaseDate = endCaseDate;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public BigDecimal getSumClaim() {
        return sumClaim;
    }

    public void setSumClaim(BigDecimal sumClaim) {
        this.sumClaim = sumClaim;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getDocAllSelectFlag() {
        return docAllSelectFlag;
    }

    public void setDocAllSelectFlag(String docAllSelectFlag) {
        this.docAllSelectFlag = docAllSelectFlag;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
}