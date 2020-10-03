package com.integrateur.fesevent.metier;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.integrateur.fesevent.Exception.SpringRedditException;
import com.integrateur.fesevent.dao.OrganisateurRep;
import com.integrateur.fesevent.dao.ProRestaurRep;
import com.integrateur.fesevent.dao.VerificationOrgRep;
import com.integrateur.fesevent.dao.VerificationPropRep;
import com.integrateur.fesevent.dto.AuthResponseToken;
import com.integrateur.fesevent.dto.LoginRequest;
import com.integrateur.fesevent.modules.Notification;
import com.integrateur.fesevent.modules.Organisateur;
import com.integrateur.fesevent.modules.PropRestaurant;
import com.integrateur.fesevent.modules.VerificationTokenOrg;
import com.integrateur.fesevent.modules.VerificationTokenPropR;
import com.integrateur.fesevent.security.JwtProvider;

@Service
public class AuthService {

	@Autowired
	private ProRestaurRep proRestaurRep;
	@Autowired
	private OrganisateurRep organisateurRep;
	@Autowired
	private PasswordEncoder passEncoder;
	@Autowired
	private VerificationPropRep verificationPropRep;
	@Autowired
	private VerificationOrgRep verificationOrgRep;
	@Autowired
	private MailService mailService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	
	
	//PropRestau signup
	
	public void ResSignup(PropRestaurant propRestaurant) {
		String passwd = propRestaurant.getPasswd();
		propRestaurant.setPasswd(passEncoder.encode(passwd));
		propRestaurant.setVerify(false);
		proRestaurRep.save(propRestaurant);
		String token = generateTokenRep(propRestaurant);
		Notification n = new Notification();
		n.setSubject("Activate your account");
		n.setRecipient(propRestaurant.getEmail());
		String body = "wellcome"
				+ "\n"
				+ "http://localhost:8080/api/auth/ResaccountVerification/";
		n.setBody(body + token);
		mailService.sendEmail(n);
	}

	String generateTokenRep(PropRestaurant propRestaurant) {
		String token = UUID.randomUUID().toString();
		VerificationTokenPropR veify = new VerificationTokenPropR();
		
		veify.setPropRestaurant(propRestaurant);
		veify.setToken(token);
		
		verificationPropRep.save(veify);
		
		return token;
	}
	
	//Organisateur signup
	
	public void orgsignup(Organisateur organisateur) {
		String passwd = organisateur.getPasswd();
		organisateur.setPasswd(passEncoder.encode(passwd));
		organisateur.setVerify(false);
		organisateurRep.save(organisateur);
		String token = generateTokenOrg(organisateur);
		Notification n = new Notification();
		n.setSubject("Activate your account");
		n.setRecipient(organisateur.getEmail());
		String body = "wellcome"
				+ "\n"
				+ "http://localhost:8080/api/auth/OrgaccountVerification/";
		n.setBody(body + token);
		mailService.sendEmail(n);
	}

	String generateTokenOrg(Organisateur organisateur) {
		String token = UUID.randomUUID().toString();
		VerificationTokenOrg veify = new VerificationTokenOrg();
		
		veify.setOrganisateur(organisateur);
		veify.setToken(token);
		
		verificationOrgRep.save(veify);
		
		return token;
	}
	
	//verification of signups
	
	public void verificationRes(String token) {
		Optional<VerificationTokenPropR> ls = verificationPropRep.findByToken(token);
		fetchProprestauandverify(ls.orElseThrow(() -> new SpringRedditException("no token found")));
	}
	
	private void fetchProprestauandverify(VerificationTokenPropR verificationTokenPropR) {
		int id = verificationTokenPropR.getPropRestaurant().getId();
		PropRestaurant propRestaurant =  proRestaurRep.findById(id).orElseThrow(() ->new SpringRedditException("account not found"));
		propRestaurant.setVerify(true);
		proRestaurRep.save(propRestaurant);
	}
	
	public void verificationOrg(String token) {
		Optional<VerificationTokenOrg> ls = verificationOrgRep.findByToken(token);
		fetchorganiandverify(ls.orElseThrow(() -> new SpringRedditException("no token found")));
	}

	private void fetchorganiandverify(VerificationTokenOrg verificationTokenOrg) {
		int id = verificationTokenOrg.getOrganisateur().getId();
		Organisateur organisateur = organisateurRep.findById(id).orElseThrow(() -> new SpringRedditException("account not found"));
		organisateur.setVerify(true);
		organisateurRep.save(organisateur);
	}

	//login
	
	public AuthResponseToken login(LoginRequest request) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPasswd()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new AuthResponseToken(jwtProvider.generateToken(authentication), request.getEmail());
	}
}
