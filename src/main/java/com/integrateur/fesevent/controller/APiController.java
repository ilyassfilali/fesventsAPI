package com.integrateur.fesevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.metier.Services;
import com.integrateur.fesevent.modules.Client;
import com.integrateur.fesevent.modules.Restaurant;

@RestController
public class APiController {
	@Autowired
	private Services service;
	
	@RequestMapping("/api/clients")
	public List<Client> clients(){
		return service.getallclients();
	}
	
	
	@RequestMapping("/api/restaurant/{name}")
	public List<Restaurant> allrestaurant(@PathVariable String name){
		//return service.getrestaubyName(name);
		return null;
	}
	
	@RequestMapping("/api/restaurants")
	public List<Restaurant> restaurants(){
		return service.getallRestaurants();
	}
}
