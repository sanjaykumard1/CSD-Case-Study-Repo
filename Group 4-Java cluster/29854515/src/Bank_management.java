import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

 class ManageTransaction {
     public static void DepositeMoney(){
         System.out.println("Enter Account number:");
         Scanner scanner = new Scanner(System.in);
         int Acc_no = scanner.nextInt();

         System.out.println("Enter Amount:");
         int amount = scanner.nextInt();

         try{
             int init_amount=0;
             Bank_management connect= new Bank_management();
             Connection conn = connect.getconnection();
             Statement statement=connect.getconnection().createStatement();
             ResultSet result=statement.executeQuery("select * from accounts where account_number="+Acc_no);
            int flag=0;
             while (result.next()){
                  init_amount=Integer.parseInt(result.getString("balance"));
                  flag=1;
             }
             if(flag==0){
                 System.out.println("No user found !");
             }
             String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?;";
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setInt(1, amount+init_amount);
             pstmt.setInt(2,Acc_no);
             int rowsupdated = pstmt.executeUpdate();
             if (rowsupdated > 0) {
                 System.out.println("fund deposited successfully");
                 generateTransaction( Acc_no,"Deposite",+amount);
             }
             else{
                 System.out.println("Something went wrong!");

             }
         }
         catch (Exception e){
             System.out.println("Error is :"+e);
         }


     }  // this method deposites the money in accounts

     public static void WithdrawMoney(){
         System.out.println("Enter Account number:");
         Scanner scanner = new Scanner(System.in);
         int Acc_no = scanner.nextInt();

         System.out.println("Enter Amount:");
         int amount = scanner.nextInt();

         try{
             int init_amount=0;
             Bank_management connect= new Bank_management();
             Connection conn = connect.getconnection();
             Statement statement=connect.getconnection().createStatement();
             ResultSet result=statement.executeQuery("select * from accounts where account_number="+Acc_no);
             int flag=0;
             while (result.next()){
                 init_amount=Integer.parseInt(result.getString("balance"));
                 flag=1;
             }
             if(flag==0){
                 System.out.println("No user found !");
             }
             if(init_amount < amount){
                 System.out.println("Sorry!Not sufficient balance.");
             }
             else{
                 String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?;";
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 pstmt.setInt(1, init_amount-amount);
                 pstmt.setInt(2,Acc_no);
                 int rowsupdated = pstmt.executeUpdate();
                 if (rowsupdated > 0) {
                     System.out.println("fund withdrawn successfully");
                     generateTransaction( Acc_no,"Withdrawal",-amount);
                 }
                 else{
                     System.out.println("Something went wrong!");

                 }
             }

         }
         catch (Exception e){
             System.out.println("Error is :"+e);
         }

     } // this method withdraw money from the account

     public static void TransferMoney(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter your Account number :");
         int Acc_from = scanner.nextInt();
         System.out.println("Enter Account number which you want to transfer the amount in:");
         int Acc_to = scanner.nextInt();

         System.out.println("Enter Amount:");
         int amount = scanner.nextInt();

         try{
             int init_amount=0;
             Bank_management connect= new Bank_management();
             Connection conn = connect.getconnection();
             Statement statement=connect.getconnection().createStatement();
             ResultSet result=statement.executeQuery("select * from accounts where account_number="+Acc_from);
             int flag=0;
             while (result.next()){
                 init_amount=Integer.parseInt(result.getString("balance"));
                 flag=1;
             }
             if(flag==0){
                 System.out.println("No user found with account number"+Acc_from);
             }
             if(init_amount < amount){
                 System.out.println("Sorry!Not sufficient balance.");
             }
             else{

                 String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?;";
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 pstmt.setInt(1, init_amount-amount);
                 pstmt.setInt(2,Acc_from);
                 int rowsupdated = pstmt.executeUpdate();
                 result=statement.executeQuery("select * from accounts where account_number="+Acc_to);
                  flag=0;
                 while (result.next()){
                     init_amount=Integer.parseInt(result.getString("balance"));
                     flag=1;
                 }
                 if(flag==0){
                     System.out.println("No user found with account number"+Acc_to);
                 }

                 else{
                     sql = "UPDATE accounts SET balance = ? WHERE account_number = ?;";
                     pstmt = conn.prepareStatement(sql);
                     pstmt.setInt(1, init_amount+amount);
                     pstmt.setInt(2,Acc_to);
                     rowsupdated = pstmt.executeUpdate();
                     if (rowsupdated > 0) {
                         System.out.println("fund transfered successfully");
                         generateTransaction( Acc_from,"transfer",-amount);
                     }
                     else{
                         System.out.println("Something went wrong!");

                     }
                 }

             }

         }
         catch (Exception e){
             System.out.println("error:"+e);
         }
         System.out.println("fund transfered successfully");
     }   // this method transfers money from one account to another account

     public static  void generateTransaction(int acc_num,String trans_type,int amt){
         Bank_management connect= new Bank_management();
         try {
             String sql = "INSERT INTO transaction (account_number,transaction_type,amount) VALUES (?, ?, ?)";
             Connection conn = DriverManager.getConnection(connect.databaseUrl,connect.userName,connect.password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setInt(1, acc_num);
             pstmt.setString(2,trans_type);
             pstmt.setInt(3, amt);

             int rowsInserted = pstmt.executeUpdate();
         }
         catch (Exception e){
             System.out.println("error:"+e);
         }
     }  // this method maintain all the transactions

     public static void TransactionHistory(){
         Bank_management connect= new Bank_management();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter your Account number");
         int acc_no = scanner.nextInt();
         try{
             Statement statement=connect.getconnection().createStatement();

             ResultSet result=statement.executeQuery("select * from transaction where account_number="+acc_no);

             int flag=0;
             System.out.println("transaction_id "+"       "+"account_number"+"      "+"transaction_type"+"      "+"amount");
             while (result.next()){

                 System.out.print(result.getString("transaction_id")+ "                      ");
                 System.out.print(result.getString("account_number")+"                   ");
                 System.out.print(result.getString("transaction_type")+"            ");
                 System.out.print(result.getString("amount"));
                 flag=1;
             }
             if(flag==0){
                 System.out.println("No transaction found!");
             }
         }
         catch (Exception e){
             System.out.println("error:"+e);
         }
     }  // this method show all the transactions history of particular account

     public static void HandleTransaction(){

         System.out.println("Choose the operation you want to perform:");
         System.out.println("1.Deposite fund");
         System.out.println("2.withdraw fund");
         System.out.println("3.Transfer fund");
         System.out.println("4.Check transactions history");
         Scanner scanner = new Scanner(System.in);
         int exp = scanner.nextInt();
         switch(exp){
             case 1:
                DepositeMoney();
                break;
             case 2:
                 WithdrawMoney();
                 break;
             case 3:
                 TransferMoney();
                 break;
             case 4:
                 TransactionHistory();
                 break;

         }
     }   // this method executes all the transaction related operations

}     // this class manages all transaction related operations

 

class ManageAccount {

   public static  void CreateAccount(){
       Scanner scanner = new Scanner(System.in);
       Bank_management connect= new Bank_management();
       System.out.println("Enter your Account number");
       int acc_no = scanner.nextInt();
       scanner.nextLine();
       System.out.println("Enter your name");
       String UserName = scanner.nextLine();
       System.out.println(UserName);

       System.out.println("Enter Amount that you want to deposite ");
       int amount = scanner.nextInt();
       connect.getconnection();

       try{
           String sql = "INSERT INTO accounts (account_number,account_holder_name,balance) VALUES (?, ?, ?)";
           Connection conn = DriverManager.getConnection(connect.databaseUrl,connect.userName,connect.password);
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, acc_no);
           pstmt.setString(2,UserName);
           pstmt.setInt(3, amount);

           // Execute the query
           int rowsInserted = pstmt.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("A new account created successfully!");
           }


       }
       catch (Exception e){
           System.out.println("error:"+e);
       }

   }   //this method creates new accounts

    public static  void ViewAccount(){
        Bank_management connect= new Bank_management();
       connect.getconnection();
        System.out.println("Enter your Account number ");
        Scanner scanner = new Scanner(System.in);


        int acc_no = scanner.nextInt();

        try{
            Statement statement=connect.getconnection().createStatement();

            ResultSet result=statement.executeQuery("select * from accounts where account_number="+acc_no);

           int flag=0;
            System.out.println("account_number "+"       "+"account_holder_name"+"      "+"balance");
            while (result.next()){

                System.out.print(result.getString("account_number")+ "                  ");
                System.out.print(result.getString("account_holder_name")+"                     ");
                System.out.print(result.getString("balance"));
                flag=1;
            }
            if(flag==0){
                System.out.println("No account found!");
            }
        }
        catch (Exception e){
            System.out.println("error:"+e);
        }
    }    //we can see details of any using account number

    public static  void UpdateAccount(){
        System.out.println("Account updated");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account number:");
        int acc_no = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your new name :");
        String name= scanner.nextLine();

        try{
            Bank_management connect= new Bank_management();
            Connection conn = connect.getconnection();
            String sql = "UPDATE accounts SET account_holder_name = ? WHERE account_number = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2,acc_no);
            int rowsupdated = pstmt.executeUpdate();
            if (rowsupdated > 0) {
                System.out.println("your name is successfully updated!");
            }
            else{
                System.out.println("Something went wrong!");

            }
        }
        catch (Exception e){
            System.out.println("Error is :"+e);
        }

    }  // this method updates the existing details of account mainly name of account holder

    public static  void CloseAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account number:");
        int acc_no = scanner.nextInt();
        try {
            Bank_management connect= new Bank_management();
            Connection conn = connect.getconnection();
            String sql = "DELETE FROM accounts WHERE account_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, acc_no);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Account deleted  successfully!");
            }
            else {
                System.out.println("Something went wrong!");
            }
        }
        catch (Exception e){
            System.out.println("Error:"+ e);
        }
    }  // this method deletes the account

    public static void HandelAccount(){

        System.out.println("Enter your Choice :");
        System.out.println("1.Create accounts:");
        System.out.println("2.View account details:");
        System.out.println("3.Update account information:");
        System.out.println("4.Close an account:");
        Scanner scanner = new Scanner(System.in);
        int exp = scanner.nextInt();
        switch(exp){
            case 1:
                CreateAccount();
                break;
            case 2:
                ViewAccount();
                break;
            case 3:
                UpdateAccount();
                break;
            case 4:
                CloseAccount();
                break;
        }
    }   // this method executes all Account related opertaions


}        // this class manages all Account related operations

public class Bank_management {

    public   String databaseUrl = "jdbc:mysql://localhost:3306/bank";
    public String userName = "root";
    public  String password = "tyagi@123";

    public static void main(String[] args){

        ManageAccount account = new ManageAccount();
        ManageTransaction transaction = new ManageTransaction();
        System.out.println("Enter your Choice :");
        System.out.println("1.Manage Accounts:");
        System.out.println("2.Manage Transactions:");
        Scanner scanner = new Scanner(System.in);
        int exp = scanner.nextInt();
        switch(exp){
            case 1:
                account.HandelAccount();
                break;
            case 2:
                transaction.HandleTransaction();
                break;

        }
    }

    public  Connection getconnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl, userName, password);
            return conn;
        } catch (Exception e) {
            System.out.println("some error" + e);
        }
        return null;
    }

}
