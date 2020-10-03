package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dateD;
	private String dateF;
	private String description;
	private String tel;
	private String adress;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "organisateur_id",nullable = false)
	private Organisateur organisateur;
	
	public Event() {
	}

	public Event(int id, String dateD, String dateF, String description, String tel, String adress) {
		super();
		this.id = id;
		this.dateD = dateD;
		this.dateF = dateF;
		this.description = description;
		this.tel = tel;
		this.adress = adress;
	}
	public Integer getId() {
		return id;
	}

	public String getDateD() {
		return dateD;
	}

	public void setDateD(String dateD) {
		this.dateD = dateD;
	}

	public String getDateF() {
		return dateF;
	}

	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getOrganisateur() {
		return organisateur.getId();
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
