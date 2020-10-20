package app.bank;

import java.io.Console;
import java.util.Scanner;

import app.bank.operations.BankOperations;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int user_choice;
		BankOperations bankOperations = new BankOperations();

		do {
			String name;
			int accountNumber;
			double amount;
			System.out.println(
					" 1: Open a new bank account \n 2: Deposit money into  bank account\n 3: Withdraw money from bank account \n 4: Credit Interest \n 5: Quit \n Please enter your Choice");
			user_choice = sc.nextInt();
			switch (user_choice) {
			case 1:
				System.out.println("Enter a customer name");
				name = sc.next();
				System.out.println("Enter account Number");
				accountNumber = sc.nextInt();
				System.out.println("Enter a opening balance");
				double balance = sc.nextDouble();
				System.out.println("Enter password");
				String password = sc.next();				
				bankOperations.createAccount(name, accountNumber, password, balance);
				break;
			case 2:
				System.out.println("Enter account Number");
				accountNumber = sc.nextInt();
				System.out.println("Enter the depositing money");
				amount = sc.nextDouble();
				bankOperations.depositMoney(accountNumber, amount);
				break;
			case 3:
				System.out.println("Enter account Number");
				accountNumber = sc.nextInt();
				System.out.println("Enter Withdrawing money");
				amount = sc.nextDouble();
				bankOperations.withdrawMoney(accountNumber, amount);
				break;
			case 4:
				System.out.println("Enter account Number");
				accountNumber = sc.nextInt();
				System.out.println("Enter Interest Rate");
				float rate = sc.nextFloat();
				bankOperations.creditInterestRate(accountNumber, rate);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Please choose option from below");
			}
		} while (user_choice != 5);
	}
}
