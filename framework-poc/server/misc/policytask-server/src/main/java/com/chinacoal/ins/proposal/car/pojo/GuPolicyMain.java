package com.chinacoal.ins.proposal.car.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GuPolicyMain {
    /**
     * 保单号码
     */
    private String policyNo;

    /**
     * 投保单号码
     */
    private String proposalNo;

    /**
     * 保单印刷号
     */
    private String printNo;

    /**
     * 渠道
     */
    private String businessChannel;

    /**
     * 业务来源
     */
    private String businessSource;

    /**
     * 业务类别
     */
    private String businessType;

    /**
     * 保单种类
     */
    private String policySort;

    /**
     * 保单语种
     */
    private String language;

    /**
     * 团体标志
     */
    private String groupInd;

    /**
     * 中介代码
     */
    private String intermediaryCode;

    /**
     * 中介协议号
     */
    private String agreementNo;

    /**
     * 分配方案代码
     */
    private String solutionCode;

    /**
     * 账期
     */
    private Long creditPeriod;

    /**
     * 指示价号码
     */
    private String indicationNo;

    /**
     * 指示价序号
     */
    private Long indicationSeqNo;

    /**
     * 报价单号码
     */
    private String quotationNo;

    /**
     * 报价单序号
     */
    private Long quotationSeqNo;

    /**
     * 按保单号码
     */
    private String holdCoverNo;

    /**
     * 按保单序号
     */
    private Long holdCoverSeqNo;

    /**
     * 暂保单号码
     */
    private String coverNoteNo;

    /**
     * 暂保单序号
     */
    private Long coverNoteSeqnNo;

    /**
     * 代理保单号码
     */
    private String agentReferenceNo;

    /**
     * 续保旧单号码
     */
    private String reNewAlNo;

    /**
     * 续保新单号码
     */
    private String replacedPolicyNo;

    /**
     * 促销计划代码
     */
    private String promotionCode;

    /**
     * 投保人代码
     */
    private String appliCode;

    /**
     * 投保人名称
     */
    private String appliName;

    /**
     * 投保人地址
     */
    private String appliAddress;

    /**
     * 投保人地址类型
     */
    private String appliAddrType;

    /**
     * 被保险人代码
     */
    private String insuredCode;

    /**
     * 被保险人名称
     */
    private String insuredName;

    /**
     * 被保险人地址
     */
    private String insuredAddress;

    /**
     * 被保险人地址类型
     */
    private String insuredAddrType;

    /**
     * 投保日期
     */
    private Date operateDate;

    /**
     * 收件日期
     */
    private Date receivedDate;

    /**
     * 签单日期
     */
    private Date issueDate;

    /**
     * 保单币别
     */
    private String currency;

    /**
     * 总保额
     */
    private BigDecimal sumInsured;

    /**
     * 总毛保费
     */
    private BigDecimal sumGrossPremium;

    /**
     * 总净保费
     */
    private BigDecimal sumNetPremium;

    /**
     * 争议解决方式
     */
    private String argueSolution;

    /**
     * 交换单保险公司代码1
     */
    private String mainPort;

    /**
     * 交换单保险公司代码2
     */
    private String subPort;

    /**
     * 交换单保险单号码
     */
    private String othPolicyNo;

    /**
     * 对方公司代码
     */
    private String theirCompanyCode;

    /**
     * 对方公司名称
     */
    private String theirCompanyName;

    /**
     * 对方单号
     */
    private String theirReference;

    /**
     * 仲裁委员会名称
     */
    private String arbitoryName;

    /**
     * 约定分期交费次数
     */
    private Long installMentNo;

    /**
     * 批改次数
     */
    private Long endorseTimes;

    /**
     * 报案次数
     */
    private Long registTimes;

    /**
     * 理赔次数
     */
    private Long claimsTimes;

    /**
     * 打印次数
     */
    private Long printTimes;

    /**
     * 出单机构
     */
    private String issueCompany;

    /**
     * 签单地点
     */
    private String issuePlace;

    /**
     * 业务归属机构代码
     */
    private String companyCode;

    /**
     * 归属业务员代码
     */
    private String salesManCode;

    /**
     * 复核人代码
     */
    private String approverCode;

    /**
     * 操作员代码
     */
    private String operatorCode;

    /**
     * 入机日期
     */
    private Date inputDate;

    /**
     * 承保年度
     */
    private String uwYear;

    /**
     * 最终核保人代码
     */
    private String underWriteCode;

    /**
     * 最终核保人名称
     */
    private String underWriteName;

    /**
     * 核保完成日期
     */
    private Date underWriteEndDate;

    /**
     * 核保标志
     */
    private String underWriteInd;

    /**
     * 自动续保标志
     */
    private String autoRenewInd;

    /**
     * 多险种保单标志
     */
    private String multiRiskInd;

    /**
     * 最后一次修改人员代码
     */
    private String lastModifierCode;

    /**
     * 最后一次修改日期
     */
    private Date lastModifyDate;

    /**
     * 出面保单分出比例
     */
    private BigDecimal frontIngriPercent;

    /**
     * 出面保单分出佣金比例
     */
    private BigDecimal frontIngriCommissionPercent;

    /**
     * 出面保单分出管理费比例
     */
    private BigDecimal frontIngriAdminFeePercent;

    /**
     * 出面保单分出税金比例
     */
    private BigDecimal frontIngriTaxPercent;

    /**
     * 新/续保标志
     */
    private String reNewind;

    /**
     * 被续保标志
     */
    private String reNewedInd;

    /**
     * 退保标志
     */
    private String surrenderInd;

    /**
     * 保险合同终止标志
     */
    private String endInd;

    /**
     * 年保费
     */
    private BigDecimal yearPremium;

    /**
     * 注销标志
     */
    private String cancelInd;

    /**
     * 遗失标志
     */
    private String lostInd;

    /**
     * 是否转入收付费
     */
    private String debtorInd;

    /**
     * 是否统计
     */
    private String statInd;

    /**
     * 业务提奖来源
     */
    private String sourceId;

    /**
     * 迁移客户号
     */
    private String migratedClientNo;

    /**
     * 迁移帐号
     */
    private String migratedAccountNum;

    /**
     * 旧保单号
     */
    private String migratedPolicyNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 有效标志
     */
    private String validInd;

    /**
     * 标志字段
     */
    private String flag;

    /**
     * 总承保保费
     */
    private BigDecimal sumUwPremium;

    /**
     * 印刷单证类型
     */
    private String visaType;

    /**
     * 影像标识
     */
    private String imageInd;

    /**
     * 补录保单标志位
     */
    private String proposalPolicyInd;

    /**
     * 备注号
     */
    private String inwardReference;

    /**
     * 出面业务分保计算公式
     */
    private String hengSangInd;

    /**
     * 境内外标志
     */
    private String domesticInd;

    /**
     * 历史数据标示
     */
    private String historyInd;

    /**
     * 换单申请提出人
     */
    private String replaceProposerInd;

    /**
     * 处理状态
     */
    private String handleStatus;

    /**
     * 复核通过日期
     */
    private Date approveEndDate;

    /**
     * 处理人代码
     */
    private String dealerCode;

    /**
     * 见费出单COD标志
     */
    private String codInd;

    /**
     * 承保确认时间
     */
    private Date acceptDate;

    /**
     * 特別允許受保标志
     */
    private String specialAcceptance;

    /**
     * 允许关联录入险种
     */
    private String relatedRiskCode;

    /**
     * 联系人备注
     */
    private String contactRemark;

    /**
     * 协议是否有效
     */
    private String agrValidInd;

    /**
     * 外部代理
     */
    private String outerUserCode;

    /**
     * 外部机构
     */
    private String outerCompanyCode;

    /**
     * 增值服务方案
     */
    private String serviceProjectCode;

    /**
     * 渠道细类
     */
    private String channelDetailCode;

    /**
     * 产品代码
     */
    private String productCode;

    /**
     * 问题件标示
     */
    private String problemInd;

    /**
     * 问题件回销时间
     */
    private Date cancelTime;

    /**
     * 保单客户类型
     */
    private String channelFlag;

    /**
     * 农险标志
     */
    private String agricultureFlag;

    /**
     * HistoryFlag
     */
    private String historyFlag;

    /**
     * null
     */
    private String calculateType;

    /**
     * 保费计算方式<
     */
    private String businessInd;

    /**
     * 业务类型
     */
    private String salesCommissionerCode;

    /**
     * 寿销产专员代码
     */
    private String cmbPrintivcInd;

    /**
     * 业务方式
     */
    private String businessMode;

    /**
     * 报批号
     */
    private String applyNo;

    /**
     * 旧车打印位置
     */
    private String oldCarPrintFlag;

    /**
     * 渠道小类
     */
    private String channelTip;

    /**
     * 合作网点
     */
    private String cooperateSiteCode;

    /**
     * 报批序列号
     */
    private Short applySerialno;

    /**
     * 是否统保业务
     */
    private String cominsureInd;

    /**
     * 客户经理团队长
     */
    private String teamManager;

    /**
     * 寿险综合开拓专员
     */
    private String pioneerCode;

    /**
     * 统括保单标志
     */
    private String comPolicyInfo;

    /**
     * 预收费自动对单
     */
    private String preFeeFlag;

    /**
     * 暂收款编号
     */
    private String poaSerialNo;

    /**
     * 是否处于查勘状态
     */
    private String surveyInd;

    /**
     * 优先级标志
     */
    private String priInd;

    /**
     * 打印时间
     */
    private Date printDate;

    /**
     * 寿险机构
     */
    private String outerSubCompanyCode;

    /**
     * 寿险部门
     */
    private String departmentCode;

    /**
     * 是否一揽子业务
     */
    private String basketInd;

    /**
     * 未知字段
     */
    private String flowId;

    /**
     * 中介销售人员职业证号
     */
    private String interSalesManRegisterNo;

    /**
     * 中介销售人员
     */
    private String interSalesManCode;

    /**
     * 业务员职业证号
     */
    private String salesManRegisterNo;

    /**
     * 标示是否上传了影像附件
     */
    private String imageAttachInd;

    /**
     * 反洗钱可疑交易特征
     */
    private String moneySuSpiciousInd;

    /**
     * 关联交易类型
     */
    private String relatetRadeType;

    /**
     * 业务等级分类
     */
    private String businessGrade;

    /**
     * 业务类型来源
     */
    private String businessTypeSource;

    /**
     * 业务来源细分（一级业务来源）
     */
    private String businessSourceSub;

    /**
     * 渠道来源
     */
    private String channelSource;

    /**
     * 渠道来源细分
     */
    private String channelSourceSub;

    /**
     * 销售团队
     */
    private String teamCode;

    /**
     * 关联保单号
     */
    private String relatePropoSalNo;

    /**
     * 车行名称
     */
    private String carParkName;

    /**
     * 归属机构对应传统归属机构（互联网归属机构才有）
     */
    private String CompanyCodeTradtional;
    /**
     * 网点代码
     */
    private String netPointCode;
    /**
     * 二级业务来源
     */
    private String businessDetail;
    /**
     * 三级业务来源
     */
    private String businessDetailThree;

    public String getReNewAlNo() {
        return reNewAlNo;
    }

    public void setReNewAlNo(String reNewAlNo) {
        this.reNewAlNo = reNewAlNo;
    }

    public String getReplacedPolicyNo() {
        return replacedPolicyNo;
    }

    public void setReplacedPolicyNo(String replacedPolicyNo) {
        this.replacedPolicyNo = replacedPolicyNo;
    }

    public String getRelatedRiskCode() {
        return relatedRiskCode;
    }

    public void setRelatedRiskCode(String relatedRiskCode) {
        this.relatedRiskCode = relatedRiskCode;
    }

    public String getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(String calculateType) {
        this.calculateType = calculateType;
    }

    public String getBasketInd() {
        return basketInd;
    }

    public void setBasketInd(String basketInd) {
        this.basketInd = basketInd;
    }

    public String getCompanyCodeTradtional() {
        return CompanyCodeTradtional;
    }

    public void setCompanyCodeTradtional(String companyCodeTradtional) {
        CompanyCodeTradtional = companyCodeTradtional;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getPrintNo() {
        return printNo;
    }

    public void setPrintNo(String printNo) {
        this.printNo = printNo;
    }

    public String getBusinessChannel() {
        return businessChannel;
    }

    public void setBusinessChannel(String businessChannel) {
        this.businessChannel = businessChannel;
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getPolicySort() {
        return policySort;
    }

    public void setPolicySort(String policySort) {
        this.policySort = policySort;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGroupInd() {
        return groupInd;
    }

    public void setGroupInd(String groupInd) {
        this.groupInd = groupInd;
    }

    public String getIntermediaryCode() {
        return intermediaryCode;
    }

    public void setIntermediaryCode(String intermediaryCode) {
        this.intermediaryCode = intermediaryCode;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public void setSolutionCode(String solutionCode) {
        this.solutionCode = solutionCode;
    }

    public Long getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(Long creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public String getIndicationNo() {
        return indicationNo;
    }

    public void setIndicationNo(String indicationNo) {
        this.indicationNo = indicationNo;
    }

    public Long getIndicationSeqNo() {
        return indicationSeqNo;
    }

    public void setIndicationSeqNo(Long indicationSeqNo) {
        this.indicationSeqNo = indicationSeqNo;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public Long getQuotationSeqNo() {
        return quotationSeqNo;
    }

    public void setQuotationSeqNo(Long quotationSeqNo) {
        this.quotationSeqNo = quotationSeqNo;
    }

    public String getHoldCoverNo() {
        return holdCoverNo;
    }

    public void setHoldCoverNo(String holdCoverNo) {
        this.holdCoverNo = holdCoverNo;
    }

    public Long getHoldCoverSeqNo() {
        return holdCoverSeqNo;
    }

    public void setHoldCoverSeqNo(Long holdCoverSeqNo) {
        this.holdCoverSeqNo = holdCoverSeqNo;
    }

    public String getCoverNoteNo() {
        return coverNoteNo;
    }

    public void setCoverNoteNo(String coverNoteNo) {
        this.coverNoteNo = coverNoteNo;
    }

    public Long getCoverNoteSeqnNo() {
        return coverNoteSeqnNo;
    }

    public void setCoverNoteSeqnNo(Long coverNoteSeqnNo) {
        this.coverNoteSeqnNo = coverNoteSeqnNo;
    }

    public String getAgentReferenceNo() {
        return agentReferenceNo;
    }

    public void setAgentReferenceNo(String agentReferenceNo) {
        this.agentReferenceNo = agentReferenceNo;
    }

    public String getReNewalNo() {
        return reNewAlNo;
    }

    public void setReNewalNo(String reNewAlNo) {
        this.reNewAlNo = reNewAlNo;
    }

    public String getReplacedPolicyno() {
        return replacedPolicyNo;
    }

    public void setReplacedPolicyno(String replacedPolicyNo) {
        this.replacedPolicyNo = replacedPolicyNo;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getAppliCode() {
        return appliCode;
    }

    public void setAppliCode(String appliCode) {
        this.appliCode = appliCode;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getAppliAddress() {
        return appliAddress;
    }

    public void setAppliAddress(String appliAddress) {
        this.appliAddress = appliAddress;
    }

    public String getAppliAddrType() {
        return appliAddrType;
    }

    public void setAppliAddrType(String appliAddrType) {
        this.appliAddrType = appliAddrType;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredAddress() {
        return insuredAddress;
    }

    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress;
    }

    public String getInsuredAddrType() {
        return insuredAddrType;
    }

    public void setInsuredAddrType(String insuredAddrType) {
        this.insuredAddrType = insuredAddrType;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public BigDecimal getSumGrossPremium() {
        return sumGrossPremium;
    }

    public void setSumGrossPremium(BigDecimal sumGrossPremium) {
        this.sumGrossPremium = sumGrossPremium;
    }

    public BigDecimal getSumNetPremium() {
        return sumNetPremium;
    }

    public void setSumNetPremium(BigDecimal sumNetPremium) {
        this.sumNetPremium = sumNetPremium;
    }

    public String getArgueSolution() {
        return argueSolution;
    }

    public void setArgueSolution(String argueSolution) {
        this.argueSolution = argueSolution;
    }

    public String getMainPort() {
        return mainPort;
    }

    public void setMainPort(String mainPort) {
        this.mainPort = mainPort;
    }

    public String getSubPort() {
        return subPort;
    }

    public void setSubPort(String subPort) {
        this.subPort = subPort;
    }

    public String getOthPolicyNo() {
        return othPolicyNo;
    }

    public void setOthPolicyNo(String othPolicyNo) {
        this.othPolicyNo = othPolicyNo;
    }

    public String getTheirCompanyCode() {
        return theirCompanyCode;
    }

    public void setTheirCompanyCode(String theirCompanyCode) {
        this.theirCompanyCode = theirCompanyCode;
    }

    public String getTheirCompanyName() {
        return theirCompanyName;
    }

    public void setTheirCompanyName(String theirCompanyName) {
        this.theirCompanyName = theirCompanyName;
    }

    public String getTheirReference() {
        return theirReference;
    }

    public void setTheirReference(String theirReference) {
        this.theirReference = theirReference;
    }

    public String getArbitoryName() {
        return arbitoryName;
    }

    public void setArbitoryName(String arbitoryName) {
        this.arbitoryName = arbitoryName;
    }

    public Long getInstallMentNo() {
        return installMentNo;
    }

    public void setInstallMentNo(Long installMentNo) {
        this.installMentNo = installMentNo;
    }

    public Long getEndorseTimes() {
        return endorseTimes;
    }

    public void setEndorseTimes(Long endorseTimes) {
        this.endorseTimes = endorseTimes;
    }

    public Long getRegistTimes() {
        return registTimes;
    }

    public void setRegistTimes(Long registTimes) {
        this.registTimes = registTimes;
    }

    public Long getClaimsTimes() {
        return claimsTimes;
    }

    public void setClaimsTimes(Long claimsTimes) {
        this.claimsTimes = claimsTimes;
    }

    public Long getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Long printTimes) {
        this.printTimes = printTimes;
    }

    public String getIssueCompany() {
        return issueCompany;
    }

    public void setIssueCompany(String issueCompany) {
        this.issueCompany = issueCompany;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSalesManCode() {
        return salesManCode;
    }

    public void setSalesManCode(String salesManCode) {
        this.salesManCode = salesManCode;
    }

    public String getApproverCode() {
        return approverCode;
    }

    public void setApproverCode(String approverCode) {
        this.approverCode = approverCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getUwYear() {
        return uwYear;
    }

    public void setUwYear(String uwYear) {
        this.uwYear = uwYear;
    }

    public String getUnderWriteCode() {
        return underWriteCode;
    }

    public void setUnderWriteCode(String underWriteCode) {
        this.underWriteCode = underWriteCode;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }

    public Date getUnderWriteEndDate() {
        return underWriteEndDate;
    }

    public void setUnderWriteEndDate(Date underWriteEndDate) {
        this.underWriteEndDate = underWriteEndDate;
    }

    public String getUnderWriteInd() {
        return underWriteInd;
    }

    public void setUnderWriteInd(String underWriteInd) {
        this.underWriteInd = underWriteInd;
    }

    public String getAutoRenewInd() {
        return autoRenewInd;
    }

    public void setAutoRenewInd(String autoRenewInd) {
        this.autoRenewInd = autoRenewInd;
    }

    public String getMultiRiskInd() {
        return multiRiskInd;
    }

    public void setMultiRiskInd(String multiRiskInd) {
        this.multiRiskInd = multiRiskInd;
    }

    public String getLastModifierCode() {
        return lastModifierCode;
    }

    public void setLastModifierCode(String lastModifierCode) {
        this.lastModifierCode = lastModifierCode;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public BigDecimal getFrontIngriPercent() {
        return frontIngriPercent;
    }

    public void setFrontIngriPercent(BigDecimal frontIngriPercent) {
        this.frontIngriPercent = frontIngriPercent;
    }

    public BigDecimal getFrontIngriCommissionPercent() {
        return frontIngriCommissionPercent;
    }

    public void setFrontIngriCommissionPercent(BigDecimal frontIngriCommissionPercent) {
        this.frontIngriCommissionPercent = frontIngriCommissionPercent;
    }

    public BigDecimal getFrontIngriAdminFeePercent() {
        return frontIngriAdminFeePercent;
    }

    public void setFrontIngriAdminFeePercent(BigDecimal frontIngriAdminFeePercent) {
        this.frontIngriAdminFeePercent = frontIngriAdminFeePercent;
    }

    public BigDecimal getFrontIngriTaxPercent() {
        return frontIngriTaxPercent;
    }

    public void setFrontIngriTaxPercent(BigDecimal frontIngriTaxPercent) {
        this.frontIngriTaxPercent = frontIngriTaxPercent;
    }

    public String getReNewind() {
        return reNewind;
    }

    public void setReNewind(String reNewind) {
        this.reNewind = reNewind;
    }

    public String getReNewedInd() {
        return reNewedInd;
    }

    public void setReNewedInd(String reNewedInd) {
        this.reNewedInd = reNewedInd;
    }

    public String getSurrenderInd() {
        return surrenderInd;
    }

    public void setSurrenderInd(String surrenderInd) {
        this.surrenderInd = surrenderInd;
    }

    public String getEndInd() {
        return endInd;
    }

    public void setEndInd(String endInd) {
        this.endInd = endInd;
    }

    public BigDecimal getYearPremium() {
        return yearPremium;
    }

    public void setYearPremium(BigDecimal yearPremium) {
        this.yearPremium = yearPremium;
    }

    public String getCancelInd() {
        return cancelInd;
    }

    public void setCancelInd(String cancelInd) {
        this.cancelInd = cancelInd;
    }

    public String getLostInd() {
        return lostInd;
    }

    public void setLostInd(String lostInd) {
        this.lostInd = lostInd;
    }

    public String getDebtorInd() {
        return debtorInd;
    }

    public void setDebtorInd(String debtorInd) {
        this.debtorInd = debtorInd;
    }

    public String getStatInd() {
        return statInd;
    }

    public void setStatInd(String statInd) {
        this.statInd = statInd;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMigratedClientNo() {
        return migratedClientNo;
    }

    public void setMigratedClientNo(String migratedClientNo) {
        this.migratedClientNo = migratedClientNo;
    }

    public String getMigratedAccountNum() {
        return migratedAccountNum;
    }

    public void setMigratedAccountNum(String migratedAccountNum) {
        this.migratedAccountNum = migratedAccountNum;
    }

    public String getMigratedPolicyNo() {
        return migratedPolicyNo;
    }

    public void setMigratedPolicyNo(String migratedPolicyNo) {
        this.migratedPolicyNo = migratedPolicyNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValidInd() {
        return validInd;
    }

    public void setValidInd(String validInd) {
        this.validInd = validInd;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getSumUwPremium() {
        return sumUwPremium;
    }

    public void setSumUwPremium(BigDecimal sumUwPremium) {
        this.sumUwPremium = sumUwPremium;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getImageInd() {
        return imageInd;
    }

    public void setImageInd(String imageInd) {
        this.imageInd = imageInd;
    }

    public String getProposalPolicyInd() {
        return proposalPolicyInd;
    }

    public void setProposalPolicyInd(String proposalPolicyInd) {
        this.proposalPolicyInd = proposalPolicyInd;
    }

    public String getInwardReference() {
        return inwardReference;
    }

    public void setInwardReference(String inwardReference) {
        this.inwardReference = inwardReference;
    }

    public String getHengSangInd() {
        return hengSangInd;
    }

    public void setHengSangInd(String hengSangInd) {
        this.hengSangInd = hengSangInd;
    }

    public String getDomesticInd() {
        return domesticInd;
    }

    public void setDomesticInd(String domesticInd) {
        this.domesticInd = domesticInd;
    }

    public String getHistoryInd() {
        return historyInd;
    }

    public void setHistoryInd(String historyInd) {
        this.historyInd = historyInd;
    }

    public String getReplaceProposerInd() {
        return replaceProposerInd;
    }

    public void setReplaceProposerInd(String replaceProposerInd) {
        this.replaceProposerInd = replaceProposerInd;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Date getApproveEndDate() {
        return approveEndDate;
    }

    public void setApproveEndDate(Date approveEndDate) {
        this.approveEndDate = approveEndDate;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getCodInd() {
        return codInd;
    }

    public void setCodInd(String codInd) {
        this.codInd = codInd;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getSpecialAcceptance() {
        return specialAcceptance;
    }

    public void setSpecialAcceptance(String specialAcceptance) {
        this.specialAcceptance = specialAcceptance;
    }

    public String getRelatedRiskcode() {
        return relatedRiskCode;
    }

    public void setRelatedRiskcode(String relatedRiskCode) {
        this.relatedRiskCode = relatedRiskCode;
    }

    public String getContactRemark() {
        return contactRemark;
    }

    public void setContactRemark(String contactRemark) {
        this.contactRemark = contactRemark;
    }

    public String getAgrValidInd() {
        return agrValidInd;
    }

    public void setAgrValidInd(String agrValidInd) {
        this.agrValidInd = agrValidInd;
    }

    public String getOuterUserCode() {
        return outerUserCode;
    }

    public void setOuterUserCode(String outerUserCode) {
        this.outerUserCode = outerUserCode;
    }

    public String getOuterCompanyCode() {
        return outerCompanyCode;
    }

    public void setOuterCompanyCode(String outerCompanyCode) {
        this.outerCompanyCode = outerCompanyCode;
    }

    public String getServiceProjectCode() {
        return serviceProjectCode;
    }

    public void setServiceProjectCode(String serviceProjectCode) {
        this.serviceProjectCode = serviceProjectCode;
    }

    public String getChannelDetailCode() {
        return channelDetailCode;
    }

    public void setChannelDetailCode(String channelDetailCode) {
        this.channelDetailCode = channelDetailCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProblemInd() {
        return problemInd;
    }

    public void setProblemInd(String problemInd) {
        this.problemInd = problemInd;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getChannelFlag() {
        return channelFlag;
    }

    public void setChannelFlag(String channelFlag) {
        this.channelFlag = channelFlag;
    }

    public String getAgricultureFlag() {
        return agricultureFlag;
    }

    public void setAgricultureFlag(String agricultureFlag) {
        this.agricultureFlag = agricultureFlag;
    }

    public String getHistoryFlag() {
        return historyFlag;
    }

    public void setHistoryFlag(String historyFlag) {
        this.historyFlag = historyFlag;
    }

    public String getCalculatetype() {
        return calculateType;
    }

    public void setCalculatetype(String calculateType) {
        this.calculateType = calculateType;
    }

    public String getBusinessInd() {
        return businessInd;
    }

    public void setBusinessInd(String businessInd) {
        this.businessInd = businessInd;
    }

    public String getSalesCommissionerCode() {
        return salesCommissionerCode;
    }

    public void setSalesCommissionerCode(String salesCommissionerCode) {
        this.salesCommissionerCode = salesCommissionerCode;
    }

    public String getCmbPrintivcInd() {
        return cmbPrintivcInd;
    }

    public void setCmbPrintivcInd(String cmbPrintivcInd) {
        this.cmbPrintivcInd = cmbPrintivcInd;
    }

    public String getBusinessMode() {
        return businessMode;
    }

    public void setBusinessMode(String businessMode) {
        this.businessMode = businessMode;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getOldCarPrintFlag() {
        return oldCarPrintFlag;
    }

    public void setOldCarPrintFlag(String oldCarPrintFlag) {
        this.oldCarPrintFlag = oldCarPrintFlag;
    }

    public String getChannelTip() {
        return channelTip;
    }

    public void setChannelTip(String channelTip) {
        this.channelTip = channelTip;
    }

    public String getCooperateSiteCode() {
        return cooperateSiteCode;
    }

    public void setCooperateSiteCode(String cooperateSiteCode) {
        this.cooperateSiteCode = cooperateSiteCode;
    }

    public Short getApplySerialno() {
        return applySerialno;
    }

    public void setApplySerialno(Short applySerialno) {
        this.applySerialno = applySerialno;
    }

    public String getCominsureInd() {
        return cominsureInd;
    }

    public void setCominsureInd(String cominsureInd) {
        this.cominsureInd = cominsureInd;
    }

    public String getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(String teamManager) {
        this.teamManager = teamManager;
    }

    public String getPioneerCode() {
        return pioneerCode;
    }

    public void setPioneerCode(String pioneerCode) {
        this.pioneerCode = pioneerCode;
    }

    public String getComPolicyInfo() {
        return comPolicyInfo;
    }

    public void setComPolicyInfo(String comPolicyInfo) {
        this.comPolicyInfo = comPolicyInfo;
    }

    public String getPreFeeFlag() {
        return preFeeFlag;
    }

    public void setPreFeeFlag(String preFeeFlag) {
        this.preFeeFlag = preFeeFlag;
    }

    public String getPoaSerialNo() {
        return poaSerialNo;
    }

    public void setPoaSerialNo(String poaSerialNo) {
        this.poaSerialNo = poaSerialNo;
    }

    public String getSurveyInd() {
        return surveyInd;
    }

    public void setSurveyInd(String surveyInd) {
        this.surveyInd = surveyInd;
    }

    public String getPriInd() {
        return priInd;
    }

    public void setPriInd(String priInd) {
        this.priInd = priInd;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public String getOuterSubCompanyCode() {
        return outerSubCompanyCode;
    }

    public void setOuterSubCompanyCode(String outerSubCompanyCode) {
        this.outerSubCompanyCode = outerSubCompanyCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getBasketind() {
        return basketInd;
    }

    public void setBasketind(String basketind) {
        this.basketInd = basketInd;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getInterSalesManRegisterNo() {
        return interSalesManRegisterNo;
    }

    public void setInterSalesManRegisterNo(String interSalesManRegisterNo) {
        this.interSalesManRegisterNo = interSalesManRegisterNo;
    }

    public String getInterSalesManCode() {
        return interSalesManCode;
    }

    public void setInterSalesManCode(String interSalesManCode) {
        this.interSalesManCode = interSalesManCode;
    }

    public String getSalesManRegisterNo() {
        return salesManRegisterNo;
    }

    public void setSalesManRegisterNo(String salesManRegisterNo) {
        this.salesManRegisterNo = salesManRegisterNo;
    }

    public String getImageAttachInd() {
        return imageAttachInd;
    }

    public void setImageAttachInd(String imageAttachInd) {
        this.imageAttachInd = imageAttachInd;
    }

    public String getMoneySuSpiciousInd() {
        return moneySuSpiciousInd;
    }

    public void setMoneySuSpiciousInd(String moneySuSpiciousInd) {
        this.moneySuSpiciousInd = moneySuSpiciousInd;
    }

    public String getRelatetRadeType() {
        return relatetRadeType;
    }

    public void setRelatetRadeType(String relatetRadeType) {
        this.relatetRadeType = relatetRadeType;
    }

    public String getBusinessGrade() {
        return businessGrade;
    }

    public void setBusinessGrade(String businessGrade) {
        this.businessGrade = businessGrade;
    }

    public String getBusinessTypeSource() {
        return businessTypeSource;
    }

    public void setBusinessTypeSource(String businessTypeSource) {
        this.businessTypeSource = businessTypeSource;
    }

    public String getBusinessSourceSub() {
        return businessSourceSub;
    }

    public void setBusinessSourceSub(String businessSourceSub) {
        this.businessSourceSub = businessSourceSub;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public String getChannelSourceSub() {
        return channelSourceSub;
    }

    public void setChannelSourceSub(String channelSourceSub) {
        this.channelSourceSub = channelSourceSub;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getRelatePropoSalNo() {
        return relatePropoSalNo;
    }

    public void setRelatePropoSalNo(String relatePropoSalNo) {
        this.relatePropoSalNo = relatePropoSalNo;
    }

    public String getCarParkName() {
        return carParkName;
    }

    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
    }
}