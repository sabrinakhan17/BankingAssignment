# Banking Assignment
CSS 1035 Banking Assignment
 <br />Group 4: Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine

**Purpose:** Java program that creates a Checking and Savings Account (with Inheritance).

Main Functions:
- ~~Now allows users to input Checking and Saving Account Number, Name and Balance~~
- **LAB 7 EDIT:** Allowing users to input data is commented out, there are now 2 lists with data in it. The program will iterate through each list and print out the following functions below.
- Input Validation on Checking and Saving Account Number and Balace
  - If user inputs a string instead of a integer value, there is an error
- Output Encoding on Checking and Saving Account Name
  - When user inputs an Account Name, its encoded to keep the Account Name secure
- Depositing money from Checkings and Savings Account
- Withdrawl money from Checkings and Savings Account
  - Custom Exception: InvalidWithdrawalAmount created
- Charging a fee
  - If balance first deposited in Savings Account is less than $2,000, there's an automatic $50 fee charged
  - Custom Exception: SavingFeeError created
