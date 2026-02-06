package testCalcolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tamagotchi.Tamagotchi;

public class TestTamagotchi {
	
	private Tamagotchi t;

    @BeforeEach // prima di ogni test ricrea popa canarino
    void setUp() {
        t = new Tamagotchi("Popa", "Canarino");
    }
	
	@Test
	void testCostruttoreInizializzaValoriCorretti() {
		Assertions.assertEquals(100, t.getPeso());
		Assertions.assertEquals(3, t.getAltezza());
		Assertions.assertEquals(3, t.getEnergia());
	}
	
	@Test
	void mangiaOk() {
		int altezzaIniziale = t.getAltezza(); 
		int pesoIniziale = t.getPeso();
		int energiaIniziale = t.getEnergia();
		
		Assertions.assertTrue(t.mangia());
		Assertions.assertEquals(altezzaIniziale + 1, t.getAltezza());
		Assertions.assertEquals(pesoIniziale + 150, t.getPeso());
		Assertions.assertEquals(energiaIniziale + 1, t.getEnergia());	
	}
	
	@Test
	void mangiaNo() {
		int altezzaIniziale = t.getAltezza();
		int pesoIniziale = t.getPeso();
		
		t.setEnergia(10);
		Assertions.assertFalse(t.mangia());
		Assertions.assertEquals(altezzaIniziale, t.getAltezza());
		Assertions.assertEquals(pesoIniziale, t.getPeso());
		Assertions.assertEquals(10, t.getEnergia());	
	}
	
	@Test
	void dormeOk() {
		int energiaIniziale = t.getEnergia();
		
		Assertions.assertTrue(t.dorme()); // metodo funziona
		Assertions.assertEquals(energiaIniziale + 1, t.getEnergia()); // energia + 1
	}
	
	@Test
	void dormeNo() {
		t.setEnergia(10);
		
		Assertions.assertFalse(t.dorme()); // metodo non funziona
		Assertions.assertEquals(10, t.getEnergia()); // energia rimane uguale
	}
	
	@Test
	void giocaOk() {
		// il peso deve essere sup a 100
		t.setEnergia(200);
		int energiaIniziale = t.getEnergia();
		
		Assertions.assertTrue(t.gioca());
		Assertions.assertEquals(energiaIniziale - 1, t.getEnergia());
	}
	
	@Test
	void giocaNo() {
		t.setEnergia(1); // energia troppo bassa
		
		Assertions.assertFalse(t.gioca());
		Assertions.assertEquals(1, t.getEnergia());
		
	}
	
	@Test
	void testGiocaPesoMinimo() {
		// peso canarino gia impostato a 100
		Assertions.assertFalse(t.gioca());
		Assertions.assertEquals(100, t.getPeso());
		
	}
	
}
