package adapter;

import java.util.Date;

import azienda.Impiegato;

public class Main {
	public static void main(String[] args) {
		Impiegato imp = new Impiegato("paolo", 1200, new Date(120, 2, 15));
		AdattatoreImpiegato addImp = new AdattatoreImpiegato(imp);
		
		System.out.println(addImp.getAnniAnzianita());
		System.out.println(addImp.getNominativo());
		System.out.println(addImp.getRetribuzioneAnnua());
	}
	
	
	
}
