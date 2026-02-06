package mappe;

import java.util.Comparator;

public class IntgerComprator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg1.compareTo(arg0); // per avere ordine decrescente inverto la comparazione
	}
	
}
