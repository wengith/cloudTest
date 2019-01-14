package com.chinacoal.ins.proposal.car.pojo;

public class GuPolicyRiskKey {
    /**
     * 投保单号码
     */
    private String policyNo;

    /**
     * 计划代码
     */
    private String planCode;

    /**
     * 险种代码
     */
    private String riskCode;

    /**
     * 投保单号码
     * @return policyNo 投保单号码
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 投保单号码
     * @param policyNo 投保单号码
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
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
    public void setPlanCode(String planCode) {
        this.planCode = planCode == null ? null : planCode.trim();
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
}