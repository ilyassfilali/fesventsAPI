package com.integrateur.fesevent.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.ProRestaurRep;
import com.integrateur.fesevent.dao.RestauRep;
import com.integrateur.fesevent.modules.PropRestaurant;
import com.integrateur.fesevent.modules.Restaurant;
import com.integrateur.fesevent.modules.RestaurantAdress;

@Service
public class PropRestServices {

	@Autowired
	private ProRestaurRep proRestaurRep;
	@Autowired
	private RestauRep restauRep;
	@Autowired
	private AuthService authService;
	
	public void modifyRestaurant(Restaurant restaurant) {
		PropRestaurant propRestaurant = authService.getCurrentres();
		Restaurant r = propRestaurant.getRestaurant();
		r.setEmail(restaurant.getEmail());
		r.setNomRes(restaurant.getNomRes());
		r.setImgPath(restaurant.getImgPath());
		r.setTel(restaurant.getTel());
		r.setSpesialite(restaurant.getSpesialite());
		restauRep.save(r);
	}
	
	public void addAdress(RestaurantAdress adress) {
		PropRestaurant propRestaurant = authService.getCurrentres();
		Restaurant r = propRestaurant.getRestaurant();
		adress.setRestaurant(r);
		r.getAdress().add(adress);
		restauRep.save(r);
	}

	public Restaurant getRestaurant() {
		return authService.getCurrentres().getRestaurant();
	}
}
