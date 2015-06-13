package adapter;

import java.util.*;
import model.*;
import util.*;
import exceptionHandler.*;

public abstract class ProxyAutomobile {
	private static Fleet fleet;
	
	public ProxyAutomobile() {
		fleet = new Fleet();
	}
	
	public static void setFleet(Fleet fleet) {
		ProxyAutomobile.fleet = fleet;
	}
	
	public static Fleet getFleet() {
		return fleet;
	}
	
	public double getTotalPrice(String Model) {
		return fleet.getModelTotalPrice(Model);
	}
	
	// Build the whole fleet by reading from file
	public Fleet buildFleet(String fileName) {
		AutoUtil autoUtil = new AutoUtil();	
		fleet = autoUtil.readFile(fleet, fileName);
		return fleet;
	}
	
	// Add new model into the fleet
	public void addAuto(String Model, Automobile Auto) {
		fleet.setFleet(Model, Auto);
	}
	
	public void addAuto(Properties pro, String fileName) {
//		BuildCarModelOptions builder = new BuildCarModelOptions();
		
//		fleet = builder.addAutoToLHM(builder.createAuto(pro, fileName));
	}
	
	// Add choice to the Choices LinkedHashMap
	public void addOptionChoice(String Model, String optName, String Name) {
		fleet.setOptionChoice(Model, optName, Name);
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	public void updateModelName(String oldModelName, String newModelName) {
		boolean updated = fleet.updateModelName(oldModelName, newModelName);
			
		if(updated) {
			System.out.printf("* " + newModelName + " is updated\n\n");
		}
		else {
			System.out.printf("* Unable to update " + oldModelName + "\n\n");
		}
	}
	
	public void updateOptionName(String Model, String oldName, String newName) {
		boolean updated = fleet.updateOptionName(Model, oldName, newName);
		
		if(updated) {
			System.out.printf("* " + oldName + " in " + Model + " is found\n"
					+ "* Successfully updating to " + newName + "\n\n");
		}
		else {
			System.out.printf("* " + oldName + " in " + Model + " cannot be found\n"
					+ "* Fail updating to " + newName + "\n\n");
		}
		
	}
		
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.
	public void updateOptionPrice(String Model, String Name, double newPrice) {
		boolean updated = fleet.updateOptionPrice(Model, Name, newPrice);
			
		if(updated) {
			System.out.printf("* " + Name + " in " + Model + " is found\n"
					+ "* Successfully updating " + Name + " to " + newPrice + "\n\n");
		}
		else {
			System.out.printf("* " + Name + " in " + Model + " cannot be found\n"
					+ "* Fail updating " + Name + " to " + newPrice + "\n\n");
		}
	}
	
	// Remove a specific model from the fleet
	public void removeAuto(String Model) {
		boolean removed = fleet.removeAuto(Model);
		
		if(removed) {
			System.out.printf(Model + " was removed!\n");
		}
		else {
			System.out.printf(Model + " was not removed!\n");
		}
	}
	
	public void fixProblem(ExceptionHandler exp) {
		exp.printmyproblem();
	}
	
	// Print the whole fleet
	public void printFleet() {
		fleet.printFleet();
	}
	
	// Search and print the properties of a given modelName.
	public void printAuto(String Model) {
		if(fleet.containsKey(Model)) {
			fleet.printAuto(Model);
		}
		else {
			System.out.printf("* " + Model + " is empty\n\n");
		}
	}
	
	// Print chosen options
	public void printChoices(String Model) {
		if(fleet.containsKey(Model)) {
			fleet.printChoices(Model);
		}
		else {
			System.out.printf("* " + Model + " is empty\n\n");
		}
	}
	
	// Print total price for chosen option and base price
	public void printTotalPrice(String Model) {
		if(fleet.containsKey(Model)) {
			System.out.printf("********************************" + "\nModel: " + Model
					+ "\nTotal Price: " + fleet.getModelTotalPrice(Model) + "\n"
					+ "********************************\n");
		}
		else {
			System.out.printf("* " + Model + " has no chosen option!\n");
		}
	}
}
