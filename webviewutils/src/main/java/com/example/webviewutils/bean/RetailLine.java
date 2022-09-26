package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class RetailLine implements Serializable {

	// 明细行编号
	private String lineNumber;
	// 商品GID(商品的唯一键）
	private String gid;
	// 商品代码
	private String code;
	// 商品名称
	private String name;
	// 商品大类代码
	private String bsort;
	// 商品中类代码
	private String msort;
	// 商品小类代码
	private String ssort;
	// 销售数量
	private BigDecimal qty;
	// 包装数量
	private BigDecimal iqty;
	// 商品零售价
	private BigDecimal rtlprc;
	// 标准销售金额=零售价*销售数量
	private BigDecimal amount;
	// 实际销售金额(计算优惠后的销售金额)
	private BigDecimal realAmount;
	// 商品分账明细
	private List<RetailLineAccount> retailLineAccountList;
	// 商品优惠明细
	private List<RetailLineFavor> retailLineFavorList;

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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

	public String getBsort() {
		return bsort;
	}

	public void setBsort(String bsort) {
		this.bsort = bsort;
	}

	public String getMsort() {
		return msort;
	}

	public void setMsort(String msort) {
		this.msort = msort;
	}

	public String getSsort() {
		return ssort;
	}

	public void setSsort(String ssort) {
		this.ssort = ssort;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getIqty() {
		return iqty;
	}

	public void setIqty(BigDecimal iqty) {
		this.iqty = iqty;
	}

	public BigDecimal getRtlprc() {
		return rtlprc;
	}

	public void setRtlprc(BigDecimal rtlprc) {
		this.rtlprc = rtlprc;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public List<RetailLineAccount> getRetailLineAccountList() {
		return retailLineAccountList;
	}

	public void setRetailLineAccountList(List<RetailLineAccount> retailLineAccountList) {
		this.retailLineAccountList = retailLineAccountList;
	}

	public List<RetailLineFavor> getRetailLineFavorList() {
		return retailLineFavorList;
	}

	public void setRetailLineFavorList(List<RetailLineFavor> retailLineFavorList) {
		this.retailLineFavorList = retailLineFavorList;
	}

}
