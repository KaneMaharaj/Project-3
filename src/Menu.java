import java.util.Scanner;
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    //instance of bank class
    private Bank newBank = new Bank();
    private InheritanceClass demo = new InheritanceClass();

    public void displayMenu(){
        while (true) {
            System.out.println("********** MENU **********");
            System.out.println("Please Make a Selection:");
            System.out.println("1) Access Account");
            System.out.println("2) Open a New Account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Purchase Scratch Off Ticket");
            System.out.println("5) Exit");
            int userChoice = Integer.parseInt(scanner.nextLine());
            //------
            if (userChoice == 1) {
                // 1st methods
                //call method
                accessAccount();
            }
            else if (userChoice == 2) {
                openNewAccount();
            }
            else if (userChoice == 3) {
                closeAccount();
            }
            else if (userChoice == 4){
                lotteryGame();
            }
            else if (userChoice == 5) {
                System.out.println("Exiting....");
                break;
            }
            else {
                System.out.println("Invalid Entry Message!");
            }
        }
    }
    private void lotteryGame(){
        Customer customer;
        Account account;

        System.out.println("Enter your pin number: ");
        int pin = Integer.parseInt(scanner.nextLine());
        customer = newBank.getCustomer(pin);
        System.out.println("Please Enter Your Account Number: ");
        int userAcc = Integer.parseInt(scanner.nextLine());
        account = customer.getAccount(userAcc);
        demo.lotteryTime(account);
    }

    private void closeAccount(){
        System.out.println("Please Enter PIN:");
        int userPIN = Integer.parseInt(scanner.nextLine());
        Customer methodResponse = newBank.getCustomer(userPIN);
        if (methodResponse.equals(null)){
            //break;
            return;
        }
        else{
            newBank.RemoveCustomer(methodResponse);
            System.out.println("Customer has been removed from bank registry!");
        }
    }
    private void openNewAccount(){
        Customer customer;
        System.out.println("Are You a New Customer?");
        String userReply = scanner.nextLine();
        if (userReply.equals("yes") || userReply.equals("Yes")){
            customer = createNewCustomer();
            //System.out.println(" New Account Opened: " + account.getAccountNumber());
        }
        else if (userReply.equals("no") || userReply.equals("No")){
            System.out.println("What is Your PIN?");
            int userPIN = Integer.parseInt(scanner.nextLine());
            customer = newBank.getCustomer(userPIN);
            if (newBank.getCustomer(userPIN)==null){

                return ;
                //break;
            }
            System.out.println("Please enter the deposit amount: ");
            int deposit = Integer.parseInt(scanner.nextLine());
            Account account = new Account(deposit);
            customer.AddAccount(account);
            System.out.println("New Account Opened: " + account.getAccountNumber());
        }
    }
    private void accessAccount() {
        // Create an object of account class
        Account account;
        System.out.println("Please Enter PIN:");
        int returningUserPIN = Integer.parseInt(scanner.nextLine());
        Customer getCustomResponse = newBank.getCustomer(returningUserPIN);
        //Issue HERE needs to call the string method form account?
        if (getCustomResponse == null) {
            System.out.println("PIN not valid!");
            //ISSUE HERE
            return;
        } else {
            System.out.println(getCustomResponse.getAllAccounts());
            //getCustomResponse.getAllAccounts();
            System.out.println("Enter the number of the account you want to access:");
            int userAccountNum = Integer.parseInt(scanner.nextLine());
            //Account
            //Customer accountMethod = getAccount(userAccountNum);
            account = getCustomResponse.getAccount(userAccountNum);
            //original
            //if (accountMethod.equals(null)) {
            if (account == null) {
                System.out.println("Account number invalid");
                return;
            } else {
                getCustomResponse.getAllAccounts();
            }
            //While true
            while (true) {
                System.out.println("Please make a selection:");
                System.out.println("1) Make a deposit");
                System.out.println("2) Make a withdrawl");
                System.out.println("3) See account balance");
                System.out.println("4) Close account");
                System.out.println("5) Exit");
                int accountUserResponse = Integer.parseInt(scanner.nextLine());
                if (accountUserResponse == 1) {
                    System.out.println("Please deposit an amount");
                    int userDeposit = Integer.parseInt(scanner.nextLine());//*****
                    account.Deposit(userDeposit);
                } else if (accountUserResponse == 2) {
                    System.out.println("Please enter a withdrawal amount");
                    int userWithdrawAmount = Integer.parseInt(scanner.nextLine());
                    account.Withdraw(userWithdrawAmount);
                } else if (accountUserResponse == 3) {
                    System.out.printf("The account number: %d\nBalance: %.2f\n ", account.getAccountNumber(), account.getBalance());

                } else if (accountUserResponse == 4) {
                    getCustomResponse.RemoveAccount(account);
                    System.out.println("Account number " + account.getAccountNumber() + " closed");

                } else if (accountUserResponse == 5) {
                    System.out.println("Exiting ....");
                    break;
                } else {
                    System.out.println("Invalid Response");
                }
            }
        }
    }
    private Customer createNewCustomer()
    {
        Customer newCustomer;
        System.out.println("Input First Name:");
        String newCustomerFirstName = scanner.nextLine();
        System.out.println("Input Last Name:");
        String newCustomerLastName = scanner.nextLine();
        System.out.println("Enter PIN:");
        int newCustomerPIN = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the deposit number: ");
        int deposit = Integer.parseInt(scanner.nextLine());
        newCustomer = new Customer(newCustomerFirstName, newCustomerLastName, newCustomerPIN);
        Account account = new Account(deposit);  // accout instance passing in deposit in constructor
        //added customer
        newCustomer.AddAccount(account);
        // does make new customer?
        newBank.AddCustomer(newCustomer);
        System.out.println("New Account Opened: " + account.getAccountNumber());
        return newCustomer;
    }

}
