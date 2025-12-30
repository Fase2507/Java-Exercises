public class exMain extends Thread {
  public static int amount = 0;

  public static void main(String[] args) throws InterruptedException {
    exMain thread = new exMain();
    thread.start();
    thread.join(); // Wait for the thread to finish
    System.out.println(amount);
    amount++;
    System.out.println(amount);
  }

  @Override
  public void run() {
    amount++;
  }
}