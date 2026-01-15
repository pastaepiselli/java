package hotel;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Room> camere = new ArrayList<>();

		camere.add(new Room(100, 1, 2));
		camere.add(new Room(112, 1, 3));
		camere.add(new Room(124, 1, 2));
		camere.add(new Room(111, 1, 3));
		camere.add(new Room(201, 2, 4));
		camere.add(new Room(210, 2, 4));
		camere.add(new Room(205, 2, 2));
		camere.add(new Room(222, 2, 3));

		// 1. Calcola il numero totale di posti letto dell’hotel
		int postiLettoTot = 0;
		for (Room room : camere) {
			postiLettoTot += room.getPostiLetto();
		}
		System.out.println("Posti letto totali: " + postiLettoTot);

		// 2. Calcola il numero totale di posti letto per piano
		int postiLettoPianoUno = 0;
		int postiLettoPianoDue = 0;

		for (Room room : camere) {
			if (room.getPiano() == 1) {
				postiLettoPianoUno += room.getPostiLetto();
			} else if (room.getPiano() == 2) {
				postiLettoPianoDue += room.getPostiLetto();
			}
		}

		System.out.println("Posti letto primo piano: " + postiLettoPianoUno);
		System.out.println("Posti letto secondo piano: " + postiLettoPianoDue);

		// 3. Calcola il numero di camere doppie per piano

		int camereDoppiePianoUno = 0;
		int camereDoppiePianoDue = 0;
		for (Room room : camere) {
			if (room.getPiano() == 1 && room.getPostiLetto() == 2) {
				camereDoppiePianoUno ++;
			} else if (room.getPiano() == 2 && room.getPostiLetto() == 2) {
				camereDoppiePianoDue ++;
			}
		}
		System.out.println("Camere doppie al primo piano: " + camereDoppiePianoUno);
		System.out.println("Camere doppie al secondo piano: " + camereDoppiePianoDue);
		
		// cerca una camera doppia al primo piano
		boolean trovata = false;
		for (Room room : camere) {
			if (room.getPiano() == 1 && room.getPostiLetto() == 2) {
				System.out.println("Camera doppia al primo piano trovata, numero: " + room.getNumero());
				trovata = true;
				break;
			}
		}
		
		if (!trovata) {
			System.out.println("Camera non trovata!");
		}
		
		// cerca un camera doppia al secondo piano 
		
		trovata = false;
		for (Room room : camere) {
			if (room.getPiano() == 2 && room.getPostiLetto() == 2) {
				System.out.println("Camera doppia al secondo piano trovata, numero: " + room.getNumero());
				trovata = true;
				break;
			}
		}
		
		if (!trovata) {
			System.out.println("Camera non trovata!");
		}
		
		// cerca un camera quadrupla al primo piano
		
		trovata = false;
		for (Room room : camere) {
			if (room.getPiano() == 1 && room.getPostiLetto() == 4) {
				System.out.println("Camera quadrupla al primo piano trovata, numero: " + room.getNumero());
				trovata = true;
				break;
			}
		}
		
		if (!trovata) {
			System.out.println("Camera non trovata!");
		}
		
		// camera quadrupla al secondo piano
		
		trovata = false;
		for (Room room : camere) {
			if (room.getPiano() == 2 && room.getPostiLetto() == 4) {
				System.out.println("Camera quadrupla al secondo piano trovata, numero: " + room.getNumero());
				trovata = true;
				break;
			}
		}
		
		if (!trovata) {
			System.out.println("Camera non trovata!");
		}
		
		
		
	}
}