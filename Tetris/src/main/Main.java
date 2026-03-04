package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Tetris");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	
		
		// Aggiungiamo game panel a window
		GamePanel gp = new GamePanel();
		window.add(gp);
		
		// la window si adatta alla size del pannello
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
