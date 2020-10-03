package com.integrateur.fesevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrateur.fesevent.dto.AuthResponseToken;
import com.integrateur.fesevent.dto.LoginRequest;
import com.integrateur.fesevent.metier.AuthService;
import com.integrateur.fesevent.modules.Organisateur;
import com.integrateur.fesevent.modules.PropRestaurant;

@RestController
@RequestMapping(value = "/api/auth/")
public class Authcontoller {

	@Autowired
	private AuthService authService;
	
	public Authcontoller() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/signupRes")
	public ResponseEntity<String> signupR(@RequestBody PropRestaurant propRestaurant){
		authService.ResSignup(propRestaurant);
		return new ResponseEntity<>("good",HttpStatus.OK);
	}
	
	@PostMapping("/signupOrg")
	public ResponseEntity<String> signupOrg(@RequestBody Organisateur organisateur){
		authService.orgsignup(organisateur);
		return new ResponseEntity<>("good",HttpStatus.OK);
	}
	
	@GetMapping("/ResaccountVerification/{token}")
	public ResponseEntity<String> verifyres(@PathVariable String token){
		authService.verificationRes(token);
		return new ResponseEntity<>("account activated Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/OrgaccountVerification/{token}")
	public ResponseEntity<String> verifyorg(@PathVariable String token){
		authService.verificationOrg(token);
		return new ResponseEntity<>("account activated Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/loginRes")
	public AuthResponseToken resLogin(@RequestBody LoginRequest request){
		return authService.login(request);
	}
	
	@PostMapping("/loginOrg")
	public AuthResponseToken OrgLogin(@RequestBody LoginRequest request){
		return authService.login(request);
	}
}
