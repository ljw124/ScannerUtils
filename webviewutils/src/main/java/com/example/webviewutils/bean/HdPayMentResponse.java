package com.example.webviewutils.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class HdPayMentResponse implements Serializable {

	// 响应代码
	private String echoCode;
	// 响应信息
	private String echoMessage;
	// 支付渠道
	private PayChannel payChannel;
	// 支付系统流水号
	private String payNo;
	// 下单金额
	private BigDecimal amount;
	// 实际扣款金额
	private BigDecimal payAmount;
	// 优惠金额
	private BigDecimal favAmount;
	// 不开票金额（根据支付方式来设置：现在是除了翼支付为0，其他都等于实际扣款金额）
	private BigDecimal noInvoiceAmount;
	// 是否分摊优惠到商品
	private String favApportion;
	// 分摊商品优惠明细
	private List<GoodsFav> goodsfavList;
	// 支付商品分账明细
	private List<PaySubAccount> payGdSubLineList;
	// 支付状态
	private String payState;
	// 调用返回值
	private PayMentResult payMentResult;

	private List<Goodsh> goodsList;

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public String getEchoCode() {
		return echoCode;
	}

	public void setEchoCode(String echoCode) {
		this.echoCode = echoCode;
	}

	public String getEchoMessage() {
		return echoMessage;
	}

	public void setEchoMessage(String echoMessage) {
		this.echoMessage = echoMessage;
	}

	public PayChannel getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(PayChannel payChannel) {
		this.payChannel = payChannel;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getFavAmount() {
		return favAmount;
	}

	public void setFavAmount(BigDecimal favAmount) {
		this.favAmount = favAmount;
	}

	public String getFavApportion() {
		return favApportion;
	}

	public void setFavApportion(String favApportion) {
		this.favApportion = favApportion;
	}

	public List<GoodsFav> getGoodsfavList() {
		return goodsfavList;
	}

	public void setGoodsfavList(List<GoodsFav> goodsfavList) {
		this.goodsfavList = goodsfavList;
	}

	public List<PaySubAccount> getPayGdSubLineList() {
		return payGdSubLineList;
	}

	public void setPayGdSubLineList(List<PaySubAccount> payGdSubLineList) {
		this.payGdSubLineList = payGdSubLineList;
	}

	public PayMentResult getPayMentResult() {
		return payMentResult;
	}

	public void setPayMentResult(PayMentResult payMentResult) {
		this.payMentResult = payMentResult;
	}

	public BigDecimal getNoInvoiceAmount() {
		return noInvoiceAmount;
	}

	public void setNoInvoiceAmount(BigDecimal noInvoiceAmount) {
		this.noInvoiceAmount = noInvoiceAmount;
	}

	public List<Goodsh> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goodsh> goodsList) {
		this.goodsList = goodsList;
	}

}
