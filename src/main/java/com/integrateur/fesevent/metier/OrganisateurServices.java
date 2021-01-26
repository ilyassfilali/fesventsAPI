package com.integrateur.fesevent.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.EventRep;
import com.integrateur.fesevent.dao.OrganisateurRep;
import com.integrateur.fesevent.dto.EventDTO;
import com.integrateur.fesevent.modules.Event;
import com.integrateur.fesevent.modules.Organisateur;

@Service
public class OrganisateurServices {

	@Autowired
	private OrganisateurRep organisateurRep;
	@Autowired
	private EventRep eventRep;
	@Autowired
	private AuthService authService;
	
	public void addevent(String email, EventDTO e) {
		//Organisateur organisateur = authService.getCurrentorg();
		Organisateur organisateur = organisateurRep.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
		Event event = Mapping.mapEvent(e);
		event.setOrganisateur(organisateur);
		organisateur.getEvents().add(event);
		organisateurRep.save(organisateur);
	}
	
	public List<Event> geteventbyorg() {
		/*Organisateur o = authService.getCurrentorg();
		System.out.println(o.getEmail());
		return eventRep.findByorganisateur(o);*/
		List<Event> events = new ArrayList<Event>();
		eventRep.findAll().forEach(events::add);
		return events;
	}

	public List<Event> getevents() {
		List<Event> events = new ArrayList<Event>();
		eventRep.findAll().forEach(events::add);
		return events;
	}
	
	public List<Event> geteventbyorg(String id) {
		Organisateur o = organisateurRep.findByEmail(id).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
		return eventRep.findByorganisateur(o);
	}
	
	public void deltevent(EventDTO e) {
		Event event = eventRep.findById(e.getId()).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
		eventRep.delete(event);
	}
	
	
}
