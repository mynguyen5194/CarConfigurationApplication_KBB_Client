/*
 * Name: My Nguyen
 * Course: CIS 35B - 63Y
 * Assignment: #3
 * Data submitted: 05/16/2015
 * 
 * This program builds a Ford's Focus Wagon ZTW model with these options:
 * - Color - Fort Knox Gold Clearcoat Metallic, Liquid Grey Clearcoat Metallic,
 *    Infra-Red Clearcoat, Grabber Green Clearcoat Metallic, Sangria Red Clearcoat
 *    Metallic, French Blue Clearcoat Metallic, Twilight Blue Clearcoat Metallic,
 *    CD Silver Clearcoat Metallic, Pitch Black Clearcoat, Cloud 9 White Clearcoat
 *    ($0.0 for all colors)
 * - Transmission - automatic ($0.00) or manual ($-815)
 * - Brakes/Traction Control - Standard ($0), ABS ($400), or ABS with Advance Trac ($1625)
 * - Side Impact Air Bags - present ($350) or not present ($0)
 * - Power Moonroof - present ($595) or not present ($0)
 * 
 * The program reads the file and saves the names and prices in the appropriate position. 
 * It then displays the Automotive object before and after serializing/deserializing
 */

package kbbDriver_Client;

import client.*;

public class KBBDriver_Client {
	public static void main(String[] args) {
		CreateClient newClient = new CreateClient();
		newClient.selectServiceOption();
	}
}

/*
 * OUTPUT:
Enter your option: menu
	*** Menu ***
  upload: upload properties file
  config: config a car
  display: display fleet
  display model: display a specific model
  menu: display menu
Enter your option: upload
Enter the properties file name: auto1.properties
*** Properties file uploaded successfully ***
Enter your option: upload
Enter the properties file name: auto2.properties
*** Properties file uploaded successfully ***
Enter your option: display

*** Available Models ***
********************************
Model: Ford's Focus Wagon ZTW
Maker: Ford
Base Price: 18445.0

Option Name: Color
   Fort Knox Gold Clearcoat Metallic	0.0 
   Liquid Grey Clearcoat Metallic	0.0 
   Infra-Red Clearcoat	0.0 
   Grabber Green Clearcoat Metallic	0.0 
   Sangria Red Clearcoat Metallic	0.0 
   French Blue Clearcoat Metallic	0.0 
   Twilight Blue Clearcoat Metallic	0.0 
   CD Silver Clearcoat Metallic	0.0 
   Pitch Black Clearcoat	0.0 
   Cloud 9 White Clearcoat	0.0 

Option Name: Transmission
   Automatic	0.0 
   Manual	-815.0 

Option Name: Brakes/TractionControl
   Standard	0.0 
   ABS	400.0 
   ABS with Advance Trac	1625.0 

Option Name: Side Impact Air Bags
   Air Bags Present	350.0 
   Air Bags Not Present	0.0 

Option Name: Power Moonroof
   Power Moonroof Present	595.0 
   Power Moonroof Not Present	0.0 

********************************
********************************
Model: Honda Accord
Maker: Honda
Base Price: 15000.0

Option Name: Color
   Fort Knox Gold Clearcoat Metallic	0.0 
   Liquid Grey Clearcoat Metallic	0.0 
   Infra-Red Clearcoat	0.0 
   Grabber Green Clearcoat Metallic	0.0 
   Sangria Red Clearcoat Metallic	0.0 
   French Blue Clearcoat Metallic	0.0 
   Twilight Blue Clearcoat Metallic	0.0 
   CD Silver Clearcoat Metallic	0.0 

Option Name: Transmission
   Automatic	0.0 
   Manual	-815.0 

Option Name: Brakes/TractionControl
   Standard	0.0 
   ABS	400.0 
   ABS with Advance Trac	1600.0 

Option Name: Side Impact Air Bags
   Air Bags Present	300.0 
   Air Bags Not Present	0.0 

Option Name: Power Moonroof
   Power Moonroof Present	300.0 
   Power Moonroof Not Present	0.0 

********************************
Enter your option: config
	*** Automobile Configuration ***
Enter the model name: Honda Accord
Enter the option set name: Transmission
Enter the option name: Manual
	***Chosen Option***
Model: Honda Accord
   Base Price	15000.0
   Manual	-815.0
* Total Price: 14185.0
Enter your option: config
	*** Automobile Configuration ***
Enter the model name: Ford's Focus Wagon ZTW
Enter the option set name: Power Moonroof
Enter the option name: Power Moonroof Present
	***Chosen Option***
Model: Ford's Focus Wagon ZTW
   Base Price	18445.0
   Power Moonroof Present	595.0
* Total Price: 19040.0
Enter your option: config
	*** Automobile Configuration ***
Enter the model name: Honda Accord
Enter the option set name: Brakes/TractionControl
Enter the option name: ABS
	***Chosen Option***
Model: Honda Accord
   Base Price	15000.0
   Manual	-815.0
   ABS	400.0
* Total Price: 14585.0
Enter your option: display model
Enter the model name: Honda Accord
********************************
Model: Honda Accord
Maker: Honda
Base Price: 15000.0

Option Name: Color
   Fort Knox Gold Clearcoat Metallic	0.0 
   Liquid Grey Clearcoat Metallic	0.0 
   Infra-Red Clearcoat	0.0 
   Grabber Green Clearcoat Metallic	0.0 
   Sangria Red Clearcoat Metallic	0.0 
   French Blue Clearcoat Metallic	0.0 
   Twilight Blue Clearcoat Metallic	0.0 
   CD Silver Clearcoat Metallic	0.0 

Option Name: Transmission
   Automatic	0.0 
   Manual	-815.0 

Option Name: Brakes/TractionControl
   Standard	0.0 
   ABS	400.0 
   ABS with Advance Trac	1600.0 

Option Name: Side Impact Air Bags
   Air Bags Present	300.0 
   Air Bags Not Present	0.0 

Option Name: Power Moonroof
   Power Moonroof Present	300.0 
   Power Moonroof Not Present	0.0 

********************************
Enter your option: quit
 */