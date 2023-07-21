package com.desafios.desafioCRUD.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@GetMapping
	public String test() {
		return "ola mundo!";
	}
	
}