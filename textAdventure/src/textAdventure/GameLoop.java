
package textAdventure;

import java.util.Scanner;
import java.util.Random;

public class GameLoop {
	// Codici colore ANSI
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_ITALIC = "\u001B[3m";

	private Random random = new Random();
	private Popa popa;
	private Scanner sc;
	private int pianoAttuale = 2;

	public GameLoop() {
		this.popa = new Popa(100);
		this.sc = new Scanner(System.in);
	}

	// Slow print
	public static void printText(String text) throws InterruptedException {
		System.out.println();
		for (char c : text.toCharArray()) {
			System.out.print(c);
			Thread.sleep(40);
		}
	}

	// Popa parla
	public void popaText(String text) throws InterruptedException {
		System.out.println();
		for (char c : text.toCharArray()) {
			System.out.print(ANSI_ITALIC + ANSI_CYAN);
			System.out.print(c);
			Thread.sleep(70);
		}
		System.out.print(ANSI_RESET);
	}

	// Nemico parla
	public static void nemicoText(String text) throws InterruptedException {
		System.out.println();
		for (char c : text.toCharArray()) {
			System.out.print(ANSI_RED + ANSI_BOLD + c);
			Thread.sleep(60);
		}
		System.out.println(ANSI_RESET);
	}

	// Pickup item
	public static void printPickUp(String text) throws InterruptedException {
		System.out.println();
		for (char c : text.toCharArray()) {
			System.out.print(ANSI_GREEN + c);
			Thread.sleep(70);
		}
		System.out.println(ANSI_RESET);
	}

	// Statistiche
	public void printStats() {
		System.out.println("\n" + ANSI_BOLD + ANSI_YELLOW + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_YELLOW + "║         STATISTICHE                ║" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_YELLOW + "╚════════════════════════════════════╝" + ANSI_RESET);

		int hpPercent = (popa.getHp() * 100) / popa.getHpMax();
		String hpColor = hpPercent > 60 ? ANSI_GREEN : (hpPercent > 30 ? ANSI_YELLOW : ANSI_RED);
		System.out.println("HP: " + hpColor + popa.getHp() + "/" + popa.getHpMax() + ANSI_RESET + " [" + getHpBar(hpPercent) + "]");
		System.out.println("Arma: " + ANSI_PURPLE + (popa.getArma() == null ? "Pugni" : popa.getArma().getNome()) + ANSI_RESET);
		System.out.println("Hashish: " + ANSI_GREEN + popa.getHashish() + "g" + ANSI_RESET);
		System.out.println("Braccio Robotico: " + (popa.isBraccioAttivato() ? ANSI_GREEN + "ATTIVO ⚡" : ANSI_RED + "INATTIVO") + ANSI_RESET);
		System.out.println("Piano: " + getPianoNome(pianoAttuale));
		System.out.println("\nInventario (" + popa.getInventario().size() + " oggetti):");

		for (Oggetto obj : popa.getInventario()) {
			System.out.println("  " + ANSI_CYAN + "• " + obj.getNome() + ANSI_RESET);
		}
		System.out.println(ANSI_BOLD + ANSI_YELLOW + "════════════════════════════════════" + ANSI_RESET + "\n");
	}

	private String getPianoNome(int piano) {
		switch(piano) {
		case 2: return ANSI_BLUE + "Piano 2 (Reparti)" + ANSI_RESET;
		case 1: return ANSI_BLUE + "Piano 1 (Corridoio Pazienti)" + ANSI_RESET;
		case 0: return ANSI_YELLOW + "Piano Terra (Main Hall)" + ANSI_RESET;
		case -1: return ANSI_PURPLE + "Piano -1 (Laboratorio 1)" + ANSI_RESET;
		case -2: return ANSI_RED + "Piano -2 (Laboratorio 2)" + ANSI_RESET;
		default: return "???";
		}
	}

	private String getHpBar(int percent) {
		int bars = percent / 10;
		StringBuilder bar = new StringBuilder();
		String color = percent > 60 ? ANSI_GREEN : (percent > 30 ? ANSI_YELLOW : ANSI_RED);

		bar.append(color);
		for (int i = 0; i < bars; i++) {
			bar.append("█");
		}
		bar.append(ANSI_RESET);
		for (int i = bars; i < 10; i++) {
			bar.append("░");
		}

		return bar.toString();
	}

	// Sistema combattimento
	public boolean combat(Nemico nemico) throws InterruptedException {
//		if (nemico.isBoss()) {
//			bossFight(nemico);
//			return true;
//		}

		System.out.println("\n" + ANSI_RED + ANSI_BOLD + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_RED + ANSI_BOLD + "║   COMBATTIMENTO INIZIATO!          ║" + ANSI_RESET);
		System.out.println(ANSI_RED + ANSI_BOLD + "╚════════════════════════════════════╝" + ANSI_RESET);
		nemicoText("Nemico: " + nemico.getNome());
		printText("HP Nemico: " + nemico.getHp());

		while (popa.getHp() > 0 && nemico.getHp() > 0) {
			System.out.println("\n" + ANSI_CYAN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + ANSI_RESET);
			System.out.println(ANSI_BOLD + "Turno di Popa" + ANSI_RESET);
			System.out.println(ANSI_CYAN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + ANSI_RESET);

			int popaHpPercent = (popa.getHp() * 100) / popa.getHpMax();
			int nemicoHpPercent = (nemico.getHp() * 100) / nemico.getHpMax();

			System.out.println("Popa HP: " + getHpBar(popaHpPercent) + " " + popa.getHp() + "/" + popa.getHpMax());
			System.out.println(ANSI_RED + "Nemico HP: " + getHpBar(nemicoHpPercent) + " " + nemico.getHp() + "/" + nemico.getHpMax() + ANSI_RESET);

			System.out.println("\n" + ANSI_YELLOW + "Cosa fai?" + ANSI_RESET);
			System.out.println("1 - ⚔️  Attacca");
			System.out.println("2 - 🛡️  Difendi");
			System.out.println("3 - 🌿 Fuma hashish (20 HP) [" + ANSI_GREEN + popa.getHashish() + "g" + ANSI_RESET + "]");
			if (popa.isBraccioAttivato()) {
				System.out.println("4 - ⚡ Laser Braccio Robotico (danno potenziato!)");
			}
			System.out.print("\n" + ANSI_BOLD + "Scelta: " + ANSI_RESET);

			int scelta = sc.nextInt();

			if (scelta == 1) {
				Thread.sleep(300);
				int danno = calcolaDanno();
				boolean morto = nemico.takeDamage(danno);

				System.out.println("\n" + ANSI_YELLOW + "💥 Popa attacca con " + (popa.getArma() == null ? "i pugni" : popa.getArma().getNome()) + "!" + ANSI_RESET);
				System.out.println(ANSI_RED + "⚡ Infligge " + ANSI_BOLD + danno + ANSI_RESET + ANSI_RED + " danni!" + ANSI_RESET);

				if (morto) {
					vittoria(nemico);
					return true;
				}
			} else if (scelta == 2) {
				printText("🛡️  Popa si mette in guardia!");
				Thread.sleep(800);
				int dannoRidotto = nemico.getDanno() / 2;
				nemicoText(nemico.getNome() + " attacca!");
				printText("Popa difende! Subisce " + ANSI_YELLOW + dannoRidotto + ANSI_RESET + " danni.");
				popa.takeDamage(dannoRidotto);
				continue;
			} else if (scelta == 3) {
				if (popa.usaHashish(0.5)) {
					System.out.println("\n" + ANSI_GREEN + "🌿 Popa fuma hashish..." + ANSI_RESET);
					Thread.sleep(1000);
					System.out.println(ANSI_GREEN + "💚 +20 HP!" + ANSI_RESET);
				} else {
					System.out.println(ANSI_RED + "❌ Hashish insufficiente!" + ANSI_RESET);
					continue;
				}
			} else if (scelta == 4 && popa.isBraccioAttivato()) {
				Thread.sleep(500);
				System.out.println("\n" + ANSI_CYAN + "⚡⚡⚡ BRACCIO ROBOTICO ATTIVATO! ⚡⚡⚡" + ANSI_RESET);
				int dannoLaser = calcolaDanno() + 25;
				boolean morto = nemico.takeDamage(dannoLaser);
				System.out.println(ANSI_PURPLE + "🔫 LASER DEVASTANTE!" + ANSI_RESET);
				System.out.println(ANSI_RED + "💥 " + ANSI_BOLD + dannoLaser + ANSI_RESET + ANSI_RED + " DANNI CRITICI!" + ANSI_RESET);

				if (morto) {
					vittoria(nemico);
					return true;
				}
			}

			// Turno nemico
			if (nemico.getHp() > 0) {
				turnoNemico(nemico);
			}
		}

		return true;
	}

	private void turnoNemico(Nemico nemico) throws InterruptedException {
		Thread.sleep(800);
		System.out.println("\n" + ANSI_RED + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + ANSI_RESET);
		System.out.println(ANSI_RED + ANSI_BOLD + "Turno di " + nemico.getNome() + ANSI_RESET);
		System.out.println(ANSI_RED + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + ANSI_RESET);
		Thread.sleep(1000);

		int dannoNemico = nemico.getDanno() + random.nextInt(5);
		boolean popamorto = popa.takeDamage(dannoNemico);

		nemicoText("💢 " + nemico.getNome() + " attacca!");
		System.out.println(ANSI_RED + "⚡ " + ANSI_BOLD + dannoNemico + ANSI_RESET + ANSI_RED + " danni a Popa!" + ANSI_RESET);

		if (popamorto) {
			gameOver();
		}
	}

	private void bossFight(Nemico boss) throws InterruptedException {
		System.out.println("\n" + ANSI_RED + ANSI_BOLD);
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║                                       ║");
		System.out.println("║        ⚠️  BOSS FIGHT  ⚠️             ║");
		System.out.println("║   MEDICO SUPERMUTATO DI TORVAIANICA   ║");
		System.out.println("║                                       ║");
		System.out.println("╚═══════════════════════════════════════╝");
		System.out.println(ANSI_RESET);

		Thread.sleep(2000);
		nemicoText("MUAHAHAHA! Benvenuto nella mia sala operatoria finale, Popa!");
		nemicoText("Il tuo braccio era solo l'inizio del mio esperimento!");
		popaText("Basta! Oggi finisce tutto, mostro!");

		combat(boss);
	}

	private void vittoria(Nemico nemico) throws InterruptedException {
		Thread.sleep(500);
		System.out.println("\n" + ANSI_GREEN + ANSI_BOLD + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_GREEN + ANSI_BOLD + "║         ✨ VITTORIA! ✨            ║" + ANSI_RESET);
		System.out.println(ANSI_GREEN + ANSI_BOLD + "╚════════════════════════════════════╝" + ANSI_RESET);
		printText(nemico.getNome() + " è stato sconfitto!");
	}

	private void gameOver() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("\n" + ANSI_RED + ANSI_BOLD);
		System.out.println("╔════════════════════════════════════╗");
		System.out.println("║                                    ║");
		System.out.println("║          GAME OVER                 ║");
		System.out.println("║                                    ║");
		System.out.println("╚════════════════════════════════════╝");
		System.out.println(ANSI_RESET);
		printText("Popa è stato sconfitto...");
		System.exit(0);
	}

	private int calcolaDanno() {
		if (popa.getArma() == null) {
			return 10 + random.nextInt(5);
		}

		int min = popa.getArma().getDannoMin();
		int max = popa.getArma().getDannoMax();
		return min + random.nextInt(max - min + 1);
	}

	// CAPITOLO 1
	public void capitolo1() throws InterruptedException {
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "\n╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "║    AVVENTURA DI POPA - CAP. 1      ║" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "║      IL RISVEGLIO                  ║" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "╚════════════════════════════════════╝" + ANSI_RESET);

		Thread.sleep(1500);

		printText("Bep... Bep... Bep... Bep...");
		printText("Popa si risveglia frastornato.");
		printText("La stanza è buia. Le finestre chiuse.");
		printText("Non si capisce se è giorno o notte.");
		printText("Il pavimento è freddo sotto i piedi scalzi.");

		popaText("Che cazzo... dove sono?");

		printText("Improvvisamente si accorge...");
		Thread.sleep(1000);

		popaText("AAAHHH! IL MIO BRACCIO!");

		printText("Il suo braccio destro è stato sostituito con un braccio robotico.");
		printText("Metallico. Freddo. Inerte.");
		Thread.sleep(1000);
		printText("Poi, all'improvviso...");
		Thread.sleep(500);
		printText("Una luce azzurra si accende dal polso.");
		printText("Le dita iniziano a muoversi.");
		printText("*Click* *Whirr* *Bzzzz*");

		popaText("Cosa... cosa mi hanno fatto?!");
		popaText("Devo uscire di qui. ORA.");

		printText("\nCosa fai?");
		printText("1 - Rimani a letto e aspetti");
		printText("2 - Ti alzi e cerchi di uscire");
		System.out.print("\n" + ANSI_BOLD + "Scelta: " + ANSI_RESET);

		int scelta = sc.nextInt();

		if (scelta == 1) {
			printText("Provi a rimanere calmo...");
			printText("Ma non riesci. L'ansia ti divora.");
			printText("Ti alzi comunque.");
		}

		printText("\nPopa si toglie la flebo e si alza.");
		printText("Prima di uscire, cerca qualcosa da portare con sé...");

		System.out.println(ANSI_BOLD + ANSI_PURPLE + "\n═══════════════════════════════════" + ANSI_RESET);
		printText("FINE CAPITOLO 1");
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "═══════════════════════════════════\n" + ANSI_RESET);
	}

	// CAPITOLO 2
	public void capitolo2() throws InterruptedException {
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "\n╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "║         CAPITOLO 2                 ║" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "║    L'OSPEDALE DESERTO              ║" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_PURPLE + "╚════════════════════════════════════╝" + ANSI_RESET);

		printText("Popa trova i suoi averi sul comodino...");

		popa.aggiungiHashish(1.5);
		popa.aggiungiOggetto(new Oggetto("Winston Blue", "Sigarette"));
		popa.equipArma(new Arma("Coltello a farfalla", 15, 25));

		printPickUp("+1.5g hashish");
		printPickUp("+1 Winston Blue");
		printPickUp("+1 Coltello a farfalla");

		popaText("Meglio di niente...");

		printText("\nEsce dalla stanza.");
		printText("Il corridoio è completamente deserto.");
		printText("Silenzio totale.");
		printText("Un cartello indica: PIANO 2");
		printText("In fondo al corridoio, un ascensore illuminato.");

		printText("\nCosa fai?");
		printText("1 - Vai diretto all'ascensore");
		printText("2 - Esplora il piano prima");
		System.out.print("\n" + ANSI_BOLD + "Scelta: " + ANSI_RESET);

		int scelta = sc.nextInt();

		if (scelta == 1) {
			printText("Ti dirigi verso l'ascensore...");
			printText("*BEEP* ACCESSO NEGATO - TESSERA RICHIESTA");
			popaText("Merda. Devo cercare una tessera.");
		}

		printText("\nTi avvicini alla reception.");
		printText("Cartelle sparse ovunque.");
		printText("Una attira la tua attenzione...");

		printText("\nLeggi la cartella?");
		printText("1 - Sì");
		printText("2 - No");
		System.out.print("\n" + ANSI_BOLD + "Scelta: " + ANSI_RESET);

		if (sc.nextInt() == 1) {
			printText("Apri la cartella...");
			Thread.sleep(1000);
			printText("'PROGETTO CYBORG - SOGGETTO 247'");
			printText("'Innesto braccio bionico - FASE SPERIMENTALE'");
			printText("'Sede: Ospedale Torvaianica - Sezione Segreta'");

			popaText("Torvaianica?! Ma che cazzo...");
			popaText("Esperimenti... su di me?!");
		}

		printText("\nPasși pesanti in corridoio.");
		Thread.sleep(1000);
		nemicoText("EHI TU! FERMO LÌ!");

		printText("Una guardia armata appare!");
		nemicoText("I pazienti non possono lasciare le stanze!");

		popaText("Vaffanculo!");

		printText("\nCOMBATTIMENTO INEVITABILE!");

		Nemico guardia = new Nemico("Guardia di Sicurezza", 50, 12);
		if (combat(guardia)) {
			printText("\nLa guardia cade a terra.");
			popa.aggiungiOggetto(new Oggetto("Tessera Magnetica", "Apre l'ascensore"));
			popa.equipArma(new Arma("Pistola", 20, 35));
			popa.aggiungiHashish(1.0);

			printPickUp("+Tessera Magnetica");
			printPickUp("+Pistola");
			printPickUp("+1g hashish");

			popaText("Ora posso usare l'ascensore...");

			printText("\nMa prima di andare, senti un gemito dalla stanza 204.");
			printText("Entri e trovi un paziente legato.");

			printText("PAZIENTE: Per favore... aiutami!");
			printText("PAZIENTE: Fanno esperimenti terribili qui!");

			printText("\nLiberi il paziente?");
			printText("1 - Sì");
			printText("2 - No, vai all'ascensore");
			System.out.print("\n" + ANSI_BOLD + "Scelta: " + ANSI_RESET);

			if (sc.nextInt() == 1) {
				printText("Liberi il paziente.");
				printText("PAZIENTE: Grazie! Ascolta bene...");
				printText("PAZIENTE: Il tuo braccio può essere attivato!");
			} else {
				printText("=== FINE CAPITOLO 2 ===");
			}
		}
	
	
	}	
	public static void main(String[] args) throws Throwable {
		GameLoop game = new GameLoop();
		game.capitolo1();
		game.capitolo2();
	}
}
