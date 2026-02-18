package thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Counter c1 = new Counter("pippo", 100);
		Counter c2 = new Counter("caco", 200);
		
		c1.start();
		c2.start();
		
		
		c1.join(); // il thread corrente aspetta c1
		c2.join(); // il therad corrente aspetta c2
		
		
		Thread c3 = new Thread(new CountDown(10, "minnie"), "minnie");
		
		
		
		c3.start();
		c3.join();

		System.out.println("Fine del processo"); // con join questa stampa la vedro alla fine
		

	}

}
