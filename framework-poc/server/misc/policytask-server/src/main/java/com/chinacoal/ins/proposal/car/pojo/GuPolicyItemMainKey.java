package com.chinacoal.ins.proposal.car.pojo;

public class GuPolicyItemMainKey {
    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 标的序号
     */
    private Long itemNo;

    /**
     * 计划代码
     */
    private String planCode;

    /**
     * 险种代码
     */
    private String riskCode;

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
     * 标的序号
     * @return itemNo 标的序号
     */
    public Long getItemNo() {
        return itemNo;
    }

    /**
     * 标的序号
     * @param itemNo 标的序号
     */
    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
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