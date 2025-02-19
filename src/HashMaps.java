import java.util.HashMap;
import java.util.HashSet;
public class HashMaps {

  public static void main(String[] args){
  HashSet<String> cars=new HashSet<String>();
  cars.add("Mazda");
  cars.add("Ferrari");
  cars.add("Honda");
  System.out.println(cars.contains("Ferrari"));
  System.out.println(cars.contains("BYD"));

  
  
    //   HashMap<String, Integer> people=new HashMap<String, Integer>();

  //   people.put("Homero", 22);
  //   people.put("Açelya", 21);
  //   people.put("Mehmet", 44);
  //   for (String i: people.keySet()){
  //     System.out.println("name: "+i+" age: "+people.get(i));
  //   }
  }
}