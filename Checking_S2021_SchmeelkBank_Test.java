import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is our Checking's Account JUnit test class, the purpose of this class is to create a
 * mock Checking's Account and test our deposit and withdrawal functions.
 */
public class Checking_S2021_SchmeelkBank_Test {
	/**
	 * We are setting up our mock Checking's Account by calling our subclass 
	 * (Checking_S2021_SchmeelkBank.java class) and creating an object
	 */
	Checking_S2021_SchmeelkBank c1;
	/**
	 * The BeforeEach method is implemented to ensure that this is run before every test,
	 * here we are adding details to our Checking's Account object
	 * @throws Exception an exception is thrown if the Checking's Account is not created or 
	 * if there is another error
	 */
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Checking_S2021_SchmeelkBank("1", "Checking 1", 1000);
	}
	/**
	 * Our first test is to make sure that $50 is deposited into our checking's account
	 * An assertEquals is used, $1,050 is the amount we expect is to be and 
	 * c1.getcheckingBalance() is calling a method that retrieves the current balance
	 */
	@Test
	public void depositCheckings() {
		c1.depositChecking(50);
		assertEquals(1050, c1.getcheckingBalance());
	}
	/**
	 * Our second test is testing our withdrawal method
	 * In this case, we are withdrawing $50, which is less than the current balance, 
	 * thus, the catch block will not be used here, as we are expecting the output to
	 * be $950
	 */
	@Test
	public void withdrawalCheckings() {
		try {
			c1.withdrawlChecking(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(950, c1.getcheckingBalance()); //initial amount 1000 - 50
	}
	/**
	 * Our third test is testing our withdrawal custom exception
	 * In this case, we are withdrawing $2,000 which is more than our current balance,
	 * thus, the we will 'catch' the custom exception, InvalidWithdrawalAmount, and print
	 * out "InvalidWithdrawalAmount: Withdrawal Error $2000 Cannot Be Withdrawn"
	 */
	@Test
	public void withdrawalErrorCheckings() {
		try {
			c1.withdrawlChecking(2000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(1000, c1.getcheckingBalance()); //initial amount 1000 - 1000 = ERROR
	}
	
}
