package corridori;

import java.util.Random;

public class Corridore implements Runnable {
	private static int posizione = 0;
	private Random random = new Random();
	private int tappe;
	private String nome;
	private int posizionamento;
	public Corridore(int tappe, String nome) {
		this.tappe = tappe;
		this.nome = nome;
	}
	@Override
	public void run() {
		for(int i = 0; i < tappe; i++) {
			System.out.println(nome + " ha completato la tappa " + i);
			
			try {
				Thread.sleep((int) random.nextInt(200, 801));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		posizione++;
		posizionamento = posizione;
		System.out.println(nome + " e arrivato in posizione " + posizione);
		
		

	}
	public String getNome() {
		return nome;
	}
	public int getPosizionamento() {
		return posizionamento;
	}
	
	
	
	

}
