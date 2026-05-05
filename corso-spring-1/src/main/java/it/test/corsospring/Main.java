package it.test.corsospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		annotationConfig();
		}
	
	public static void annotationConfig() {
		// nel costruttore gli passiamo la classe con dentro tutte le configurazioni dei bean
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		OrdineService ordine = context.getBean("ordineAnnotation", OrdineService.class);
		System.out.println(ordine.hello());
	}

	public static void xmlConfig() {
		
		// costruttore con file xml
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		OrdineService ordine = context.getBean("ordine", OrdineService.class);
		ordine.hello();

	}

}
