package model.services;

public interface OnlinePaymentService {

	double interest(double amount);
	
	double paymentFee(double amount, int months);
}
