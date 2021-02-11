public class CheckingAccount extends Account {
	private int checkingBalance;
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	
	public CheckingAccount(int id, String name, int checkingBalance) {
		setId(id);
		setName(name);
		this.checkingBalance = checkingBalance;
	}

	public int getcheckingBalance() {
		return checkingBalance;
	}

	public void setcheckingBalance(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	
	public void depositChecking(int d) {
		int newAmount = checkingBalance+d;
		setcheckingBalance(newAmount);
	}
	
	public void withdrawlChecking(int w) {
		if(w<checkingBalance) {
			int newAmount = checkingBalance-w;
			setcheckingBalance(newAmount);
		}else {
			System.out.println("ERROR: Withdrawl Amount is Over Account Balance");
		}
	}
	
	public void printCheckingAccountDetails() {
		System.out.println("\t"+getId()+"\t"+getName()+"\t"+getcheckingBalance());
	}

}
