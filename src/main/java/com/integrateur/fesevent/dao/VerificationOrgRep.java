package com.integrateur.fesevent.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.VerificationTokenOrg;

public interface VerificationOrgRep extends CrudRepository<VerificationTokenOrg,Integer>{

	public Optional<VerificationTokenOrg> findByToken(String token);
}
