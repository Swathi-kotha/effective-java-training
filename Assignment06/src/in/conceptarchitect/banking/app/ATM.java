package in.conceptarchitect.banking.app;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.utils.Input;

public class ATM {

	public static void main(String[] args) {

		BankAccount bankAccount=new BankAccount(1, "Vivek","p@ss",20000,12);
		
		//a1.createAccount(1, "Vivek","p@ss",20000,12); //no need to call this line
		
		int choice=0;
		Input input=new Input();
		do {
			
			choice=input.readInt("\n\n1. Deposit\n2. Withdraw\n3.Credit Interst\n4.Update Password5.Show\n0.Exit\nPlease Choose Option:");			
			switch(choice) {
			case 1:
				bankAccount.deposit();
				break;
			case 2:
				bankAccount.withdraw();
				break;
				
			case 3:
				bankAccount.creditInterest();
				break;
				
			case 4:
				String password = input.readString("Enter New password");
				bankAccount.setPassword(password);
				System.out.println("Password Updated Successfully");
				break;
				
			case 5:
				bankAccount.show();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Input.Retry");
				
				
			}
			
			System.out.println("\n\n");
			
		}while(choice!=0);
		
		
		
		
		
		
		
	}

}
