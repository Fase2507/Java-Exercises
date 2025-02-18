
import java.util.Scanner;
public class Sevon{
  private String name;
//INHERITENCE
  public String getName(){
    return name;
  }

  public void setName(String newName){
      this.name=newName;
  }
  public static void main(String[] args){
    Sevon mySevon=new Sevon();
    mySevon.setName("KURTULUŞ");
    System.out.println(mySevon.getName());
  }
} 



