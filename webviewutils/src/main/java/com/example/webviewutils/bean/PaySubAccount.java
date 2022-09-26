package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaySubAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	// 分账行编号
	private int lineNumber;
	// 商品行编号
	private int gdLineNumber;
	// 分账类型
	private String subType;
	// 分账金额
	private BigDecimal subAmount;
	// 分账来源单号
	private String subSrcNum;
	// 商品Gid
	private Integer goodsGid;

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getGdLineNumber() {
		return gdLineNumber;
	}

	public void setGdLineNumber(int gdLineNumber) {
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

	public Integer getGoodsGid() {
		return goodsGid;
	}

	public void setGoodsGid(Integer goodsGid) {
		this.goodsGid = goodsGid;
	}

}