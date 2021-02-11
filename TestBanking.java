//Group 4
//Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
public class TestBanking {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to ________ Bank!\n");
		
		CheckingAccount c1 = new CheckingAccount();
		c1.setId(1);
		c1.setName("Checking 1");
		c1.setcheckingBalance(1000);
		
		System.out.println("Checking Account:\n"+"Account Number\t"+"Account Name\t"+"Amount");
		c1.printCheckingAccountDetails();
		
		c1.depositChecking(50);
		c1.printCheckingAccountDetails();
		
		c1.withdrawlChecking(50);
		c1.printCheckingAccountDetails();
		
		c1.withdrawlChecking(2000);
		c1.printCheckingAccountDetails();
		
		SavingsAccount s1 = new SavingsAccount();
		s1.setId(1);
		s1.setName("Savings 1");
		s1.setsavingBalance(1000);
		System.out.println("\nSavings Account:\n"+"Account Number\t"+"Account Name\t"+"Amount");
		s1.printSavingsAccountDetails();
		
		s1.depositSavings(1000);
		s1.printSavingsAccountDetails();
		
		s1.withdrawlSavings(5000);
		s1.printSavingsAccountDetails();
		
		s1.withdrawlSavings(50);
		s1.printSavingsAccountDetails();

	}
}
/*
 * Coding: Done
 * Bank Name: WIP
 * Report: Need to Start
 */
