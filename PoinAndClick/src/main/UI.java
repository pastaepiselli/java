package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {

    GameManager gm;

    JFrame window;
    JLabel hoverText;

    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm) {
        this.gm = gm;

        createMainField();
        createBackground();
        createSecondBackground();

        window.setVisible(true);
    }

    public void createMainField() {
    	
    	
    	
        window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea();
        messageText.setBounds(600, 900, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Pixel Operator", Font.PLAIN, 26));
        window.add(messageText);
        
        hoverText = new JLabel("");
    	hoverText.setForeground(Color.WHITE);
    	hoverText.setFont(new Font("Pixel Operator", Font.PLAIN, 18));
    	hoverText.setVisible(false);
    	hoverText.setOpaque(true);
    	hoverText.setBackground(new Color(0,0,0,180)); // sfondo semitrasparente
    	hoverText.setBounds(0,0,200,30);
    	window.add(hoverText);
    	
    	window.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
    	    @Override
    	    public void mouseMoved(java.awt.event.MouseEvent e) {
    	        hoverText.setLocation(e.getX() + 15, e.getY() + 10);
    	    }
    	});

    }

    public void createBackground() {

        // SCHERMATA 1
        bgPanel[1] = new JPanel();
        bgPanel[1].setBounds(350, 140, 1200, 650);
        bgPanel[1].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[1] = new JLabel();
        bgLabel[1].setBounds(0, 0, 1200, 650);
        bgLabel[1].setIcon(new ImageIcon(getClass().getClassLoader().getResource("corridoio1.jpeg")));
        bgPanel[1].add(bgLabel[1]);

        // AREA PORTA
        JLabel doorArea = new JLabel();
        doorArea.setBounds(900, 200, 150, 300); // CAMBIA QUI
        doorArea.setOpaque(false);
        bgPanel[1].add(doorArea);

        // INTERAZIONE PORTA
        doorArea.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                window.setCursor(new Cursor(Cursor.HAND_CURSOR));
                hoverText.setText("Entra nella stanza");
                hoverText.setVisible(true);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                window.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                hoverText.setText("");
                hoverText.setVisible(false);

            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                changeScreen(2);
            }
        });
    }

    public void createSecondBackground() {

        // SCHERMATA 2
        bgPanel[2] = new JPanel();
        bgPanel[2].setBounds(350, 140, 1200, 650);
        bgPanel[2].setLayout(null);
        window.add(bgPanel[2]);
        bgPanel[2].setVisible(false);

        bgLabel[2] = new JLabel();
        bgLabel[2].setBounds(0, 0, 1200, 650);
        bgLabel[2].setIcon(new ImageIcon(getClass().getClassLoader().getResource("monkeysad.png")));
        bgPanel[2].add(bgLabel[2]);
    }

    public void changeScreen(int screen) {

        for (int i = 1; i < bgPanel.length; i++) {
            if (bgPanel[i] != null) {
                bgPanel[i].setVisible(false);
            }
        }

        bgPanel[screen].setVisible(true);
        window.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        messageText.setText("");
        hoverText.setVisible(false);

    }
}
