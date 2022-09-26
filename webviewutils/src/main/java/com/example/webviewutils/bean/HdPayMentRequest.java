package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class HdPayMentRequest implements Serializable {

	// 门店编号
	private String storeNo;
	// 收银机编号
	private String posNo;
	/**
	 * 支付
	 */
	// 请求标识
	private String uuid;
	// 业务流水号
	private String orderNumber;
	// 支付金额
	private BigDecimal amount;
	// 交易信息
	private RetailOrder retailOrder;

	/**
	 * 查询与撤销
	 */
	// 支付提交时的请求标识
//    private String paySubmitUuid;
	// 支付提交时的请求业务流水号
//    private String payOrderNumber;

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public RetailOrder getRetailOrder() {
		return retailOrder;
	}

	public void setRetailOrder(RetailOrder retailOrder) {
		this.retailOrder = retailOrder;
	}

}
