package com.chinacoal.ins.proposal.car.pojo;

public class GuPolicyRiskrelatedpartyKey {
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
     * 序号
     */
    private Long serialNo;

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
        this.policyNo = policyNo;
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
        this.planCode = planCode;
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
        this.riskCode = riskCode;
    }

    /**
     * 序号
     * @return serialNo 序号
     */
    public Long getSerialNo() {
        return serialNo;
    }

    /**
     * 序号
     * @param serialNo 序号
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }
}