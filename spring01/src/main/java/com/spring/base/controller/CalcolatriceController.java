package com.spring.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // questa te la gestisci tu (spring)
@RequestMapping(path="/calcolo")
public class CalcolatriceController {
	
	public CalcolatriceController() {
		System.out.println("Springa sta costruendo calcolatriceControlles");
	}
	
	@GetMapping(path="/somma")
	public int somma(int n, int m) {
		return n + m;
	}
	
	@GetMapping(path="/sottrazione")
	public int sottazione(int n, int m) {
		return n - m;
	}
	
	@GetMapping(path="/moltiplicazione")
	public int moltiplicazione(int n, int m) {
		return n * m;
	}
	
	@GetMapping(path="/divisione")
	public double divisione(double n, double m) {
		return n / m;
	}
}
