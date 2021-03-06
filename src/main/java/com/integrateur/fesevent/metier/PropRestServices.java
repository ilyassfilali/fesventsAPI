package com.integrateur.fesevent.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.AdressRep;
import com.integrateur.fesevent.dao.ProRestaurRep;
import com.integrateur.fesevent.dao.RestauRep;
import com.integrateur.fesevent.dto.AdressDTO;
import com.integrateur.fesevent.dto.RestaurantDTO;
import com.integrateur.fesevent.modules.PropRestaurant;
import com.integrateur.fesevent.modules.Restaurant;
import com.integrateur.fesevent.modules.RestaurantAdress;

@Service
public class PropRestServices {

	@Autowired
	private ProRestaurRep proRestaurRep;
	@Autowired
	private AdressRep adressRep;
	@Autowired
	private RestauRep restauRep;
	@Autowired
	private AuthService authService;
	
	public void modifyRestaurant(String email, RestaurantDTO restaurant) {
		PropRestaurant propRestaurant = proRestaurRep.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User name not found"));;
		Restaurant r = propRestaurant.getRestaurant();
		r.setEmail(restaurant.getEmail());
		r.setNomRes(restaurant.getNomRes());
		r.setImgPath(restaurant.getImgPath());
		r.setTel(restaurant.getTel());
		r.setSpesialite(restaurant.getSpesialite());
		restauRep.save(r);
	}
	
	public void addAdress(String email, String adress) {
		PropRestaurant propRestaurant = proRestaurRep.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User name not found"));;
		Restaurant r = propRestaurant.getRestaurant();
		RestaurantAdress a = new RestaurantAdress();
		a.setRestaurant(r);
		a.setAdress(adress);
		r.getAdress().add(a);
		restauRep.save(r);
	}

	public Restaurant getRestaurant(String email) {
		return proRestaurRep.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User name not found")).getRestaurant();
	}
	
	public void delet(AdressDTO address) {
		RestaurantAdress a = adressRep.findByadress(address.getAdress()).orElseThrow(() -> new UsernameNotFoundException("adress not found"));
		adressRep.delete(a);
	}
}
