package com.chinacoal.ins.proposal.car.pojo;

import java.math.BigDecimal;

public class GuPolicyRiskProfit extends GuPolicyRiskProfitKey {
    /**
     * 优惠系数类型
     */
    private String profittype;

    /**
     * 优惠系数名称
     */
    private String profitname;

    /**
     * 优惠系数细项代码
     */
    private String subprofitcode;

    /**
     * 优惠系数细项名称
     */
    private String subprofitname;

    /**
     * 优惠折扣
     */
    private BigDecimal rate;

    /**
     * 最低优惠折扣
     */
    private BigDecimal lowerrate;

    /**
     * 最高优惠折扣
     */
    private BigDecimal upperrate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标志字
     */
    private String flag;

    /**
     * 分单号
     */
    private String subpolicyno;

    /**
     * 原始折扣
     */
    private BigDecimal orirate;

    public String getProfittype() {
        return profittype;
    }

    public void setProfittype(String profittype) {
        this.profittype = profittype;
    }

    public String getProfitname() {
        return profitname;
    }

    public void setProfitname(String profitname) {
        this.profitname = profitname;
    }

    public String getSubprofitcode() {
        return subprofitcode;
    }

    public void setSubprofitcode(String subprofitcode) {
        this.subprofitcode = subprofitcode;
    }

    public String getSubprofitname() {
        return subprofitname;
    }

    public void setSubprofitname(String subprofitname) {
        this.subprofitname = subprofitname;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getLowerrate() {
        return lowerrate;
    }

    public void setLowerrate(BigDecimal lowerrate) {
        this.lowerrate = lowerrate;
    }

    public BigDecimal getUpperrate() {
        return upperrate;
    }

    public void setUpperrate(BigDecimal upperrate) {
        this.upperrate = upperrate;
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

    public String getSubpolicyno() {
        return subpolicyno;
    }

    public void setSubpolicyno(String subpolicyno) {
        this.subpolicyno = subpolicyno;
    }

    public BigDecimal getOrirate() {
        return orirate;
    }

    public void setOrirate(BigDecimal orirate) {
        this.orirate = orirate;
    }
}