package com.integrateur.fesevent.metier;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.Exception.SpringRedditException;
import com.integrateur.fesevent.dao.RefreshTokenRepository;
import com.integrateur.fesevent.dto.RefreshTokenReq;
import com.integrateur.fesevent.modules.RefreshToken;

@Service
public class RefreshtokenServices {

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return refreshTokenRepository.save(refreshToken);
    }

    void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new SpringRedditException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
