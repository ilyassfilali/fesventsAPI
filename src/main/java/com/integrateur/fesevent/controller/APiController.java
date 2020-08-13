package com.integrateur.fesevent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APiController {

	@RequestMapping("/hello")
	public String hi() {
		return "good";
	}

}
