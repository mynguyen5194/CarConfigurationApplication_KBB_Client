package util;

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
			
			for(int i = 1; i <= colorOptionSize; i++) {
				String colorOptionI = "ColorOption" + i;
				String colorOptionPriceI = "ColorOptionPrice" + i;
				
				auto.setOption(0, i-1, pro.getProperty(colorOptionI), Double.parseDouble(pro.getProperty(colorOptionPriceI)));
			}
	
			
			String transmission = pro.getProperty("TransmissionOptionName");
			int transmissionOptionSize = Integer.parseInt(pro.getProperty("TransmissionOptionSize"));
			auto.setOption(1, transmissionOptionSize, transmission);
				
			for(int i = 1; i <= transmissionOptionSize; i++) {
				String transmissionOptionI = "TransmissionOption" + i;
				String transmissionOptionPriceI = "TransmissionOptionPrice" + i;
				
				auto.setOption(1, i-1, pro.getProperty(transmissionOptionI), Double.parseDouble(pro.getProperty(transmissionOptionPriceI)));
			}
				
			
			String break_tractionControl = pro.getProperty("Brakes_TractionControlOptionName");
			int brakes_TractionControlOptionSize = Integer.parseInt(pro.getProperty("Brakes_TractionControlOptionSize"));
			auto.setOption(2, brakes_TractionControlOptionSize, break_tractionControl);

			for(int i = 1; i <= brakes_TractionControlOptionSize; i++) {
				String brakes_TractionControlOptionI = "Brakes_TractionControlOption" + i;
				String brakes_TractionControlPriceI = "Brakes_TractionControlOptionPrice" + i;
				
				auto.setOption(2, i-1, pro.getProperty(brakes_TractionControlOptionI), Double.parseDouble(pro.getProperty(brakes_TractionControlPriceI)));
			}
				
			
			String sideAirBags = pro.getProperty("SideImpactAirBagsOptionName");
			int sideImpactAirBagsOptionSize = Integer.parseInt(pro.getProperty("SideImpactAirBagsOptionSize"));
			auto.setOption(3, sideImpactAirBagsOptionSize, sideAirBags);
			
			for(int i = 1; i <= sideImpactAirBagsOptionSize; i++) {
				String sideImpactAirBagsOptionI = "SideImpactAirBagsOption" + i;
				String sideImpactAirBagsOptionPriceI = "SideImpactAirBagsOptionPrice" + i;
				
				auto.setOption(3, i-1, pro.getProperty(sideImpactAirBagsOptionI), Double.parseDouble(pro.getProperty(sideImpactAirBagsOptionPriceI)));
			}
				
			
			String powerMoonroof = pro.getProperty("PowerMoonroofOptionName");
			int powerMoonroofOptionSize = Integer.parseInt(pro.getProperty("PowerMoonroofOptionSize"));
			auto.setOption(4, powerMoonroofOptionSize, powerMoonroof);
			
			for(int i = 1; i <= powerMoonroofOptionSize; i++) {
				String powerMoonroofOptionI = "PowerMoonroofOption" + i;
				String powerMoonroofOptionPriceI = "PowerMoonroofOptionPrice" + i;
				
				auto.setOption(4, i-1, pro.getProperty(powerMoonroofOptionI), Double.parseDouble(pro.getProperty(powerMoonroofOptionPriceI)));
			}
		}

		return auto;
	}
}
