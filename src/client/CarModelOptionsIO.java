package client;

import java.util.Properties;
import java.io.*;

public class CarModelOptionsIO {
	public Properties readData(String fileName) {
		Properties pro = new Properties();
		
		try {
			FileInputStream in = new FileInputStream(fileName);
			pro.load(in);
			in.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pro;
	}
}
