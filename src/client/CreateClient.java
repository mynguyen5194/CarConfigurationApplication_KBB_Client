package client;

import java.util.*;
import java.io.File;
import java.net.*;

import model.*;

public class CreateClient{
	private DefaultSocketClient clientSocket;
	private SelectCarOption carOption;
	private Scanner scanner;

	public CreateClient() {
		carOption = new SelectCarOption();
		scanner = new Scanner(System.in);
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
			case "upload":
				this.uploadPropertiesFile();
				quit = false;				
				break;
				
			case "config":
				this.config();
				quit = false;
				break;
				
			case "display":
				this.displayFleet();
				quit = false;
				break;
				
			case "display model":
				this.displayModel();
				quit = false;
				break;
				
			case "menu":
				this.displayMenu();
				quit = false;
				break;
		
			case "quit":
				this.quit();
				quit = true;
				break;
				
			default:
				System.out.printf("Re-enter\n");
				break;
			}
		} while(true && !quit);			
	}
	
	public void uploadPropertiesFile() {
		CarModelOptionsIO modelOptionsIO = new CarModelOptionsIO();
		
		System.out.printf("Enter the properties file name: ");
		String propertiesFileName = "";
		
		propertiesFileName = scanner.nextLine();
		File propertiesFile = new File(propertiesFileName);
		
			
		if(!propertiesFile.exists()) {
			System.out.printf("  *** Properties file does not exit***\n");
		}
		else {
			Properties pro = modelOptionsIO.readData(propertiesFileName);
			if(pro == null) {
				System.out.printf("  *** Empty properties file ***\n");
			}
			else {
				clientSocket.sendObject(pro);
				
				if(clientSocket.getObject().equals("success")) {
					System.out.printf("*** Properties file uploaded successfully ***\n");
				} else {
					System.out.printf("*** Properties file uploaded fail ***\n");
				}
			}
		}
	}
	
	public void config() {
		clientSocket.sendObject("config");
		
		if(clientSocket.getObject().equals("start configuring")) {
			Fleet fleet = (Fleet) clientSocket.getObject();
			
			carOption.config(scanner, fleet);
		} else {
			System.out.printf("Cannot connect to the server!\n");
		}
	}
	
	public void displayModel() {
		carOption.displayModel(scanner, clientSocket);
	}
	
	public void displayFleet() {		
		carOption.getAvailableModel(clientSocket);
	}
		
	public void quit() {
		clientSocket.sendObject("quit");
		clientSocket.closeSession();
	}
	
	public void displayMenu() {
		System.out.printf("\t*** Menu ***\n"
				+ "  upload: upload properties file\n"
				+ "  config: config a car\n"
				+ "  display: display fleet\n"
				+ "  display model: display a specific model\n"
				+ "  menu: display menu\n");
	}

}
