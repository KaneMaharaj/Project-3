public class Account {
    ///instance variables
    private double balance;
    private int accountNumber;

    static int numberOfAccounts = 1000;
    //constructor
    public Account(double initialDeposit){
        balance = initialDeposit;
        accountNumber = numberOfAccounts + 1;
    }
    public void Deposit(double depositAmount){
        balance = balance + depositAmount;
        System.out.println("Amount Deposited: " + depositAmount);
        System.out.println("New Balance: " + balance);
    }
    public void Withdraw (double withdrawAmount){
        if (withdrawAmount > balance){
            System.out.println("Insufficient Funds!");
        }
        else {
            balance = balance - withdrawAmount;
            System.out.println("Withdrawn Amount: " + withdrawAmount);
            System.out.println("New Balance: " + balance);
        }
    }
    @Override
    public String toString(){
        return String.format("Account Number: %d\nBalance: %f\n",accountNumber,balance);
    }
    public int getAccountNumber(){
        return accountNumber;
    }

}
