import java.util.LinkedList;

class BroCode{
  public static void main(String[] args){
    LinkedList<String> linkedList=new LinkedList<String>();
    linkedList.push("A");
    linkedList.add(1,"A");
    linkedList.offer("b");
    linkedList.push("V");
    // linkedList.pop();
    System.out.println(linkedList.indexOf("b"));

  }
}