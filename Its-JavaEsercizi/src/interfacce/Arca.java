package interfacce;

import java.util.ArrayList;

public class Arca {
	
	ArrayList<Animale> animali = new ArrayList<Animale>();
	
	public void salva(Animale a) throws IllegalAccessException {
		int c = 0;
		for (int i = 1; i < animali.size(); i++) {
			if (animali.get(i).getClass() == a.getClass()) {
				c++;
			}
		}
		if (c >= 2) {
			throw new IllegalAccessException("Non possono essere inseriti piu di 2 animali per specie");
		}
		animali.add(a);
	}
	
	public int getNumeroAnimali() {
		return animali.size();
	}
	
	public String coro() {
		String coro = "";
		for (Animale animale : animali) {
			coro += animale.verso();
		}
		return coro;
	}
	
	public String toString() {
		String toStringanimali = "";
		for (Animale animale : animali) {
			toStringanimali += animale.toString();
		}
		return toStringanimali;
	}
}
