import java.util.*;

public class Building {
   private String[] data;
   public Building() {
      data = new String[0];
   } 
   public Building(String dataLine) {
      this.data = dataLine.split(",");
   }
   public void transferData() {
      for(int i = 0; i < data.length; i++) {
         data[i] = data[i].substring(data[i].indexOf("\"") + 1, data[i].lastIndexOf("\""));
      }
   }
   public void printData() {
      System.out.println(Arrays.toString(data));
   }
}   