import java.util.Scanner;
//INHERITENCE
import mypack.MyPackage;
public class Mond {
  public static void main(String[] args){
    // mypack.MyPackage myObj = new mypack.MyPackage();
    mypack.MyPackage.main(args);
    Scanner scanMe=new Scanner(System.in);
    System.out.println("Enter your name ");
    
    String usrName=scanMe.nextLine();
    System.out.println("Welcome "+usrName.toUpperCase()+"!");
  } 
}

// Scanner myObje=new Scanner(System.in);
//     try{
//       System.out.println("Enter username");

//     String userName=myObje.nextLine();
//     System.out.println("User name is "+ userName);
//   }finally{
//     myObje.close();
//   }