package com.integrateur.fesevent.dto;

public class AuthResponseToken {
	
	private String authToken;
	private String email;
	
	public AuthResponseToken() {
		// TODO Auto-generated constructor stub
	}

	public AuthResponseToken(String authToken, String email) {
		super();
		this.authToken = authToken;
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

}
