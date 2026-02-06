package creazione_pila;

import java.util.LinkedList;

public class PilaGenericaGenerics<E> {
	private LinkedList<E> pila = new LinkedList<E>();
	
	public E remove() {
		return pila.removeLast();
	}
	
	public void add(E element) {
		pila.addLast(element);
	}

	public LinkedList<E> getPila() {
		return pila;
	}
}
