public class CheckingAccount extends Account {
	private int amount;
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(int amount) {
		this.amount = amount;
	}
	
	public CheckingAccount(int id, String name, int amount) {
		setId(id);
		setName(name);
		this.amount = amount;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void depositChecking(int d) {
		int newAmount = amount+d;
		setAmount(newAmount);
	}
	
	public void withdrawlChecking(int w) {
		if(w<amount) {
			int newAmount = amount-w;
			setAmount(newAmount);
		}else {
			System.out.println("ERROR: Withdrawl Amount is Over Account Balance");
		}
	}
	
	public void printCheckingAccountDetails() {
		System.out.println("\t"+getId()+"\t"+getName()+"\t"+getAmount());
	}

}
