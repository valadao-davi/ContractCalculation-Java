package model.services;

public class PaypalService implements OnlinePaymentService {
	
	public double paymentFee(double amount, int months) {
		return amount * (months/100);
	}
	
	public double interest(double amount) {
		return amount * 0.02;
	}
}
