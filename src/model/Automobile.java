/*
 * Automotive class contains OptionSet array, model, and
 * basePrice. It also has many functions to access OptionSet and
 * Option classes
 */

package model;

import java.util.*;
import java.io.Serializable;

public class Automobile implements Serializable{
	private static final long serialVersionUID = 1420672609912364060L;
	// INSTANCE VARIABLES
	private ArrayList<OptionSet> optionSet;
	// choices contains chosen Option
	private LinkedHashMap<String, OptionSet.Option> choices;	// String = optionName
																// to hold chosen Option
	private String model;
	private String maker;
	private double basePrice;
	
	
	// CONSTRUCTORS
	public Automobile() {}
	
	public Automobile(String Model, String Maker, double BasePrice, int size) {
		optionSet = new ArrayList<OptionSet>();
		for(int i = 0; i < size; i++) {
			optionSet.add(i, new OptionSet());
		}
		
		choices = new LinkedHashMap<String, OptionSet.Option>();
		model = Model;
		maker = Maker;
		basePrice = BasePrice;
	}
	
	public Automobile(ArrayList<OptionSet> OptionSet, 
			String Model, String Maker, double BasePrice, int size) {
		optionSet = OptionSet;
		for(int i = 0; i < size; i++) {
			optionSet.add(i, new OptionSet());
		}
		
		choices = new LinkedHashMap<String, OptionSet.Option>();
		model = Model;
		maker = Maker;
		basePrice = BasePrice;
	}
	
	public Automobile(LinkedHashMap<String, OptionSet.Option> Choices,
			String Model, String Maker, double BasePrice, int size) {
		optionSet = new ArrayList<OptionSet>();
		for(int i = 0; i < size; i++) {
			optionSet.add(i, new OptionSet());
		}
		
		choices = Choices;
		model = Model;
		maker = Maker;
		basePrice = BasePrice;
	}

	
	// SETTERS
	// (For OptionSet)
	public void setOptionSet(ArrayList<OptionSet> optionSet) {
		this.optionSet = optionSet;
	}
	
	public void setChoices(LinkedHashMap<String, OptionSet.Option> choices) {
		this.choices = choices;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	// (For Option)
	// Set values of Option
	public void setOption(int optSetIndex, int optSize, String optName) {
		optionSet.set(optSetIndex, new OptionSet(optSize, optName));
	}
	
	public void setOption(int optSetIndex, int optIndex, String Name, double Price) {
		optionSet.get(optSetIndex).setOption(optIndex, Name, Price);
	}

	// Set the chosen Option based on Name into choices
	public void setOptionChoice(String optName, String Name) {
		for(int i = 0; i < optionSet.size(); i++) {
			if(this.findOptionSetIndex(optName) != -1) {
				choices.put(optName, this.getOption(Name));
			}
			else {
				System.out.printf("Unable to set new option choice\n");
			}
		}
	}	
	
	// Set OptionName
	public void setOptionName(int optSetIndex, String optName) {
		if(optionSet.get(optSetIndex) != null) {
			optionSet.get(optSetIndex).setOptionName(optName);
		}
		else {
			System.out.printf("Unable to set new option choice\n");
		}
	}
	
	
	
	
	// GETTERS
	public ArrayList<OptionSet> getOptionSet() {
		return optionSet;
	}
	
	public LinkedHashMap<String, OptionSet.Option> getChoices() {
		return choices;
	}
	
	public String getMaker() {
		return maker;
	}
	
	public String getModel() {
		return model;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	// Get Option Choice based on optName
	public OptionSet.Option getOptionChoice(String optName) {
		OptionSet.Option opt = null;
				
		if(choices.containsKey(optName)) {
			opt = choices.get(optName);
		}
				
		return opt;
	}
	
	// Get Option Choice Name based on optName
	public String getOptionChoiceName(String optName) {
		String name = "";
		
		if(choices.containsKey(optName)) {
			name = choices.get(optName).getName();
		}
		
		return name;
	}
	
	// Get Option Choice Price based on optName
	public double getOptionChoicePrice(String Name) {
		double price = -1;
		
		Set<String> set = choices.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			// Get the name of each element in the choices and compare with the given Name
			if(choices.get(it.next()).getName().equals(Name)) {
				price = choices.get(it.next()).getPrice();
			}
		}
		
		return price;
	}
	
	// Get total price of chosen Option
	public double getTotalPrice() {
		double total = 0.0;
		
		total += this.basePrice;
		
		Set<String> set = choices.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			// Traverse each element and add up the total price
			
			total += choices.get(it.next()).getPrice();
		}
		
		return total;
	}
	
	// Get an OptionSet based on index
	public OptionSet getOptionSet(int index) {
		return optionSet.get(index);
	}
	
	// Get an OptionSet based on Model
	public OptionSet getModel(String Model) {
		return optionSet.get(this.findOptionSetIndex(Model));
	}
	
	// Get the array length of optionSet
	public int getSize() {
		return optionSet.size();
	}
	
	// Get an Option based on Name
	public OptionSet.Option getOption(String Name) {
		OptionSet.Option opt = null;
		
		for(int i = 0 ; i < optionSet.size(); i++) {
			int optSetIndex = optionSet.get(i).searchOptionIndex(Name);
			
			if(optSetIndex != -1) {
				int optIndex = optionSet.get(i).searchOptionIndex(Name);
				opt = optionSet.get(i).getOption(optIndex);
			}
		}
		
		return opt;
	}
	
	// Get an Option based on Name and OptSetIndex
	public OptionSet.Option getOption_Index(int optSetIndex, String Name) {
		OptionSet.Option opt = null;
				
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			opt = optionSet.get(optSetIndex).getOption(optionSet.get(optSetIndex).searchOptionIndex(Name));
		}
				
		return opt;
	}
	
	// Get Option name based on optSetIndex and optIndex
	public String getOptionName(int optSetIndex, int optIndex) {
		return optionSet.get(optSetIndex).getOption(optIndex).getName();
	}
	
	// Get Option name based on optSetIndex
	public String getOptionName(int optSetIndex) {
		return optionSet.get(optSetIndex).getOptionName();
	}
	
	// Get Option price based on optSetIndex and optIndex	
	public double getOptionPrice(int optSetIndex, int optIndex) {
		return optionSet.get(optSetIndex).getOption(optIndex).getPrice();
	}
	
	// Get an Option price based on Name
	public double getOptionPrice(String Name) {
		return this.getOption(Name).getPrice();
	}
	
	// Get the array length of Option based on optSetIndex
	public int getOptionSize(int optSetIndex) {
		return optionSet.get(optSetIndex).getOption().size();
	}
	
	
	// FIND
	// Find optionSet index based on name
	public int findOptionSetIndex(String optName) {
		int index = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
			if(optionSet.get(i).getOptionName().equals(optName)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find optionSet object based on Model name
	public OptionSet findOptionSet(String Model) {
		OptionSet optSet = null;
		int index = this.findOptionSetIndex(Model);
		
		if(index != -1) {
			optSet = optionSet.get(index);
		}
		
		return optSet;
	}
	
	// Find Option index based on name
	public int findOptionIndex(String Name) {
		int index = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
			index = optionSet.get(i).searchOptionIndex(Name);
		}
		
		return index;
	}
	
	// Find and return optSetIndex and optIndex based on Name
	public int [] findIndex(String Name) {
		int index[] = new int[2];
		index[0] = -1;
		index[1] = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
			int optIndex = optionSet.get(i).searchOptionIndex(Name); 
			
			if(optIndex != -1) {
				index[0] = i;
				index[1] = optIndex;
			}
		}
		
		return index;
	}
	
	// Find Option based on name
	public OptionSet.Option findOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0; i < optionSet.size(); i++) {
			option = optionSet.get(i).searchOption(Name);
		}
		
		return option;
	}
	
	// Return true if Option is found
	public boolean foundOption(String Name) {
		boolean found = false;
		
		for(int i = 0; i < optionSet.size(); i++) {
			found = optionSet.get(i).foundOption(Name);
		}
		
		return found;
	}
	
	public boolean containsOptionName(String optName) {
		return optionSet.contains(optName);
	}
	
	// UPDATE
	// Update new optionSet
	public boolean updateOptionSet(int index, OptionSet optSet) {
		boolean updated = false;
			
		if(index >= 0 && index < optionSet.size()) {
			optionSet.get(index).equals(optSet);
			updated = true;
		}
			
		return updated;
	}
	
	// Update new Option name based on the old one 
	public boolean updateOptionName(String oldName, String newName) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.size(); i++) {
			int optSetIndex = optionSet.get(i).searchOptionIndex(oldName);
				
			if(optSetIndex != -1) {
				updated = optionSet.get(i).updateOptionName(oldName, newName);
			}
		}
			
		return updated;
	}
	
	// Update new Option price based on name
	public boolean updateOptionPrice(String Name, double newPrice) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.size(); i++) {
			int optIndex = optionSet.get(i).searchOptionIndex(Name);
				
			if(optIndex != -1) {
				updated = optionSet.get(i).updateOptionPrice(Name, newPrice);
			}
		}
			
		return updated;
	}
	
	// Update new name and new price of Option based on optionName and old name
	public boolean updateOption(String optName, String oldName, String newName, double newPrice) {
		boolean updated = false;
		int optSetIndex = this.findOptionIndex(optName);
		
		if(optSetIndex != -1) {
			updated = optionSet.get(optSetIndex).updateOption(oldName, newName, newPrice);
		}
	
		return updated;
	}
	
	// Update new name and new price of optionSet based on old name
	public boolean updateOption(String oldName, String newName, double newPrice) {
		boolean updated = false;
		
		for(int i = 0; i < optionSet.size(); i++) {
			int optIndex = optionSet.get(i).searchOptionIndex(oldName);
			
			if(optIndex != -1) {
				updated = optionSet.get(i).updateOption(optIndex, newName, newPrice);
			}
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete an optionSet based on optionSet index
	public boolean deleteOption(int optSetIndex) {
		boolean deleted = false;
		
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			optionSet.set(optSetIndex, null);
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete an option based on Option name
	public boolean deleteOption(String optName) {
		boolean deleted = false;
		int optSetIndex = this.findOptionSetIndex(optName);
		if(optSetIndex != -1) {
			deleted = this.deleteOption(optSetIndex);
		}
		
		return deleted;
	}
	
	// Delete choices in the Choices LinkedHashMapbased based on optName
	public boolean deleteOptionChoice_optName(String optName) {
		boolean deleted = false;
		
		if(choices.containsKey(optName)) {
			choices.remove(optName);
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete choices in the Choices LinkedHashMapbased based on Name
	public boolean deleteOptionChoice_Name(String Name) {
		boolean deleted = false;
		
		Set<String> set = choices.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			if(choices.get(it.next()).getName().equals(Name)) {
				deleted = choices.remove(choices.get(it.next()), Name);
			}
		}
		
		return deleted;
	}
	
	
	// PRINT
	// Print the whole optionSet[]
	public void printOptionSet() {
		System.out.printf("********************************\n"
				+ "Model: " + this.model 
				+ "\nMaker: " + this.maker
				+ "\nBase Price: " + this.basePrice + "\n\n");
		for(int i = 0; i < optionSet.size(); i++) {
			optionSet.get(i).printOption();
			System.out.printf("\n");
		}
		System.out.printf("********************************\n");
	}
	
	// Print the option[] based on optSetIndex
	public void printOption(int optSetIndex) {
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			optionSet.get(optSetIndex).printOption();
		}
	}
	
	// Print the option[] based on optName
	public void printOption(String optName) {
		int optSetIndex = this.findOptionSetIndex(optName);
		
		if(optSetIndex != -1) {
			this.printOption(optSetIndex);
		}
	}
	
	// Print name and price based on optSetIndex and optIndex
	public void printNameAndPrice(int optSetIndex, int optIndex) {
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			optionSet.get(optSetIndex).printOption(optIndex);
		}
	}
	
	// Print name and price based on Name
	public void printNameAndPrice(String Name) {
		int index[] = this.findIndex(Name);
		
		if(index[0] != -1 && index[1] != -1) {
			this.printNameAndPrice(index[0], index[1]);
		}
	}
	
	// Print choices
	public void printChoices() {
		Set<String> set = choices.keySet();
		Iterator<String> it = set.iterator();
		
		System.out.printf("\t***Chosen Option***\n"
				+ "Model: " + this.model + "\n"
				+ "   Base Price\t" + this.getBasePrice() + "\n");
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.printf("   " + choices.get(key).getName() + "\t"
					+ choices.get(key).getPrice() + "\n");
		}
	}
}
