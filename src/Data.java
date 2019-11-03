import java.io.*;
import java.util.*;

public class Data {
   //private File dataFile;
   private String filePath;
   private HashMap<String, String> data;
   private HashMap<String, ArrayList<String>> building;
   public Data() {
      //dataFile = null;
      data = new HashMap<String, String>();
      building = new HashMap<String, ArrayList<String>>();
   }
   public Data(String filePath) {
      //dataFile = new File(filePath);
      this.filePath = filePath;
      data = new HashMap<String, String>();
      building = new HashMap<String, ArrayList<String>>();
   }
   public void loadData() {
      //Scanner input = null;
      //try {
         //input = new Scanner(dataFile);
         //while(input.hasNextLine()) {
            //String line = input.nextLine();               
            //String[] lineData = line.split(",");
            //if(lineData.length > 16) {
               //building.put(lineData[5].toLowerCase(), lineData[0]);
            //}
            //data.put(lineData[1], line);
            //meter.put(lineData[1], lineData[5].toLowerCase());
         //}
      //} catch(Exception e) {
      
      //}
      //input.close();
        
      BufferedReader input = null;
      try {
         input = new BufferedReader(new FileReader(filePath));
         String line = input.readLine();
         String[] lineData = line.split(",");
         while(line != null) {
            if(lineData.length < 17) {
               ArrayList<String> meters;
               if(building.containsKey(lineData[5])) {
                  meters = building.get(lineData[5]);
               } else {
                  meters = new ArrayList<String>();
               }
               meters.add(lineData[1]);
               building.put(lineData[5], meters);
            }
            if(lineData.length > 16) {
               data.put(lineData[1], line);
            } else {
               data.put(lineData[0], line);
            }
            line = input.readLine();
            lineData = line.split(",");
         }
      } catch(Exception e) {
         
      }
   }
   public HashMap<String, String> getMeterData() {
      return data;
   }
   public HashMap<String, ArrayList<String>> getBuildingMeters() {
      return building;
   }
}  