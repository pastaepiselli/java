package sudoku;


import java.util.ArrayList;
import java.util.Collections;


public class GenerateSudoku {
	int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	// sudoku generato in questo modo
//	String[] soluzione = {
//			"387491625",
//			"241568379",
//			"569327418",
//			"758619234",
//			"123784596",
//			"496253187",
//			"934176852",
//			"675832941",
//			"812945763"
//	};
	int[][] grid = new int[9][9];
	
	public GenerateSudoku() {
		fillGrid(0, 0);
	}
	boolean fillGrid(int r, int c) {
		if (r == 9) return true; // sudoku finito
		
		// calcolo la prossima posizione
		int nextR = (c == 8) ? r + 1 : r;
		int nextC = (c + 1) % 9;
		
		int[] nums = shuffleNumbers();
		
		for(int n : nums) {
			if (isValid(r, c, n)) {
				grid[r][c] = n;
				
				// controllo inserimento del prossimo numero
				if (fillGrid(nextR, nextC)) return true;
				
				// backtrack
				grid[r][c] = 0;
			}
		}
		return false;
	}
	
	boolean isValid(int r, int c, int n) {

	    // controllo nella riga
	    for (int i = 0; i < 9; i++)
	        if (grid[r][i] == n) return false;

	    // controllo nella coolna
	    for (int i = 0; i < 9; i++)
	        if (grid[i][c] == n) return false;

	    // box 3x3 questo non so bene come controlli
	    int boxRow = (r / 3) * 3;
	    int boxCol = (c / 3) * 3;

	    for (int i = boxRow; i < boxRow + 3; i++)
	        for (int j = boxCol; j < boxCol + 3; j++)
	            if (grid[i][j] == n) return false;

	    return true;
	}

	int[] shuffleNumbers() {
		ArrayList<Integer> nums = new ArrayList<>();
		for(int n : numbers) {
			nums.add(n);
		}
		
		Collections.shuffle(nums);
		
		// trasformo in uno stream, porto da integer a int e lo converto in un array
		return nums.stream().mapToInt(i -> i).toArray();
	}
	public String[] getGrid() {
		 String[] result = new String[9];

		    for (int r = 0; r < 9; r++) {
		        StringBuilder sb = new StringBuilder();
		        for (int c = 0; c < 9; c++) {
		            if (grid[r][c] == 0)
		                sb.append('-');
		            else
		                sb.append(grid[r][c]);
		        }
		        result[r] = sb.toString();
		    }
		   return result;
	}
	
	public void printGrid() {
	    for (int r = 0; r < 9; r++) {
	        for (int c = 0; c < 9; c++) {
	            System.out.print(grid[r][c] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public String[] mode(String difficulty) {
	    int[][] tempGrid = new int[9][9];

	    // copia griglia completa
	    for (int r = 0; r < 9; r++)
	        for (int c = 0; c < 9; c++)
	            tempGrid[r][c] = grid[r][c];

	    int holes = 0;
	    switch (difficulty) {
	        case "Easy":
	            holes = 35;
	            break;
	        case "Medium":
	            holes = 45;
	            break;
	        case "Hard":
	            holes = 55;
	            break;
	    }

	    // rimuovo numeri
	    while (holes > 0) {
	        int r = (int)(Math.random() * 9);
	        int c = (int)(Math.random() * 9);

	        if (tempGrid[r][c] != 0) {
	            tempGrid[r][c] = 0;
	            holes--;
	        }
	    }

	    // conversione in String[]
	    String[] result = new String[9];

	    for (int r = 0; r < 9; r++) {
	        StringBuilder sb = new StringBuilder();
	        for (int c = 0; c < 9; c++) {
	            if (tempGrid[r][c] == 0)
	                sb.append('-');
	            else
	                sb.append(tempGrid[r][c]);
	        }
	        result[r] = sb.toString();
	    }

	    return result;
	}



	
	
}
