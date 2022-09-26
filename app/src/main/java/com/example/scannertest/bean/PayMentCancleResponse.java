package com.example.scannertest.bean;

import java.io.Serializable;

public class PayMentCancleResponse implements Serializable {

	private String echoCode;// 响应代码 0 成功 1失败
	private String echoMessage;// echoMessage
	private String status;

	public String getEchoCode() {
		return echoCode;
	}

	public void setEchoCode(String echoCode) {
		this.echoCode = echoCode;
	}

	public String getEchoMessage() {
		return echoMessage;
	}

	public void setEchoMessage(String echoMessage) {
		this.echoMessage = echoMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
