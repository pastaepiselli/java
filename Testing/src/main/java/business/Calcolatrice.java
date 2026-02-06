package business;

public class Calcolatrice {
	public int somma(int a, int b) {
		return a + b;
	}

	public int potenzaPositiva(int a, int b) throws Exception {
		if(a > 0 && b > 0)
			return (int)Math.pow(a, b);
		else
			throw new Exception("Numeri non positivi");
	}
	public double dividi(int a, int b) throws Exception {
		if(b!= 0)
			return (double)a / b;
		else 
			throw new Exception("errore divisione per zero");
	}
	
	
}
