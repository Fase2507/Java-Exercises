import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReGex {

  public static void main(String[] args){
    Pattern pattern=Pattern.compile("w3school",Pattern.CASE_INSENSITIVE);
    Matcher matcher=pattern.matcher("Visit a W3schools, I recommend it!");
    boolean matchFound=matcher.find();
    if(matchFound){
      System.out.print("Found");
    }
    else{
      System.out.print("Not found");
    }
  }
}