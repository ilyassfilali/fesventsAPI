package com.integrateur.fesevent.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.VerificationTokenPropR;



public interface VerificationPropRep extends CrudRepository<VerificationTokenPropR,Integer> {
	public Optional<VerificationTokenPropR> findByToken(String token);
}
