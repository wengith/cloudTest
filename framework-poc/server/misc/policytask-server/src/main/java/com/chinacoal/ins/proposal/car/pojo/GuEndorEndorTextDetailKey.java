package com.chinacoal.ins.proposal.car.pojo;

public class GuEndorEndorTextDetailKey {
    /**
     * 批改申请号
     */
    private String endorNo;

    /**
     * 计划代码
     */
    private String planCode;

    /**
     * 险种代码
     */
    private String riskCode;

    /**
     * 块序号
     */
    private Long blockSeriesNo;

    /**
     * 项目序号
     */
    private Long fieldSeriesNo;

    /**
     * 批改申请号
     * @return endorNo 批改申请号
     */
    public String getEndorNo() {
        return endorNo;
    }

    /**
     * 批改申请号
     * @param endorNo 批改申请号
     */
    public void setEndorNo(String endorNo) {
        this.endorNo = endorNo == null ? null : endorNo.trim();
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
     * 块序号
     * @return blockSeriesNo 块序号
     */
    public Long getBlockSeriesNo() {
        return blockSeriesNo;
    }

    /**
     * 块序号
     * @param blockSeriesNo 块序号
     */
    public void setBlockSeriesNo(Long blockSeriesNo) {
        this.blockSeriesNo = blockSeriesNo;
    }

    /**
     * 项目序号
     * @return fieldSeriesNo 项目序号
     */
    public Long getFieldSeriesNo() {
        return fieldSeriesNo;
    }

    /**
     * 项目序号
     * @param fieldSeriesNo 项目序号
     */
    public void setFieldSeriesNo(Long fieldSeriesNo) {
        this.fieldSeriesNo = fieldSeriesNo;
    }
}