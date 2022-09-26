package com.example.scannertest.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class RetailLineAccount implements Serializable {

	// 分账行编号
	private Integer lineNumber;
	// 商品行编号
	private Integer gdLineNumber;
	// 分账类型
	private String subType;
	// 分账金额
	private BigDecimal subAmount;
	// 分账来源单号
	private String subSrcNum;

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Integer getGdLineNumber() {
		return gdLineNumber;
	}

	public void setGdLineNumber(Integer gdLineNumber) {
		this.gdLineNumber = gdLineNumber;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public BigDecimal getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(BigDecimal subAmount) {
		this.subAmount = subAmount;
	}

	public String getSubSrcNum() {
		return subSrcNum;
	}

	public void setSubSrcNum(String subSrcNum) {
		this.subSrcNum = subSrcNum;
	}

}