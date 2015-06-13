package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import model.*;

public class FileIO {
	public Automobile parsePropertiesFile(Properties pro) {
		Automobile auto = new Automobile();

		String maker = pro.getProperty("Maker");

		if (!maker.equals(null)) {
			String model = pro.getProperty("Model");
			double basePrice = Double.parseDouble(pro.getProperty("BasePrice"));
			int optSetSize = Integer.parseInt(pro.getProperty("OptionSetSize"));

			auto = new Automobile(model, maker, basePrice, optSetSize);

			String color = pro.getProperty("ColorOptionName");
			int colorOptionSize = Integer.parseInt(pro.getProperty("ColorOptionSize"));
			auto.setOption(0, colorOptionSize, color);
				
			String colorOption1 = pro.getProperty("ColorOption1");
			double colorPrice1 = Double.parseDouble(pro.getProperty("ColorOptionPrice1"));
			String colorOption2 = pro.getProperty("ColorOption2");
			double colorPrice2 = Double.parseDouble(pro.getProperty("ColorOptionPrice2"));
			String colorOption3 = pro.getProperty("ColorOption3");
			double colorPrice3 = Double.parseDouble(pro.getProperty("ColorOptionPrice3"));
			String colorOption4 = pro.getProperty("ColorOption4");
			double colorPrice4 = Double.parseDouble(pro.getProperty("ColorOptionPrice4"));
			String colorOption5 = pro.getProperty("ColorOption5");
			double colorPrice5 = Double.parseDouble(pro.getProperty("ColorOptionPrice5"));
			String colorOption6 = pro.getProperty("ColorOption6");
			double colorPrice6 = Double.parseDouble(pro.getProperty("ColorOptionPrice6"));
			String colorOption7 = pro.getProperty("ColorOption7");
			double colorPrice7 = Double.parseDouble(pro.getProperty("ColorOptionPrice7"));
			String colorOption8 = pro.getProperty("ColorOption8");
			double colorPrice8 = Double.parseDouble(pro.getProperty("ColorOptionPrice8"));
			String colorOption9 = pro.getProperty("ColorOption9");
			double colorPrice9 = Double.parseDouble(pro.getProperty("ColorOptionPrice9"));
			String colorOption10 = pro.getProperty("ColorOption10");
			double colorPrice10 = Double.parseDouble(pro.getProperty("ColorOptionPrice10"));
					
			String transmission = pro.getProperty("TransmissionOptionName");
			int transmissionOptionSize = Integer.parseInt(pro.getProperty("TransmissionOptionSize"));
			auto.setOption(1, transmissionOptionSize, transmission);
				
			String transmissionOption1 = pro.getProperty("TransmissionOption1");
			double transmissionPrice1 = Double.parseDouble(pro.getProperty("TransmissionOptionPrice1"));
			String transmissionOption2 = pro.getProperty("TransmissionOption2");
			double transmissionPrice2 = Double.parseDouble(pro.getProperty("TransmissionOptionPrice2"));
				
			String break_tractionControl = pro.getProperty("Brakes_TractionControlOptionName");
			int brakes_TractionControlOptionSize = Integer.parseInt(pro.getProperty("Brakes_TractionControlOptionSize"));
			auto.setOption(2, brakes_TractionControlOptionSize, break_tractionControl);

			String brakes_TractionControlOption1 = pro.getProperty("Brakes_TractionControlOption1");
			double brakes_TractionControlPrice1 = Double.parseDouble(pro.getProperty("Brakes_TractionControlOptionPrice1"));
			String brakes_TractionControlOption2 = pro.getProperty("Brakes_TractionControlOption2");
			double brakes_TractionControlPrice2 = Double.parseDouble(pro.getProperty("Brakes_TractionControlOptionPrice2"));
			String brakes_TractionControlOption3 = pro.getProperty("Brakes_TractionControlOption3");
			double brakes_TractionControlPrice3 = Double.parseDouble(pro.getProperty("Brakes_TractionControlOptionPrice3"));
				
			String sideAirBags = pro.getProperty("SideImpactAirBagsOptionName");
			int sideImpactAirBagsOptionSize = Integer.parseInt(pro.getProperty("SideImpactAirBagsOptionSize"));
			auto.setOption(3, sideImpactAirBagsOptionSize, sideAirBags);
			
			String sideImpactAirBagsOption1 = pro.getProperty("SideImpactAirBagsOption1");
			double sideImpactAirBagsPrice1 = Double.parseDouble(pro.getProperty("SideImpactAirBagsOptionPrice1"));
			String sideImpactAirBagsOption2 = pro.getProperty("SideImpactAirBagsOption2");
			double sideImpactAirBagsPrice2 = Double.parseDouble(pro.getProperty("SideImpactAirBagsOptionPrice2"));
				
			String powerMoonroof = pro.getProperty("PowerMoonroofOptionName");
			int powerMoonroofOptionSize = Integer.parseInt(pro.getProperty("PowerMoonroofOptionSize"));
			auto.setOption(4, powerMoonroofOptionSize, powerMoonroof);
				
			String powerMoonroofOption1 = pro.getProperty("PowerMoonroofOption1");
			double powerMoonroofPrice1 = Double.parseDouble(pro.getProperty("PowerMoonroofOptionPrice1"));
			String powerMoonroofOption2 = pro.getProperty("PowerMoonroofOption2");
			double powerMoonroofPrice2 = Double.parseDouble(pro.getProperty("PowerMoonroofOptionPrice2"));
				
			auto.setOption(0, 0, colorOption1, colorPrice1);
			auto.setOption(0, 1, colorOption2, colorPrice2);
			auto.setOption(0, 2, colorOption3, colorPrice3);
			auto.setOption(0, 3, colorOption4, colorPrice4);
			auto.setOption(0, 4, colorOption5, colorPrice5);
			auto.setOption(0, 5, colorOption6, colorPrice6);
			auto.setOption(0, 6, colorOption7, colorPrice7);
			auto.setOption(0, 7, colorOption8, colorPrice8);
			auto.setOption(0, 8, colorOption9, colorPrice9);
			auto.setOption(0, 9, colorOption10, colorPrice10);
			auto.setOption(1, 0, transmissionOption1, transmissionPrice1);
			auto.setOption(1, 1, transmissionOption2, transmissionPrice2);
			auto.setOption(2, 0, brakes_TractionControlOption1, brakes_TractionControlPrice1);
			auto.setOption(2, 1, brakes_TractionControlOption2, brakes_TractionControlPrice2);
			auto.setOption(2, 2, brakes_TractionControlOption3, brakes_TractionControlPrice3);
			auto.setOption(3, 0, sideImpactAirBagsOption1, sideImpactAirBagsPrice1);
			auto.setOption(3, 1, sideImpactAirBagsOption2, sideImpactAirBagsPrice2);
			auto.setOption(4, 0, powerMoonroofOption1, powerMoonroofPrice1);
			auto.setOption(4, 1, powerMoonroofOption2, powerMoonroofPrice2);
		}

		return auto;
	}
}
