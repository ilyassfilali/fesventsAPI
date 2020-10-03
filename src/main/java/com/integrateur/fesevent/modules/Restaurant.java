package com.integrateur.fesevent.modules;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomRes;
	private String tel;
	private String spesialite;
	@OneToMany( mappedBy = "restaurant" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RestaurantAdress> adress = new ArrayList<>();
	private String email;
	private String imgPath;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(int id, String nomRes, String tel, List<RestaurantAdress> adress, String email) {
		super();
		this.id = id;
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

	public List<RestaurantAdress> getAdress() {
		return adress;
	}
	
	public void setAdress(List<RestaurantAdress> adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
