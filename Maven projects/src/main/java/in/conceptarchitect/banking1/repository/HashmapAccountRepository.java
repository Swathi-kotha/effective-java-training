package in.conceptarchitect.banking1.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import in.conceptarchitect.banking1.core.BankAccount;
import in.conceptarchitect.banking1.exceptions.InvalidAccountNumberException;

public class HashmapAccountRepository implements AccountRepository,Serializable{
	
	HashMap<Integer,BankAccount> accounts=new HashMap<Integer, BankAccount>();
	
	private int accountCount=0;
	 
	public int addAccount(BankAccount account) {
	
		
		accounts.put(account.getAccountNumber(), account);
		accountCount++;
		
		return account.getAccountNumber();
	}
	
	public BankAccount getAccountById(int accountNumber) {
		
		if(accounts.containsKey(accountNumber))
			return accounts.get(accountNumber);
		else		
			throw new InvalidAccountNumberException(accountNumber);
	}
	
	public void removeAccount(int accountNumber) {
		if(accounts.containsKey(accountNumber))
			accounts.remove(accountNumber);
		else
			throw new InvalidAccountNumberException(accountNumber);
	}
	
	public Collection<BankAccount> getAllAccounts() {
		return accounts.values();
	}

	public in.conceptarchitect.banking1.repository.BankAccount getAccountById(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
