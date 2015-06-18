package client;

import java.util.*;
import java.io.File;
import java.net.*;

import model.*;

public class CreateClient {
	private DefaultSocketClient clientSocket;
	private Scanner scanner = new Scanner(System.in);

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
			System.out.printf("*** This properties file does not exit***\n");
		}
		else {
			Properties pro = modelOptionsIO.readData(propertiesFileName);
			if(pro == null) {
				System.out.printf("*** Empty properties file ***\n");
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
		System.out.printf("\t*** Automobile Configuration ***\n");
//		clientSocket.sendObject("config");
		
		System.out.printf("Enter the model name: ");
		String model = scanner.nextLine();
		System.out.printf("Enter the option set name: ");
		String optName = scanner.nextLine();
		System.out.printf("Enter the option name: ");
		String name = scanner.nextLine();
		
		String userChoice = model + "," + optName + "," + name; 
		
		clientSocket.sendObject(userChoice);
		
	}
	
//	public void displayModel() {
//		System.out.printf("Enter your wanted model: ");
//		String modelName = scanner.nextLine();
//		
//		if(modelName.equals("")) {
//			System.out.printf("Cannot send an empty model name\n");
//		} else {
//			clientSocket.sendObject(modelName);
//		}
//		
//	}
	
	public void displayFleet() {
		clientSocket.sendObject("display");
		Object obj = clientSocket.getObject();
		
		Fleet fleet = (Fleet) obj;
		fleet.printFleet();
	}
		
	public void quit() {
		
		clientSocket.sendObject("quit");
		
		if(clientSocket.getObject().equals("terminated")) {
			System.out.printf("Server terminated\n"
					+ "Quit\n");
		} else {
			System.out.printf("Server cannot terminate\n");
		}
	}
	
	public void displayMenu() {
		System.out.printf("\t*** Menu ***\n"
				+ "  upload: upload properties file\n"
				+ "  config: config a car\n"
				+ "  display: display fleet\n"
				+ "  menu: display menu\n");
	}

}
