package laBanca;

public class Simulazione {
	
	public static void main(String[] args) {
		Banca banca = new Banca();
		
		ThreadConto thConto1 = new ThreadConto(1, banca);
		ThreadConto thConto2 = new ThreadConto(2, banca);
		ThreadConto thConto3 = new ThreadConto(3, banca);
		ThreadConto thConto4 = new ThreadConto(4, banca);
		ThreadConto thConto5 = new ThreadConto(5, banca);
		ThreadConto thConto6 = new ThreadConto(6, banca);
		ThreadConto thConto7 = new ThreadConto(7, banca);
		ThreadConto thConto8 = new ThreadConto(8, banca);
		ThreadConto thConto9 = new ThreadConto(9, banca);
		ThreadConto thConto10 = new ThreadConto(10, banca);
		
		
		ThreadPatrimonio thpatrimonio = new ThreadPatrimonio(banca);
		
		
		thConto1.start();
		thConto2.start();
		thConto3.start();
		thConto4.start();
		thConto5.start();
		thConto6.start();
		thConto7.start();
		thConto8.start();
		thConto9.start();
		thConto10.start();
		thpatrimonio.start();
	}
	
}
