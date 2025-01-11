package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.factory.ContractFactory;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		ContractService contractService = new ContractService(new PaypalService());

		//Data of contract
		Contract contract = ContractFactory.createContract(sc);	
		System.out.println("Number of installments: ");
		int months = sc.nextInt();
		
		//Contract processing
		System.out.println("INSTALLMENTS: ");
		contractService.processContract(contract, months);
		
		sc.close();
	}

}
