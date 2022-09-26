package com.example.webviewutils.bean;

import java.io.Serializable;

public class RetailMember implements Serializable {

	// 会员ID
	private String memberId;
	// 会员卡号
	private String memberCode;
	// 卡类型
	private String cardType;
	// 会员生日(yyyy.mm.dd)
	private String birthday;
	// 会员到效期(yyyy.mm.dd)
	private String expireDate;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getCardType() {
		return cardType;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
