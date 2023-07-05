package view;

import java.util.List;

import model.Customer;

public class CustomerViewer {


	public void displayProducts(List<Customer> customers) {
		
		// Some information about the record
		System.out.println("\tNumber of record: " + customers.size());
		System.out.println("\tCustomer Information");
		
		// Print all products on console
		for (Customer customer:customers) {
			
			System.out.println("\n\tCustomer Id: " + customer.getCustomerId());
			System.out.println("\tCustomer Name: " + customer.getCustomerName());
		
		}
		
	}

}