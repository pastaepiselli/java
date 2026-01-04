package test;



public class Primitivi {
	public static void main(String[] args) {
		int a = 0;
		System.out.println(a);
		
		double x = 12.4;
		System.out.println(x);
		
		/*if the type is wrong i can change or cast
		 * in memoria non cambia niente ma il quella istruzione
		 * oscura i byte che sforano*/
		byte numero = (byte) 1000; // in questo caso 1000 diventa -24
		System.out.println(numero);
					
		// variabile per i caratteri necessaria con apici singoli		
		char lettera = '\n';
		
		boolean flag = false;
		
		// operatori
		
		int num1 = 10;
		int num2  = 4;
		
		// in questo caso della divisione ritorna 2.0 perche la divisione viene effetuata tra int 
		// ignorando il resto
		double div = num1 / num2;
		
		// per il risutato esatto almeno uno deve essere un float / double
		System.out.println(div);
		
		// con operazioni a tipi diversi il risultato viene castato nel tipo piu preciso
		
		
	}
}
