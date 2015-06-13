/*
 * Option is the inner class, which contains name and price, of
 * the OptionSet class. The OptionSet class has the Option array
 * and optionName.
 */

package model;

import java.util.*;
import java.io.Serializable;

public class OptionSet implements Serializable {
	protected class Option implements Serializable {
		private static final long serialVersionUID = 1420672609912364060L;
		private String name;
		private double price;
		
		public Option() {}
		public Option(String Name, double Price) {
			name = Name;
			price = Price;
		}
		
		protected String getName() {
			return name;
		}
		
		protected double getPrice() {
			return price;
		}
		
		protected void setName(String name) {
			this.name = name;
		}
		
		protected void setPrice(double price) {
			this.price = price;
		}
		
		protected void print() {
			StringBuffer str = new StringBuffer();
			
			str.append(name + "\t");
			str.append(price);
			
			System.out.printf("   " + str + " ");
		}
	}
	
	// INSTANCE VARIABLES
	private static final long serialVersionUID = 1420672609912364060L;
	private ArrayList<Option> option;
	private String optionName;
	
	
	// CONSTRUCTORS
	public OptionSet() {}
	
	public OptionSet(int size) {
		option = new ArrayList<> (size);
		for(int i = 0; i < size; i++) {
			option.set(i, new Option());
		}
	}

	public OptionSet(int size, String optName) {
		option = new ArrayList<> ();
		for(int i = 0; i < size; i++) {
			option.add(i, new Option());	
		}
		
		optionName = optName;
	}
	

	// SETTERS
	protected void setOption(ArrayList<Option> option) {
		this.option = option;
	}
	
	protected void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	// Set the Name and Price at a specific optIndex in Option ArrayList
	protected void setOption(int optIndex, String Name, double Price) {
		option.get(optIndex).setName(Name);
		option.get(optIndex).setPrice(Price);
	}
	
	protected void setOption(int optIndex, Option newOption) {
		option.set(optIndex, newOption);
	}
	
	protected void setOption(String Name, double Price) {
		this.setOption(this.searchOptionIndex(Name), Name, Price);
	}
	
	// Set a newOption to the option ArrayList based on optName
	protected void setOptionChoice(String optName, Option newOption) {
		if(optName.equals(optionName)) {
			option.add(newOption);
		}
	}
	
	
	// GETTERS
	protected ArrayList<Option> getOption() {
		return option;
	}

	protected String getOptionName() {
		return optionName;
	}
	
	// Get an Option based on optIndex
	protected Option getOption(int optIndex) {
		return option.get(optIndex);
	}
	
	// Get an Option based on Name.
	protected Option getOptionChoice(String Name) {
		Option opt = null;
		
		if(option.get(this.searchOptionIndex(Name)) != null) {
			opt = option.get(this.searchOptionIndex(Name));
		}
		
		return opt;
	}

	
	// SEARCH
	// Search the Option index based on Name
	protected int searchOptionIndex(String Name) {
		int index = -1;
		
		for(int i = 0; i < option.size(); i++) {
			if(option.get(i).getName().equals(Name)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Search the Option index based on name and price
	protected int searchOptionIndex(String Name, double Price) {
		int index = -1;
		
		for(int i = 0; i < option.size(); i++) {
			if(option.get(i).getName().equals(Name)
					&& option.get(i).getPrice() == Price) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Search the Option index based on Option
	protected int searchOptionIndex(Option Option) {
		return this.searchOptionIndex(Option.getName());
	}
	
	// Search and return the Option based on Name
	protected Option searchOption(String Name) {
		Option foundOption = new Option("", -1);
		int index = this.searchOptionIndex(Name); 
		
		if(index != -1) {
			foundOption = option.get(index);
		}
		
		return foundOption;
	}
	
	// Search and return true if Option found.
	protected boolean foundOption(String Name) {
		boolean found = false;
		int index = this.searchOptionIndex(Name);
		
		if(index != -1) {
			found = true;
		}
		
		return found;
	}
	
	// Search and return the Option based on exact name and price
	protected Option findOption(String Name, double Price) {
		Option foundOption = new Option("", -1);
		int index = this.searchOptionIndex(Name);
		
		if(index != -1 && option.get(index).getPrice() == Price) {
			foundOption = option.get(index);
		}
		
		return foundOption;
	}
	
	
	// UPDATE
	// Update new name and new price based on the index
	protected boolean updateOption(int index, String newName, double newPrice) {
		boolean updated = false;
		
		if(index >= 0 && index < option.size()) {
			this.setOption(index, newName, newPrice);
			updated = true;
		}
		
		return updated;
	}
	
	// Update new name and new price based on the old name
	protected boolean updateOption(String oldName, String newName, double newPrice) {
		boolean updated = false;
		int index = this.searchOptionIndex(oldName);
		
		if(index != -1) {
			updated = this.updateOption(index, newName, newPrice);
		}
		
		return updated;
	}
	
	// Update new price and new price from newOption based on oldName
	protected boolean updateOption(String oldName, Option newOption) {
		return this.updateOption(oldName, newOption.getName(), newOption.getPrice());
	}
	
	// Update new price based on name
	protected boolean updateOptionPrice(String Name, double newPrice) {
		boolean updated = false;
		int index = this.searchOptionIndex(Name);
		
		if(index != -1) {
			updated = this.updateOption(index, Name, newPrice);
		}
		
		return updated;
	}
	
	// Update new name based on old name
	protected boolean updateOptionName(String oldName, String newName) {
		boolean updated = false;
		int index = this.searchOptionIndex(oldName);
		
		if(index != -1) {
			updated = this.updateOption(index, newName, option.get(index).getPrice());
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete option based on index
	protected boolean deleteOption(int index) {
		boolean deleted = false;
		
		if(index >= 0 && index < option.size()) {
			option.remove(index);
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete Option based on name
	protected boolean deleteOption(String Name) {
		return this.deleteOption(this.searchOptionIndex(Name));
	}
	
	
	// PRINT
	// Print the whole option array
	protected void printOption() {
		System.out.printf("Option Name: " + this.optionName + "\n");
		for(int i = 0; i < option.size(); i++) {
			option.get(i).print();
			System.out.printf("\n");
		}
	}
	
	// Print name and price based on optIndex
	protected void printOption(int optIndex) {
		if(optIndex >= 0 && optIndex < option.size()) {
			option.get(optIndex).print();
		}
	}
	
	// Print name and price based on Name
	protected void printOption(String Name) {
		int optIndex = this.searchOptionIndex(Name);
		
		if(optIndex != -1) {
			option.get(optIndex).print();
		}
	}
}
