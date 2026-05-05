package it.test.ioc;

import java.util.List;

import it.test.ioc.service.BibliotecaService;
import it.test.ioc.service.BibliotecaServiceImpl;

public class Biblioteca {
	private BibliotecaService service;
	
	// come creo l'istanza di quiesto service
	// 1) istanzioa a mano nel costruttore
	//public Biblioteca() {
	//	service = new BibliotecaServiceImpl();
	//	}
	
	// 2) Constuctor injection
	public Biblioteca(BibliotecaService serv) {
		this.service = serv;
	}
	
	public List<String> getLibri(){
		return service.getLibriDisponibili();
	}

	// 3) DI tipo setter
	public void setService(BibliotecaService service) {
		this.service = service;
	}
}
