package com.chinacoal.ins.proposal.car.pojo;

public class GuPolicyRiskProfitKey {
    /**
     * 保单号码
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
     * 优惠系数代码
     */
    private String profitCode;

    /**
     * 保单号码
     * @returb policyNo 保单号码
     */
    public String getPolicyno() {
        return policyNo;
    }

    /**
     * 保单号码
     * policyNo 保单号码
     */
    public void setPolicyno(String policyNo) {
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

    /**
     * 优惠系数代码
     * @return profitCode 优惠系数代码
     */
    public String getProfitCode() {
        return profitCode;
    }

    /**
     * 优惠系数代码
     * @param profitCode 优惠系数代码
     */
    public void setProfitCode(String profitCode) {
        this.profitCode = profitCode == null ? null : profitCode.trim();
    }
}