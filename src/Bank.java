import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerList = new ArrayList<>();
    public void AddCustomer(Customer customer){
        customerList.add(customer);
    }
    public void RemoveCustomer(Customer customer){
        customerList.remove(customer);
    }
    public Customer getCustomer(int pin){
        Customer foundCustomer = null;
        for(Customer customer: customerList){
            //Original Code:
            //if(customer.getCustomerPin() == (pin)){
            // Use Getter from Customer class that returns pin to compare.
            if(customer.getPin() == (pin)){
                foundCustomer = customer;
                break;
            }
            else{
                System.out.println("Invalid pin");
            }
        }
        return foundCustomer;
    }
    public ArrayList<Customer> getCustomerInfo(){
        return customerList;
    }
}
