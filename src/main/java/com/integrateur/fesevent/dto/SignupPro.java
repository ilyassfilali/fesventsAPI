package com.integrateur.fesevent.dto;

public class SignupPro {

	private String nom;
	private String prenom;
	private String email;
	private String passwd;
	private String nomres;
	public SignupPro() {
		
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
	public String getNomres() {
		return nomres;
	}
	public void setNomres(String nomres) {
		this.nomres = nomres;
	}

}
