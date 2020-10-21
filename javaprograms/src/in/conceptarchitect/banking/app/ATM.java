package in.conceptarchitect.banking.app;

import java.util.Scanner;

import in.conceptarchitect.banking.BankAccount;

public class ATM {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int userChoice;
		BankAccount bankAccount = null;
		do {
			String name;
			int accountNumber;
			double amount;
			String password;
			System.out.println(
					" \n \n1: Open a new bank account \n 2: Deposit money into  bank account\n 3: Withdraw money from bank account \n 4: Credit Interest \n 5:Display Account Details\n 6:Update Password \n7: Quit \n Please enter your Choice");
			userChoice = sc.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("Enter a customer name");
				name = sc.next();
				System.out.println("Enter account Number");
				accountNumber = sc.nextInt();
				System.out.println("Enter a opening balance");
				double balance = sc.nextDouble();
				System.out.println("Enter password");
				password = sc.next();
				System.out.println("Enter Interest Rate");
				double rate=sc.nextDouble();
				bankAccount=new BankAccount(name,accountNumber, password, balance, rate);
				System.out.println("Account Created Successfully");
				break;
			case 2:
				System.out.println("Enter password");
				password = sc.next();
				System.out.println("Enter the depositing money");
				amount = sc.nextDouble();
				bankAccount.depositMoney(password, amount);
				break;
			case 3:
				
				System.out.println("Enter Withdrawing money");
				amount = sc.nextDouble();
				System.out.println("Enter password");
				password = sc.next();
				bankAccount.withdrawMoney(password, amount);
				break;
			case 4:
				System.out.println("Enter password");
				password = sc.next();
				System.out.println("Enter Interest Rate");
				rate = sc.nextDouble();				
				bankAccount.creditInterestRate(password, rate);
				break;
			case 5:
				bankAccount.display();
				break;
			case 6:
				System.out.println("Enter New password");
				password=sc.next();
				bankAccount.updatePassword(password);
				break;
			case 7:			
				System.exit(0);
			default:
				System.out.println("Please choose option from below");
			}
		} while (userChoice != 7);
	}
}
