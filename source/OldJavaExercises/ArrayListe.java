import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
class ArrayListe{
 
  public static void main(String[] args){
    HashMap<String,String>capitalCities=new HashMap<String,String>();

    capitalCities.put("EN","London");
    capitalCities.put("TR","Ankara");
    capitalCities.put("USA", "Washington DC");
    // System.out.println(capitalCities);
    // System.out.println(capitalCities.get("TR"));
    for(String i: capitalCities.values()){
      System.out.println(i);
    }

    // ArrayList<String> cars=new ArrayList<String>();
    // cars.add("Togg");
    // cars.add("BYD");
    // cars.add(1,"Mazda");
    // cars.add(0,"Tesla");
    // Collections.sort(cars);
    // cars.remove("BYD");
    // for(String i: cars){
    //   System.out.println(i);
    // }
  }
}
