/*
 * AutoUtil class has three functions, including:
 * 	- readFile: reads the file and returns the Automotive object
 * 	- serializeAuto: serializes the Automotive object
 *  - deserializeAuto: reads the serialized file and return the
 *    Automotive object 
 */

package util;

import java.io.*;
import java.util.*;

import model.*;
import exceptionHandler.*;

public class AutoUtil {
	public Fleet readFile(Fleet fleet, String fileName) {		
		Automobile auto = new Automobile();
		String model = "";
		
		boolean problemFixed = false;	
		ProblemGenerator newProblem = new ProblemGenerator("noneExitFileName.txt");
		newProblem.setFileName(fileName);
	
		do {
			try {
				problemFixed = newProblem.openFile();
				FileReader file = new FileReader(fileName);
				BufferedReader reader = new BufferedReader(file);
				boolean eof = false;
			
				while(!eof) {
					// Get model, basePrice, and autoSize and instantiate new Automotive
					model = reader.readLine();
					
					if(model == null) {
						eof = true;
					}
					
					else {
						String maker = reader.readLine();
						double basePrice = Double.parseDouble(reader.readLine());
						int optSetSize = Integer.parseInt(reader.readLine());
						
						auto = new Automobile(model, maker, basePrice, optSetSize);
						
						for(int optSetIndex = 0; optSetIndex < optSetSize; optSetIndex++) {
							// Get optSetName and optSetSize and instantiate new Option
							String optName = reader.readLine();
							int optSize = Integer.parseInt(reader.readLine());
						
							auto.setOption(optSetIndex, optSize, optName);
						
							for(int optIndex = 0; optIndex < optSize; optIndex++) {
								StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
								StringBuffer Name = new StringBuffer("");
							
								// Get the name and price and set them at the appropriate position
								Name.append(tokenizer.nextToken(","));
								double Price = Double.parseDouble(tokenizer.nextToken());
							
								auto.setOption(optSetIndex, optIndex, Name.toString(), Price);
							}	
						}
						fleet.setFleet(model, auto);
					}	
				}
				file.close();
				reader.close();
	
			}
			catch(ExceptionHandler expt) {
				newProblem.setFileName(expt.fixProblemReadFromConsole());
			}
			catch (IOException err) {
			
			}
		}
		while(problemFixed == false);

		return fleet;
	}
	
	public void serializeAuto(Automobile auto) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Auto.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(auto);
			
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Automobile deseriallizeAuto(String fileName) {
		Automobile newAuto = new Automobile();
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			newAuto = (Automobile) in.readObject();
			
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return newAuto;
	}
}
