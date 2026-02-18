package thread;

public class CountDown implements Runnable {
	private int max;
	private String nome;
	public CountDown(int max, String nome) {
		super();
		this.max = max;
		this.nome = nome;
	}
	@Override
	public void run() {
		for(int i = max; i >= 1; i--) {
			if (i == max / 2) {
				
				String s = null;
				System.out.println(s.length());
				 
			}
			System.out.println(Thread.currentThread().getName() + "-" + i);
		}
		
	}
	
	
	
}
