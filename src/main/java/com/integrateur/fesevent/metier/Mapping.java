package com.integrateur.fesevent.metier;

import com.integrateur.fesevent.dto.AdressDTO;
import com.integrateur.fesevent.dto.EventDTO;
import com.integrateur.fesevent.dto.RestaurantDTO;
import com.integrateur.fesevent.dto.SignupOrg;
import com.integrateur.fesevent.modules.Event;
import com.integrateur.fesevent.modules.Organisateur;
import com.integrateur.fesevent.modules.Restaurant;
import com.integrateur.fesevent.modules.RestaurantAdress;

public class Mapping {

	public Mapping() {
		// TODO Auto-generated constructor stub
	}

	static public Event mapEvent(EventDTO e) {
		Event event = new Event();
		event.setAdress(e.getAdress());
		event.setDateD(e.getDateD());
		event.setDateF(e.getDateF());
		event.setDescription(e.getDescription());
		event.setTel(e.getTel());
		return event;
	}
	
	static public Organisateur mapOrg(SignupOrg org) {
		Organisateur or = new Organisateur(org.getNom(),org.getPrenom(),org.getEmail(),"");
		return or;
	}
	
	static public Restaurant mapRest(RestaurantDTO dto) {
		Restaurant r = new Restaurant(dto.getNomRes(),dto.getTel(),dto.getEmail());
		return r;
	}
	
	static public RestaurantAdress mapAdress(AdressDTO dto) {
		RestaurantAdress a = new RestaurantAdress();
		a.setAdress(dto.getAdress());
		return a;
	}
}
