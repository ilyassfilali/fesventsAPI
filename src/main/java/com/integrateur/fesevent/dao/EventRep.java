package com.integrateur.fesevent.dao;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.Event;

public interface EventRep extends CrudRepository<Event, Integer> {

}
