package com.integrateur.fesevent.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.RestaurantAdress;

public interface AdressRep extends CrudRepository<RestaurantAdress, Integer> {
	Optional<RestaurantAdress> findByadress(String adress);
}
