package client;

import java.util.*;
import java.io.*;
import java.net.*;

import model.Fleet;

public class CreateClient {
	private DefaultSocketClient clientSocket;
	private ServerSocket serverSocket;
	private Scanner scanner = new Scanner(System.in);
	private ObjectOutputStream output;
	private ObjectInputStream input;
	

	public CreateClient() {
		try {
			clientSocket = new DefaultSocketClient(Inet4Address.getLocalHost().getHostAddress(), 4444);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
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
				Object obj = readCommand();
				System.out.println("Successful read");
				Fleet f1 = (Fleet) obj;
				f1.printFleet();
				System.out.println("Successful display");
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
		} while(true && !quit);
				
	}
	
	public void sendCommand(Object command) {
		try {
			output.writeObject(command);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object readCommand() {
		return clientSocket.getObject();
	}
	
	public Object getReponse() {
		Object response = null;
		try {
			response = input.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	
	public void update() {
		CarModelOptionsIO modelOptionsIO = new CarModelOptionsIO();
		
		System.out.printf("Enter the properties file name: ");
		String propertiesFileName = "";
		
		propertiesFileName = scanner.nextLine();
			
		Properties pro = modelOptionsIO.readData(propertiesFileName);
		clientSocket.sendObject(pro);
	}
	
	public void displayModel() {
		System.out.printf("\nDisplay Model function\n");
		String command = "display";
		Object display = command;
		
		clientSocket.sendObject(display);
	}
}
