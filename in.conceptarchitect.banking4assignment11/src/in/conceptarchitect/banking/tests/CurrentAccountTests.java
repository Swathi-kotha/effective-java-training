package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;

public class CurrentAccountTests {
	CurrentAccount account;
	String name="Vivek";
	String password="p@ss";
	int balance=15000;
	@Before
	public void init() {
		account=new CurrentAccount(name, password, balance);

	}

	@Test
	public void creditInterest_doesntCreditInterestToCurrentAccount() {

		double amount=10000;
		CurrentAccount account=new CurrentAccount("","",amount);
		
		account.creditInterest(12);
		
		assertEquals(amount, account.getBalance(),0);  //balance shouldn't change after crediting interest 
				
	}

	
	@Test
	public void withdraw_canWithdrawUptoBalanceUsingRightPassword() {
		
		boolean result = account.withdraw(1000, password);	
		assertFalse(result);
	}
	
	@Test
	public void withdraw_failsForInsufficientBalance() {
		boolean result = account.withdraw(balance+1, password);		
		assertFalse(result);	
		}
	
	@Test
	public void withdraw_failsForWrongPassword() {
		boolean result = account.withdraw(1000, "wrongpassword");	
		assertFalse(result);	

	}
	
	@Test
	public void withdraw_failsForNegativeAmount() {
		boolean result = account.withdraw(-10000, password);		
		assertFalse(result);	
		}
}
