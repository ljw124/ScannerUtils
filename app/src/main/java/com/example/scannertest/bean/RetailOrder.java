package com.example.scannertest.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class RetailOrder implements Serializable {

	// POS机号
	private String posNo;
	// 门店代码
	private String storeNo;
	// 交易流水
	private String flowNo;
	// 交易类型(1 销售2 退货3 冲帐)
	private Integer tranType;
	// 应付金额
	private BigDecimal amount;
	// 操作员代码
	private String operatorCode;
	// 操作员名称
	private String operatorName;
	// 会员信息
	private RetailMember memberInfo;
	// 商品明细;
	private List<RetailLine> lines;
	// 已付款明细
	private List<RetailPayment> payments;

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getFlowNo() {
		return flowNo;
	}

	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	public Integer getTranType() {
		return tranType;
	}

	public void setTranType(Integer tranType) {
		this.tranType = tranType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public RetailMember getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(RetailMember memberInfo) {
		this.memberInfo = memberInfo;
	}

	public List<RetailLine> getLines() {
		return lines;
	}

	public void setLines(List<RetailLine> lines) {
		this.lines = lines;
	}

	public List<RetailPayment> getPayments() {
		return payments;
	}

	public void setPayments(List<RetailPayment> payments) {
		this.payments = payments;
	}

}
