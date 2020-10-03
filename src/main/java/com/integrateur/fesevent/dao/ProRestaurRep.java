package com.integrateur.fesevent.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.PropRestaurant;

public interface ProRestaurRep  extends CrudRepository<PropRestaurant,Integer>{
	Optional<PropRestaurant> findByEmail(String email);
}
