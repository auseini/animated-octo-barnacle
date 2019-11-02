import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class Scrape {
	public static void main(String args[]) throws FileNotFoundException{
		print("running...");
		long begin = System.nanoTime();
		File myFile = new File("/Users/arianuseini/Downloads/HackathonDataHourly1of2.csv");

		ArrayList<String> dataHourly1 = new ArrayList<String>();
		ArrayList<String> dataHourly2 = new ArrayList<String>();
		ArrayList<String> dataConfig = new ArrayList<String>();
		ArrayList<String> dataDaily = new ArrayList<String>();


		//reads the data for first file
		read(myFile, dataHourly1);

		//changes file location to datahourly2
		myFile = new File("/Users/arianuseini/Downloads/hackOHI.O-master/HackathonDataHourly2of2.csv");
		//reads the data for first file
		read(myFile, dataHourly2);

		//changes file location to datahourly2
		myFile = new File("/Users/arianuseini/Downloads/hackOHI.O-master/HackathonConfig.csv");
		//reads the data for third file
		read(myFile, dataConfig);

		//changes file location to dataconfig
		myFile = new File("/Users/arianuseini/Downloads/hackOHI.O-master/HackathonDataDaily.csv");

		//reads the data for last file
		read(myFile, dataDaily);

		print(dataConfig.get(12));


		//		for(int i = 0; myScan.hasNextLine(); i++) {
		//			dataHourly1.add(myScan.nextLine());
		//			dataHourly1.set(i, dataHourly1.get(i).replaceAll("\"", " "));
		//			//print(data.get(i));
		//			//System.out.println(i);
		//		}
		//		
		//		myScan.close();
		//		myFile = new File("/Users/arianuseini/Downloads/hackOHI.O-master/HackathonDataHourly2of2.csv");
		//		myScan = new Scanner(myFile);
		//		for(int i = 0; myScan.hasNextLine(); i++) {
		//			dataHourly2.add(myScan.nextLine());
		//			dataHourly2.set(i, dataHourly2.get(i).replaceAll("\"", " "));
		//			//print(data.get(i));
		//			//System.out.println(i);
		//		}
		//		
		//		print(dataHourly2.get(12));
		//		myScan.close();
		//		
		//		myFile = new File("/Users/arianuseini/Downloads/hackOHI.O-master/HackathonConfig.csv");
		//		myScan = new Scanner(myFile);
		//		for(int i = 0; myScan.hasNextLine(); i++) {
		//			dataConfig.add(myScan.nextLine());
		//			dataConfig.set(i, dataConfig.get(i).replaceAll("\"", " "));
		//			//print(data.get(i));
		//			//System.out.println(i);
		//		}
		//		print(dataConfig.get(12));
		//		myScan.close();
		//		
		//		myFile = new File("/Users/arianuseini/Downloads/hackOHI.O-master/HackathonDataDaily.csv");
		//		myScan = new Scanner(myFile);
		//		for(int i = 0; myScan.hasNextLine(); i++) {
		//			dataDaily.add(myScan.nextLine());
		//			dataDaily.set(i, dataDaily.get(i).replaceAll("\"", " "));
		//			//print(data.get(i));
		//			//System.out.println(i);
		//		}


		print("done");
		double end = System.nanoTime();
		double difference = (end - begin) /Math.pow(10, 9);
		String a = "" + difference;
		print(a);

	}

	public static void read(File myFile, ArrayList<String> arr) throws FileNotFoundException{
		Scanner myScan = new Scanner(myFile);
		for(int i = 0; myScan.hasNextLine(); i++) {
			arr.add(myScan.nextLine());
			arr.set(i, arr.get(i).replaceAll("\"", " "));
		}
		myScan.close();
	}

	public static void print(String string) {
		System.out.println(string);
	}
}