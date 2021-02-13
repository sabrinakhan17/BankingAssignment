public class SavingsAccount extends Account{
	private int savingBalance;
	private int fee = 50;
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(int savingBalance, int fee) {
		this.savingBalance = savingBalance;
		this.fee = fee;
	}
	
	public SavingsAccount(int id, String name, int savingBalance) {
		setId(id);
		setName(name);
		this.savingBalance = savingBalance;
	}

	public int getsavingBalance() {
		return savingBalance;
	}

	public void setsavingBalance(int savingBalance) {
		this.savingBalance = savingBalance;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = 50;
	}
	
	public void fee() {
		if(savingBalance < 2000) {
			this.savingBalance = savingBalance - fee;
		}else {
			this.savingBalance = savingBalance;
		}
	}
	
	public void withdrawlSavings(int w) {
		if(w<savingBalance) {
			int newAmount = savingBalance-w;
			setsavingBalance(newAmount);
		}else {
			System.out.println("ERROR: Insufficient Funds Cannot Withdraw $"+w);
		}
	}
	
	public void depositSavings(int d) {
		int newAmount = getsavingBalance()+d;
		setsavingBalance(newAmount);
	}
	
	public void printSavingsAccountDetails() {
		System.out.println("\t"+getId()+"\t"+getName()+"\t"+getsavingBalance());
	}

}
