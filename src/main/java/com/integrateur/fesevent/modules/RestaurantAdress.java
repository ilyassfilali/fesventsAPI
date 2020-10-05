package com.integrateur.fesevent.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RestaurantAdress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adress;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	
	
	public RestaurantAdress() {
	}


	public RestaurantAdress(int id, String adress, Restaurant restaurant) {
		super();
		this.id = id;
		this.adress = adress;
		this.restaurant = restaurant;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getRestaurantid() {
		return restaurant.getId();
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
