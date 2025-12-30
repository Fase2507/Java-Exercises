public class DoubleLinkedList{
  Node head;
  Node tail;
  public DoubleLinkedList(){
    this.head=null;
    this.tail=null;
  }
  class Node{
    int data;
    Node next=null;
    Node prev=null;

    public Node(int data)
    {
      this.data=data;
      this.prev=null;
      this.next=null;
    }
  }

  public void traverseForward(){
    Node iter=head;
    while(iter!=null){
      System.out.println(iter.data+" ");
      iter=iter.next;
    }
  }
  public void traverseBackward(){
    Node iter=tail;
    while(iter!=null){
      System.out.println(iter.data+" ");
      iter=iter.next;
    }
  }

  public void insertAtheBeginning(int data)
  {
    Node temp=new Node(data);
    if(head==null){
      head=temp;
      tail=temp;
    }
    else{
      temp.next=head;
      head.prev=temp;
      head=temp;
    }
  }
  
  public void insertAthePos(int data,int pos){
    Node temp=new Node(data);
    if(pos==1)
      insertAtheBeginning(data);
    else
    {
      Node iter=head;
      int current=1;
      while(iter!=null&&current<pos){
        iter=iter.next;
        current++;
      }
      if(iter==null)
        insertAthEnd(data);
      else
      {
        temp.next=iter;
        temp.prev=iter.next;
        iter.prev.next=temp;
        iter.prev=temp;
      }
    
    }
 
  }
  
  public void insertAthEnd(int data)
  {
    Node temp=new Node(data);
    if(tail==null){
      tail=temp;
      head=temp;
    }else{
      tail.next=temp;
      temp.prev=tail;
      tail=temp;
    }
  }
  public void display()
  {
    Node iter=head;
    while(iter!=null)
    {
      System.out.println(iter.data+" ");
      iter=iter.next;

    }
    // System.out.println("null");
  }
  public static void main(String[] args)
    {

    }
}
