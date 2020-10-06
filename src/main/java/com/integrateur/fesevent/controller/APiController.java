package com.integrateur.fesevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.metier.Services;
import com.integrateur.fesevent.modules.Restaurant;

@RestController
@RequestMapping(value = "/api/")
public class APiController {
	@Autowired
	private Services service;	
	
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> restaurants(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getallRestaurants());
	}
}
