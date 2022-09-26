package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinishPaymentResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	// 海鼎返回参数
	private HdPayMentResponse[] payments;
	// 支付总额
	private BigDecimal amount;
	// 支付状态（1：成功，0为未知，-1为失败 ，注 ：多个支付状态里有一个为失败即为失败）
	private String status;

	public HdPayMentResponse[] getPayments() {
		return payments;
	}

	public void setPayments(HdPayMentResponse[] payments) {
		this.payments = payments;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
