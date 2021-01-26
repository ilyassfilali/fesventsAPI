package com.integrateur.fesevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.dto.EventDTO;
import com.integrateur.fesevent.metier.OrganisateurServices;
import com.integrateur.fesevent.modules.Event;

@RestController
@RequestMapping(value = "/api/Organisateur/")
public class OrganisateurController {

	@Autowired
	private OrganisateurServices orgservice;
	
	@GetMapping("events/")
	public List<Event> getallevent() {
		return orgservice.getevents();
	}
	
	@GetMapping("events/{email}")
	public List<Event> getevent(@PathVariable String email) {
		return orgservice.geteventbyorg(email);
	}
	
	@PostMapping("addevent/{email}")
	public void addevent(@PathVariable String email, @RequestBody EventDTO event) {
		orgservice.addevent(email, event);
	}
	
	@DeleteMapping("delevents/")
	public void delevent(@RequestBody EventDTO event) {
		orgservice.deltevent(event);
	}
	
 
}
