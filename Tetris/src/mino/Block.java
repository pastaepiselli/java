package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

// singolo blocco dei tetrominos
public class Block extends Rectangle {
	public int x;
	public int y;
	public static final int size = 30;
	public Color c;
	
	public Block(Color c) {
		this.c = c;
	}
	
	void draw(Graphics2D g2) {
		g2.setColor(c);
		g2.fillRect(x, y, size, size);
	}
}
