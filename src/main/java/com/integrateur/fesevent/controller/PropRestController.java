package com.integrateur.fesevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	@GetMapping("restauinfo/{email}")
	public ResponseEntity<Restaurant> getinfo(@PathVariable String email,@RequestBody PropRestaurant propRestaurant) {
		return ResponseEntity.status(HttpStatus.OK).body(propRestServices.getRestaurant(email));
	}
	
	@PostMapping("restrauUpdate/{email}")
	public void setRestaurant(@PathVariable String email,@RequestBody Restaurant restaurant) {
		propRestServices.modifyRestaurant(email, restaurant);
	}
	
	@PostMapping("newadress/{email}")
	public void addadress(@PathVariable String email,@RequestBody RestaurantAdress adress) {
		propRestServices.addAdress(email,adress);
	}

}
