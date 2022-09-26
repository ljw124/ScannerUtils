package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsFav implements Serializable {

	private static final long serialVersionUID = 1L;

	// 商品行号
	private Integer lineNumber;
	// 分账类型
	private String favType;
	// 分账金额
	private BigDecimal amount;
	// 分账来源单号
	private String favSrcNum;
	// 商品Gid
	private Integer goodsGid;

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getFavType() {
		return favType;
	}

	public void setFavType(String favType) {
		this.favType = favType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFavSrcNum() {
		return favSrcNum;
	}

	public void setFavSrcNum(String favSrcNum) {
		this.favSrcNum = favSrcNum;
	}

	public Integer getGoodsGid() {
		return goodsGid;
	}

	public void setGoodsGid(Integer goodsGid) {
		this.goodsGid = goodsGid;
	}

}
