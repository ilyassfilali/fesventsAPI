package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VerificationTokenOrg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String token;
	@OneToOne(fetch = FetchType.LAZY)
	private Organisateur organisateur;
	
	public VerificationTokenOrg() {
	}

	public VerificationTokenOrg(int id, String token, Organisateur organisateur) {
		super();
		this.id = id;
		this.token = token;
		this.organisateur = organisateur;
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

	public Organisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

	
}
