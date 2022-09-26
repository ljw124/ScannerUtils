package com.example.scannertest.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class RetailPayment implements Serializable {

	// 付款行编号
	private Integer lineNumber;
	// 付款方式代码
	private String code;
	// 付款方式名称
	private String name;
	// 付款金额
	private BigDecimal amount;
	// 支付子类型
	private PaySubType paySubType;

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

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

	public PaySubType getPaySubType() {
		return paySubType;
	}

	public void setPaySubType(PaySubType paySubType) {
		this.paySubType = paySubType;
	}

}
