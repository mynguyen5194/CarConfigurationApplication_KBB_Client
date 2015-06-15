package client;

import java.util.*;
import java.io.*;
import java.net.*;

public class CreateClient {
	private DefaultSocketClient clientSocket;
	private ServerSocket serverSocket;
	private Scanner scanner = new Scanner(System.in);
	private ObjectOutputStream output;
	private ObjectInputStream input;
	

	public CreateClient() {
		clientSocket = new DefaultSocketClient("10.41.209.172", 4444);
		clientSocket.openConnection();
	}
	
	
	public void selectServiceOption() {
		boolean quit = false;
		
		do {
			System.out.printf("Enter your option: ");
			String option = scanner.nextLine();
			
			switch(option.toLowerCase()) {
			case "update":
				this.sendCommand("update");
				System.out.println("command sent");
				try {
					if(((String) input.readObject()).equals("received")) {
						this.update();
						quit = false;
					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				
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
	
	public void sendCommand(Object command) {
		try {
			output.writeObject(command);
//			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readCommand() {
		String command = "";
		
		command = ((String) this.getReponse());
		
		return command;
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
