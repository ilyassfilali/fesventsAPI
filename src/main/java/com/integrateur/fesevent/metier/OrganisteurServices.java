package com.integrateur.fesevent.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.EventRep;
import com.integrateur.fesevent.dao.OrganisateurRep;
import com.integrateur.fesevent.modules.Event;
import com.integrateur.fesevent.modules.Organisateur;

@Service
public class OrganisteurServices {

	@Autowired
	private OrganisateurRep organisateurRep;
	@Autowired
	private EventRep eventRep;
	@Autowired
	private AuthService authService;
	
	public void addevent(Event event) {
		Organisateur organisateur = authService.getCurrentorg();
		event.setOrganisateur(organisateur);
		organisateur.getEvents().add(event);
		organisateurRep.save(organisateur);
	}
	
}
