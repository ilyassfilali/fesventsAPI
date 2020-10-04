package com.integrateur.fesevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.metier.PropRestServices;
import com.integrateur.fesevent.modules.PropRestaurant;

@RestController
@RequestMapping(value = "/api/PropRest/")
public class PropRestController {

	@Autowired
	private PropRestServices propRestServices;
	
	public PropRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping
	public void updateinfo(@RequestBody PropRestaurant propRestaurant) {
		
	}

}
