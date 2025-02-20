public class TryCatch {
  static void checkAge(int age){
    if(age<18){
      throw new ArithmeticException("Access denied You must be 18 and above!");
    }
    else{
      System.out.println("Accepted.");
    }
  }
  public static void main(String[] args){
    checkAge(22);
  }



}
