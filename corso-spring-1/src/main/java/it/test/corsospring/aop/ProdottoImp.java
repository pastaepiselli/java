package it.test.corsospring.aop;

import java.util.ArrayList;
import java.util.List;

public class ProdottoImp implements Prodotto {

	@Override
	public String getProdotto() {
		// TODO Auto-generated method stub
		return "Smartphone";
	}

	@Override
	public List<String> getProdotti() {
		List<String> prodotti = new ArrayList<String>();
		prodotti.add("prod 1");
		prodotti.add("prod 2");
		prodotti.add("prod 3");
		return prodotti;
	}


}
