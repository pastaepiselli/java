package com.spring.statisticheCalcolo.service;

/*
 * interfaccia service per design scelta
 * non necessaria 
 */
public interface OperazioniService {
	public int addizione(int a, int b);
	public int sottrazione(int a, int b);
	public int moltiplicazione(int a, int b);
	public int divisione(int a, int b) throws ArithmeticException;
}
