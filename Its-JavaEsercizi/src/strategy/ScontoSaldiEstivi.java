package strategy;

public class ScontoSaldiEstivi implements Sconto {
	@Override
	public double applica(double totale) {
		// 25%
		return totale * 0.75;
	}
	
}
