public class MyChainList{

  public static void main(String[] args ){
     ChainedList nums=new ChainedList();

     nums.add(3);
     nums.add(5);
     nums.add(1);
     nums.addFirst(2);
     nums.addFirst(12);
     nums.printValues();
     nums.delete(12);
     nums.delete(3);
     nums.delete(1);

     nums.printValues();
  }
}
