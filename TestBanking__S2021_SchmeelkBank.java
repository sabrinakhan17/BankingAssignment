import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.SecureRandom;
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
	 * This class declares 3 private global variables:
	 * secretKey is used for AES encryption
	 * cList is the Checking Account arrayList used in the user inputed checkings list account
	 * sList is the Savings Account arrayList used in the user inputed savings list account
	 */
	private static SecretKeySpec secretKey;
	private static ArrayList<Checking_S2021_SchmeelkBank> cList = new ArrayList<>();
	private static ArrayList<Saving_S2021_SchmeelkBank> sList = new ArrayList<>();
	/**
	 * Week 9 Lab Update
	 * The purpose of this method is to return a random AES Secret Key
	 */
	public static void randomSecretKey() {
		try {
			SecureRandom secureRandom = new SecureRandom();
			byte[] key = new byte[32];
			secureRandom.nextBytes(key);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Week 9 Lab Update
	 * The purpose of this method is to encrypt a string using AES
	 * @param accountNumber is a plaintext message, this method takes the value and uses AES to encrypt it
	 * @return the encoded account number (ciphertext)
	 */
	public static String encryptwithAES(String accountNumber) {
        try{
        	randomSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(accountNumber.getBytes("UTF-8")));
        }catch (Exception e){
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
	/**
	 * Week 9 Update
	 * The purpose of this method is to decrypt a string using AES
	 * @param accountNumber this method takes accountNumber as the ciphertext to decrypt back to plaintext
	 * @return the decoded account number (plaintext)
	 */
	public static String decryptwithAES(String accountNumber){
        try{
            Cipher cipher = Cipher.getInstance("AES"); 
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(accountNumber)));
        }catch (Exception e){
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
	/**
	 * The purpose of this method is to take an inputed string and 
	 * output the encoded string.
	 * This method will be used when the user inputs an account name.
	 * @param x takes String x (plaintext)
	 * @return the method returns the encoded String
	 */
	public static String outputEncoding(String x) {
		String encodedString = Base64.getEncoder().encodeToString(x.getBytes());
		return encodedString;
	}
	/**
	 * The purpose of this method is to decode the inputed string into its original plaintext
	 * @param x takes String x (ciphertext)
	 * @return the method returns the decoded string
	 */
	public static String decodeEncoding(String x) {
		byte[] decodedBytes = Base64.getDecoder().decode(x);
		return new String(decodedBytes);
	}
	
	/**
	 * The purpose of this method is to allow users to choose an account number,
	 * account name and balance for a Checking Account.
	 * Then, it saves the checking account to the arrayList.
	 * The method validates that the account number and balance is inputed correctly.
	 * The method uses the encryptwithAES method on account id.
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
		String cANum = "";
		while(!inputValid) {
			System.out.println("Enter a Checking Account Number:"); //Week 7 Part 1: Sensitive Part of Report
			try {
				cANum = kb.next();
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
		
		Checking_S2021_SchmeelkBank c1 = new Checking_S2021_SchmeelkBank(encryptwithAES(cANum), cAName, cAAmount);
		cList.add(c1);
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
	 * Then, it saves the savings account to the arrayList.
	 * The method validates that the account number and balance is inputed correctly.
	 * The method uses the encryptwithAES method on account id.
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
		String sANum = "";
		while(!inputValid) {
			System.out.println("Enter a Savings Account Number:"); //Week 7 Part 1: Sensitive Part of Report
			try {
				sANum = kb.next();
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
		
		Saving_S2021_SchmeelkBank s1 = new Saving_S2021_SchmeelkBank(encryptwithAES(sANum), sAName, sAAmount);
		sList.add(s1);
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
	 * The purpose of this method is to take a list of checkings accounts declared in the main method,
	 * and implement the deposit and withdrawal features
	 * The method uses the encryptwithAES method on account id and outputEncoding on account name.
	 * @param genericCList Takes in the list created in the main method that stores 
	 * different checking accounts
	 */
	public static void printCheckingsAccountFromList(ArrayList<Checking_S2021_SchmeelkBank> genericCList) {
		
		for(int i = 0; i < genericCList.size(); i++) {
			System.out.println("\nChecking Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
			genericCList.get(i).printCheckingsAccountDetailsFromList();
			System.out.println("\nAfter Encoding Account Name:\n");
			System.out.println("Account Number\t" + "Account Name\t\t" + "Amount");
			genericCList.get(i).setId(encryptwithAES(genericCList.get(i).getId()));
			genericCList.get(i).setName(outputEncoding(genericCList.get(i).getName()));
			genericCList.get(i).depositChecking(50);
			genericCList.get(i).printCheckingsAccountDetailsFromList();
			try {
				genericCList.get(i).withdrawlChecking(50);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
			genericCList.get(i).printCheckingsAccountDetailsFromList();
			try {
				genericCList.get(i).withdrawlChecking(genericCList.get(i).getcheckingBalance()+500);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
		}
		
	}
	/**
	 * The purpose of this method is to take a list of savings accounts declared in the main method,
	 * and implement the deposit and withdrawal features
	 * The method uses the encryptwithAES method on account id and outputEncoding on account name.
	 * @param genericSList Takes in the list created in the main method that stores 
	 * different savings accounts
	 */
	public static void printSavingsAccountFromList(ArrayList<Saving_S2021_SchmeelkBank> genericSList) {
		
		for(int i = 0; i < genericSList.size(); i++) {
			System.out.println("\nSavings Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
			genericSList.get(i).printSavingsAccountDetailsFromList();
			System.out.println("\nAfter Encoding Account Name:\n");
			System.out.println("Account Number\t" + "Account Name\t" + "Amount");
			genericSList.get(i).setId(encryptwithAES(genericSList.get(i).getId()));
			genericSList.get(i).setName(outputEncoding(genericSList.get(i).getName()));
			genericSList.get(i).printSavingsAccountDetailsFromList();
			try {
				genericSList.get(i).fee();
			} catch (SavingFeeError e1) {
				System.out.println(e1);
			}
			genericSList.get(i).printSavingsAccountDetailsFromList();
			genericSList.get(i).depositSavings(100);
			genericSList.get(i).printSavingsAccountDetailsFromList();
			try {
				genericSList.get(i).withdrawlSavings(genericSList.get(i).getsavingBalance()+500);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
			genericSList.get(i).printSavingsAccountDetailsFromList();
			try {
				genericSList.get(i).withdrawlSavings(300);
			} catch (InvalidWithdrawalAmount e) {
				System.out.println(e);
			}
			genericSList.get(i).printSavingsAccountDetailsFromList();
		}
	}
	/**
	 * This main method was created to test the banking application.
	 * The program first asks the user if they are a bank employee or a bank account user,
	 * if they are a bank employee the following options get printed:
	 *		1 - View Previous Generic Checkings Accounts Transactions
	 *		2 - View Previous Generic Savings Accounts Transactions
	 *		3 - View Checkings Accounts List
	 *		4 - View Savings Accounts List
	 *		5 - Exit
	 * NOTE: The bank employee cannot create a checkings or savings account, they can 
	 * only see the previous user created accounts and transactions, refer to the Week 7 
	 * Lab: Generics example
	 * However, if they are a user, the following options get printed:
	 * 		1 - Create Checkings Account
	 * 		2 - Create Savings Account
	 * 		3 - View Checking Accounts
	 * 		4 - View Savings Accounts
	 * 		5 - Exit
	 * Users are allowed to their create checkings and/or savings accounts, and then view
	 * them. Additional functions: Encrypting account number and name and testing custom 
	 * exceptions.
	 * @param args Main Method Class
	 */
	public static void main(String[] args) {
		
		
		Checking_S2021_SchmeelkBank genericC1 = new Checking_S2021_SchmeelkBank("43659", "My_Frst_Chckngs_1", 100);
		Checking_S2021_SchmeelkBank genericC2 = new Checking_S2021_SchmeelkBank("17613", "ZachsCheckings2", 5000);
		Checking_S2021_SchmeelkBank genericC3 = new Checking_S2021_SchmeelkBank("92465", "chck3", 4500);
		
		ArrayList<Checking_S2021_SchmeelkBank> genericCList = new ArrayList<>();
		genericCList.add(genericC1);
		genericCList.add(genericC2);
		genericCList.add(genericC3);
		
		Saving_S2021_SchmeelkBank genericS1 = new Saving_S2021_SchmeelkBank("78256", "Our_Savings_Account_1", 500);
		Saving_S2021_SchmeelkBank genericS2 = new Saving_S2021_SchmeelkBank("89721", "MariesSavings2", 3000);
		Saving_S2021_SchmeelkBank genericS3 = new Saving_S2021_SchmeelkBank("93028", "Savings 3", 1500);
		
		ArrayList<Saving_S2021_SchmeelkBank> genericSList = new ArrayList<>();
		genericSList.add(genericS1);
		genericSList.add(genericS2);
		genericSList.add(genericS3);		
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Schmeelk's Bank - Spring 2021");
		
		System.out.println("Are you a \n 1 - Bank Employee \nor a \n 2 - User?");
		int employeeOption = kb.nextInt();
		if(employeeOption == 1) {
			System.out.println("Welcome Employee!");
			System.out.println("\nBanking Options:\n1 - View Previous Generic Checkings Accounts Transactions\n2 - View Previous Generic Savings Accounts Transactions\n3 - View Checkings Accounts List\n4 - View Savings Accounts List\n5 - Exit\n");
			boolean empExit = false;
			while(!empExit) {
				System.out.println("\nPlease choose an option: ");
				int empOption = kb.nextInt();
				switch(empOption) {
				case 1:
					printCheckingsAccountFromList(genericCList);
					break;
				case 2:
					printSavingsAccountFromList(genericSList);
					break;
				case 3:
					System.out.println("Previous Checkings Accounts List:");
					for(int i = 0; i < genericCList.size(); i++) {   
					    System.out.print(genericCList.get(i).getId()+", "+genericCList.get(i).getName()+", "+genericCList.get(i).getcheckingBalance()+"\n");
					} 
					System.out.println();
					break;
				case 4:
					System.out.println("Previous Savings Accounts List:");
					for(int i = 0; i < genericSList.size(); i++) {   
					    System.out.print(genericSList.get(i).getId()+", "+genericSList.get(i).getName()+", "+genericSList.get(i).getsavingBalance()+"\n");
					} 
					System.out.println();
					break;
				default:
					System.out.println("exiting program.....\nHave a nice day!");
					empExit = true;
				}
			}
		}else if(employeeOption == 2) {
			System.out.println("Welcome User!");
			System.out.println("\nBanking Options:\n1 - Create Checkings Account\n2 - Create Savings Account\n3 - View Checking Accounts\n4 - View Savings Accounts\n5 - Exit\n");

			boolean exit = false;

			while(!exit) {
				System.out.println("Please choose an option: ");
				int option = kb.nextInt();
				switch(option) {
				case 1:
					checkingAccountInputValidation(kb);
					break;
				case 2:
					savingsAccountInputValidation(kb);
					break;
				case 3:
					System.out.println("Checkings Accounts:");
					for(int i = 0; i < cList.size(); i++) {   
					    System.out.print(decryptwithAES(cList.get(i).getId())+", "+decodeEncoding(cList.get(i).getName())+", "+cList.get(i).getcheckingBalance()+"\n");
					} 
					System.out.println();
					break;
				case 4:
					System.out.println("Savings Accounts:");
					for(int i = 0; i < sList.size(); i++) {   
					    System.out.print(decryptwithAES(sList.get(i).getId())+", "+decodeEncoding(sList.get(i).getName())+", "+sList.get(i).getsavingBalance()+"\n");
					} 
					System.out.println();
					break;
				default:
					System.out.println("exiting program.....\nHave a nice day!");
					exit = true;
				}
			}
		}else {
			System.out.println("ERROR!! \nexiting program.....\nHave a nice day!");
		}
		
		kb.close();
		
	}
}
