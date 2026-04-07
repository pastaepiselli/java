package com.spring.statisticheCalcolo.service;

import org.springframework.stereotype.Service;


@Service
public class OperazioniServiceImpl implements OperazioniService {

	@Override
	public int addizione(int a, int b) {
		return a + b;
	}

	@Override
	public int sottrazione(int a, int b) {
		return a - b;
	}

	@Override
	public int moltiplicazione(int a, int b) {
		return a * b;
	}

	@Override
	public int divisione(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Divisione con 0 non permessa");
		}
		return a / b;
	}

}
