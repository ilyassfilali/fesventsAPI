package com.integrateur.fesevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.metier.Services;
import com.integrateur.fesevent.modules.Client;
import com.integrateur.fesevent.modules.Restaurant;

@RestController
@RequestMapping(value = "/api/")
public class APiController {
	@Autowired
	private Services service;
	
	@RequestMapping(value = "clients", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> clients(){
		return service.getallclients();
	}
	
	
	@RequestMapping(value = "restaurant/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Restaurant> allrestaurant(@PathVariable String name){
		//return service.getrestaubyName(name);
		return null;
	}
	@RequestMapping(value="/restaurants", method = RequestMethod.GET)
	@ResponseBody
	public List<Restaurant> restaurants(){
		return service.getallRestaurants();
	}
}
