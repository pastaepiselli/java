package strategy;

public class ScontoSaldiInvernali implements Sconto {

	@Override
	public double applica(double totale) {
		// 15%
		return totale * 0.85;
	}
	
}
