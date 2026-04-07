package com.spring.statisticheCalcolo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.statisticheCalcolo.aspect.UtilizzoOperazioniAspect;

/*
 * definizione controller solo per statistiche
 */

@RestController
@RequestMapping("/calcoli/statistiche")
public class StatisticheCalcoliController {
	
	@Autowired
	private UtilizzoOperazioniAspect service;
	
	@GetMapping(path="")
	public Map<String, Integer> getAddizioneUso() {
		return service.getCount();
	}
}
