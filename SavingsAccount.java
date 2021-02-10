public class SavingsAccount extends Account{
	private int amount;
	private int fee;
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(int amount, int fee) {
		this.amount = amount;
		this.fee = fee;
	}
	
	public SavingsAccount(int id, String name, int amount, int fee) {
		setId(id);
		setName(name);
		this.amount = amount;
		this.fee = fee;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
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
	
	public void printSavingsAccountDetails() {
		System.out.println("\t"+getId()+"\t"+getName()+"\t"+getAmount());
	}

}
