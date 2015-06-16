/*	
 * Fleet manages multiple models by using LinkedHashMap methods
 * to access each Automobile model
 */

package model;

import java.io.Serializable;
import java.util.*;

public class Fleet implements Serializable {
	private LinkedHashMap<String, Automobile> fleet;	// String (key) = model
	
	
	// CONSTRUCTORS
	public Fleet() {
		fleet = new LinkedHashMap<String, Automobile>();
	}
	
	public Fleet(LinkedHashMap<String, Automobile> Fleet) {
		fleet = Fleet;
	}
	
	
	// SETTERS
	public void setFleet(LinkedHashMap<String, Automobile> fleet) {
		this.fleet = fleet;
	}
	
	public void setFleet(String model, Automobile auto) {
		fleet.put(model, auto);
	}
	
	public void setOptionChoice(String model, String optName, String Name) {
		fleet.get(model).setOptionChoice(optName, Name);
	}
	
	
	// GETTERS
	public LinkedHashMap<String, Automobile> getFleet() {
		return fleet;
	}
	
	public Automobile getAuto(String Model) {
		Automobile auto = null;
		
		if(fleet.containsKey(Model)) {
			auto = fleet.get(Model);
		}
		
		return auto;
	}
	
	public double getModelTotalPrice(String Model) {
		return fleet.get(Model).getTotalPrice();
	}
	
	
	// SEARCH
	// Search and return automobile if found. Otherwise return null
	public Automobile searchAuto(String Model) {		
		return this.getAuto(Model);
	}
	
	
	// UPDATE
	// updated new Automobile based on Model name
	public boolean updateAuto(String Model, Automobile newAuto) {
		boolean updated = false;
		
		if(fleet.containsKey(Model)) {
			fleet.replace(Model, newAuto);
			updated = true;
		}
		
		return updated;
	}
	
	// update oldModelName based on newModelName
	public boolean updateModelName(String oldModelName, String newModelName) {
		boolean updated = false;
		
		if(fleet.containsKey(oldModelName)) {
			fleet.get(oldModelName).setModel(newModelName);
			updated = true;
		}
		
		return updated;
	}
	
	// Update old option name to new option name
	public boolean updateOptionName(String Model, String oldName, String newName) {
		boolean updated = false;
		
		if(fleet.containsKey(Model)) {
			fleet.get(Model).updateOptionName(oldName, newName);
			updated = true;
		}
		
		return updated;
	}
	
	// update new price based on Model name and Name
	public boolean updateOptionPrice(String Model, String Name, double newPrice) {
		boolean updated = false;
		
		if(fleet.containsKey(Model)) {
			fleet.get(Model).updateOptionPrice(Name, newPrice);
			updated = true;
		}
		
		return updated;
	}
	
	
	// REMOVE
	// Remove a particular model based on Model name
	public boolean removeAuto(String Model) {
		boolean removed = false;
		
		if(fleet.containsKey(Model)) {
			fleet.remove(Model);
			removed = true;
		}
		
		return removed;
	}
	
	// Return true if fleet contains that Model
	public boolean containsKey(String Model) {
		boolean contains = false;
		
		if(fleet.containsKey(Model)) {
			contains = true;
		}
		
		return contains;
	}
	
	// Print
	// Print the whole fleet
	public void printFleet() {
		Set<String> set = fleet.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			fleet.get(it.next()).printOptionSet();
		}
	}
	
	// Print a specific auto based on Model name
	public void printAuto(String Model) {
		if(fleet.containsKey(Model)) {
			fleet.get(Model).printOptionSet();
		}
		else {
			System.out.printf("* " + Model + " is empty!\n");
		}
	}
	
	// Print the chosen options in choices based on Model name
	public void printChoices(String Model) {
		if(fleet.containsKey(Model)) {
			fleet.get(Model).printChoices();
		}
		else {
			System.out.printf("* " + Model + " has no chosen option!\n");
		}
	}
}
