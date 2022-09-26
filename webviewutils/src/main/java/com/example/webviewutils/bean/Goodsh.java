package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Goodsh implements Serializable {

	private Integer gid;

	private String code;

	private String name;

	private String sort;

	private String spec;

	private String munit;

	private BigDecimal qpc;

	private BigDecimal rtlprc;

	private String[] ids;

	private String parentCode;

	private String[] parentCodes;

	private String[] codes;

	// 查询限制中类时放入1
	private String sign;

	private String parentName;

	private Date addTime;

	private String creator;

	private BigDecimal qty;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getMunit() {
		return munit;
	}

	public void setMunit(String munit) {
		this.munit = munit;
	}

	public BigDecimal getQpc() {
		return qpc;
	}

	public void setQpc(BigDecimal qpc) {
		this.qpc = qpc;
	}

	public BigDecimal getRtlprc() {
		return rtlprc;
	}

	public void setRtlprc(BigDecimal rtlprc) {
		this.rtlprc = rtlprc;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String[] getParentCodes() {
		return parentCodes;
	}

	public void setParentCodes(String[] parentCodes) {
		this.parentCodes = parentCodes;
	}

	public String[] getCodes() {
		return codes;
	}

	public void setCodes(String[] codes) {
		this.codes = codes;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

}
