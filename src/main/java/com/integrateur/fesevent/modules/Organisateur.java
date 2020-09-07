package com.integrateur.fesevent.modules;

import java.util.Vector;

public class Organisateur {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private Vector<Event> events;
	
	public Organisateur() {
		events = new Vector<>();
	}

	public Organisateur(int id, String nom, String prenom, String email, Vector<Event> events) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.events = new Vector<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	

}
