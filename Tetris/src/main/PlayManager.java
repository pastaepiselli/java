package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PlayManager {
	
	// disegna ui
	
	// Main play area
	final int width = 350;
	final int heigth = 600;
	public static int left_x;
	public static int right_x;
	public static int top_y;
	public static int bottom_y;
	
	public PlayManager() {
		// TODO Auto-generated constructor stub
		left_x = (GamePanel.width / 2) - (width - 2);
		right_x = left_x + width;
		top_y = 50;
		bottom_y =  top_y + heigth;
	}
	
	void update() {
		
	}
	
	void draw(Graphics2D g2) {
		// draw play area frame
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(4f));
		g2.drawRect(left_x - 4, top_y - 4, width + 8, heigth + 8);
		
		// prossimo pezzo container 
		int x = right_x + 100;
		int y = bottom_y - 200;
		
		g2.drawRect(x, y, 200, 200);
		g2.setFont(new Font("Arial", Font.PLAIN, 30));
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("NEXT", x + 60, y + 60);
	}

}
