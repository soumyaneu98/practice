/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SalesManagement;

import TheBusiness.CustomerManagement.CustomerProfile;
import java.util.ArrayList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonProfile extends Profile {
    ArrayList<Order> salesorders;
    private ArrayList<CustomerProfile> customers;

    public ArrayList<CustomerProfile> getCustomers() {
        return customers;
    }

    public SalesPersonProfile(Person p) {

        super(p); 
        salesorders = new ArrayList();
        customers = new ArrayList();


    }
    public void addSalesOrder(Order o){
        salesorders.add(o);
    }

    public boolean hasCustomer(CustomerProfile customer) {
        return customers.contains(customer);
    }
    
    @Override
    public String getRole(){
        return  "Sales";
    }

}
