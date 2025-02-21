import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
public class Snowy {

  public static void main(String[] args){
    // try//Create side
    // {
    //   File myObje=new File("snowy.txt");
    //   if(myObje.createNewFile()){
    //     System.out.println("File created "+myObje.getName());
    //   }else{
    //     System.out.println("File already exits");
    //   }
    // }catch(IOException e){
    //   System.out.println("An error occured");
    //   e.printStackTrace();
    // }
    try{
      Scanner myScanner=new Scanner(System.in);
      System.out.println("Write something inside snowy.txt file");
      String input=myScanner.nextLine();
      FileWriter myWriter=new FileWriter("snowy.txt",true);
      myWriter.write(input);
      myWriter.close();
      System.out.println("Succesfully done!");
    }catch(IOException e){
      System.out.println("Errror!");
      e.printStackTrace();
    }
  }
}