package it.test.corsospring.aop;

import java.util.List;

public class ProdottoProxy implements Prodotto {
	private Prodotto prodotto;
	
	public ProdottoProxy(Prodotto prodotto) {
		super();
		this.prodotto = prodotto;
	}

	@Override
	public String getProdotto() {
		// TODO Auto-generated method stub
		return prodotto.getProdotto();
	}

	@Override
	public List<String> getProdotti() {
		// TODO Auto-generated method stub
		return prodotto.getProdotti();
	}

}
