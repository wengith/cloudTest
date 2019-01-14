package com.chinacoal.ins.common.service.impl;

import com.chinacoal.ins.common.service.ServiceBase;
import com.chinacoal.ins.utils.CommonConst;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: wen
 * @date: 2018/10/24 10:43
 * @description: Service基础工具
 */
public class ServiceBaseImpl implements ServiceBase {

	/**
	 * 功能描述:String型转换为Double
	 * @author: wen
	 * @date: 2018/10/24 11:01
	 * @param: [str]
	 * @return: java.lang.Double
	 */
	@Override
	public Double convertStringToDouble(String str) throws Exception{
		double dou = 0.0;
		if(str != "" && str!=null){
			return Double.parseDouble(str);
		}
		return dou;
	}
	/**
	 * 功能描述:
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [str]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToString(String str) throws Exception{
		String s = "";
		if(str != null && !"".equals(str)){
			s = str;
		}
		return s;
	}
	/**
	 * 功能描述: Object转换为String数据
	 * @author: wen
	 * @date: 2018/10/25 11:42
	 * @param: [object]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToString(Object object) throws Exception {
		String s = "";
		if(object != null){
			s = String.valueOf(object);
		}
		return s;
	}

	/**
	 * 功能描述:str格式化为日期Date
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [str]
	 * @return: java.util.Date
	 */
	@Override
	public Date convertToDate(String str) throws Exception{
		/** 日期格式 yyyy-MM-dd HH:mm:ss */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(str != null && !"".equals(str)){
			return format.parse(str);

		}else{
			return null;
		}
	}
	/**
	 * 功能描述:Date转换为String型
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [date]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToString(Date date) throws Exception {
		String str = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date!=null){
			str = format.format(date);
			return str;
		} else {
			return str;
		}
	}
	/**
	 * 功能描述:
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [dou]
	 * @return: java.math.BigDecimal
	 */
	@Override
	public BigDecimal convertToBigDecimal(Double dou) throws Exception{
		if(dou != null){
			return BigDecimal.valueOf(dou);
		}else{
			return null;
		}
	}
	/**
	 * 功能描述:
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [str]
	 * @return: java.math.BigDecimal
	 */
	@Override
	public BigDecimal convertToBigDecimal(String str) throws Exception{
		if(str != null){
			return BigDecimal.valueOf(new Double(str));
		}else{
			return null;
		}
	}
	/**
	 * 功能描述:Long转换为BigDecimal
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [l]
	 * @return: java.math.BigDecimal
	 */
	@Override
	public BigDecimal convertToBigDecimal(Long l) throws Exception{
		if(l != null){
			return BigDecimal.valueOf(l);
		}else{
			return null;
		}
	}
	/**
	 * 功能描述: Integer转换为BigDecimal
	 * @author: wen
	 * @date: 2018/10/24 11:02
	 * @param: [i]
	 * @return: java.math.BigDecimal
	 */
	@Override
	public BigDecimal convertToBigDecimal(Integer i) throws Exception{
		if(i != null){
			return BigDecimal.valueOf(i);
		}else{
			return null;
		}
	}
	/**
	 * 功能描述: BusinessType转换
	 * @author: wen
	 * @date: 2018/10/25 14:56
	 * @param: [str]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToBusinessType(String str) throws Exception {
		String s = "2";
		if(str != null){
			if("2".equals(str)){
				s = "1";
			}else if("1".equals(str)){
				s = "0";
			}else if("3".equals(str)||"4".equals(str)){
				s="2";
			}
		}
		return s;
	}

	@Override
	public Double convertToDouble(BigDecimal bigDecimal) throws Exception {
		if(bigDecimal!=null){
			return bigDecimal.doubleValue();
		}else{
			return null;
		}
	}

	@Override
	public Double convertToDouble(String str) throws Exception {
		double dou = 0.0;
		if(str != "" && str!=null){
			return Double.parseDouble(str);
		}
		return dou;
	}
	@Override
	public Boolean  convertToBoolean(String str) throws Exception{
		Boolean result = true;
		if(str != null){
			if("0".equals(str)){
				result = false;
			}else if("".equals(str)){
				result = null;
			}
		}
		return result;
	}

	@Override
	public String convertTCarLicenseType(String str, String planCode) throws Exception {
		String carLicenseType  = "";
		carLicenseType = str ;
		if("1370".equals(planCode)){
			if("01".equals(carLicenseType)){
				carLicenseType = "07";
			}else if("02".equals(carLicenseType)){
				carLicenseType = "08";
			}else if("03".equals(carLicenseType)){
				carLicenseType = "09";
			}else if("04".equals(carLicenseType)){
				carLicenseType = "10";
			}else if("05".equals(carLicenseType)){
				carLicenseType = "11";
			}else if("06".equals(carLicenseType)){
				carLicenseType = "12";
			}else if("07".equals(carLicenseType)){
				carLicenseType = "14";
			}else if("08".equals(carLicenseType)){
				carLicenseType = "18";
			}else if("09".equals(carLicenseType)){
				carLicenseType = "19";
			}else if("10".equals(carLicenseType)){
				carLicenseType = "21";
			}else if("11".equals(carLicenseType)){
				carLicenseType = "33";
			}
		}
		return carLicenseType;
	}

	@Override
	public Integer convertToInteger(Long lon) throws Exception {
		if(lon!=null){
			return lon.intValue();
		}else{
			return 0;
		}
	}

	@Override
	public Integer convertToInteger(BigDecimal bigDecimal) throws Exception {
		if(bigDecimal!=null){
			return bigDecimal.intValue();
		}else{
			return null;
		}
	}

	@Override
	public Object formatDate(Date date1) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date1!=null){
			return sdf.format(date1);
		}else{
			return null;
		}
	}
	/**
	 * 功能描述: 性别转换
	 * @author: wen
	 * @date: 2018/11/5 18:00
	 * @param: [sexCode]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToPersonSex(String sexCode) throws Exception{
		String personSexName = "";
		if(sexCode!=null && !"".equals(sexCode)){
			if(CommonConst.sexMan.equals(sexCode)){
				personSexName = "男";
			}else if(CommonConst.sexWoman.equals(sexCode)){
				personSexName = "女";

			}else if(CommonConst.sexNo.equals(sexCode)){
				personSexName = "未知的性别";

			}else if(CommonConst.sexNoCommon.equals(sexCode)){
				personSexName = "未说明的性别";
			}
		}
		return personSexName;
	}
	/**
	 * 功能描述: 案件状态转换
	 * @author: wen
	 * @date: 2018/11/6 14:11
	 * @param: [endCaseDate]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToCaseStatus(Date endCaseDate) throws Exception {
		String statusCode = "";
		if(statusCode!=null && !"".equals(statusCode)){
			statusCode = CommonConst.endCase;
		}else{
			statusCode = CommonConst.unEndCase;
		}
		return statusCode;
	}
	/**
	 * 功能描述: 案件状态转换
	 * @author: wen
	 * @date: 2018/11/22 10:15
	 * @param: [nodeId]
	 * @return: java.lang.String
	 */
	@Override
	public String convertToCaseStatus(String nodeId) throws Exception{
		String nodeName = "";
		if(nodeId==null || "".equals(nodeId)){
			nodeName = "";
		} else if("0".equals(nodeId)){
			nodeName = "报案";
		} else if("1".equals(nodeId)){
			nodeName = "派工";
		} else if("2".equals(nodeId)){
			nodeName = "查勘";
		} else if("3".equals(nodeId)){
			nodeName = "立案";
		} else if("4".equals(nodeId)){
			nodeName = "定损";
		} else if("5".equals(nodeId)){
			nodeName = "核损";
		} else if("6".equals(nodeId)){
			nodeName = "理算";
		} else if("8".equals(nodeId)){
			nodeName = "核赔";
		} else if("9".equals(nodeId)){
			nodeName = "结案";
		} else if("50".equals(nodeId)){
			nodeName = "小额处理";
		}
		return nodeName;
	}

}
