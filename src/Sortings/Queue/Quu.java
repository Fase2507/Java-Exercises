// import java.util.Queue;

public class Quu {

  public static void main(String[] args){
      Queue queue = new Queue();
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      queue.enqueue(40);
      queue.dequeu();
      queue.enqueue(45);
      System.out.println("Peek is "+queue.peek());
      queue.enqueue(145);
      queue.enqueue(435);

      System.out.println(queue.dequeu());
      System.out.println(queue.dequeu());

      System.out.println(queue.dequeu());
      System.out.println(queue.dequeu());
      System.out.println(queue.dequeu());
      System.out.println(queue.dequeu());


      // queue.show();
  }
}