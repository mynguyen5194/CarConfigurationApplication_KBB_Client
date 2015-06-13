package scale;

import model.Fleet;
import adapter.*;

public class EditOptions extends ProxyAutomobile implements ScaleThread, Runnable {
	private Fleet fleet;
	private Thread thread;
	private int ops;
	private String [] name;
	// [0] Model/oldModelName, [1] newModelName, [2] Name/oldName,
	// [3] newName, [4] newPrice (double)
	
	public EditOptions() {
		thread = new Thread(this);
		name = new String[5];
		start();
	}
	
	public EditOptions(int Ops, String [] Name) {
		thread = new Thread(this);
		ops = Ops;
		name = Name;
		start();
	}
	
	public EditOptions(int Ops, String [] Name, Object Obj) {
		thread = new Thread(this);
		ops = Ops;
		name = Name;
		fleet = (Fleet) Obj;
		start();
	}
	
	
	// [0] Model/oldModelName, [1] newModelName, [2] Name/oldName,
	// [3] newName, [4] newPrice (double)
	public void run() {
		System.out.printf("  * " + thread.getName() + " is running\n");
		
		switch(ops) {
		case 0:
			this.updateModelName(name[0], name[1]);
			System.out.printf(thread.getName() + " finished updating model name\n");
			stop();
			break;
			
		case 1:
			this.updateOptionName(name[0], name[2], name[3]);
			System.out.printf(thread.getName() + " finished updating option name\n");
			stop();
			break;
			
		case 2:
			this.updateOptionPrice(name[0], name[2], Double.parseDouble(name[4]));
			System.out.printf(thread.getName() + " finished updating option price\n");
			stop();
			break;
			
		default:
			System.out.printf("Wrong operation!\n");
			break;
		}
	}
	
	public void start() {
		try {
			System.out.printf(thread.getName() + " is starting\n");
			Thread.sleep(2000);
			thread.start();
		} catch(InterruptedException e) {
			e.getMessage();
		}	
	}
	
	public void stop() 	{
		System.out.printf("  * " + thread.getName() + " stopped\n\n");
		thread = null;
	}
	
	public synchronized void updateModelName(String oldModelName, String newModelName) {
		fleet.updateModelName(oldModelName, newModelName);
		
		try {
			Thread.sleep(2000);
			fleet.printFleet();
		} catch(InterruptedException e) {
			e.getMessage();
		}
	}
	
	public synchronized void updateOptionName(String Model, String oldName, String newName) {
		fleet.updateOptionName(Model, oldName, newName);
		
		try {
			Thread.sleep(2000);
			fleet.printFleet();
		} catch(InterruptedException e) {
			e.getMessage();
		}
	}
	
	public synchronized void updateOptionPrice(String Model, String Name, double newPrice) {
		fleet.updateOptionPrice(Model, Name, newPrice);
		
		try {
			Thread.sleep(2000);
			fleet.printFleet();
		} catch(InterruptedException e) {
			e.getMessage();
		}
	}
}
