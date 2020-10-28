package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.SavingsAccount;

public class BankTests {
	Bank bank = new Bank("Vivek", 20);
	int first = 0;
	int second = 0;
	String password = "Swa";
	BankAccount account;
	SavingsAccount savingsaccount;

	@Before
	public void init() {
		savingsaccount = new SavingsAccount("swa", "swa", 1000);

		first = bank.openAccount("savings", "Swa", "Swa", 1000);
		second = bank.openAccount("savings", "Sri", "Sri", 500);

	}

	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result = bank.transfer(1, 500, "Swa", 15);
		assertFalse(result);

	}

	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result = bank.transfer(9, 500, "Swa", 1);
		assertFalse(result);

	}

	@Test
	public void transfer_shouldFailForInvalidPassword() {

		boolean result = bank.transfer(12, 500, "aaa", 2);
		assertFalse(result);

	}

	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		boolean result = bank.transfer(first, 500000, "Swa", second);
		assertFalse(result);

	}

	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result = bank.transfer(first, 100, "Swa", second);
		assertTrue(result);
	}

	@Test
	public void creditInterest_creditsOneMonthOfInterest() {

		double rate = 12;
		double updatedBalance = 1000 + 1000 * rate / 1200;

		// act
		savingsaccount.creditInterest(rate);

		// assert
		assertEquals(updatedBalance, savingsaccount.getBalance(), 0.2);

	}

	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result = false;
		BankAccount account = bank.getAccount(5, "swa");
		if (account != null)
			result = bank.close(5, "suni");
		assertFalse(result);

	}

	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		boolean result = bank.withdraw(4, 1000, "Swa");
		assertFalse(result);

	}

	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		bank.openAccount("savings", "Durga", "Durga", 1000);
	}

}
