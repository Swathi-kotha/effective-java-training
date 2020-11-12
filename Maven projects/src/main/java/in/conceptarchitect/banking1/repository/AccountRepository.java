package in.conceptarchitect.banking1.repository;

import java.util.Collection;

import in.conceptarchitect.banking1.core.BankAccount;

public interface AccountRepository {

	int addAccount(BankAccount account);

	BankAccount getAccountById(int accountNumber);

	void removeAccount(int accountNumber);

	Collection<BankAccount> getAllAccounts();

	default void save() {
		
	}

	default void save(BankAccount account) {
		save();
	}
}