package creazione_pila;

import java.util.LinkedList;

public class PilaGenericaObject {
	private LinkedList<Object> pila = new LinkedList<Object>();
	
	public Object remove() {
		return pila.removeLast();
	}
	
	public void add(Object element) {
		pila.addLast(element);
	}

	public LinkedList<Object> getPila() {
		return pila;
	}
	
	
}

