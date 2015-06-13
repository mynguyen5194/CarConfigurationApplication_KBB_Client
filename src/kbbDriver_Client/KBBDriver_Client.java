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
		System.out.println("done");
		newClient.selectServiceOption();
	}
}