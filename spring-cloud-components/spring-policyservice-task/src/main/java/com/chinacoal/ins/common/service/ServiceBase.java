package com.chinacoal.ins.common.service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther: wen
 * @date: 2018/10/24 10:43
 * @description:
 */
public interface ServiceBase {

	Double convertStringToDouble(String str) throws Exception;
	String convertToString(String str) throws Exception;
	String convertToString(Object object) throws Exception;
	Date convertToDate(String str) throws Exception;
	String convertToString(Date date) throws Exception;
	BigDecimal convertToBigDecimal(Double dou) throws Exception;
	BigDecimal convertToBigDecimal(String str) throws Exception;
	BigDecimal convertToBigDecimal(Long l) throws Exception;
	BigDecimal convertToBigDecimal(Integer i) throws Exception;
	String  convertToBusinessType(String str) throws Exception;
	Double convertToDouble(BigDecimal bigDecimal) throws Exception;
	Double convertToDouble(String s) throws Exception;
	Boolean  convertToBoolean(String str) throws Exception;
	String  convertTCarLicenseType(String str,String planCode) throws Exception;
	Integer convertToInteger(Long lon) throws Exception;
	Integer convertToInteger(BigDecimal bigDecimal) throws Exception;
	Object formatDate(Date date1) throws Exception;
	String convertToPersonSex(String sexCode) throws Exception;
	String convertToCaseStatus(Date endCaseDate) throws Exception;
	String convertToCaseStatus(String nodeId) throws Exception;
}
