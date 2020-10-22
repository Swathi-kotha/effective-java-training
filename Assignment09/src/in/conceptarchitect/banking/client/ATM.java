package in.conceptarchitect.banking.client;

import java.util.Scanner;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.utils.Input;

public class ATM {
	
	
	Bank bank =new Bank("ICCI",4.5);
	Input keyboard=new Input();
	private int accountNumber;
	BankAccount bankAccount;
	Scanner sc=new Scanner(System.in);
	
	public void connectTo(Bank bank) {
		// TODO Auto-generated method stub
		this.bank=bank;
	}
	
	
	public void start() {
		
		displayWelcomeScreen();		
		
	}


	public void displayWelcomeScreen() {
		// TODO Auto-generated method stub
		while(true) {
			accountNumber=keyboard.readInt("accountNumber?");
			if(accountNumber==-999) {		//hidden admin menu
				if(keyboard.readString("error:").equals("NIMDA"))
					if(displayAdminMenu().equals("QUIT"))
						return;
			}else
				displayUserMenu();
		
		}
	}


	private void displayUserMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome "+accountNumber);
		
		int choice;
		do {
			choice=keyboard.readInt("1. Deposit  2. Widthraw  3. Transfer  4. Show 5. Close Account  0. Exit: ");
			switch(choice) {
			case 1:
				doDeposit(); break;
			case 2:
				doWithdraw(); break;
			case 3:
				doTransfer(); break;
			case 4:
				doShow(); break;
			case 5:
				doCloseAccount(); break;
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		
		
	}


	private void doCloseAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter account Number");
		accountNumber = sc.nextInt();
		System.out.println("Enter  Password");
		String password= sc.next();
		bank.close(accountNumber, password);
		
		
		
	}


	private void doShow() {
		// TODO Auto-generated method stub
		System.out.println("Enter account Number");
		accountNumber = sc.nextInt();
		bank.show(accountNumber);
		
	}


	private void doTransfer() {
		// TODO Auto-generated method stub
		System.out.println("Enter sourceAccount Number");
		int sourceAccountNumber = sc.nextInt();
		System.out.println("Enter  Password");
		String password= sc.next();
		System.out.println("Enter  amount");
		double amount = sc.nextDouble();
		System.out.println("Enter targetAccount Number");
		int targetAccountNumber = sc.nextInt();
		bank.transfer( sourceAccountNumber,amount, password, targetAccountNumber);
		
	}


	private void doWithdraw() {
		// TODO Auto-generated method stub
		System.out.println("Enter account Number");
		accountNumber = sc.nextInt();
		System.out.println("Enter  Password");
		String password= sc.next();
		System.out.println("Enter  money to withdraw");
		double amount = sc.nextDouble();
		
		
		
		// TODO Auto-generated method stub
		bank.withdraw(accountNumber, amount, password);
		
		
	}


	private void doDeposit() {
		System.out.println("Enter account Number");
		accountNumber = sc.nextInt();
		System.out.println("Enter the depositing money");
		double amount = sc.nextDouble();
		
		// TODO Auto-generated method stub
		bank.deposit(accountNumber, amount);
		
	}


	private String displayAdminMenu() {
		// TODO Auto-generated method stub
		int choice;
		do {
			choice=keyboard.readInt("1. Open Account  2. Credit Interest  3. Print Accounts  4. Shutdown  0. Exit: ");
			switch(choice) {
			case 1:
				doOpenAccount(); break;
			case 2:
				doCreditInterest(); break;
			case 3:
				doPrintAccounts(); break;
			case 4:
				return "QUIT";
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		return "";
	}


	private void doPrintAccounts() {
		bank.printAccountList();
		// TODO Auto-generated method stub
		
	}


	private void doCreditInterest() {
		// TODO Auto-generated method stub
		
		
		bank.creditInterests();
		
	}


	private void doOpenAccount() {
		System.out.println("Enter account name");
		String name = sc.next();
		System.out.println("Enter  Password");
		String password= sc.next();
		System.out.println("Enter  amount");
		double amount = sc.nextDouble();
		
		
		bank.openAccount(name, password, amount);
		
	}	
	
	
	
	
	
}
