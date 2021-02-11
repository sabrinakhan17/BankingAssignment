public class SavingsAccount extends Account{
	private int amount;
	private int fee = 50;
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(int amount, int fee) {
		this.amount = amount;
		this.fee = fee;
	}
	
	public SavingsAccount(int id, String name, int amount) {
		setId(id);
		setName(name);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		fee();
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = 50;
	}
	
	public void depositSavings(int d) {
		int newAmount = amount+d;
		setAmount(newAmount);
	}
	
	public void withdrawlSavings(int w) {
		if(w<amount) {
			int newAmount = amount-w;
			setAmount(newAmount);
		}else {
			System.out.println("ERROR: Withdrawl Amount is Over Account Balance");
		}
	}
	
	public void fee() {
		if(amount < 2000) {
			this.amount = amount - fee;
		}else {
			this.amount = amount;
		}
	}
	
	public void printSavingsAccountDetails() {
		System.out.println("\t"+getId()+"\t"+getName()+"\t"+getAmount());
	}

}
