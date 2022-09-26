package com.example.webviewutils.bean;

import java.io.Serializable;

public class PayChannel implements Serializable {

	private static final long serialVersionUID = 1L;

	// code
	private String code;
	// name
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
