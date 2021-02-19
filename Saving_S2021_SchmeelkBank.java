//Group 4 - Spring 2021
//Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine

public class Saving_S2021_SchmeelkBank extends Account_S2021_SchmeelkBank{

	private int savingBalance;
	private int fee = 50;
	
	public Saving_S2021_SchmeelkBank(int id, String name, int savingBalance) {
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
	
	public int fee() {
		if(savingBalance < 2000) 
		{
			return this.savingBalance = savingBalance - fee;
		}
		else 
		{
			return this.savingBalance = savingBalance;
		}
	}
	
	public boolean withdrawlSavings(int withdrawAmount) {
		if( withdrawAmount < savingBalance) 
		{
			int newAmount = savingBalance - withdrawAmount;
			setsavingBalance(newAmount);
			return true;
		}
		else 
		{
			System.out.println("ERROR: Insufficient Funds Cannot Withdraw $" + withdrawAmount);
			return false;
		}
	}
	
	public void depositSavings(int depositAmount) {
		int newAmount = getsavingBalance() + depositAmount;
		setsavingBalance(newAmount);
	}
	
	public void printSavingsAccountDetails() {
		System.out.println("\t" + getId() + "\t" + getName() + "\t" + getsavingBalance());
	}	
}
