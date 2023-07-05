package server.controller;

import java.util.List;
import java.util.ArrayList;

import model.Customer;

public class CustomerDataManager {
	
	private List<Customer> customers;
	
	/*
	 * this is the constructor
	 */
	public CustomerDataManager() {
		this.customers = new ArrayList<Customer>();
		this.loadCustomer();
	}
	
	/*
	 * this method want to create a list of customer
	 */
	public List<Customer> getCustomers() {

		return customers;
		
	}
	
	public Customer getCustomerByName(String customerName) {
		
	    for (Customer customer : customers) {
	        if (customer.getCustomerName().toLowerCase().contains(customerName.toLowerCase())) {
	            return customer;
	        }
	    }
	    
	    //return customer not found
	  	Customer custNotFound = new Customer();
	  	custNotFound.setCustomerName("Customer not found");
	  			
	  	return custNotFound;
	}

	public Customer getCustomerById(int customerId) {
		
		for (Customer customer: customers) {
			if(customer.getCustomerId() == customerId) {
				
				return customer;
			}
		}
		//return customer not found
		Customer custNotFound = new Customer();
		custNotFound.setCustomerName("Customer not found");
			
		return custNotFound;
			
	}
		
	private void loadCustomer(){
		
		// Sample data
		int ids[] = {1,2,3};
		String names[] = {"Ali", "Abu", "Mamat"};

		// Load data into list
		for (int index=0; index < ids.length; index++) {

			// Create product
			Customer customer = new Customer();
			customer.setCustomerId(ids[index]);
			customer.setCustomerName(names[index]);

			// Add to list
			customers.add(customer);
			

		}
		
	}
	

}