public class FX{

  public static void main(String[] args) {
    DoubleListe liste=new DoubleListe();
    liste.OrderlyAdd(3);
    liste.OrderlyAdd(5);
    liste.OrderlyAdd(1);
    liste.pop();
    liste.OrderlyAdd(0);
    liste.OrderlyAdd(9);
    liste.OrderlyAdd(2);
    liste.OrderlyAdd(4);
    // liste.del(9);
    // liste.pop();
    // liste.pop();
    liste.OrderlyAdd(44);
    liste.OrderlyAdd(41);
    // liste.pop();
    liste.del(3);
    // liste.del(111);
    // liste.del(1121);


    liste.print();
  }
}