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
            if(customer.getCustomerPin() == (pin)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public ArrayList<Customer> getCustomerInfo(){
        return customerList;
    }
}
