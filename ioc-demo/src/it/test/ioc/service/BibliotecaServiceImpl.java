package it.test.ioc.service;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaServiceImpl implements BibliotecaService {

	@Override
	public List<String> getLibriDisponibili() {
		// boh non ricordo ora 
		List<String> libri = new ArrayList<String>();
		libri.add("Libro 1");
		libri.add("Libro 2");
		libri.add("Libro 3");
		return libri;
	}


	
}
