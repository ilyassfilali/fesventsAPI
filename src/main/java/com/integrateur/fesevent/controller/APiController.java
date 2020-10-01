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
@RequestMapping(value = "/apifesevents/resources/")
public class APiController {
	@Autowired
	private Services service;	
	
	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	@ResponseBody
	public void setrestaurant(@RequestBody Restaurant restaurant){
		service.addRestaurant(restaurant);
	}
	
	
	@RequestMapping(value="/restaurants", method = RequestMethod.GET)
	@ResponseBody
	public List<Restaurant> restaurants(){
		return service.getallRestaurants();
	}
}
