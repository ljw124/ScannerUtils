package com.example.scannertest.bean;

import java.io.Serializable;

public class ResultData implements Serializable {

	private static final long serialVersionUID = 1L;

	// 商户号
	private String merchantId;
	// 商户总订单号
	private String orderNo;
	// 商户总订单请求流水号
	private String orderReqNo;
	// 预留字段
	private String orderDate;
	// 翼支付交易号
	private String ourTransNo;
	// 订单金额
	private String transAmt;
	// 交易状态
	private String transStatus;
	// 签名方式
	private String encodeType;
	// sign校验域
	private String sign;
	// 退款标识 (0代表为退款，1 已退款2部分退款 3已冲正)
	private String refundFlag;

	private String customerId;

	private String productDesc;

	private String payChannel;

	private String payerAccount;

	private String payeeAccount;

	private String respCode;

	private String respDesc;
	private String coupon;// 优惠金额 订单优惠金 额，用户使代券或立减的金额，金额为分
	private String scValue;// 商户营销优惠成本 商户营销优惠成本
	private String mchntTmNum; // 商户自定义终端号
	private String deviceTmNum;// 设备终端号
	private String attach;

	// 新增
	private String transPhone;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderReqNo() {
		return orderReqNo;
	}

	public void setOrderReqNo(String orderReqNo) {
		this.orderReqNo = orderReqNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOurTransNo() {
		return ourTransNo;
	}

	public void setOurTransNo(String ourTransNo) {
		this.ourTransNo = ourTransNo;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getEncodeType() {
		return encodeType;
	}

	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getRefundFlag() {
		return refundFlag;
	}

	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getScValue() {
		return scValue;
	}

	public void setScValue(String scValue) {
		this.scValue = scValue;
	}

	public String getMchntTmNum() {
		return mchntTmNum;
	}

	public void setMchntTmNum(String mchntTmNum) {
		this.mchntTmNum = mchntTmNum;
	}

	public String getDeviceTmNum() {
		return deviceTmNum;
	}

	public void setDeviceTmNum(String deviceTmNum) {
		this.deviceTmNum = deviceTmNum;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTransPhone() {
		return transPhone;
	}

	public void setTransPhone(String transPhone) {
		this.transPhone = transPhone;
	}

}
