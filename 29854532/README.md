# Banking System
The Banking System project is a console-based application developed using Core Java, designed to facilitate bankers in managing various customer accounts and financial transactions The application uses Object-Oriented Programming principles and uses Java Collections use to store account and transaction information. Key features include adding and removing accounts, editing account information, depositing and withdrawing funds, transferring funds between accounts, and ensuring that transactions do not exceed available funds there on Exceptional control procedures are used to deal with potential errors 
## How to Run the Application

1. Compile the Java files:
    
    javac Account.java Transaction.java BankingSystem.java Main.java
    

2. Run the application:
   
    java Main

## Technologies used
- Operating System:Windows 10
- Programming Language:JAVA
- IDE:Visual Studio


## Instructions for Each Feature

1. **Add Account**:
   - Select option 1 from the menu.
   - Enter account ID, customer ID, initial balance, and account type when prompted.
   -This option will add account.

2. **Remove Account**:
   - Select option 2 from the menu.
   - Enter the account ID of the account you wish to remove.
   

3. **Update Account**:
   - Select option 3 from the menu.
   - Enter account ID to update, then enter new customer ID, new balance, and new account type when prompted.

4. **Deposit Funds**:
   - Select option 4 from the menu.
   - Enter the account ID and the amount to deposit.

5. **Withdraw Funds**:
   - Select option 5 from the menu.
   - Enter the account ID and the amount to withdraw.

6. **Transfer Funds**:
   - Select option 6 from the menu.
   - Enter the from account ID, to account ID, and the amount to transfer.

7. **Print Accounts**:
   - Select option 7 from the menu to display all accounts.

8. **Print Transactions**:
   - Select option 8 from the menu to display all transactions.

9. **Exit**:
   - Select option 9 to exit the application.

## Exception Handling Implemented

- **Duplicate Account ID**: When adding an account, it will check  if the account ID already exists and prints a message that the account ID already existed.
- **Account Not Found**: When removing, updating, depositing, or withdrawing, the system checks if the account ID exists and prints a message if it does not.
- **Insufficient balance**: When withdrawing or transferring funds, the system checks if the balance is sufficient and prints a message if it is not.
- **Input Validation**: The application includes basic input validation that the IDs which are entered was in correct datatype or not if not it will raise an exception that it's an invalid datatype.
