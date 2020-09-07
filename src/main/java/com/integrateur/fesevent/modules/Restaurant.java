package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomPro;
	private String nomRes;
	private String tel;
	private String spesialite;
	private String adress;
	private String email;
	private String imgPath;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(int id, String nomPro, String nomRes, String tel, String adress, String email) {
		super();
		this.id = id;
		this.nomPro = nomPro;
		this.nomRes = nomRes;
		this.tel = tel;
		this.adress = adress;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomPro() {
		return nomPro;
	}
	
	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}
	
	public String getNomRes() {
		return nomRes;
	}
	
	public void setNomRes(String nomRes) {
		this.nomRes = nomRes;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getSpesialite() {
		return spesialite;
	}

	public void setSpesialite(String spesialite) {
		this.spesialite = spesialite;
	}

	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
