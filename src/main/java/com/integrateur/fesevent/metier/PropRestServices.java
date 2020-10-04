package com.integrateur.fesevent.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.ProRestaurRep;
import com.integrateur.fesevent.modules.PropRestaurant;

@Service
public class PropRestServices {

	@Autowired
	private ProRestaurRep proRestaurRep;
	
	

}
