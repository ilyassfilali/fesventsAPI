package com.integrateur.fesevent.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.Organisateur;

public interface OrganisateurRep extends CrudRepository<Organisateur, Integer> {
	Optional<Organisateur> findByEmail(String email);
}
