public class Account {
    ///instance variables
    private int balance;
    private int accountNumber;

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    public Account (){
    }

    static int numberOfAccounts = 1000;
    //constructor
    public Account(int initialDeposit){
        balance = initialDeposit;
        accountNumber = numberOfAccounts++;
    }
    //Getter
    public double getBalance() {
        return balance;
    }
    // It's not callinmg ****
    public void Deposit(int depositAmount){
        balance = balance + depositAmount;
        System.out.println("Amount Deposited: $" + depositAmount);
        System.out.println("New Balance: $" + balance);
    }
    // It's not callinmg ****
    public void Withdraw (int withdrawAmount){
        if (withdrawAmount > balance){
            System.out.println("Insufficient Funds!");
        }
        else {
            balance = balance - withdrawAmount;
            System.out.println("Withdrawn Amount: $" + withdrawAmount);
            System.out.println("New Balance: $" + balance);
        }
    }
    @Override
    public String toString(){
        return String.format("\n***Active Account(s)***\nAccount Number: %d\nBalance: %d\n", accountNumber,balance);
    }
    public int getAccountNumber(){
        return accountNumber;
    }
}
