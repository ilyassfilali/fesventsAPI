package com.integrateur.fesevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.metier.PropRestServices;
import com.integrateur.fesevent.modules.PropRestaurant;
import com.integrateur.fesevent.modules.Restaurant;
import com.integrateur.fesevent.modules.RestaurantAdress;

@RestController
@RequestMapping(value = "/api/PropRest/")
public class PropRestController {

	@Autowired
	private PropRestServices propRestServices;

	
	@GetMapping("restauinfo")
	public ResponseEntity<Restaurant> getinfo(@RequestBody PropRestaurant propRestaurant) {
		return ResponseEntity.status(HttpStatus.OK).body(propRestServices.getRestaurant());
	}
	
	@PostMapping("restrauUpdate")
	public void setRestaurant(@RequestBody Restaurant restaurant) {
		propRestServices.modifyRestaurant(restaurant);
	}
	
	@PostMapping("newadress")
	public void addadress(@RequestBody RestaurantAdress adress) {
		propRestServices.addAdress(adress);
	}

}
