package com.spring.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica a spring che deve istanziare e gestire questa classe (Ioc)
@RequestMapping(path="/saluti") // instrada verso questa classe
public class HelloController {
	
	@GetMapping(path="/generici")
	public String helloWorld() {
		return "Ciao Mondo!";
	}
	
	// la variabile nome sara inserita nell'url in questo caso con ?nome="nome";
	@GetMapping(path="/pers")
	public String hello(String nome) {
		return "Ciao " + nome;
	}
}
