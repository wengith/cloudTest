package com.chinacoal.ins.utils;


/**
 * @author: wen
 * @date: 2018/10/23 16:26
 * @description: RespEntity返回实体
 */
public class RespEntity {

	private String code;
	private String msg;
	private Object data;

	public RespEntity(RespCode respCode) {
		this.code = respCode.getCode();
		this.msg = respCode.getMsg();
	}

	public RespEntity(RespCode respCode, Object data) {
		this(respCode);
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
