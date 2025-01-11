package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService paymentService;

	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months) {
		double amountContractPerMonth = contract.getTotalValue()/months;
		for(int i = 1; i <= months; i++) {
			double amountWithFee = amountContractPerMonth + paymentService.paymentFee(amountContractPerMonth, i);
			double paymentInstallment = amountWithFee + paymentService.interest(amountWithFee);
			LocalDate installmentDate = contract.getDate().plusMonths(i);
			contract.addInstallment(new Installment(installmentDate, paymentInstallment));
			
		}
	}
}
