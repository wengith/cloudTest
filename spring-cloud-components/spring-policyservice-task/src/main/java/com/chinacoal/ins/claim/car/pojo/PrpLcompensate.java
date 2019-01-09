package com.chinacoal.ins.claim.car.pojo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PrpLcompensate {

    /**��ǿ׷�����*/
    private BigDecimal bzReplacePaid;
    /**��ҵ׷�����*/
    private BigDecimal replacePaid;
    /**��׷�����*/
    private BigDecimal sumReplacePaid;
    /**�������⸶���*/
    private BigDecimal sumrealPayPaid;
    /**��λ��ʶ*/
    private String replaceFlag;
    /**����λ��ʶ*/
    private String disReplaceFlag;
    /**�Ը����*/
    private BigDecimal sumRealSelfPaid;
    /** ʣ����Ҫ׷�����*/
    private BigDecimal remainReplacePaid;
    /** ׷������*/
    private String replevyReason;

    /**׷�����*/
    private String replevyFee;

    /** ��������� */
    private String compensateNo;

    /** ��������� */
    private String mainCompensateNo;

    /** ҵ������ID���� */
    private Long businessId;

    /** �������� */
    private String lflag;

    /** ���������� */
    private String compensateType;

    /** �ⰸ�� */
    private String caseNo;

    /** ���� */
    private Integer times;

    /** ������� */
    private String classCode;

    /** ���ִ��� */
    private String riskCode;

    /** ������ */
    private String claimNo;

    /** �������� */
    private String registNo;

    /** ������ */
    private String policyNo;

    /** �ͻ��ȼ� */
    private String customLevel;

    /** ���������̶� */
    private String mercyFlag;

    /** ���������ֶ� */
    private String deductCond;

    /** �յ����� */
    private Date preserveDate;

    /** ��������˴��� */
    private String checkAgentCode;

    /** ������������� */
    private String checkAgentName;

    /** ���������� */
    private String surveyorName;

    /** ���������� */
    private String counterClaimerName;

    /** �������� */
    private String dutyDescription;

    /** �ұ� */
    private String currency;

    /** ��ҵ�����δ��� */
    private String indemnityDuty;

    /** ��ҵ�����α��� */
    private BigDecimal indemnityDutyRate;

    /** �����ʧ��� */
    private BigDecimal sumLoss;

    /** ��ֵ */
    private BigDecimal sumRest;

    /** �����������ܼ� */
    private BigDecimal sumNoDeductFee;

    /** �������ϼ� */
    private BigDecimal sumDutyPaid;

    /** ���������ķ��ý�� */
    private BigDecimal sumNoDutyFee;

    /** �⸶��� */
    private BigDecimal sumPaid;

    /** ��Ԥ����� */
    private BigDecimal sumPrePaid;

    /** �����⸶��� */
    private BigDecimal sumThisPaid;

    private BigDecimal sumBzPaid;

    /** Э���� */
    private BigDecimal exgratiaFee;

    /** Э�鱸ע */
    private String exgratiaRemark;

    /** ����λ/������/������ */
    private String receiverName;

    /** �������� */
    private String bank;

    /** �ʺ� */
    private String account;

    /** ��ǿ�����㹫ʽ���� */
    private String bzExpCode;

    /** �Ƿ����ϰ��� */
    private String isSuitFlag;

    /** ע��/���⣨�ָ������봦����� */
    private String makeCom;

    /** �������� */
    private String comCode;

    /** �����˴��� */
    private String handlerCode;

    /** ����ҵ��Ա���� */
    private String handler1Code;

    /** �ձ���㹫ʽ */
    private String compensateExp;

    /** �ձ���㹫ʽ */
    private String compensateKindExp;

    /** ���㱨�� */
    private String lctext;

    /** ȷ���˴��� */
    private String approverCode;

    /** ���պ˱��˴��� */
    private String underwriteCode;

    /** ���պ˱������� */
    private String underwriteName;

    /** ͳ������ */
    private Date statisticsYm;

    /** ����Ա���� */
    private String operatorCode;

    /** ����Ա���� */
    private String operatorName;

    /** ����޸��˴��� */
    private String lastModifyCode;

    /** �����޸������� */
    private String lastModifyName;

    /** ����޸�ʱ�� */
    private Date lastModifyTime;

    /** ¼������ */
    private Date inputTime;

    /** ����������� */
    private Date underwriteEndDate;

    /** �����־ */
    private String underWriteFlag;

    /** �ⰸ��� */
    private String claimType;

    /** ��ע */
    private String remark;

    /** ��־�ֶ� */
    private String flag;

    /** �Ƿ���Ҫ׷�� */
    private String replevyFlag;

    /** �Ƿ��ռ����� */
    private String endCompensateFlag;

    /** �Ƿ�ͨ�� 0:��1���� */
    private String exgratiaFlag;

    /** �ܱ��ռ�ֵ */
    private BigDecimal sumValue;

    /** �Ƿ�����ɽ�����ֱ�־0��,1�� */
    private String chgCurrency1Flag;

    /** �Ƿ�ת�������� 0��,1�� */
    private String regularFlowFlag;

    /** ���鰸������ʽ:0:�Դ���1:��Ƹ���� */
    private String lawsuitMode;

    /** ���鰸����������:0:����1:�ٲ�2:����3:���� */
    private String lawsuitType;

    /**���ⰸ����ʶ 0����  1����*/
    private String caseFlag;

    /** ֧���ұ� */
    private String currency1;

    /** ֧���ұ����⸶��� */
    private BigDecimal sumPaid1;

    /** ��������⸶��� */
    private BigDecimal sumPaid3;

    /** ֧���ұ𱾴��⸶��� */
    private BigDecimal sumThisPaid1;

    /** ����ұ����⸶��� */
    private BigDecimal sumThisPaid3;

    /**�����ʶ 0������  1������*/
    private String compensateFlag;

    /**�����־ 0������ 1������*/
    private String exceptionFlag;

    /** ����ԭ�� */
    private String exceptionReason;

    /** ��������ԭ�� add by limiao 20110114 */
    private String exceptionReasonText;

    /** ȫ���־ */
    private String totalLossFlag;

    /** ��Ʊ�� */
    private String invoiceNo;
    /**��Ʊ����*/
    private String invoiceType;

    private String assessorPayFlag;

    private String agricultureFlag;

    private String multiFlag;

    /** �Ƿ���թ  1��  0����*/
    private String isFraud;

    /** ��թ��־*/
    private String fraudFlag;

    /** ��թ��־����*/
    private String fraudName;

    /** ��թ�����ʧ���*/
    private BigDecimal fraudRecoverAmount;

    /** ��թ��־*/
    private String fraudType;

    /**ͨ�ñ�ʶλ 0Ϊ��ϱ��ղƲ������ʶ��1Ϊ��ϱ������������ʶ add by limiao 20101215 start */
    private String othFlag;
    /**�Ƿ����ϱ�ʶ     0����1����*/
    private String lawsuitFlag;

    /**
     * �Ƿ��˹��޸ģ����α����� 0����1����
     */
    private String isPersonChange;

    /**
     * ��׼���α���
     */
    private BigDecimal indemnityDutyRateBac;

    private String trinity;

    /**֧���޸���������*/
    private String auditorCode;

    private String otherReplevyReason;

    /**
     * �Ƿ���ɰ�����1-��
     */
    private String isKeyiCase;
    /**
     * ���ɰ����Ĵ���Ͷ�Ӧԭ��
     */
    private String keyiCaseCode;
    private String keyiCaseReason;
    /**
     * ���ɽ��״���ʱ��
     */
    private Date keyiCaseTime;

    /** ��������ģ�飬ȱ����ص�֤����*/
    private BigDecimal deductCondTimes;

    public BigDecimal getBzReplacePaid() {
        return bzReplacePaid;
    }

    public void setBzReplacePaid(BigDecimal bzReplacePaid) {
        this.bzReplacePaid = bzReplacePaid;
    }

    public BigDecimal getReplacePaid() {
        return replacePaid;
    }

    public void setReplacePaid(BigDecimal replacePaid) {
        this.replacePaid = replacePaid;
    }

    public BigDecimal getSumReplacePaid() {
        return sumReplacePaid;
    }

    public void setSumReplacePaid(BigDecimal sumReplacePaid) {
        this.sumReplacePaid = sumReplacePaid;
    }

    public BigDecimal getSumrealPayPaid() {
        return sumrealPayPaid;
    }

    public void setSumrealPayPaid(BigDecimal sumrealPayPaid) {
        this.sumrealPayPaid = sumrealPayPaid;
    }

    public String getReplaceFlag() {
        return replaceFlag;
    }

    public void setReplaceFlag(String replaceFlag) {
        this.replaceFlag = replaceFlag;
    }

    public String getDisReplaceFlag() {
        return disReplaceFlag;
    }

    public void setDisReplaceFlag(String disReplaceFlag) {
        this.disReplaceFlag = disReplaceFlag;
    }

    public BigDecimal getSumRealSelfPaid() {
        return sumRealSelfPaid;
    }

    public void setSumRealSelfPaid(BigDecimal sumRealSelfPaid) {
        this.sumRealSelfPaid = sumRealSelfPaid;
    }

    public BigDecimal getRemainReplacePaid() {
        return remainReplacePaid;
    }

    public void setRemainReplacePaid(BigDecimal remainReplacePaid) {
        this.remainReplacePaid = remainReplacePaid;
    }

    public String getReplevyReason() {
        return replevyReason;
    }

    public void setReplevyReason(String replevyReason) {
        this.replevyReason = replevyReason;
    }

    public String getReplevyFee() {
        return replevyFee;
    }

    public void setReplevyFee(String replevyFee) {
        this.replevyFee = replevyFee;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getMainCompensateNo() {
        return mainCompensateNo;
    }

    public void setMainCompensateNo(String mainCompensateNo) {
        this.mainCompensateNo = mainCompensateNo;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getLflag() {
        return lflag;
    }

    public void setLflag(String lflag) {
        this.lflag = lflag;
    }

    public String getCompensateType() {
        return compensateType;
    }

    public void setCompensateType(String compensateType) {
        this.compensateType = compensateType;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getCustomLevel() {
        return customLevel;
    }

    public void setCustomLevel(String customLevel) {
        this.customLevel = customLevel;
    }

    public String getMercyFlag() {
        return mercyFlag;
    }

    public void setMercyFlag(String mercyFlag) {
        this.mercyFlag = mercyFlag;
    }

    public String getDeductCond() {
        return deductCond;
    }

    public void setDeductCond(String deductCond) {
        this.deductCond = deductCond;
    }

    public Date getPreserveDate() {
        return preserveDate;
    }

    public void setPreserveDate(Date preserveDate) {
        this.preserveDate = preserveDate;
    }

    public String getCheckAgentCode() {
        return checkAgentCode;
    }

    public void setCheckAgentCode(String checkAgentCode) {
        this.checkAgentCode = checkAgentCode;
    }

    public String getCheckAgentName() {
        return checkAgentName;
    }

    public void setCheckAgentName(String checkAgentName) {
        this.checkAgentName = checkAgentName;
    }

    public String getSurveyorName() {
        return surveyorName;
    }

    public void setSurveyorName(String surveyorName) {
        this.surveyorName = surveyorName;
    }

    public String getCounterClaimerName() {
        return counterClaimerName;
    }

    public void setCounterClaimerName(String counterClaimerName) {
        this.counterClaimerName = counterClaimerName;
    }

    public String getDutyDescription() {
        return dutyDescription;
    }

    public void setDutyDescription(String dutyDescription) {
        this.dutyDescription = dutyDescription;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIndemnityDuty() {
        return indemnityDuty;
    }

    public void setIndemnityDuty(String indemnityDuty) {
        this.indemnityDuty = indemnityDuty;
    }

    public BigDecimal getIndemnityDutyRate() {
        return indemnityDutyRate;
    }

    public void setIndemnityDutyRate(BigDecimal indemnityDutyRate) {
        this.indemnityDutyRate = indemnityDutyRate;
    }

    public BigDecimal getSumLoss() {
        return sumLoss;
    }

    public void setSumLoss(BigDecimal sumLoss) {
        this.sumLoss = sumLoss;
    }

    public BigDecimal getSumRest() {
        return sumRest;
    }

    public void setSumRest(BigDecimal sumRest) {
        this.sumRest = sumRest;
    }

    public BigDecimal getSumNoDeductFee() {
        return sumNoDeductFee;
    }

    public void setSumNoDeductFee(BigDecimal sumNoDeductFee) {
        this.sumNoDeductFee = sumNoDeductFee;
    }

    public BigDecimal getSumDutyPaid() {
        return sumDutyPaid;
    }

    public void setSumDutyPaid(BigDecimal sumDutyPaid) {
        this.sumDutyPaid = sumDutyPaid;
    }

    public BigDecimal getSumNoDutyFee() {
        return sumNoDutyFee;
    }

    public void setSumNoDutyFee(BigDecimal sumNoDutyFee) {
        this.sumNoDutyFee = sumNoDutyFee;
    }

    public BigDecimal getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(BigDecimal sumPaid) {
        this.sumPaid = sumPaid;
    }

    public BigDecimal getSumPrePaid() {
        return sumPrePaid;
    }

    public void setSumPrePaid(BigDecimal sumPrePaid) {
        this.sumPrePaid = sumPrePaid;
    }

    public BigDecimal getSumThisPaid() {
        return sumThisPaid;
    }

    public void setSumThisPaid(BigDecimal sumThisPaid) {
        this.sumThisPaid = sumThisPaid;
    }

    public BigDecimal getSumBzPaid() {
        return sumBzPaid;
    }

    public void setSumBzPaid(BigDecimal sumBzPaid) {
        this.sumBzPaid = sumBzPaid;
    }

    public BigDecimal getExgratiaFee() {
        return exgratiaFee;
    }

    public void setExgratiaFee(BigDecimal exgratiaFee) {
        this.exgratiaFee = exgratiaFee;
    }

    public String getExgratiaRemark() {
        return exgratiaRemark;
    }

    public void setExgratiaRemark(String exgratiaRemark) {
        this.exgratiaRemark = exgratiaRemark;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBzExpCode() {
        return bzExpCode;
    }

    public void setBzExpCode(String bzExpCode) {
        this.bzExpCode = bzExpCode;
    }

    public String getIsSuitFlag() {
        return isSuitFlag;
    }

    public void setIsSuitFlag(String isSuitFlag) {
        this.isSuitFlag = isSuitFlag;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getCompensateExp() {
        return compensateExp;
    }

    public void setCompensateExp(String compensateExp) {
        this.compensateExp = compensateExp;
    }

    public String getCompensateKindExp() {
        return compensateKindExp;
    }

    public void setCompensateKindExp(String compensateKindExp) {
        this.compensateKindExp = compensateKindExp;
    }

    public String getLctext() {
        return lctext;
    }

    public void setLctext(String lctext) {
        this.lctext = lctext;
    }

    public String getApproverCode() {
        return approverCode;
    }

    public void setApproverCode(String approverCode) {
        this.approverCode = approverCode;
    }

    public String getUnderwriteCode() {
        return underwriteCode;
    }

    public void setUnderwriteCode(String underwriteCode) {
        this.underwriteCode = underwriteCode;
    }

    public String getUnderwriteName() {
        return underwriteName;
    }

    public void setUnderwriteName(String underwriteName) {
        this.underwriteName = underwriteName;
    }

    public Date getStatisticsYm() {
        return statisticsYm;
    }

    public void setStatisticsYm(Date statisticsYm) {
        this.statisticsYm = statisticsYm;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getLastModifyCode() {
        return lastModifyCode;
    }

    public void setLastModifyCode(String lastModifyCode) {
        this.lastModifyCode = lastModifyCode;
    }

    public String getLastModifyName() {
        return lastModifyName;
    }

    public void setLastModifyName(String lastModifyName) {
        this.lastModifyName = lastModifyName;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Date getUnderwriteEndDate() {
        return underwriteEndDate;
    }

    public void setUnderwriteEndDate(Date underwriteEndDate) {
        this.underwriteEndDate = underwriteEndDate;
    }

    public String getUnderWriteFlag() {
        return underWriteFlag;
    }

    public void setUnderWriteFlag(String underWriteFlag) {
        this.underWriteFlag = underWriteFlag;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
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

    public String getReplevyFlag() {
        return replevyFlag;
    }

    public void setReplevyFlag(String replevyFlag) {
        this.replevyFlag = replevyFlag;
    }

    public String getEndCompensateFlag() {
        return endCompensateFlag;
    }

    public void setEndCompensateFlag(String endCompensateFlag) {
        this.endCompensateFlag = endCompensateFlag;
    }

    public String getExgratiaFlag() {
        return exgratiaFlag;
    }

    public void setExgratiaFlag(String exgratiaFlag) {
        this.exgratiaFlag = exgratiaFlag;
    }

    public BigDecimal getSumValue() {
        return sumValue;
    }

    public void setSumValue(BigDecimal sumValue) {
        this.sumValue = sumValue;
    }

    public String getChgCurrency1Flag() {
        return chgCurrency1Flag;
    }

    public void setChgCurrency1Flag(String chgCurrency1Flag) {
        this.chgCurrency1Flag = chgCurrency1Flag;
    }

    public String getRegularFlowFlag() {
        return regularFlowFlag;
    }

    public void setRegularFlowFlag(String regularFlowFlag) {
        this.regularFlowFlag = regularFlowFlag;
    }

    public String getLawsuitMode() {
        return lawsuitMode;
    }

    public void setLawsuitMode(String lawsuitMode) {
        this.lawsuitMode = lawsuitMode;
    }

    public String getLawsuitType() {
        return lawsuitType;
    }

    public void setLawsuitType(String lawsuitType) {
        this.lawsuitType = lawsuitType;
    }

    public String getCaseFlag() {
        return caseFlag;
    }

    public void setCaseFlag(String caseFlag) {
        this.caseFlag = caseFlag;
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public BigDecimal getSumPaid1() {
        return sumPaid1;
    }

    public void setSumPaid1(BigDecimal sumPaid1) {
        this.sumPaid1 = sumPaid1;
    }

    public BigDecimal getSumPaid3() {
        return sumPaid3;
    }

    public void setSumPaid3(BigDecimal sumPaid3) {
        this.sumPaid3 = sumPaid3;
    }

    public BigDecimal getSumThisPaid1() {
        return sumThisPaid1;
    }

    public void setSumThisPaid1(BigDecimal sumThisPaid1) {
        this.sumThisPaid1 = sumThisPaid1;
    }

    public BigDecimal getSumThisPaid3() {
        return sumThisPaid3;
    }

    public void setSumThisPaid3(BigDecimal sumThisPaid3) {
        this.sumThisPaid3 = sumThisPaid3;
    }

    public String getCompensateFlag() {
        return compensateFlag;
    }

    public void setCompensateFlag(String compensateFlag) {
        this.compensateFlag = compensateFlag;
    }

    public String getExceptionFlag() {
        return exceptionFlag;
    }

    public void setExceptionFlag(String exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
    }

    public String getExceptionReason() {
        return exceptionReason;
    }

    public void setExceptionReason(String exceptionReason) {
        this.exceptionReason = exceptionReason;
    }

    public String getExceptionReasonText() {
        return exceptionReasonText;
    }

    public void setExceptionReasonText(String exceptionReasonText) {
        this.exceptionReasonText = exceptionReasonText;
    }

    public String getTotalLossFlag() {
        return totalLossFlag;
    }

    public void setTotalLossFlag(String totalLossFlag) {
        this.totalLossFlag = totalLossFlag;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getAssessorPayFlag() {
        return assessorPayFlag;
    }

    public void setAssessorPayFlag(String assessorPayFlag) {
        this.assessorPayFlag = assessorPayFlag;
    }

    public String getAgricultureFlag() {
        return agricultureFlag;
    }

    public void setAgricultureFlag(String agricultureFlag) {
        this.agricultureFlag = agricultureFlag;
    }

    public String getMultiFlag() {
        return multiFlag;
    }

    public void setMultiFlag(String multiFlag) {
        this.multiFlag = multiFlag;
    }

    public String getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(String isFraud) {
        this.isFraud = isFraud;
    }

    public String getFraudFlag() {
        return fraudFlag;
    }

    public void setFraudFlag(String fraudFlag) {
        this.fraudFlag = fraudFlag;
    }

    public String getFraudName() {
        return fraudName;
    }

    public void setFraudName(String fraudName) {
        this.fraudName = fraudName;
    }

    public BigDecimal getFraudRecoverAmount() {
        return fraudRecoverAmount;
    }

    public void setFraudRecoverAmount(BigDecimal fraudRecoverAmount) {
        this.fraudRecoverAmount = fraudRecoverAmount;
    }

    public String getFraudType() {
        return fraudType;
    }

    public void setFraudType(String fraudType) {
        this.fraudType = fraudType;
    }

    public String getOthFlag() {
        return othFlag;
    }

    public void setOthFlag(String othFlag) {
        this.othFlag = othFlag;
    }

    public String getIsPersonChange() {
        return isPersonChange;
    }

    public void setIsPersonChange(String isPersonChange) {
        this.isPersonChange = isPersonChange;
    }

    public BigDecimal getIndemnityDutyRateBac() {
        return indemnityDutyRateBac;
    }

    public void setIndemnityDutyRateBac(BigDecimal indemnityDutyRateBac) {
        this.indemnityDutyRateBac = indemnityDutyRateBac;
    }

    public String getTrinity() {
        return trinity;
    }

    public void setTrinity(String trinity) {
        this.trinity = trinity;
    }

    public String getAuditorCode() {
        return auditorCode;
    }

    public void setAuditorCode(String auditorCode) {
        this.auditorCode = auditorCode;
    }

    public String getOtherReplevyReason() {
        return otherReplevyReason;
    }

    public void setOtherReplevyReason(String otherReplevyReason) {
        this.otherReplevyReason = otherReplevyReason;
    }

    public String getIsKeyiCase() {
        return isKeyiCase;
    }

    public void setIsKeyiCase(String isKeyiCase) {
        this.isKeyiCase = isKeyiCase;
    }

    public String getKeyiCaseCode() {
        return keyiCaseCode;
    }

    public void setKeyiCaseCode(String keyiCaseCode) {
        this.keyiCaseCode = keyiCaseCode;
    }

    public String getKeyiCaseReason() {
        return keyiCaseReason;
    }

    public void setKeyiCaseReason(String keyiCaseReason) {
        this.keyiCaseReason = keyiCaseReason;
    }

    public Date getKeyiCaseTime() {
        return keyiCaseTime;
    }

    public void setKeyiCaseTime(Date keyiCaseTime) {
        this.keyiCaseTime = keyiCaseTime;
    }

    public BigDecimal getDeductCondTimes() {
        return deductCondTimes;
    }

    public void setDeductCondTimes(BigDecimal deductCondTimes) {
        this.deductCondTimes = deductCondTimes;
    }

    public String getLawsuitFlag() {
        return lawsuitFlag;
    }

    public void setLawsuitFlag(String lawsuitFlag) {
        this.lawsuitFlag = lawsuitFlag;
    }
}