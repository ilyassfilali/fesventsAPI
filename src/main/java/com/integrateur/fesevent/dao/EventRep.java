package com.integrateur.fesevent.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.Event;
import com.integrateur.fesevent.modules.Organisateur;

public interface EventRep extends CrudRepository<Event, Integer> {
	List<Event> findByorganisateur(Organisateur organisateur );
}
