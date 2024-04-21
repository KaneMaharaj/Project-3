import java.util.ArrayList;
public class Customer {
    //instance variables
    private String firstName, lastName;
    private int pin;
    private ArrayList<Account> customerAccountList = new ArrayList<>();
    public Customer(String firstName, String lastName, int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }
    public void AddAccount(Account account){
    customerAccountList.add(account);
    }
    public void RemoveAccount(Account account){
    customerAccountList.remove(account);
    }
    public String getAccount(int accountNumber){
    Account foundAccount = null;
    for (Account account : customerAccountList) {
        if (account.getAccountNumber() == (accountNumber)) {
            foundAccount = account;
            break;
        }
    }
    return foundAccount;

    public ArrayList<Account> getAllAccounts(){
        return customerAccountList;
    }
    @Override
    public String toString(){
        return String.format("Customer Name: %s%-5s\nPIN: %d\n",firstName,lastName,pin);
    }
    public int getCustomer(int pin) {
            return Customer;
        }
}

