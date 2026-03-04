package adapter;

public class AdattatorePaymentSystem extends PaymentSystem implements PaymentProcessor  {
	
	
	
	@Override
	public void pay(double amount) {
		double t = amount * 100;
		super.makePayment((int) t);
	}

}
