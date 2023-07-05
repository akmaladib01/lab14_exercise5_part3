package client.app;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import view.CustomerViewer;
import model.Customer;

public class TCPCustomersClient {

	public static void main(String[] args) {
			
			try {
			
				// Server information
				int serverPortNo = 8081;
				InetAddress serverAddress = InetAddress.getLocalHost();
				
				// 1. Connect to remote machine
				Socket socket = new Socket(serverAddress, serverPortNo);
				
				
				// Create stream to receive response from the server
				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				
				// 3. Read respond from the server - cast the object
				List<Customer> products = (List<Customer>) ois.readObject();
				
				// 4. Process response - display the object
				CustomerViewer productViewer = new CustomerViewer();
				productViewer.displayProducts(products);
				
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
				
			}
			

	}

}