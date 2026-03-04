package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	public static final int width = 1280;
	public static final int height = 720;
	final int fps = 60;
	Thread gameThread;
	PlayManager pm;
	
	
	public GamePanel() {
		
		// panel settings
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.black);
		this.setLayout(null); // nessul layout base
	
		pm = new PlayManager();
		
		
	}
	
	void launchGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}



	@Override
	public void run() {
		// Game loop
		double drawInterval = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				// chiama draw e paintComponent
				repaint();
				delta--;
			}
		}
		
	}
	
	private void update() { // aggiorna le informazioni
		pm.update();
		
	}
	
	void draw() { // aggiona la gui
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// castiamo a graphics 2d
		Graphics2D g2 = (Graphics2D) g;
		pm.draw(g2);
	}
	
	
}
