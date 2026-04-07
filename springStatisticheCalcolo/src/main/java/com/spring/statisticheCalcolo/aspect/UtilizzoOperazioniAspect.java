package com.spring.statisticheCalcolo.aspect;

import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

/*
 * classe aspect in cui viene gestito e segnato in una mappa
 * 	"nome metodo": volte utilizzo, la frequenza d'uso dei metodi di calcolo
 */

import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;


@Component
@Aspect
public class UtilizzoOperazioniAspect {

	// mappa che supporta multiThreading :)
    private Map<String, Integer> count = new ConcurrentHashMap<>();
    
  
    
    public Map<String, Integer> getCount() {
		return count;
	}
	// qualsiadi metodo di questa classe 
    @After("execution(* com.spring.statisticheCalcolo.service.OperazioniServiceImpl.*(..))")
    public void countOperazioni(JoinPoint joinPoint) { // viene automaticamente preso in input in metodo chiamato
        
    	// ottiene il nome 
        String methodName = joinPoint.getSignature().getName();

        // se presente fa + 1 se non esiste imposta ad uno
        count.merge(methodName, 1, Integer::sum);
    }
}
