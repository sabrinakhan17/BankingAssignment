import java.util.Scanner;
import java.util.Base64;
import java.util.InputMismatchException;
/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 *
 */
public class TestBanking__S2021_SchmeelkBank {
	/**
	 * The purpose of this method is to take an inputed string and 
	 * output the encoded string.
	 * This method will be used when the user inputs an account name.
	 * @param x takes String x
	 * @return the method returns the encoded String
	 */
	public static String outputEncoding(String x) {
		String encodedString = Base64.getEncoder().encodeToString(x.getBytes());
		return encodedString;
	}
	/**
	 * The purpose of this method is to allow users to choose an account number,
	 * account name and balance for a Checking Account.
	 * The method validates that the account number and balance is inputed correctly.
	 * The method uses the outputEncoding method on account name.
	 * Finally, it prints out deposit and withdrawal functions 
	 * (and uses the custom exceptions).
	 * @param kb takes in the Scanner declared in our main method class
	 */
	public static void checkingAccountInputValidation(Scanner kb) {
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Checking Account");
		
		boolean inputValid = false;
		int cANum = 0;
		while(!inputValid) {
			System.out.println("Enter a Checking Account Number:");
			try {
				cANum = kb.nextInt();
				inputValid = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid account number! Try again!");
				kb.next();
			}
		}
		
		kb.nextLine();
		System.out.println("Enter a Checking Account Name:");
		String cAName = outputEncoding(kb.nextLine());
		
		boolean inputValid2 = false;
		int cAAmount = 0;
		while(!inputValid2) {
			System.out.println("Enter Initial Amount:");
			try {
				cAAmount = kb.nextInt();
				inputValid2 = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid amount! Try again!");
				kb.next();
			}
		}
		
		Checking_S2021_SchmeelkBank c1 = new Checking_S2021_SchmeelkBank(cANum, cAName, cAAmount);
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 2: Depositing $50");
		c1.depositChecking(50);
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $50");
		
		try {
			c1.withdrawlChecking(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		int errorCheckingsWithdrawal = c1.getcheckingBalance()+500;
		System.out.println("Trying to withdraw "+errorCheckingsWithdrawal);
		try {
			c1.withdrawlChecking(errorCheckingsWithdrawal);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		
		c1.printCheckingAccountDetails();
		System.out.println();
		
	}
	/**
	 * The purpose of this method is to allow users to choose an account number,
	 * account name and balance for a Savings Account.
	 * The method validates that the account number and balance is inputed correctly.
	 * The method uses the outputEncoding method on account name.
	 * Finally, it prints out deposit and withdrawal functions
	 * (and uses the custom exceptions).
	 * @param kb takes in the Scanner declared in our main method class
	 */
	public static void savingsAccountInputValidation(Scanner kb) {
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Savings Account");
		
		boolean inputValid = false;
		int sANum = 0;
		while(!inputValid) {
			System.out.println("Enter a Savings Account Number:");
			try {
				sANum = kb.nextInt();
				inputValid = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid account number! Try again!");
				kb.next();
			}
		}
		
		kb.nextLine();
		System.out.println("Enter a Savings Account Name:");
		String sAName = outputEncoding(kb.nextLine());
		
		boolean inputValid2 = false;
		int sAAmount = 0;
		while(!inputValid2) {
			System.out.println("Enter Initial Amount:");
			try {
				sAAmount = kb.nextInt();
				inputValid2 = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid amount! Try again!");
				kb.next();
			}
		}
		
		Saving_S2021_SchmeelkBank s1 = new Saving_S2021_SchmeelkBank(sANum, sAName, sAAmount);
		s1.printSavingsAccountDetails();
		
		System.out.println("Test 5: Charge Fee if Balance is Less Than $2000, amount deposited is $" + s1.getsavingBalance());
		try {
			s1.fee();
		} catch (SavingFeeError e1) {
			System.out.println(e1);
		}
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 2: Depositing $1000");
		s1.depositSavings(1000);
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		int errorSavingsWithdrawal = s1.getsavingBalance()+500;
		System.out.println("Trying to withdraw "+errorSavingsWithdrawal);
		try {
			s1.withdrawlSavings(errorSavingsWithdrawal);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $50");
		try {
			s1.withdrawlSavings(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s1.printSavingsAccountDetails();
		System.out.println();
	}
	/**
	 * This main method was created to test the banking application.
	 * The program calls our checking account method once and 
	 * savings account methods twice and then tests out the following tests:
	 * 		Test 1: Create account
	 * 		Test 2: Deposit
	 * 		Test 3: Withdrawal
	 * 		Test 4: Withdrawal Error
	 * 		Test 5: Charge Fee
	 * @param args Main Method Class
	 */
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		checkingAccountInputValidation(kb);
		savingsAccountInputValidation(kb); //deposit less than $2000
		savingsAccountInputValidation(kb); //deposit more than $2000
		
		kb.close();
		
	}
}
