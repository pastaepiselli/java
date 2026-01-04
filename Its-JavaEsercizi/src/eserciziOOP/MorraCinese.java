package eserciziOOP;

import java.util.Scanner;

public class MorraCinese {
	public static void main(String[] args) {
		boolean running = true;
		while (running) {
		int mossa_cpu = (int)(Math.random() * 3);
//		System.out.println(mossa_cpu);
		
		Scanner sc = new Scanner(System.in);
		
		// input player 
		int mossa_giocatore = -1;
		System.out.println("0: sasso");
		System.out.println("1: carta");
		System.out.println("2: forbici");
		System.out.println("Inserire mossa:");
		while (mossa_giocatore < 0 || mossa_giocatore > 2) {
			mossa_giocatore = sc.nextInt();
			if (mossa_giocatore > 2 || mossa_giocatore < 0) System.out.println("Inserire una mossa valida!");
			
;		}
		
		// partita
		
		switch(mossa_cpu) {
		case 0: // cpu sasso
			System.out.println("Mossa cpu " + mossa_cpu + " (sasso)");
			if (mossa_giocatore == 1) {
				System.out.println("Vittoria player");
			} else if (mossa_giocatore == 2) {
				System.out.println("Vittoria cpu!");
			} else {
				System.out.println("Pareggio");
			}
			break;
		case 1: // cpu carta
			System.out.println("Mossa cpu " + mossa_cpu + " (carta)");
			if (mossa_giocatore == 1) {
				System.out.println("Pareggio");
			} else if (mossa_giocatore == 2) {
				System.out.println("Vittoria player!");
			} else {
				System.out.println("Vittoria cpu!");
			}
			break;
		case 2: // cpu forbice
			System.out.println("Mossa cpu " + mossa_cpu + " (forbice)");
			if (mossa_giocatore == 1) {
				System.out.println("Vittoria cpu!");
			} else if (mossa_giocatore == 2) {
				System.out.println("Pareggio");
			} else {
				System.out.println("Vittoria player!");
			}
			break;
		}
		System.out.print("Rigiocare? S/n ");
		String rematch = sc.next();
		if (rematch.equalsIgnoreCase("n")) {
			running = false;
		}
		}
		
	}
}	
