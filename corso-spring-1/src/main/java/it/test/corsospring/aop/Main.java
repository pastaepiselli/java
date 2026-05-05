package it.test.corsospring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProdottoProxy pp = new ProdottoProxy(new ProdottoImp());
		System.out.println(pp.getProdotto());
		System.out.println(pp.getProdotti());
	}

	private static void aspect() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
