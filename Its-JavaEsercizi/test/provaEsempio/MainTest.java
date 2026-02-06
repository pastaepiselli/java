package provaEsempio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void palindromaTrue() {
        Main m = new Main();
        boolean risultato = m.isPalindroma("osso");
        assertTrue(risultato);
    }

    @Test
    void palindromaFalse() {
        Main m = new Main();
        boolean risultato = m.isPalindroma("ciao");
        assertFalse(risultato);
    }
    
    @Test 
    void contaOccorrenze() {
    	Main m = new Main();
    	int occ = m.contaOccorrenze("llll aa o", "a");
    	assertEquals(25, occ);
    }
}
