import java.util.ArrayList;


public class Lambdax {

  public static void main(String[] args){
    StringFunc exclaim=(s)->s+" ^!^";
    StringFunc ask=(s)->s+" !?";
    printFormatted("Hi",exclaim);
    printFormatted("HEllo",ask);

    // ArrayList<Integer>  nums=new ArrayList<Integer>();
    // nums.add(4);
    // nums.add(41);
    // nums.add(14);
    // nums.add(432);
    // nums.forEach((n)->{System.out.println(n);});
  }
  public static void printFormatted(String str,StringFunc format){
    String result=format.run(str);
    System.out.println(result);
  }
}
interface StringFunc{
  String run(String str);
}