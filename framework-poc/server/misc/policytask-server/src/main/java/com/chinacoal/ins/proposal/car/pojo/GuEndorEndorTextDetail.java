package com.chinacoal.ins.proposal.car.pojo;

public class GuEndorEndorTextDetail extends GuEndorEndorTextDetailKey {
    /**
     * 分单号
     */
    private String subEndorNo;

    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 项目标题描述
     */
    private String fieldName;

    /**
     * 原值
     */
    private String oldValue;

    /**
     * 新值
     */
    private String newValue;

    /**
     * 变化量
     */
    private String changeQuantity;

    /**
     * 是否变化标志 默认1--一般数据变化 2--险种特别约定数据变化  3--条款数据变化
     */
    private String changeInd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 是否打印标志 默认1-打印
     */
    private String printInd;

    public String getSubEndorNo() {
        return subEndorNo;
    }

    public void setSubEndorNo(String subEndorNo) {
        this.subEndorNo = subEndorNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getChangeQuantity() {
        return changeQuantity;
    }

    public void setChangeQuantity(String changeQuantity) {
        this.changeQuantity = changeQuantity;
    }

    public String getChangeInd() {
        return changeInd;
    }

    public void setChangeInd(String changeInd) {
        this.changeInd = changeInd;
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

    public String getPrintInd() {
        return printInd;
    }

    public void setPrintInd(String printInd) {
        this.printInd = printInd;
    }
}