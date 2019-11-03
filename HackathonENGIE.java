/**
 * @author Caleb Bucci
 * @version 20191102
 *
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class HackathonENGIE {
	
	public static String[] configInfo = {"Building ID","Meter ID","Description","Units","Resource","Building Name","Gross Square Feet","Build Date","Latitude","Longitude","Campus","Organization","Location Type","Steam Source ID","Chilled Water Source ID","Hot Water Source ID","Activation Date"};
	/** Reads the file given, and finds the length of it, then it
	 * assigns the entire line to an element of an array and continues 
	 * this until there are no more lines in the array
	 * 
	 * @param File that is being read
	 * 
	 * @return String array of each line of the files read
	 */
	public static String[] fileReader(String userFile) {
			
		String[] elementName = null;
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(userFile));
			int counter = 0;
			//Finds length of data
			while(buffReader.readLine() != null) {
				counter++;
			}
			elementName = new String[counter];
			buffReader.close();
			buffReader = new BufferedReader(new FileReader(userFile));
			//Assigns data to array
			for (int i = 0; i < counter; i++) {
				elementName[i] = buffReader.readLine();
			}
			buffReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("Error - Cannot Find File Specified.");
		}
		catch (IOException e) {
			System.out.print("IO Exception.");
		}
		
		return elementName;			
	}
	
	//Prints out lines of string array for debugging purposes
	public static void debug(String[] elem) {
		for(int i = 0; i < elem.length; i++) {
			System.out.println(elem[i]);
		}
		System.out.println(elem.length);
		
	}
	
	public static String searchResult(String userSearch, String[]config, String[] daily, String[] hourly) {
		String searchResults = "Sorry, we couldn't find that building.";
		String[] meterID = new String[config.length];
		String[] buildingName = new String[config.length];
		//Creates array of the meterIDs and building names, which are related through their index
		//The replaceAll methods use regexes to delete everything before and after 
		for (int i = 0; i < config.length; i++) {
			String workingString = config[i].replaceAll("^\"\\d+\",\"", "");
			meterID[i] = workingString.replaceAll("\",\".+\"", "").toUpperCase();
			workingString = config[i].replaceAll("\"[0-9]+\",\"[A-Z 0-9_.]+\",\"[A-Za-z .\\- / # 0-9]+\",\"[A-Za-z/ ]+\",\"[A-Za-z ]+\",\"","");
			buildingName[i] = workingString.replaceAll("\",\".+$", "").toUpperCase();
		}
		for (int i = 0; i < buildingName.length; i++) {
			if (buildingName[i].contains(userSearch.toUpperCase())) {
				searchResults = "Found it!";
				System.out.println("\nBuilding Information:");
				String[] buildingInfo = config[i].split("\",\"");
				for (int j = 0; j < buildingInfo.length; j++) {
					if (j != 5) {
						System.out.println(configInfo[j] + ": " + buildingInfo[j].replaceAll("\"",""));
						
					}
					
				}
			}
		}
		return searchResults;
	}
		
		
		
		
	
	public static void main(String[] args) {
	//	System.out.println("Running...");
		double startTime = System.nanoTime();
		String[] config = fileReader("HackOhioConfig");
	//	debug(config);
		String[] dataDaily = fileReader("HackathonDataDaily.csv");
	//	debug(dataDaily);
		String[] dataHourly = fileReader("HackathonDataHourlyAll.txt");
	//	debug(dataHourly);
		double endTime = System.nanoTime();
		System.out.println((endTime - startTime) / Math.pow(10,9) + " sec");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a building name: ");
		String userInput = keyboard.nextLine();
		
		System.out.print(searchResult(userInput, config, dataDaily, dataHourly));
		
		
	keyboard.close();
	
	
	}

}