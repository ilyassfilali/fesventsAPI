package com.integrateur.fesevent.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.RestauRep;
import com.integrateur.fesevent.modules.Restaurant;

@Service
public class Services {
	
	@Autowired
	private RestauRep restauRep;
	
	//@Autowired
	
	public List<Restaurant> getallRestaurants(){
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restauRep.findAll().forEach(restaurants::add);
		return restaurants;
	}
	
	
	public void addRestaurant(Restaurant res) {
		restauRep.save(res);
	}
}
