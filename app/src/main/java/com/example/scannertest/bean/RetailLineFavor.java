package com.example.scannertest.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class RetailLineFavor implements Serializable {

	// 优惠行编号
	private Integer lineNumber;
	// 商品行编号
	private Integer gdLineNumber;
	// 优惠类型
	private String favType;
	// 优惠金额
	private BigDecimal favAmount;
	// 优惠来源单号
	private String favSrcNum;

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

	public String getFavType() {
		return favType;
	}

	public void setFavType(String favType) {
		this.favType = favType;
	}

	public BigDecimal getFavAmount() {
		return favAmount;
	}

	public void setFavAmount(BigDecimal favAmount) {
		this.favAmount = favAmount;
	}

	public String getFavSrcNum() {
		return favSrcNum;
	}

	public void setFavSrcNum(String favSrcNum) {
		this.favSrcNum = favSrcNum;
	}

}
