//Group 4
//Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
public class TestBanking {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Schmeelk's Savings Bank!\n");
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Checking Account");
		CheckingAccount c1 = new CheckingAccount();
		c1.setId(1);
		c1.setName("Checking 1");
		c1.setcheckingBalance(1000);
		
		System.out.println("Checking Account:\n"+"Account Number\t"+"Account Name\t"+"Amount");
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 2: Depositing $50");
		c1.depositChecking(50);
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $50");
		c1.withdrawlChecking(50);
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		c1.withdrawlChecking(2000);
		c1.printCheckingAccountDetails();
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Savings Account");
		SavingsAccount s1 = new SavingsAccount();
		s1.setId(1);
		s1.setName("Savings 1");
		s1.setsavingBalance(1000);
		System.out.println("Test 5: Charge Fee if Balance is Less Than $2000, amount deposited is $"+s1.getsavingBalance());
		s1.fee();
		System.out.println("\nSavings Account:\n"+"Account Number\t"+"Account Name\t"+"Amount");
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 2: Depositing $1000");
		s1.depositSavings(1000);
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		s1.withdrawlSavings(5000);
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $50");
		s1.withdrawlSavings(50);
		s1.printSavingsAccountDetails();
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Savings Account");
		SavingsAccount s2 = new SavingsAccount();
		s2.setId(1);
		s2.setName("Savings 1");
		s2.setsavingBalance(3000);
		System.out.println("Test 5: Charge Fee if Balance is Less Than $2000, amount deposited is $"+s2.getsavingBalance());
		System.out.println("\nSavings Account:\n"+"Account Number\t"+"Account Name\t"+"Amount");
		s2.printSavingsAccountDetails();
		
		System.out.println("\nTest 2: Depositing $1000");
		s2.depositSavings(1000);
		s2.printSavingsAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $500");
		s2.withdrawlSavings(500);
		s2.printSavingsAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance");
		s2.withdrawlSavings(10000);
		s2.printSavingsAccountDetails();

	}
}
/*
 * Test 1: Create account
 * Test 2: Deposit
 * Test 3: Withdrawal
 * Test 4: Withdrawal Error
 * Test 5: Charge Fee
 */
