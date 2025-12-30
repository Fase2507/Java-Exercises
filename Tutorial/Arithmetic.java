package Tutorial;
import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] dizi){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter mail address:");
        String mailname = scn.nextLine();

        if(mailname.contains("@")){
            System.out.println("Enter your mail password: ");
            String pass = scn.nextLine();
            if(pass.equals(mailname)){
                System.out.println(" your mail address can't be the same with password: ");
            }else
                System.out.println("succesfull1");
        }else{
            System.out.println("Email address is invalid must contain @");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day");
        String dayName = scanner.nextLine().toLowerCase();
        //Enhanced Switch
        switch(dayName){
            case "monday","tuesday","wednesday","thursday","friday" -> System.out.println("It's a weekday!");
            case "saturday","sunday" -> System.out.println("It's a weekend");
            default -> System.out.println("Not a day");
        }
        scn.close();
    }
}