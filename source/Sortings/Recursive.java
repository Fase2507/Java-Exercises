class Recursive{

  public static void main(String[] args){
    Recursive myObj=new Recursive();
    int result=myObj.facto(6);
    System.out.println(result);
  }

  public int facto(int i){
    
    if(i!=0){
      return i*facto(i-1);
    }
    
    return 1;

  }
}