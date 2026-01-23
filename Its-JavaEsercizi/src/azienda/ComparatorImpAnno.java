package azienda;

import java.util.Comparator;

public class ComparatorImpAnno implements Comparator<Impiegato> {

	@Override
	public int compare(Impiegato i1, Impiegato i2) {
		if (i1.getAnnoAssunzione() > i2.getAnnoAssunzione())
			return 1;
		else if (i1.getAnnoAssunzione() < i2.getAnnoAssunzione()) 
			return -1;
		else
			return 0;
		
	
		
	}
}
