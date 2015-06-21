package client;

import java.util.Scanner;
import model.*;

public class SelectCarOption {
	public void getAvailableModel(DefaultSocketClient clientSocket) {
		clientSocket.sendObject("display");
		
		System.out.printf("\n*** Available Models ***\n");
		((Fleet) clientSocket.getObject()).printFleet();
	}
	
	public void displayModel(Scanner scanner, DefaultSocketClient clientSocket) {
		System.out.printf("Enter the model name: ");
		String modelName = scanner.nextLine();
		
		clientSocket.sendObject(modelName);
		Object obj = clientSocket.getObject();
		
		if(obj.equals("fail")) {
			System.out.printf("Model does not exist\n");
		} else {
			Automobile auto = (Automobile) obj;
			auto.printOptionSet();
		}
	}
	
	public void config(Scanner scanner, Fleet fleet) {
		String model = "";
		String optName = "";
		String name = "";
		
		System.out.printf("\t*** Automobile Configuration ***\n");
		
		System.out.printf("Enter the model name: ");
		model = scanner.nextLine();
		
		if(fleet.containsKey(model)) {
			System.out.printf("Enter the option set name: ");
			optName = scanner.nextLine();
			
			System.out.printf("Enter the option name: ");
			name = scanner.nextLine();
			
			fleet.setOptionChoice(model, optName, name);
			fleet.printChoices(model);
			System.out.printf("* Total Price: " + fleet.getModelTotalPrice(model) + "\n");
		} else {
			System.out.printf("*** Model does not exit ***\n");
		}
		
	}
}
