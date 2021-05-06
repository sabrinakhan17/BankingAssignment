# Banking Assignment
CSS 1035 Spring 2021 Banking Assignment
 <br />Group 4: Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine

**Purpose:** Java program that creates a Checking and Savings Account (with Inheritance) and incorporates cybersecurity techniques to make the program more secure and safer for users to use.

Name of Our Bank: Schmeelk’sBank_Spring2021

Main Banking Functions:
- Asks the user if they are a Bank Employee or a Bank Account User
- **If they are a Bank Employee the following functions get printed:**
  - Lab 7 Generics Example is Implemented
    - There are two arraylists with checkings and savings account information already created, the program will iterate through each list and deposit money, withdrawal money and charge a fee. They can also view the checkings or savings account information.
    - AES Encryption is implemented on the Account ID and Output Encoding is implelemented on Account Balance.
    - Input Validation is **NOT** implemented with this Generics example.
    - Bank Employees cannot create new checkings or savings account
  - NOTE: This option allows **ONLY Bank Employees** to see many different checkings and savings account transactions.
- **If they are a Bank Account User the following functions get printed:**
  - User Input: 
    - Allows users to input Checking and Saving Account Number, Name and Balance
    - Account Number: AES encryption is implemented
    - Account Name: Output Encoding is implemented
    - Account Balance: Input Validation is implemented
  - Depositing money from Checkings and Savings Account
  - Withdrawl money from Checkings and Savings Account
    - **Custom Exception: InvalidWithdrawalAmount created**
  - Charging a fee
    - If balance first deposited in Savings Account is less than $2,000, there's an automatic $50 fee charged
    - **Custom Exception: SavingFeeError created**

Secure Coding Functions:
- **Custom Exceptions**
  - InvalidWithdrawalAmountError
    - If a user tries to withdraw money that exceeds the current balance, there will be an error
  - SavingFeeError
    - After creating a Savings Account, if the initial balance is less than $2,000, there will be an error 
- **AES Encryption and Decryption** 
  - On Checking and Saving Account ID Number
- **Input Validation**
  - On Checking and Saving Account Balance
  - If a user inputs a string instead of a integer value, there is an error
- **Output Encoding and Decoding**
  - On Checking and Saving Account Name
  - When user inputs an Account Name, its encoded to keep the Account Name secure
- **Generics Example**
  - 2 ArrayLists with Checkings and Savings account information have already been created
  - The program iterates through these lists does the following:
    - AES Encrypting on Account ID
    - Output Encoding on Account Name
    - Prints out the transactions:
      - Deposting money
      - Withdrawing money
      - Charging a fee (Savings Account)
 
 Additional Features:
 - JavaDoc API
 - JUnit Testing
