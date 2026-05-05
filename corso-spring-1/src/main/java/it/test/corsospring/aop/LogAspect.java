package it.test.corsospring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

	@Before(value = "execution (* it.test.corsospring.aop.bean.")
	public void logBefore() {
		System.out.println("inizio esecuzioe");
	}
	
	@After()
	public void logAfter() {
		System.out.println("fine esecuzione");
	}
}
