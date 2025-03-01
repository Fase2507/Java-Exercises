public class MyStacks{

  public static void main(String[] args){
    Stacke numbers=new Stacke();
    // numbers.pop();
    numbers.push(10);
    numbers.push(1);
    numbers.push(12);
    numbers.push(13);
    numbers.push(11);
    numbers.pop();
    numbers.push(3);
    System.out.println("Top value in the stack is "+numbers.peek());
    numbers.printStacke();
    }
}