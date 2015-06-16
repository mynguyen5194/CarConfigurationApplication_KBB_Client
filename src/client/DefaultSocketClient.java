package client;

import java.net.*;
import java.io.*;
import java.util.*;

import model.*;

public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket socket;
	private String strHost;
	private int iPort;
	private Scanner scanner = new Scanner(System.in);
	
	public DefaultSocketClient() {}
	public DefaultSocketClient(Socket Socket) {
		socket = Socket;
	}
	public DefaultSocketClient(String StrHost, int IPort) {
		strHost = StrHost;
		iPort = IPort;
	}
	
	
	public Socket getSocket() {
		return socket;
	}
	public String getStrHost() {
		return strHost;
	}
	public int getiPort() {
		return iPort;
	}
	public void setReader(ObjectInputStream reader) {
		this.reader = reader;
	}
	public void setWriter(ObjectOutputStream writer) {
		this.writer = writer;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void setStrHost(String strHost) {
		this.strHost = strHost;
	}
	public void setiPort(int iPort) {
		this.iPort = iPort;
	}
	
	
	public void run() {
		if(openConnection()) {
			this.handleSession();
			this.closeSession();
		}
	}
	
	public boolean openConnection() {
		boolean opened = true;
		
		try {
			socket = new Socket(strHost, iPort);
			System.out.println("created socket client");
		} catch (IOException socketError) {
			if(DEBUG) {
				System.err.printf("Unable to connect to " + strHost + "\n");
			}
			opened = false;
		}
		
		try {
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
		} catch(IOException e) {
			if(DEBUG) {
				e.printStackTrace();
				System.err.printf("Unable to obtain stream to/from " + strHost + "\n");
			}
			opened = false;
		}
		
		return opened;
	}
	
	public void handleSession() {
		String strInput = "";
		if(DEBUG) {
			System.out.printf("Handling session with " + strHost + ": " + iPort);	
		}
		try {
			while((strInput = (String) reader.readObject()) != null) {
				handleInput(strInput);
			}
		} catch(IOException e) {
			if(DEBUG) {
				System.out.printf("Handling session with " + strHost + ": " + iPort);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Object getObject() {
		Object receivedObj = null;
		try {
			receivedObj = reader.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return receivedObj;
	}

	public boolean uploadPropertiesFile() {
		CarModelOptionsIO modelOptions = new CarModelOptionsIO();
		boolean updated = false;
		Properties pro = null;
		
		System.out.printf("\nEnter the properties file name: ");
		String fileName = scanner.nextLine();
		
		if(fileName.equals("")) {
			updated = false;
		} else {
			pro = modelOptions.readData(fileName);
			updated = true;
		}
		
		
		
		return updated;
	}
	
	
	public void setCommand(String command) {
		try {
			writer.writeObject(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendOutput(String strOutput) {
		try {
			writer.writeObject(strOutput);
		} catch(IOException e) {
			if(DEBUG) {
				System.out.printf("Error writing to " + strHost + "\n");
			}
		}
	}
	
	public void handleInput(String strInput) {
		System.out.printf(" " + strInput + " \n");
	}
	
	public void sendObject(Object obj) {
		try {
			writer.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receiveCommand() {
		
		try {
			if(reader.readObject().toString().equals("display")) {
				Fleet fleet = (Fleet) reader.readObject();
				
				fleet.printFleet();
			}
		} catch(IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException err) {
			err.printStackTrace();
		}
	}
	
	public void closeSession() {
		try {
			writer = null;
			reader = null;
			socket.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}	
}
