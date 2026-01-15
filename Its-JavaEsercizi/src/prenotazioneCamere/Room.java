package prenotazioneCamere;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Room {
	private int number;
	private ArrayList<Reservation> reservation = new ArrayList<Reservation>();
	
	public Room(int number) {
		this.setNumber(number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number < 100 || number > 599) {
			throw new IllegalArgumentException("Inserire un numero compreso tra 100 e 599");
		}
		
		this.number = number;
	}
	
	public Reservation reserve(String nome, int inizio, int fine) {
		for (Reservation r : reservation) {
			if (inizio >= r.getInizio() && inizio <= r.getFine()) {
				throw new IllegalAccessError("Camera gia prenotata");
			} else if (fine >= r.getInizio() && fine <= r.getFine()) {
				throw new IllegalAccessError("Camera gia prenotata");
			}
		}
		
		Reservation r = new Reservation(nome, inizio, fine);
		reservation.add(r);
		
		return r;
	}
	
	public ArrayList<Reservation> reservations(){
		 Collections.sort(this.reservation);
		 return this.reservation;
	}

	@Override
	public String toString() {
		return "Room [number=" + number + ", reservation=" + reservation + "]";
	}
	
	
	
}
