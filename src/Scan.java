import java.util.Scanner;
import java.time.LocalDate;

class Scan{

  public static void main(String[] args){
    Scanner myObj=new Scanner(System.in);
    LocalDate myTime = LocalDate.now(); // Create a date object
    System.out.println("Enter name,age and salary");

    String name=myObj.nextLine();

    int age=myObj.nextInt();
    double salary=myObj.nextDouble();
    System.out.println("Date is "+ myTime);
    System.out.println("name "+ name);
    System.out.println("age \n"+ age);
    System.out.println("salary \n"+ salary);
  }
}