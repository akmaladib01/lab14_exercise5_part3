package server.app;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;

import model.Customer;
import server.controller.CustomerDataManager;

public class TCPCustomerNameServer {

	public static void main(String[] args) {

		int portNo = 2509;

		CustomerDataManager manager = new CustomerDataManager();

		System.out.println("\n\tExecuting TCPProductServerApp");

		try {

			System.out.println("\tWaiting for next request");

			// 1. Bind to a port
			ServerSocket serverSocket = new ServerSocket(portNo); 

			// 2. Server need to continually run to listen to request
			while (true) {

				// 3. Accept request from client
				Socket clientSocket = serverSocket.accept();

				// 4. Process request - create input stream to read request
				// Request - customer name: String
				InputStream is = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(is);

				//read number of customer names
				int numOfNames = dis.readInt();

				List<Customer> customers = new ArrayList<>();

				// Read each customer name and search for the customer
				for (int i = 0; i < numOfNames; i++) {
					String custName = dis.readUTF();
					System.out.println("\tRequest for customer name: " + custName);

					// Get customer
					Customer customer = manager.getCustomerByName(custName);
					customers.add(customer);
				}

				// 5. Respond to client
				OutputStream os  = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(customers);

				System.out.println("\tSending customer(s):");
				for (Customer customer : customers) {
					System.out.println("\t- " + customer.getCustomerId() + " " + customer.getCustomerName());
				}
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

}