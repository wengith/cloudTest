package com.chinacoal.ins.proposal.car.pojo;

public class GuPolicyRelatedPartyKey {
    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 关系人序号
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
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    /**
     * 关系人序号
     * @return serialNo 关系人序号
     */
    public Long getSerialNo() {
        return serialNo;
    }

    /**
     * 关系人序号
     * @param serialNo 关系人序号
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }
}