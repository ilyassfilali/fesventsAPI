package com.integrateur.fesevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.metier.OrganisteurServices;
import com.integrateur.fesevent.modules.Event;

@RestController
@RequestMapping(value = "/api/Organisateur/")
public class OrganisateurController {

	@Autowired
	private OrganisteurServices orgservice;
	
	public OrganisateurController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("addevent")
	public void addevent(@RequestBody Event event) {
		orgservice.addevent(event);
	}

}
