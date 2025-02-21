public class Main extends Thread {
  public static int amount = 0;

  public static void main(String[] args) throws InterruptedException {
    Main thread = new Main();
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