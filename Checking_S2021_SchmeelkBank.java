//Group 4 - Spring 2021
//Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine

public class Checking_S2021_SchmeelkBank extends Account_S2021_SchmeelkBank {

	private int checkingBalance;

	public Checking_S2021_SchmeelkBank(int id, String name, int checkingBalance) {
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
	
	public void depositChecking(int depositAmount) {
		int newAmount = checkingBalance + depositAmount;
		setcheckingBalance(newAmount);
	}
	
	public boolean withdrawlChecking(int withdrawAmount) {
		if(withdrawAmount < checkingBalance) 
		{
			int newAmount = checkingBalance - withdrawAmount;
			setcheckingBalance(newAmount);
			return true;
		}
		else 
		{
			System.out.println("ERROR: Insufficient Funds Cannot Withdraw $" + withdrawAmount);
			return false;
		}
	}
	
	public void printCheckingAccountDetails() {
		System.out.println("\t" + getId() + "\t" + getName() + "\t" + getcheckingBalance());
	}
}
