package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dateD;
	private String dateF;
	private String offre;
	private int rid;
	
	
	public Offre() {
		// TODO Auto-generated constructor stub
	}

	public Offre(int id, String dateD, String dateF, String offre, int fid) {
		super();
		this.id = id;
		this.dateD = dateD;
		this.dateF = dateF;
		this.offre = offre;
		this.rid = fid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getOffre() {
		return offre;
	}

	public void setOffre(String offre) {
		this.offre = offre;
	}

	public int getFid() {
		return rid;
	}

	public void setFid(int fid) {
		this.rid = fid;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", dateD=" + dateD + ", dateF=" + dateF + ", offre=" + offre + ", fid=" + rid + "]";
	}

}
