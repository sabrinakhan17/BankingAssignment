import java.util.Scanner;
import java.util.ArrayList;
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
		
		//Week 7 Part 1: Sensitive Part of Report
		boolean inputValid = false;
		int cANum = 0;
		while(!inputValid) {
			System.out.println("Enter a Checking Account Number:"); //Week 7 Part 1: Sensitive Part of Report
			try {
				cANum = kb.nextInt();
				inputValid = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid account number! Try again!");
				kb.next();
			}
		}
		
		kb.nextLine();
		System.out.println("Enter a Checking Account Name:"); //Week 7 Part 1: Sensitive Part of Report
		String cAName = outputEncoding(kb.nextLine());
		
		//Week 7 Part 1: Sensitive Part of Report
		boolean inputValid2 = false;
		int cAAmount = 0;
		while(!inputValid2) {
			System.out.println("Enter Initial Amount:"); //Week 7 Part 1: Sensitive Part of Report
			try {
				cAAmount = kb.nextInt();
				inputValid2 = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid amount! Try again!");
				kb.next();
			}
		}
		
		Checking_S2021_SchmeelkBank c1 = new Checking_S2021_SchmeelkBank(cANum, cAName, cAAmount);
		c1.printCheckingAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("\nTest 2: Depositing $50");
		c1.depositChecking(50);
		c1.printCheckingAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("\nTest 3: Withdrawal $50");
		
		try {
			c1.withdrawlChecking(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		
		c1.printCheckingAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		int errorCheckingsWithdrawal = c1.getcheckingBalance()+500;
		System.out.println("Trying to withdraw "+errorCheckingsWithdrawal);
		try {
			c1.withdrawlChecking(errorCheckingsWithdrawal);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		
		c1.printCheckingAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
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
		
		//Week 7 Part 1: Sensitive Part of Report
		boolean inputValid = false;
		int sANum = 0;
		while(!inputValid) {
			System.out.println("Enter a Savings Account Number:"); //Week 7 Part 1: Sensitive Part of Report
			try {
				sANum = kb.nextInt();
				inputValid = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid account number! Try again!");
				kb.next();
			}
		}
		
		kb.nextLine();
		System.out.println("Enter a Savings Account Name:"); //Week 7 Part 1: Sensitive Part of Report
		String sAName = outputEncoding(kb.nextLine());
		
		//Week 7 Part 1: Sensitive Part of Report
		boolean inputValid2 = false;
		int sAAmount = 0;
		while(!inputValid2) {
			System.out.println("Enter Initial Amount:"); //Week 7 Part 1: Sensitive Part of Report
			try {
				sAAmount = kb.nextInt();
				inputValid2 = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid amount! Try again!");
				kb.next();
			}
		}
		
		Saving_S2021_SchmeelkBank s1 = new Saving_S2021_SchmeelkBank(sANum, sAName, sAAmount);
		s1.printSavingsAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("Test 5: Charge Fee if Balance is Less Than $2000, amount deposited is $" + s1.getsavingBalance());
		try {
			s1.fee();
		} catch (SavingFeeError e1) {
			System.out.println(e1);
		}
		s1.printSavingsAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("\nTest 2: Depositing $1000");
		s1.depositSavings(1000);
		s1.printSavingsAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		int errorSavingsWithdrawal = s1.getsavingBalance()+500;
		System.out.println("Trying to withdraw "+errorSavingsWithdrawal);
		try {
			s1.withdrawlSavings(errorSavingsWithdrawal);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s1.printSavingsAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		
		System.out.println("\nTest 3: Withdrawal $50");
		try {
			s1.withdrawlSavings(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s1.printSavingsAccountDetails(); //Week 7 Part 1: Sensitive Part of Report
		System.out.println();
	}
	/**
	 * The purpose of this method is to take a list of checkings accounts
	 * and implement the deposit and withdrawal features
	 * @param cList Takes in the list created in the main method that stores 
	 * different checking accounts
	 */
	public static void printCheckingsAccountFromList(ArrayList<Checking_S2021_SchmeelkBank> cList) {
		
		for(int i = 0; i < cList.size(); i++) {
			System.out.println("\nChecking Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
			cList.get(i).printCheckingsAccountDetailsFromList();
			System.out.println("\nAfter Encoding Account Name:\n");
			System.out.println("Account Number\t" + "Account Name\t\t" + "Amount");
			cList.get(i).setName(outputEncoding(cList.get(i).getName()));
			cList.get(i).depositChecking(50);
			cList.get(i).printCheckingsAccountDetailsFromList();
			try {
				cList.get(i).withdrawlChecking(50);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
			cList.get(i).printCheckingsAccountDetailsFromList();
			try {
				cList.get(i).withdrawlChecking(cList.get(i).getcheckingBalance()+500);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
		}
		
	}
	/**
	 * The purpose of this method is to take a list of savings accounts
	 * and implement the deposit and withdrawal features
	 * @param sList Takes in the list created in the main method that stores 
	 * different savings accounts
	 */
	public static void printSavingsAccountFromList(ArrayList<Saving_S2021_SchmeelkBank> sList) {
		
		for(int i = 0; i < sList.size(); i++) {
			System.out.println("\nSavings Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
			sList.get(i).printSavingsAccountDetailsFromList();
			System.out.println("\nAfter Encoding Account Name:\n");
			System.out.println("Account Number\t" + "Account Name\t" + "Amount");
			sList.get(i).setName(outputEncoding(sList.get(i).getName()));
			sList.get(i).printSavingsAccountDetailsFromList();
			try {
				sList.get(i).fee();
			} catch (SavingFeeError e1) {
				System.out.println(e1);
			}
			sList.get(i).printSavingsAccountDetailsFromList();
			sList.get(i).depositSavings(100);
			sList.get(i).printSavingsAccountDetailsFromList();
			try {
				sList.get(i).withdrawlSavings(sList.get(i).getsavingBalance()+500);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
			sList.get(i).printSavingsAccountDetailsFromList();
			try {
				sList.get(i).withdrawlSavings(300);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
			sList.get(i).printSavingsAccountDetailsFromList();
		}
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
		
		//checkingAccountInputValidation(kb);
		//savingsAccountInputValidation(kb); //deposit less than $2000
		//savingsAccountInputValidation(kb); //deposit more than $2000
		
		Checking_S2021_SchmeelkBank c1 = new Checking_S2021_SchmeelkBank(11111, "Checkings 1", 100);
		Checking_S2021_SchmeelkBank c2 = new Checking_S2021_SchmeelkBank(22222, "Checkings 2", 5000);
		Checking_S2021_SchmeelkBank c3 = new Checking_S2021_SchmeelkBank(33333, "Checkings 3", 4500);
		
		ArrayList<Checking_S2021_SchmeelkBank> cList = new ArrayList<>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		
		printCheckingsAccountFromList(cList);
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		Saving_S2021_SchmeelkBank s1 = new Saving_S2021_SchmeelkBank(44444, "Savings 1", 500);
		Saving_S2021_SchmeelkBank s2 = new Saving_S2021_SchmeelkBank(55555, "Savings 2", 3000);
		Saving_S2021_SchmeelkBank s3 = new Saving_S2021_SchmeelkBank(77777, "Savings 3", 1500);
		
		ArrayList<Saving_S2021_SchmeelkBank> sList = new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		
		printSavingsAccountFromList(sList);
		
		kb.close();
		
	}
}
