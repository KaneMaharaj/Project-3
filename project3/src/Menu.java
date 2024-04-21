import java.util.Scanner;
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    //instance of bank class
    private Bank newBank = new Bank();

    public void displayMenu(){
        while (true) {
            System.out.println("********** MENU **********");
            System.out.println("Please Make a Selection:");
            System.out.println("1) Access Account");
            System.out.println("2) Open a New Account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Exit");
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (userChoice == 1) {
                System.out.println("Please Enter PIN:");
                int returningUserPIN = Integer.parseInt(scanner.nextLine());
                Customer getCustomResponse = newBank.getCustomer(returningUserPIN);
                if (getCustomResponse.equals(null)){
                    System.out.println("PIN not valid!");
                    return;
                }
                System.out.println(getCustomResponse);
                System.out.println("Enter the number of the account you want:");
                int userAccountNum = Integer.parseInt(scanner.nextLine());
                Customer accountMethod = getAccount(userAccountNum);
                if (accountMethod.equals(null)){
                    System.out.println("Account number invalid");
                    return;
                }
                System.out.println("Please make a selection:");
                System.out.println("1) Make a deposit");
                System.out.println("2) Make a withdrawl");
                System.out.println("3) See account balance");
                System.out.println("4) Close account");
                System.out.println("5) Exit");
                int accountUserResponse = Integer.parseInt(scanner.nextLine());
                if (accountUserResponse == 1){
                    System.out.println("Please deposit an ammount in the form of 0.0/00.00/etc.");
                    double userDeposit = scanner.nextDouble();
                    Deposit(userDeposit);
                }
                else if (accountUserResponse == 2){
                    System.out.println("Please enter a withdrawl amount in the form of 0.0/00.00/etc.");
                    double userWithdrawAmount = scanner.nextDouble();
                    Withdraw (userWithdrawAmount);
                }
                else if (accountUserResponse == 3) {

                }
                else if (accountUserResponse == 4) {

                }
                else if (accountUserResponse == 5) {
                    break;
                }
                else {
                    System.out.println("Invalid Resposne");
                }
            }
            else if (userChoice == 2) {
                System.out.println("Are You a New Customer?");
                String userReply = scanner.nextLine();
                if (userReply.equals("yes") || userReply.equals("Yes")){
                    createNewCustomer();
                }
                else if (userReply.equals("no") || userReply.equals("No")){
                    System.out.println("What is Your PIN?");
                    int userPIN = Integer.parseInt(scanner.nextLine());
                    newBank.getCustomer(userPIN);
                    if (newBank.getCustomer(userPIN).equals(null)){
                        break;
                    }
                }
            }
            else if (userChoice == 3) {
                System.out.println("Please Enter PIN:");
                int userPIN = Integer.parseInt(scanner.nextLine());
                Customer methodResponse = newBank.getCustomer(userPIN);
                if (methodResponse.equals(null)){
                    break;
                }
                else{
                    newBank.RemoveCustomer(methodResponse);
                    System.out.println("Customer has been removed from bank registry!");
                }
            }
            else if (userChoice == 4) {
                break;
            }
            else {
                System.out.println("Invalid Entry Message!");
            }
        }
        public Customer createNewCustomer(){
            Customer newCustomer;
            System.out.println("Input First Name:");
            String newCustomerFirstName = scanner.nextLine();
            System.out.println("Input Last Name:");
            String newCustomerLastName = scanner.nextLine();
            System.out.println("Enter PIN:");
            int newCustomerPIN = Integer.parseInt(scanner.nextLine());
            newCustomer = new Customer(newCustomerFirstName, newCustomerLastName, newCustomerPIN);
            newBank.AddCustomer(newCustomer);
            //return newCustomer;
        }
    }
}
