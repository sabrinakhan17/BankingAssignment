/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is one of our Custom Exceptions classes, the InvalidWithdrawalAmount class
 * is responsible for throwing an error if the withdrawal balance is larger then the 
 * checking or savings account balance
 */
@SuppressWarnings("serial")
public class InvalidWithdrawalAmount extends Exception {
	/**
	 * This class takes in the withdrawal amount value as a private integer
	 */
	private int withdrawAmount;
	/**
	 * Method defines the Custom Exception: InvalidWithdrawalAmount
	 * @param withdrawAmount Method takes in the withdrawal amount in the checkings 
	 * or savings class
	 */
	public InvalidWithdrawalAmount(int withdrawAmount) {
		super("Withdrawal Error $" + withdrawAmount + " Cannot Be Withdrawn");
	    this.withdrawAmount = withdrawAmount;
	}
	/**
	 * 
	 * @return Method returns what the withdrawal amount is
	 */
	public int getwithdrawAmount() {
		return withdrawAmount;
	}

}
