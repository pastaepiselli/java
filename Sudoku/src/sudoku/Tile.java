package sudoku;

import javax.swing.JButton;

public class Tile extends JButton {
	// coordinate nel numero
	int r; // row num
	int c; // col num
	Tile(int r, int c){
		this.r = r;
		this.c = c;
	}
}
