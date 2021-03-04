/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is one of two of the subclasses that extends from the main Account class
 *
 */
public class Checking_S2021_SchmeelkBank extends Account_S2021_SchmeelkBank {
	/**
	 * The Checking Balance is common knowledge
	 */
	private int checkingBalance;
	/**
	 * Constructor for the Checking Account class
	 * @param id Set Checking Account ID in the constructor
	 * @param name Set Checking Account Name in the constructor
	 * @param checkingBalance Set Checking Account Balance in the constructor
	 */
	public Checking_S2021_SchmeelkBank(int id, String name, int checkingBalance) {
		setId(id);
		setName(name);
		this.checkingBalance = checkingBalance;
	}
	/**
	 * 
	 * @return the Checking Balance
	 */
	public int getcheckingBalance() {
		return checkingBalance;
	}
	/**
	 * 
	 * @param checkingBalance Sets Checking Balance
	 */
	public void setcheckingBalance(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	/**
	 * Method that deposits the amount to checking account, re-sets checking account balance
	 * @param depositAmount is the amount the user is depositing into the account
	 */
	public void depositChecking(int depositAmount) {
		int newAmount = checkingBalance + depositAmount;
		setcheckingBalance(newAmount);
	}
	/**
	 * Method that withdraws amount to checking account, 
	 * if the withdrawal amount is less than checking account balance, throws Exception
	 * @param withdrawAmount is the amount the user is trying to withdrawal
	 * @throws Exception this throws error if the withdrawal amount is over 
	 * the checking account balance
	 */
	public void withdrawlChecking(int withdrawAmount) throws Exception {
		
		if(withdrawAmount < checkingBalance) {
			int newAmount = checkingBalance - withdrawAmount;
			setcheckingBalance(newAmount);
		}else {
			throw new Exception("Checking Withdrawl Error");
		}
	
	}
	/**
	 * Prints out the Checking Account ID, Checking Account Name and Account Checking Balance
	 */
	public void printCheckingAccountDetails() {
		System.out.println("\t" + getId() + "\t" + getName() + "\t" + getcheckingBalance());
	}
}
