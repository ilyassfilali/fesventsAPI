package com.integrateur.fesevent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.integrateur.fesevent.modules.Restaurant;

public interface RestauRep extends CrudRepository<Restaurant, Integer>{
}
