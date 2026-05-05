package it.test.ioc;
import java.util.Scanner;

import it.test.ioc.service.BibliotecaServiceImpl;
public class Hello {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca(new BibliotecaServiceImpl());
		biblioteca.getLibri();
		
	}

}
