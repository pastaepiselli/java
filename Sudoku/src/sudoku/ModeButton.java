package sudoku;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ModeButton extends JButton {
	private String text;
	private Sudoku sudoku;
	
	public ModeButton(String text, Sudoku sudoku) {
		this.sudoku = sudoku;
		this.setText(text);
		this.setFont(new Font("Arial", Font.BOLD, 13));
		this.setFocusable(false);
		
		
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ottengo bottone premuto
				JButton mode = (JButton) e.getSource();
				
				// prendo difficolta scritta nel bottone
				String difficulty = mode.getText();
				
				GenerateSudoku gen = new GenerateSudoku();
				sudoku.changeMode(gen.getGrid(), gen.mode(difficulty), difficulty);
				
						
			}
		});
	}
}
