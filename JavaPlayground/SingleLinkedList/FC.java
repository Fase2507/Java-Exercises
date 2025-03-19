public class FC {

  public static void main(String[] args) {
     LinkedListe liste=new LinkedListe();

     liste.OrderlyInsert(6);
     liste.OrderlyInsert(5);
     liste.OrderlyInsert(7);
     liste.OrderlyInsert(11);
     liste.OrderlyInsert(1);
     liste.OrderlyInsert(2);

     liste.del(6);
     liste.printAll();

  }
}