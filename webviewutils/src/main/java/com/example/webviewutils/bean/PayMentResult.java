package com.example.webviewutils.bean;

import java.io.Serializable;

public class PayMentResult implements Serializable {

	private static final long serialVersionUID = -8454209836061203475L;

	// 是否成功
	private boolean success;
	// 调用返回值
	private ResultData result;
	// 错误码
	private String errorCode;
	// 错误描述
	private String errorMsg;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public ResultData getResult() {
		return result;
	}

	public void setResult(ResultData result) {
		this.result = result;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
