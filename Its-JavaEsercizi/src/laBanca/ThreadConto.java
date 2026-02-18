package laBanca;

public class ThreadConto extends Thread {
	private int numero;
	private Banca banca;
	public ThreadConto(int numero, Banca banca) {
		this.numero = numero;
		this.banca = banca;
	}
	@Override
	synchronized public void run() {
		while (true) {
			try {
				banca.bonifico(numero,(int) Math.random() * 11, 500);
				
			} catch (ImportoNonValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
