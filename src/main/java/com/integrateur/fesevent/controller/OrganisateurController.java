package com.integrateur.fesevent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("events/")
	public List<Event> getallevent() {
		return orgservice.getevents();
	}
	
	@GetMapping("events/{email}")
	public List<Event> getevent(@PathVariable String email) {
		return orgservice.geteventbyorg(email);
	}
	
	@PostMapping("addevent/{email}")
	public void addevent(@PathVariable String email, @RequestBody Event event) {
		System.out.println(email);
		System.out.println(event.getAdress());
		orgservice.addevent(email, event);
	}
	
	@PostMapping("delevent/{email}")
	public void delevent(@PathVariable String email,@RequestBody Event event) {
		orgservice.delevent(email,event);
	}
 
}
