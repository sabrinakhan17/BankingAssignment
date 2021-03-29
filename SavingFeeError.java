/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is our second Custom Exceptions class. This exception throws an error if the 
 * initial savings account deposit is less than $2,000
 *
 */
@SuppressWarnings("serial")
public class SavingFeeError extends Exception {
	/**
	 * Defines the SavingFeeError exception
	 */
	public SavingFeeError() {
		super("First Time Savings Balance Error: $50 Fee Charged");
	}

}
