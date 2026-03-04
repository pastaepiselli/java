package toDoApp;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		
		TaskDAO tDao = new TaskDAO();
		
		while (true) {
			System.out.print("Inserire task?: S/n");
			String scelta = sc.next();
			
			if (scelta.toLowerCase().equals("s")) {
				
				System.out.print("Inserire titolo task: ");
				String titolo = sc1.nextLine();
				tDao.insertTask(new TaskDTO(titolo));
			}
		}
	
		

	}

}
