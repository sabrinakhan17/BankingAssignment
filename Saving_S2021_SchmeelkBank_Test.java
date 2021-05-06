import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 * This is our Savings Account JUnit test class, the purpose of this class is to create a
 * mock Savings Account and test our deposit, withdrawal, and charge fee functions.
 */
public class Saving_S2021_SchmeelkBank_Test {
	/**
	 * We are setting up our mock Savings Account by calling our subclass 
	 * (Saving_S2021_SchmeelkBank.java class) and creating an object
	 */
	Saving_S2021_SchmeelkBank s1;
	Saving_S2021_SchmeelkBank s2;
	/**
	 * The BeforeEach method is implemented to ensure that this is run before every test,
	 * here we are adding details to two Savings Account object
	 * There are two accounts with different amounts in order to 
	 * test our charge fee function
	 * @throws Exception an exception is thrown if the Savings Account is not created or
	 * if there is another error 
	 */
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Saving_S2021_SchmeelkBank("1", "Savings 1", 3000);
		s2 = new Saving_S2021_SchmeelkBank("2", "Savings 2", 1000);
	}
	/**
	 * Our first test is to make sure that $1,000 is deposited into our Savings account
	 * An assertEquals is used, $4,000 is the amount we expect is to be and 
	 * s1.getsavingBalance() is calling a method that retrieves the current balance
	 */
	@Test
	public void depositSavings() {
		s1.depositSavings(1000);
		assertEquals(4000, s1.getsavingBalance());
	}
	/**
	 * Our second test is testing our withdrawal method
	 * In this case, we are withdrawing $500, which is less than the current balance,
	 * thus, the catch block will not be used here, as we are expecting the output to
	 * be $2,500 (our current balance for s1 is $3,000)
	 */
	@Test
	public void withdrawalSavings() {
		try {
			s1.withdrawlSavings(500);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(2500, s1.getsavingBalance()); //initial amount: 3000 - 500 = 2500
	}
	/**
	 * Our third test is testing our withdrawal custom exception
	 * In this case, we are withdrawing $10,000 which is more than our current balance,
	 * thus, the we will 'catch' the custom exception, InvalidWithdrawalAmount, and print
	 * out "InvalidWithdrawalAmount: Withdrawal Error $10000 Cannot Be Withdrawn"
	 */
	@Test
	public void withdrawalErrorSavings() {
		try {
			s1.withdrawlSavings(10000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(3000, s1.getsavingBalance()); //initial amount: 3000 - 10000 = ERROR
		Assert.assertNotEquals(13000, s1.getsavingBalance());
	}
	/**
	 * For our fourth and final test, we are testing our Savings Fee custom exception
	 * When a bank account user first opens their savings account, if their initial 
	 * amount balance is less than $2,000, a $50 fee is automatically 
	 * charged to their account
	 * In the first try and catch block, the first Savings account has a balance of more
	 * than $2,000 which means we are expecting the output to be "$50 Fee was NOT charged"
	 * In the second try and catch block, the second Savings accound has a balance of less
	 * than $2,000, which means we will 'catch' the custom exception, SavingFeeError, and
	 * print out "SavingFeeError: First Time Savings Balance Error: $50 Fee Charged"
	 */
	@Test
	public void chargeFeeSavings() {
		try {
			s1.fee();
		} catch (SavingFeeError e) {
			System.out.println(e);
		}
		assertEquals(3000, s1.getsavingBalance());
		
		try {
			s2.fee();
		} catch (SavingFeeError e) {
			System.out.println(e);
		}
		assertEquals(950, s2.getsavingBalance());
	}

}
