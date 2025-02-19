import java.util.Iterator;
import java.util.ArrayList;
public class Iterate {

  public static void main(String[] arg){
    ArrayList<Integer> numbers=new ArrayList<Integer>();
    numbers.add(9);
    numbers.add(11);
    numbers.add(29);
    numbers.add(1);
    numbers.add(99);
    numbers.add(111);
    Iterator<Integer> it=numbers.iterator();
    while(it.hasNext()){
      Integer i=it.next();
      if(i<13){
        it.remove();
      }
    }
    System.out.println(numbers);


    // ArrayList<String> cars= new ArrayList<String>();
    // cars.add("Volvo");
    // cars.add("BMW");
    // cars.add("Ford");
    // cars.add("Mazda");
  
    // Iterator<String> it=cars.iterator();
    // while(it.hasNext()){
    //   System.out.println(it.next());

    // }
  }
}