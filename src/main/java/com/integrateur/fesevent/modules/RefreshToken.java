package com.integrateur.fesevent.modules;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RefreshToken {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String token;
    private Instant createdDate;
    
    public RefreshToken() {
		// TODO Auto-generated constructor stub
	}

	public RefreshToken(int id, String token, Instant createdDate) {
		super();
		this.id = id;
		this.token = token;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
    
    
}
