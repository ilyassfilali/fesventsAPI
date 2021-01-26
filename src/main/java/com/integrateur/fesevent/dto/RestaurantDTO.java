package com.integrateur.fesevent.dto;

public class RestaurantDTO {

	private String nomRes;
	private String tel;
	private String spesialite;
	private String email;
	private String site;
	private String imgPath;
	
	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
