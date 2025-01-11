package application;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter fmt = new DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter contract data: ");
		
		System.out.print("Number of contract: ");
		int number = sc.nextInt();
		
		sc.close();
	}

}
