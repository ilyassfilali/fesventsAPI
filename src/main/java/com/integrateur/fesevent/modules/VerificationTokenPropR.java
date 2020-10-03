package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VerificationTokenPropR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String token;
	@OneToOne(fetch = FetchType.LAZY)
	private PropRestaurant propRestaurant;
	
	
	public VerificationTokenPropR() {
	}

	public VerificationTokenPropR(int id, String token, PropRestaurant propRestaurant) {
		super();
		this.id = id;
		this.token = token;
		this.propRestaurant = propRestaurant;
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

	public PropRestaurant getPropRestaurant() {
		return propRestaurant;
	}

	public void setPropRestaurant(PropRestaurant propRestaurant) {
		this.propRestaurant = propRestaurant;
	}

}
