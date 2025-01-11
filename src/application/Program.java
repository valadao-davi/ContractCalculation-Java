package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Data of contract
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int numberContract = sc.nextInt();
		System.out.print("Date(dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate dateContract = LocalDate.parse(sc.nextLine(), fmt);
		System.out.println("Amount: ");
		double amount = sc.nextDouble();
		System.out.println("Number of installments: ");
		int months = sc.nextInt();
		Contract contract = new Contract(numberContract, dateContract, amount);
		
		//Contract processing
		ContractService contractService = new ContractService(new PaypalService());
		System.out.println("INSTALLMENTS: ");
		contractService.processContract(contract, months);
		
		sc.close();
	}

}
