package eserciziStringhe;

import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {
		System.out.print("Inserire la data: ");
		Scanner sc = new Scanner(System.in);
		
		String date = sc.next();
		
		// divido la data in una lista che si separata 
		String[] dateParts = date.split("/");
		
		String day = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];
		
		String monthName = "";
		switch(month.charAt(1)) {
		  case '1':
			  monthName = "January";
			  break;
		  case '2':
			  monthName = "February";
			  break;
		  case '3':
			  monthName = "March";
			  break;
		  case '4':
			  monthName = "April";
			  break;
		  case '6':
			  monthName = "May";
          		break;
		  case '7':
			  monthName = "June"; 
          		break;
		  case '8':
			  monthName = "July";
			  break;
//      case 8: b = "August";
//          break;
//      case 9: b = "September";
//          break;
//      case 10: b = "October";
//          break;
//      case 11: b = "November";
//          break;
//      case 12: b = "December";
//          break;
//		}
//		
		}
		System.out.println("Day: " + day);
		System.out.println("Month: " + monthName);
		System.out.println("Year: " + year);
		
		sc.close();
		
		
		

	}

}
