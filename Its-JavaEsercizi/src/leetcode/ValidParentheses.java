package leetcode; 

import java.util.LinkedList;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.
//
//An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.


public class ValidParentheses {
	public boolean isValid(String s) {
		
		// utilizzo linked list per accesso a prima e ultima variabile
		LinkedList<Character> pila = new LinkedList<Character>();
		
		// itero per la stringa
		for(char c : s.toCharArray()) { // torna un array con i caratteri della stringa
			if (c == '(') {
				pila.addFirst(')'); // aggiungo alla lista la parentesi che si aspettera di vederea al primo posto
			} else if (c == '[') {
				pila.addFirst(']');
			} else if (c == '{') {
				pila.addFirst('}');
			} else { // se e una chiusura
				// se la pila e vuota o la prima parentesi aperta e diversa da la prima chiusa es "(]"
				if (pila.isEmpty() || pila.getFirst() != c) { 
					return false;
				}
				// se tutto ok rimuovo la parentesi completata dalla lista
				pila.removeFirst();
			}
		}
		// se va tutto top (la pila sara vuota) ritorna true
		
		if (pila.isEmpty()) { // questo controllo e necessario per casi come "]"
			return true;
		}
		return true;
	}
}
