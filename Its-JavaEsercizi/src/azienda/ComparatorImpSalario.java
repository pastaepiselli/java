package azienda;

import java.util.Comparator;

public class ComparatorImpSalario implements Comparator<Impiegato> {

	@Override
	public int compare(Impiegato i1, Impiegato i2) {
		if (i1.getSalario() > i2.getSalario()) {
			return 1;
		} else if (i1.getSalario() < i2.getSalario()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
