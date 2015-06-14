package client;

import java.util.*;
import java.io.*;
import java.net.*;

public class CreateClient {
	private DefaultSocketClient clientSocket;
	private ServerSocket serverSocket;
	private Scanner scanner = new Scanner(System.in);

	public CreateClient() {
		clientSocket = new DefaultSocketClient("192.168.1.105", 4444);
		clientSocket.openConnection();
	}
	
	public void selectServiceOption() {
		boolean quit = false;
		
		do {
			System.out.printf("Enter your option: ");
			String option = scanner.nextLine();
			
			switch(option.toLowerCase()) {
			case "update":
				this.update();
				quit = false;
				break;
				
			case "display":
				this.displayModel();
				quit = false;
				break;
		
			case "quit":
				System.out.printf("Quit\n");
				quit = true;
				break;
				
			default:
				System.out.printf("Re-enter\n");
				break;
			}
		} while(!quit);
				
	}
	
//	public void performOperation(String fileName) {
//		CarModelOptionsIO modelOptionsIO = new CarModelOptionsIO();
//		
//		Properties pro = modelOptionsIO.readData(fileName);
//		clientSocket.sendPropertiesObj(pro);
//	}
	
	public void update() {
		CarModelOptionsIO modelOptionsIO = new CarModelOptionsIO();
		
		System.out.printf("Enter the properties file name: ");
		String propertiesFileName = "";
		
		propertiesFileName = scanner.nextLine();
			
		Properties pro = modelOptionsIO.readData(propertiesFileName);
		clientSocket.sendPropertiesObj(pro);
	}
	
	public void displayModel() {
		System.out.printf("\nDisplay Model function\n");
		clientSocket.sendCommand("display");
	}
}
