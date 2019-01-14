package com.chinacoal.ins.claim.car.pojo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PrpLcompensate {

    /**交强追偿金额*/
    private BigDecimal bzReplacePaid;
    /**商业追偿金额*/
    private BigDecimal replacePaid;
    /**总追偿金额*/
    private BigDecimal sumReplacePaid;
    /**车损总赔付金额*/
    private BigDecimal sumrealPayPaid;
    /**代位标识*/
    private String replaceFlag;
    /**被代位标识*/
    private String disReplaceFlag;
    /**自付金额*/
    private BigDecimal sumRealSelfPaid;
    /** 剩余需要追偿金额*/
    private BigDecimal remainReplacePaid;
    /** 追偿依据*/
    private String replevyReason;

    /**追偿金额*/
    private String replevyFee;

    /** 赔款计算书号 */
    private String compensateNo;

    /** 主计算书号 */
    private String mainCompensateNo;

    /** 业务数据ID号码 */
    private Long businessId;

    /** 理赔类型 */
    private String lflag;

    /** 计算书类型 */
    private String compensateType;

    /** 赔案号 */
    private String caseNo;

    /** 次数 */
    private Integer times;

    /** 险类代码 */
    private String classCode;

    /** 险种代码 */
    private String riskCode;

    /** 立案号 */
    private String claimNo;

    /** 报案号码 */
    private String registNo;

    /** 保单号 */
    private String policyNo;

    /** 客户等级 */
    private String customLevel;

    /** 案件紧急程度 */
    private String mercyFlag;

    /** 免赔条件字段 */
    private String deductCond;

    /** 终到日期 */
    private Date preserveDate;

    /** 理赔代理人代码 */
    private String checkAgentCode;

    /** 理赔代理人名称 */
    private String checkAgentName;

    /** 检验人名称 */
    private String surveyorName;

    /** 索赔人名称 */
    private String counterClaimerName;

    /** 航方责任 */
    private String dutyDescription;

    /** 币别 */
    private String currency;

    /** 商业险责任代码 */
    private String indemnityDuty;

    /** 商业险责任比例 */
    private BigDecimal indemnityDutyRate;

    /** 标的损失金额 */
    private BigDecimal sumLoss;

    /** 残值 */
    private BigDecimal sumRest;

    /** 不计免赔金额总计 */
    private BigDecimal sumNoDeductFee;

    /** 责任赔款合计 */
    private BigDecimal sumDutyPaid;

    /** 不计入赔款的费用金额 */
    private BigDecimal sumNoDutyFee;

    /** 赔付金额 */
    private BigDecimal sumPaid;

    /** 已预付赔款 */
    private BigDecimal sumPrePaid;

    /** 本次赔付金额 */
    private BigDecimal sumThisPaid;

    private BigDecimal sumBzPaid;

    /** 协议金额 */
    private BigDecimal exgratiaFee;

    /** 协议备注 */
    private String exgratiaRemark;

    /** 领赔款单位/代理人/索赔人 */
    private String receiverName;

    /** 开户银行 */
    private String bank;

    /** 帐号 */
    private String account;

    /** 交强险理算公式代码 */
    private String bzExpCode;

    /** 是否诉讼案件 */
    private String isSuitFlag;

    /** 注销/拒赔（恢复）申请处理机构 */
    private String makeCom;

    /** 机构代码 */
    private String comCode;

    /** 经办人代码 */
    private String handlerCode;

    /** 归属业务员代码 */
    private String handler1Code;

    /** 险别计算公式 */
    private String compensateExp;

    /** 险别计算公式 */
    private String compensateKindExp;

    /** 理算报告 */
    private String lctext;

    /** 确认人代码 */
    private String approverCode;

    /** 最终核保人代码 */
    private String underwriteCode;

    /** 最终核保人名称 */
    private String underwriteName;

    /** 统计年月 */
    private Date statisticsYm;

    /** 操作员代码 */
    private String operatorCode;

    /** 操作员名称 */
    private String operatorName;

    /** 最后修改人代码 */
    private String lastModifyCode;

    /** 最终修改人名称 */
    private String lastModifyName;

    /** 最后修改时间 */
    private Date lastModifyTime;

    /** 录入日期 */
    private Date inputTime;

    /** 核赔完成日期 */
    private Date underwriteEndDate;

    /** 核赔标志 */
    private String underWriteFlag;

    /** 赔案类别 */
    private String claimType;

    /** 备注 */
    private String remark;

    /** 标志字段 */
    private String flag;

    /** 是否需要追偿 */
    private String replevyFlag;

    /** 是否案终计算书 */
    private String endCompensateFlag;

    /** 是否通融 0:否；1：是 */
    private String exgratiaFlag;

    /** 总保险价值 */
    private BigDecimal sumValue;

    /** 是否折算成结算币种标志0否,1是 */
    private String chgCurrency1Flag;

    /** 是否转正常流程 0否,1是 */
    private String regularFlowFlag;

    /** 争议案件处理方式:0:自处理1:外聘处理 */
    private String lawsuitMode;

    /** 争议案件处理类型:0:调解1:仲裁2:诉讼3:其它 */
    private String lawsuitType;

    /**自赔案件标识 0：否  1：是*/
    private String caseFlag;

    /** 支付币别 */
    private String currency1;

    /** 支付币别总赔付金额 */
    private BigDecimal sumPaid1;

    /** 人民币总赔付金额 */
    private BigDecimal sumPaid3;

    /** 支付币别本次赔付金额 */
    private BigDecimal sumThisPaid1;

    /** 人民币本次赔付金额 */
    private BigDecimal sumThisPaid3;

    /**理算标识 0：分项  1：正常*/
    private String compensateFlag;

    /**例外标志 0：正常 1：例外*/
    private String exceptionFlag;

    /** 例外原因 */
    private String exceptionReason;

    /** 具体例外原因 add by limiao 20110114 */
    private String exceptionReasonText;

    /** 全损标志 */
    private String totalLossFlag;

    /** 发票号 */
    private String invoiceNo;
    /**发票类型*/
    private String invoiceType;

    private String assessorPayFlag;

    private String agricultureFlag;

    private String multiFlag;

    /** 是否欺诈  1是  0不是*/
    private String isFraud;

    /** 欺诈标志*/
    private String fraudFlag;

    /** 欺诈标志名称*/
    private String fraudName;

    /** 欺诈挽回损失金额*/
    private BigDecimal fraudRecoverAmount;

    /** 欺诈标志*/
    private String fraudType;

    /**通用标识位 0为组合保险财产理算标识，1为组合保险人伤理算标识 add by limiao 20101215 start */
    private String othFlag;
    /**是否诉讼标识     0：否1：是*/
    private String lawsuitFlag;

    /**
     * 是否人工修改（责任比例） 0：否，1：是
     */
    private String isPersonChange;

    /**
     * 标准责任比例
     */
    private BigDecimal indemnityDutyRateBac;

    private String trinity;

    /**支付修改审核审核人*/
    private String auditorCode;

    private String otherReplevyReason;

    /**
     * 是否可疑案件，1-是
     */
    private String isKeyiCase;
    /**
     * 可疑案件的代码和对应原因
     */
    private String keyiCaseCode;
    private String keyiCaseReason;
    /**
     * 可疑交易触发时间
     */
    private Date keyiCaseTime;

    /** 免赔条件模块，缺少相关单证数量*/
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