/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is the second subclass that extends from the main Account class
 */
public class Saving_S2021_SchmeelkBank extends Account_S2021_SchmeelkBank{
	/**
	 * The Savings Balance is common knowledge
	 * The Savings Fee amount is set to $50 and is common knowledge
	 */
	private int savingBalance;
	private int fee = 50;
	/**
	 * Constructor for the Savings Account class
	 * @param id Set Savings Account ID in the constructor
	 * @param name Set Savings Account Name in the constructor
	 * @param savingBalance Set Savings Account Balance in the constructor
	 */
	public Saving_S2021_SchmeelkBank(int id, String name, int savingBalance) {
		setId(id);
		setName(name);
		this.savingBalance = savingBalance;
	}
	/**
	 * 
	 * @return the Savings Balance
	 */
	public int getsavingBalance() {
		return savingBalance;
	}
	/**
	 * 
	 * @param savingBalance Sets Savings Balance
	 */
	public void setsavingBalance(int savingBalance) {
		this.savingBalance = savingBalance;
	}
	/**
	 * 
	 * @return the Savings fee
	 */
	public int getFee() {
		return fee;
	}
	/**
	 * 
	 * @param fee Sets Savings fee
	 */
	public void setFee(int fee) {
		this.fee = 50;
	}
	/**
	 * Method that automatically subtracts the balance if initial savings 
	 * deposit is less than $2000
	 * @throws SavingFeeError exception this throws exception if the 
	 * balance is less than $2000
	 */
	public void fee() throws SavingFeeError {
		if(savingBalance < 2000) {
			this.savingBalance = savingBalance - fee;
			throw new SavingFeeError();
		}else {
			System.out.println("$50 Fee was NOT charged");
		}
	}
	/**
	 * 
	 * @param withdrawAmount is the amount the user is trying to withdrawal
	 * @throws InvalidWithdrawalAmount exception his throws error if the 
	 * withdrawal amount is over the savings account balance
	 */
	public void withdrawlSavings(int withdrawAmount) throws InvalidWithdrawalAmount {
	
		if(withdrawAmount < savingBalance) {
			int newAmount = savingBalance - withdrawAmount;
			setsavingBalance(newAmount);
		}else {
			throw new InvalidWithdrawalAmount(withdrawAmount);
		}
	}
	/**
	 * Method that deposits the amount to savings account, re-sets savings account balance
	 * @param depositAmount is the amount the user is depositing into the account
	 */
	public void depositSavings(int depositAmount) {
		int newAmount = getsavingBalance() + depositAmount;
		setsavingBalance(newAmount);
	}
	/**
	 * Prints out the Savings Account ID, Savings Account Name and Account Savings Balance
	 */
	public void printSavingsAccountDetails() {
		System.out.println("\nSavings Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
		System.out.println("    " + getId() + "\t" + getName() + "\t" + getsavingBalance());
	}	
	/**
	 * Prints out savings account details but method is specified for list items
	 */
	public void printSavingsAccountDetailsFromList() {
		System.out.println("    " + getId() + "\t" + getName() + "\t" + getsavingBalance());
	}
}
