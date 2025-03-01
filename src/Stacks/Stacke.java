public class Stacke {

  private int[] arr=new int[6];
  int top=-1;
  int size;
  public Stacke()
  {
    size=arr.length;
    top=-1;
  }
  public static void main(String[] args){

  }
  public void push(int data){
    if(top<size)
      arr[++top]=data;
    else
      System.out.println("StackOverFlow!! for "+data);  
    
  }

  public int pop()
  {
    if(top>-1)
      return arr[top--];
    else
      System.out.println("StackUnderFlow!!");
    return 0;
  }

  public int peek(){
    return arr[top];
  }

  public void printStacke(){
    for(int n:arr){
      System.out.println(n+" ");
    }
    System.out.println();
  }
}