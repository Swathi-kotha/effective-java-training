package in.conceptarchitect.banking;

public class BankAccount {
	public String name;
	public double balance;
	public String password;
	public int accountNumber;
	public double interestRate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", balance=" + balance + ", password=" + password + ", accountNumber="
				+ accountNumber + ", interestRate=" + interestRate + "]";
	}

	public BankAccount(String name, int accountNumber, String password, double balance,double rate) {
		createAccount(name,accountNumber, password,balance, rate);

	}

	public void createAccount(String name, int accountNumber, String password, double balance,double rate) {
		this.accountNumber=accountNumber;
		this.name=name;  
		this.password=password;		
		this.balance=balance; 
		interestRate=rate;
	}

	public void depositMoney(String password, double amount) {
		if(!this.password.equals(password)) {
			System.out.println("invalid credentials");
			return ;
		}else if (amount > 0) {
					balance = balance + amount;
					System.out
							.println("Money deposited successfuly \n Current balance in account is " + balance);
				} else {
					System.out.println("Please enter valid amount");
				}
					
	}

	public void withdrawMoney(String password, double amount) {
		if(!this.password.equals(password)) {
			System.out.println("invalid credentials");
			return ;
		}else if (balance > amount) {
					balance = balance - amount;
					System.out.println("Money withdrawn successfuly\nCurrent balance in account is " + balance);
				} else {
					System.out.println("Insufficient Balance");
				}
		}

	public void creditInterestRate(String password, double rate) {
		if(!this.password.equals(password)) {
			System.out.println("invalid credentials");
			return ;
		}else {
				balance =( balance * rate) / 1200;
				System.out.println("Interest is " + balance);
			} 
		}


public void updatePassword(String password) {
	this.password=password;
	System.out.println("Password Updated successfully");
	
}
public void display() {
	System.out.println("Account Number\t"+accountNumber); 
	System.out.println("Name\t"+name); 
	System.out.println("Password\t"+password); 
	System.out.println("Balance\t"+balance);
	System.out.println("Interest Rate\t"+interestRate); 
}
}
