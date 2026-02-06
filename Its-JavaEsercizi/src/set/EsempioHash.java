package set;

import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import azienda.ComparatorImpAnno;
import azienda.ComparatorImpSalario;
import azienda.Impiegato;

public class EsempioHash {
	public static void main(String[] args) {
		HashSet<Impiegato> set = new HashSet<Impiegato>();
		System.out.println(set.size());
		set.add(new Impiegato("marco", 1200, new Date()));
		set.add(new Impiegato("Pier", 200, new Date()));
		set.add(new Impiegato("Luca", 1700, new Date()));
		set.add(new Impiegato("Luca", 1700, new Date()));
		
		for (Impiegato i : set) {
			System.out.println(i);
		}
		
		System.out.println("----------------------------------------------------------------------------------");
		
		TreeSet<Impiegato> tSet = new TreeSet<Impiegato>(); // qui puoo inserire CompImpSalario o Anno
		System.out.println(tSet);
		
		tSet.add(new Impiegato("anna", 1200, new Date()));
		tSet.add(new Impiegato("paolo", 200, new Date()));
		tSet.add(new Impiegato("luca", 1700, new Date()));
		tSet.add(new Impiegato("luca", 1700, new Date()));
		
		for (Impiegato i : tSet) {
			System.out.println(i);
		}
		
		
		
		
	}
}
