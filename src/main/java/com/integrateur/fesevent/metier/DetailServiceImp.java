package com.integrateur.fesevent.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.dao.OrganisateurRep;
import com.integrateur.fesevent.dao.ProRestaurRep;
import com.integrateur.fesevent.modules.Organisateur;
import com.integrateur.fesevent.modules.PropRestaurant;
import static java.util.Collections.singletonList;

@Service
public class DetailServiceImp  implements UserDetailsService{

	@Autowired
	private ProRestaurRep proRestaurRep;
	@Autowired
	private OrganisateurRep organisateurRep;
	
	@Override
	public UserDetails loadUserByUsername(String email)  {
		/*PasswordEncoder  passwd = new BCryptPasswordEncoder();
		if(email.equals("invite")) {
			return new org.springframework.security
	                .core.userdetails.User(email,passwd.encode(""),true,
	                		true, true,
	                        true, getAuthorities("invit"));
		}*/
		Organisateur organisateur = getorganisateur(email);
		if(organisateur != null) {
			return new org.springframework.security.core.userdetails.User(organisateur.getEmail(),organisateur.getPasswd(),organisateur.isVerify(),true, true,true, getAuthorities("Org"));
		}
		PropRestaurant prop = getPropRestaurant(email);
		return new org.springframework.security.core.userdetails.User(prop.getEmail(),prop.getPasswd(),prop.isVerify(),true, true,true, getAuthorities("Proprest"));
	}
	
	public PropRestaurant getPropRestaurant(String email) {
		Optional<PropRestaurant> proprestau = proRestaurRep.findByEmail(email);
		PropRestaurant propRestaurant =null;
		try {
			propRestaurant = proprestau.get();
		}catch (Exception e) {
		}
		return propRestaurant;
	}

	public Organisateur getorganisateur(String email) {
		Optional<Organisateur> optional = organisateurRep.findByEmail(email);
		Organisateur organisateur = null;
		try {
			organisateur = optional.get();
		} catch (Exception e) {
		}
		return organisateur;
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return singletonList(new SimpleGrantedAuthority(role));
	}

}
