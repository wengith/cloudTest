package com.chinacoal.ins.claim.car.vo;

/**
 * @author: wen
 * @date: 2018/11/12 10:50
 * @description: 理赔单证收集信息
 */
public class ClaimDocInfo {

	/** 产品 对应产品大类代码（默认‘03’） */
	private String proNo;
	/** 索赔资料代码 */
	private String docCode;
	/** 索赔资料名称 */
	private String docName;
	/** 险种代码 */
	private String riskCode;
	/** 创建人编码 */
	private String creatorName;
	/** 创建时间 */
	private String createDate;
	/** 更新人编码 */
	private String modifierCode;
	/** 更新时间 */
	private String modifyDate;
	/** 失效时间 */
	private String expiryDate;
	/** 新增加的项目 */
	private String addDocs;

	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifierCode() {
		return modifierCode;
	}

	public void setModifierCode(String modifierCode) {
		this.modifierCode = modifierCode;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getAddDocs() {
		return addDocs;
	}

	public void setAddDocs(String addDocs) {
		this.addDocs = addDocs;
	}
}
