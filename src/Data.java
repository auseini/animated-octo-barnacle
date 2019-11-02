import java.io.*;
import java.util.*;

public class Data {
   private File dataFile;
   private ArrayList<String> data;
   public Data() {
      dataFile = null;
      data = new ArrayList<String>();;
   }
   public Data(String filePath) {
      dataFile = new File(filePath);
      data = new ArrayList<String>();
   }
   public void loadData() {
      Scanner input = null;
      try {
         input = new Scanner(dataFile);
         while(input.hasNextLine()) {
            String line = input.nextLine();
            //String[] lineData = line.split(",");
            data.add(line);
         }
      } catch(Exception e) {
      
      }
      
   }
   public ArrayList<String> getData() {
      return data;
   }
}  