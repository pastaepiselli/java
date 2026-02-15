package strategy;

public class ScontoBlackFriday implements Sconto {

	@Override
	public double applica(double totale) {
		// 20%
		return totale * 0.8;
	}
	
}
