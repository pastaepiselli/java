package oggetti;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestTamagotchi {
	public static void clearTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	public static void main(String[] args) throws InterruptedException {
		//		Tamagotchi cane = new Tamagotchi("Fluffy");
		//		System.out.println(cane);
		//		
		//		Tamagotchi gatto = new Tamagotchi("Nina", "Gatto");
		//		System.out.println(gatto);
		//		
		//		Tamagotchi canarino = new Tamagotchi("Piccio", "cAnArino");
		//		System.out.println(canarino);
		//		
		//		Tamagotchi coniglio = new Tamagotchi("Palleto",	 "ConiglIo");
		//		System.out.println(coniglio);
		//		
		//		// caso in cui si inserisce una specie non riconosciuta
		//		Tamagotchi trex = new Tamagotchi("Dexter", "Trex");
		//		System.out.println(trex);



		Scanner sc = new Scanner(System.in);

		System.out.println(" _____                                 _       _     _ \n"
				+ "|_   _|                               | |     | |   (_)\n"
				+ "  | | __ _ _ __ ___   __ _  __ _  ___ | |_ ___| |__  _ \n"
				+ "  | |/ _` | '_ ` _ \\ / _` |/ _` |/ _ \\| __/ __| '_ \\| |\n"
				+ "  | | (_| | | | | | | (_| | (_| | (_) | || (__| | | | |\n"
				+ "  \\_/\\__,_|_| |_| |_|\\__,_|\\__, |\\___/ \\__\\___|_| |_|_|\n"
				+ "                            __/ |                      \n"
				+ "                           |___/                       ");

		System.out.print("Inserire nome del tuo tamagotchi: ");
		String nome = sc.next();

		System.out.println();

		System.out.print("Inserisci la specie del tuo tamagotchi (default=cane): ");
		String specie = sc.next();

		Tamagotchi userTam = new Tamagotchi(nome, specie);

		while (true) {
			System.out.println(userTam);
			
			System.out.println("1: Mangia");
			System.out.println("2: Dormi");
			System.out.println("3: Gioca");
			System.out.println("4: Chiudi");
			System.out.print("Scegli cosa vuoi fare: ");
			int azione = sc.nextInt();

			switch(azione) {
			case 1:
				userTam.mangia();
				clearTerminal();
				System.out.println("\n"
						+ "\n"
						+ "          __O__\n"
						+ "        .'     '.\n"
						+ "      .'         '.\n"
						+ "     .  _________  .\n"
						+ "     : |   .-.   | :\n"
						+ "    :  |  ( 0 )  |  :\n"
						+ "    :  |   \" \"   |  :\n"
						+ "    :  |_________|  :\n"
						+ "     |             |\n"
						+ "     '   O     O   '\n"
						+ "      ',    O    ,'\n"
						+ "        '.......'"
						);

				TimeUnit.SECONDS.sleep(1);
				
				System.out.println(userTam);

			}

		}




	}
}
