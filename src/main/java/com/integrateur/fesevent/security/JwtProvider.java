package com.integrateur.fesevent.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.Exception.SpringRedditException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import static io.jsonwebtoken.Jwts.parser;

@Service
public class JwtProvider {

	private KeyStore keyStore;
	@Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;
	
	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
		} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			throw new SpringRedditException("Exception occured while retrieving public key from keystore", e);
		}
	}
	
	public String generateToken(Authentication authentication) {
		User user = (User)authentication.getPrincipal();
		return Jwts.builder().setSubject(user.getUsername()).signWith(getprivatekey()).setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis))).compact();
	}
	
	public String generateTokenWithUsername(String name) {
		return Jwts.builder().setSubject(name).signWith(getprivatekey()).setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis))).compact();
	}

	private Key getprivatekey() {
		try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringRedditException("Exception occured while retrieving public key from keystore", e);
        }
	}
	
	public boolean validateToken(String token) {
		parser().setSigningKey(getpublickey()).parseClaimsJws(token);
		return true;
	}

	private PublicKey getpublickey() {
		try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringRedditException("Exception occured while retrieving public key from keystore", e);
        }
	}

	public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(getpublickey()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
	
	public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
}
