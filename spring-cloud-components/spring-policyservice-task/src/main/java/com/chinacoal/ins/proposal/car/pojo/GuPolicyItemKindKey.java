package com.chinacoal.ins.proposal.car.pojo;

public class GuPolicyItemKindKey {
    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 险种代码
     */
    private String riskCode;

    /**
     * 计划代码
     */
    private String planCode;

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
     * @return riskCode ?险种代码
     */
    public String getRiskcode() {
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
     * 计划代码
     * @return planCode 计划代码
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * 计划代码
     * @param planCode 计划代码
     */
    public void setPlancode(String planCode) {
        this.planCode = planCode == null ? null : planCode.trim();
    }
}