public class Queue {
  private int front=0;
  private int rear=-1;
  private int size=0;
  private int[] arr=new int[4];

  public void enqueue(int data)
  {
    if(!isFull())
    {     
      rear=(rear+1)%4;
      arr[rear]=data;
      size++;
    }else{
      System.out.println("Queue is full!");
    }
  }

  public int dequeu()
  {
      if(isEmpty())
      {
        throw new RuntimeException("Queue is empty!");
      }
      int data=arr[front];
      front=(front+1)%4;
      size--;
      return data;
  }
  public void show()
  {
    for(int n:arr){
      System.out.println(n+" ");
    }
    System.out.println();
  }
  public boolean isFull()
  {
    return size==4;
  }

  public boolean isEmpty(){
    return size==0;
  }
  public int peek(){
    if(isEmpty())
      throw new RuntimeException("Queue is empty!");
    return arr[front];
    }
  public static void main(String[] args){

  }


}