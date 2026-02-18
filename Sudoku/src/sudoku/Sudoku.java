package sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoku {


	int boardWidth = 600;
	int boardHeight = 750;

	String[] puzzle = {
			"--74916-5",
			"2---6-3-9",
			"-----7-1-",
			"-586----4",
			"--3----9-",
			"--62--187",
			"9-4-7---2",
			"67-83----",
			"81--45---"
	};
	
	String[] soluzione = {
			"387491625",
			"241568379",
			"569327418",
			"758619234",
			"123784596",
			"496253187",
			"934176852",
			"675832941",
			"812945763"
	};
	
	

	JFrame frame = new JFrame("Sudoku");
	JLabel textLabel = new JLabel() ;
	JPanel textPanel = new JPanel();
	JPanel boardPanel = new JPanel(); // pannello in cui andra la griglia dei numeri
	JPanel buttonsPanel = new JPanel();
	JPanel modePanel = new JPanel();
	JLabel difficultyText = new JLabel();
	
	// dove andra la difficola e i numeri 
	JPanel southPanel = new JPanel();
	
	// tenere traccia del numero sotto selezionato
	JButton numSelected = null;
	int errors = 0;
	
	int emptyTiles = countEmptyTiles();

	public Sudoku() {
		//		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando si preme la x la finestra si chiude
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout()); // possiamo insesire ovunque dei componenti nel frame

		// stile, posizione e inserimento testo
		textPanel.setLayout(new BorderLayout());
		textLabel.setFont(new Font("Arial", Font.BOLD, 30));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setText("Sudoku: 0");
		
		difficultyText.setText("Easy");
		difficultyText.setFont(new Font("Arial", Font.BOLD, 30));
		difficultyText.setForeground(Color.blue);

		textPanel.add(textLabel); // aggiungo al frame
		textPanel.add(difficultyText, BorderLayout.LINE_START);
		
		frame.add(textPanel, BorderLayout.NORTH); // inserisco e specifico posizione
		

		boardPanel.setLayout(new GridLayout(9, 9));
		setUpTiles();

		// appena abbiamo aggiunto tutte le tile inseriamo la board
		frame.add(boardPanel, BorderLayout.CENTER); // specifichiamo al centro
		
		buttonsPanel.setLayout(new GridLayout(1, 9));
		setUpButtons(); // inserisco i bottoni con i numeri
		
		southPanel.setLayout(new BorderLayout());
	
		southPanel.add(buttonsPanel, BorderLayout.CENTER); // aggiungo numeri selezionabili
		
		// difficolta
		
		modePanel.add(new ModeButton("Easy", this));
		modePanel.add(new ModeButton("Medium", this));
		modePanel.add(new ModeButton("Hard", this));
		southPanel.add(modePanel, BorderLayout.SOUTH);
		
		frame.add(southPanel, BorderLayout.SOUTH);
		
		// button per il reset
		textPanel.add(new ResetButton(this), BorderLayout.EAST); // crea un ResetButton e passagli questo Sudoku.
		
		

		// si imposta visibile appena tutto e stato inserito per evitare che a volte non carichi tutto
		frame.setVisible(true);
		
		

	}

	void setUpTiles() {
		for (int r = 0; r < 9; r++) { // per ogni row
			// controllo ogni colonna
			for (int c = 0; c < 9; c++) {
				Tile tile = new Tile(r, c);
				// accediamo al puzzle nella row e al carattere c (colonna)
				char tileChar = puzzle[r].charAt(c); 



				if (tileChar != '-') {
					tile.setFont(new Font("Arial", Font.BOLD, 20));
					// setText richiede una stringa, con value of estraiamo una stringa dal char
					tile.setText(String.valueOf(tileChar));
					tile.setBackground(Color.LIGHT_GRAY);

				} else { // tile vuota
					tile.setFont(new Font("Arial", Font.BOLD, 20));
					tile.setBackground(Color.white);
				}
				// controllo angoli (spessore sia basso che destra
				if ((r == 2 && c == 2) || (r == 2 && c == 5) || (r == 5 && c == 2) || (r == 5 && c == 5)) { // caso per angoli
					tile.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.black));
				}

				else if (r == 2 || r == 5) {	// linea piu spessa per la separazioen in quadarti 3x3
					tile.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.black));
				} else if (c == 2 || c == 5) {
					tile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));

				} else {
					tile.setBorder(BorderFactory.createLineBorder(Color.black));
				}
				// rimuoviamo effetto di un rettangolo attorno al testo quando si poggia in cursore
				tile.setFocusable(false);

				// aggiungiamo alla board
				boardPanel.add(tile); 
				
				tile.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Tile tile = (Tile) e.getSource(); // ritorna oggetto premuto
						
						// otteniamo le coordinate della tile premuta
						int r = tile.r;
						int c = tile.c;
						
						// se un numero e stato selezionato
						if (numSelected != null) {
							
							// se si preme una tile con il numero gia inserito
							if (!tile.getText().isEmpty()) {
								return; // non fa niente
							}
							String numSelectedText = numSelected.getText(); // salvo il valore 
							
							// controllo se matcha la soluzione
							
							// ottenetndo il valore in quelle coordinate della soluzione
							String tileSolution = String.valueOf(soluzione[r].charAt(c));
							
							if (tileSolution.equals(numSelectedText)) { // corretto
								tile.setText(numSelectedText); // inseriamo il alore
								// tolgo una emptyTile
								emptyTiles--;
								if (checkSolved()) { // se risolto
									textLabel.setText("Sudoku solved!! Errors: " + String.valueOf(errors));
									// cambia il testo in alto
								}
							} else { // valore sbagliato
								errors += 1;
								textLabel.setText("Sudoku: " + String.valueOf(errors));
							}
						}
						
					}
				});
			}
		}
	}
	void setUpButtons() {
		for (int i = 1; i< 10; i++) {
			// creo i 9 bottoni
			JButton button = new JButton();
			button.setFont(new Font("Arial", Font.BOLD, 20));
			// ad ognugno inseisco il numero 
			button.setText(String.valueOf(i)); // x inserire converto a stringa :P
			// sempre per il triangolino
			button.setFocusable(false);
			button.setBackground(Color.white);
			buttonsPanel.add(button);
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) { // e sta per evento
					// prendo la source la converto in un bottone 
					JButton button  = (JButton) e.getSource();
					
					// se si seleziona un altro numero
					if (numSelected != null) { 
						// l'altro torna bianco il background
						numSelected.setBackground(Color.white);
					}
					// e il numero selezionato dall'utente
					numSelected = button;
					button.setBackground(Color.LIGHT_GRAY);
					
				}
			});
		}
	}
	
	int countEmptyTiles() {
		// contano le tiles con - (vuote)
		int count = 0;
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (puzzle[r].charAt(c) == '-') {
					count++;
				}
			}
		}
		return count;
	}
	boolean checkSolved() {
		// se nessuna e vuota e risolta
		if (emptyTiles == 0) {
			return true;
		}
		return false;
	}
	// svuotare le caselle,  resettare il conteggio errore e ricontare le caselle vuote
	void resetGame() {
		// rimuove tutte le tiles
		boardPanel.removeAll();
		
		// le reinseisce
		setUpTiles();
		
		textLabel.setText("Sudoku: 0"); // reimposta il testo
		emptyTiles = countEmptyTiles();
		errors = 0;
		
		// se ce un numero selezionato 
		if (numSelected != null) {
			// cambia background e lo deselezionaq
		    numSelected.setBackground(Color.white);
		    numSelected = null;
		}

		
		// i componenti sono cambiati
		boardPanel.revalidate(); // riconta le dimensioni e robe
		boardPanel.repaint(); // ridisegna tutto il pannello
	}
	
	void changeMode(String[]newGridSolved, String[] newGridPuzzle, String difficulty) {
		
		// cambio mappa e resetto
		puzzle = newGridPuzzle;
		soluzione = newGridSolved;
		
		// cambio testo della difficolta
		difficultyText.setText(difficulty);
		
		
		resetGame();
	}

}
