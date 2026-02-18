package thread;

public class Counter extends Thread {
	private int max; // numero massimo del conteggio

	public Counter(String nome, int max) {
		super(nome);
		this.max = max;
	}

	@Override
	public void run() {
		for(int i = 0; i <= max; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + i);
		}
	}
	
	
	
}
