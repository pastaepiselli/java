package laBanca;

public class ThreadPatrimonio extends Thread {
	private Banca banca;
	public ThreadPatrimonio(Banca banca) {
		this.banca = banca;

	}

	@Override
	public void run() {
		while (true) {
			System.out.println(banca.getPatrimonio());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
