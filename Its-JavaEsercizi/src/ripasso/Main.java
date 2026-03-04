package ripasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) {
		SuperClasse sc = new Sottoclasse(null);
		System.out.println(sc.caca());
		
		SuperClasse fi = new Sottoclasse(null);
		fi.pipi();
		
		
		Object o = new Object();
		
		HashMap<String, String> hm = new HashMap();
		
		
		
		System.out.println(o.hashCode());
		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("elem1");
		lista.add("elem2");
		lista.add("elem3");
		
		
		
		
		
		List<String> link = new LinkedList<String>();
		
		
		
		ListIterator<String> i = lista.listIterator();
		i.forEachRemaining(arg0 -> System.out.println(arg0));
		
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			
			System.out.println(string);
			
		}
		
	}
}
