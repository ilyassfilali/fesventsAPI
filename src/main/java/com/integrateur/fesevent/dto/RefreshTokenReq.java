package com.integrateur.fesevent.dto;


public class RefreshTokenReq {
	private String refreshtoken;
	private String email;
	
	public RefreshTokenReq() {
		// TODO Auto-generated constructor stub
	}
	
	public RefreshTokenReq(String refreshtoken, String email) {
		super();
		this.refreshtoken = refreshtoken;
		this.email = email;
	}

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
