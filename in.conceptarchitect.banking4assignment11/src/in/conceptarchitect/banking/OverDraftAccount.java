package in.conceptarchitect.banking;

public class OverDraftAccount extends BankAccount {

	public OverDraftAccount(String name, String password, double amount) {
		super(name, password, amount);
		// TODO Auto-generated constructor stub
		
	}
		
		@Override
		public boolean withdraw(double amount, String password) {		
			//write the additional logic that we need
			if(amount>= getBalance()+getBalance()%10)
				return false;		
			else
				return super.withdraw(amount, password); //let super class work
			
		}
	}


