package com.spring.statisticheCalcolo.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @AfterReturning("execution(* com.spring.statisticheCalcolo.service.OperazioniServiceImpl.*(..))")
    public void logSucc(JoinPoint jp) { // joinpoint e il metodo su cui abbiamo agganciato un aspetct
    	// in questo caso tutti i metodi che ritornano qualcoa di OperazioniServiceImpl

        try (FileWriter myWriter = new FileWriter("log.txt", true)) {

            myWriter.write(
                LocalDate.now() + " - " +
                jp.getSignature().getName() +
                " SUCCESSO\n"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing(
        pointcut = "execution(* com.spring.statisticheCalcolo.service.OperazioniServiceImpl.*(..))",
        throwing = "ex" // prende anche che tipo di eccezione 
    )
    public void logErr(JoinPoint jp, Exception ex) {

        try (FileWriter myWriter = new FileWriter("log.txt", true)) {

            myWriter.write(
                LocalDate.now() + " - " +
                jp.getSignature().getName() +
                " ERRORE: " + ex.getMessage() + "\n"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}