package com.integrateur.fesevent.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.integrateur.fesevent.modules.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,Integer> {

	Optional<RefreshToken> findByToken(String token);
	
	void deleteByToken(String token);
}
