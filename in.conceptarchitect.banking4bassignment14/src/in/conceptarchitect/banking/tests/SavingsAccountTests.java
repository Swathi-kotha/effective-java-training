package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

public class SavingsAccountTests {

	SavingsAccount account;
	String name="Vivek";
	String password="p@ss";
	int balance=15000;
	int minBalance=5000;

	@Before
	public void init() {
		
		account=new SavingsAccount(name, password, balance);
		
	}
	
	@Test
	public void withdraw_failsForWrongPassword() {
		try {
			account.withdraw(1, "wrong-password");
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDenominationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(balance-1, account.getBalance(), 0.01);
		//assertFalse(result);
		
		
	}
	
	
	@Test
	public void withdraw_failsIfNetBalancePostWithdrawRedudesBelowMinBalance() {
		
		 try {
			account.withdraw(balance-minBalance+1, password);
			assertNotEquals(balance-minBalance+1, account.getBalance(), 0.01);

		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDenominationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		//assertFalse(result);
	}
	
	@Test
	public void withdraw_succeedsIfPostWithdrawMinBalanceIsAvailable() {
		try {

			account.withdraw(balance-minBalance, password);
			assertEquals(balance-(balance-minBalance), account.getBalance(),0.01);

		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDenominationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void withdraw_reducesTheBalance() throws InsufficientBalanceException, InvalidCredentialsException, InvalidDenominationException {
		
		account.withdraw(1000, password);
		
		assertEquals(balance-1000, account.getBalance(),0.01);
	}
	
	@Test
	public void creditInterest_addsMonthlyInterstToBalance() {

		//arrange
		double rate=12;
		double updatedBalance= balance+ balance*rate/1200;
		
		//act
		account.creditInterest(rate);		
		
		
		//assert
		assertEquals(updatedBalance, account.getBalance(),0.2);  //balance shouldn't change after crediting interest 
		
		
	}


	

}
