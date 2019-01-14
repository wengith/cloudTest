package com.chinacoal.ins.utils;

/**
 * @author: wen
 * @date: 2018/10/23 16:17
 * @description: RespCode 枚举类状态码
 */
public enum RespCode {

	/** 维护状态码START */
	SUCCESS("200", "SUCCESS"),
	ERROR("0000", "Error,Please Check Parameters"),
	/** 移动项目组要求 start*/
	SUCCESS1("0000", "SUCCESS"),
	ERROR1("201", "Error,Please Check Parameters"),
	/** 移动项目组要求 end*/
	FAIL("-1", "Fail,Request Fail");
	/** 维护状态码END */

	private String code;
	private String msg;

	RespCode(String code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode(){
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
