package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ResetButton extends JButton {
	
	public ResetButton(Sudoku sudoku) {
		this.setBackground(Color.red);
		this.setText("Reset");
		this.setFocusable(false);
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sudoku.resetGame();
				
			}
		});
	}
	
	
}
