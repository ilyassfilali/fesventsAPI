package com.integrateur.fesevent.modules;

import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Organisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String passwd;
	@OneToMany(mappedBy = "organisateur" , fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Event> events;
	private boolean verify;
	
	public Organisateur() {
		events = new Vector<>();
	}

	public Organisateur(String nom, String prenom, String email,String pass) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.passwd = pass;
		this.events = new Vector<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * @return the verify
	 */
	public boolean isVerify() {
		return verify;
	}

	/**
	 * @param verify the verify to set
	 */
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	
	

}
