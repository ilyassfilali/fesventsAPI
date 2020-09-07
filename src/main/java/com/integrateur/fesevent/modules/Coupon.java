package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


public class Coupon extends Offre {
	
	private int id;
	private int code;
	
	public Coupon() {
		super();
	}

	public Coupon(int id, String dateD, String dateF, String offre, int fid, int id2, int code) {
		super(id, dateD, dateF, offre, fid);
		id = id2;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", code=" + code + "]";
	}
	
}
