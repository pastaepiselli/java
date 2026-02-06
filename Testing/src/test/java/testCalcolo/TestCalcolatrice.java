package testCalcolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import business.Calcolatrice;

public class TestCalcolatrice {
	
	// dichiaro attributo della classe da testare
	private Calcolatrice calcolatrice = new Calcolatrice();
	
	@Test
	public void sumok() {
		Assertions.assertEquals(2, calcolatrice.somma(1, 1));
	}
	
	@Test
	public void sumZero() {
		Assertions.assertEquals(0, calcolatrice.somma(-1, 1));
	}
		
	@Test
	public void divisioneok() {
		try {
			Assertions.assertEquals(2,  calcolatrice.dividi(10, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void divisioneZero() {
		try {
			Assertions.assertThrows(Exception.class,() -> calcolatrice.dividi(10, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void potenzaOk() {
		try {
			Assertions.assertEquals(4, calcolatrice.potenzaPositiva(2, 2));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void potenzaNegativa() {
		try {
			Assertions.assertThrows(Exception.class, () -> calcolatrice.potenzaPositiva(-1, 2));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
} 
