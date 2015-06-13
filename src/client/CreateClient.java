package client;

import java.util.*;
import java.io.*;

public class CreateClient {
	private DefaultSocketClient clientSocket;
	Scanner scanner = new Scanner(System.in);

	public CreateClient() {
		clientSocket = new DefaultSocketClient("192.168.1.105", 4444);
		clientSocket.openConnection();
	}
	
	public void selectServiceOption() {
		System.out.printf("Enter your option: ");
		String option = scanner.nextLine();
		
		switch(option.charAt(0)) {
		case 'U':
			this.update();
			break;
				
		case 'C':
			
			
		break;
		}		
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
}
