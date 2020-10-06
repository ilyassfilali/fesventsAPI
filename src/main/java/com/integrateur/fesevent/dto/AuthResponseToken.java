package com.integrateur.fesevent.dto;

public class AuthResponseToken {
	
	private String authToken;
	private String refreshtoken;
	private String expireAt;
	private String email;
	
	public AuthResponseToken() {
		// TODO Auto-generated constructor stub
	}

	public AuthResponseToken(String authToken, String refreshtoken, String expireAt, String email) {
		super();
		this.authToken = authToken;
		this.refreshtoken = refreshtoken;
		this.expireAt = expireAt;
		this.email = email;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}

}
