package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaySubType implements Serializable {

	private static final long serialVersionUID = 1L;

	// 子类型代码
	private String code;
	// 子类型名称
	private String name;
	// 支付金额
	private BigDecimal amount;

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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
