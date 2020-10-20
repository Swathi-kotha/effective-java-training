package app.bank.operations;

import java.util.HashMap;
import java.util.Map;

import app.bank.model.AccountDetails;

public class BankOperations {
	AccountDetails accountDetails = new AccountDetails();
	Map<Integer, AccountDetails> map = new HashMap<>();

	public void createAccount(String name, int accountNumber, String password, double balance) {
		boolean valid = map.get(accountNumber) != null;
		if (!valid) {
			accountDetails.setAccountNumber(accountNumber);
			accountDetails.setBalance(balance);
			accountDetails.setName(name);
			accountDetails.setPassword(password);
			map.put(accountNumber, accountDetails);
			System.out.println("User Account of " + accountDetails.getName()
					+ " created successfully with account number " + accountDetails.getAccountNumber());
		} else {
			System.out.println("Account Already Exists");
		}
	}

	public void depositMoney(int accountNumber, double amount) {
		boolean valid = map.get(accountNumber) != null;
		if (valid) {
			if (amount > 0) {
				double oldBalance = accountDetails.getBalance();
				double currentBalance = oldBalance + amount;
				accountDetails.setBalance(currentBalance);
				map.put(accountNumber, accountDetails);
				System.out.println("Money deposited successfuly \n Current balance in account is " + currentBalance);
			} else {
				System.out.println("Please enter valid amount");
			}
		} else {
			System.out.println("Account Does not Exist,Please enter Valid Account");
		}
	}

	public void withdrawMoney(int accountNumber, double amount) {
		boolean valid = map.get(accountNumber) != null;
		if (valid) {
			double balance = accountDetails.getBalance();
			if (balance > amount) {
				double currentBalance = balance - amount;
				accountDetails.setBalance(currentBalance);
				map.put(accountNumber, accountDetails);
				System.out.println("Money withdrawn successfuly\nCurrent balance in account is " + currentBalance);
			} else {
				System.out.println("Insufficient Balance");
			}
		} else {
			System.out.println("Account Does not Exist,Please enter Valid Account");
		}
	}

	public void creditInterestRate(int accountNumber, float rate) {
		boolean valid = map.get(accountNumber) != null;
		if (valid) {
			double balance = accountDetails.getBalance();
			double interest = balance * rate / 12.00;
			balance+=interest;
			accountDetails.setBalance(balance);
			System.out.println("Current Balance is " + balance);
		} else {
			System.out.println("Account Does not Exist,Please enter Valid Account");
		}
	}

}
