public class LinkedListe{
  private class Node{
    int data;
    Node next;

    public Node(int data){
      this.data=data;
      this.next=null;
    }
  }
  Node root=null;
  public void insert(int data){
    Node newNode=new Node(data);
    if(root == null)
      root=newNode;
    else{
      Node iter=root;
      while(iter.next!=null){
        iter=iter.next;
      }
      iter.next=newNode;
    }
  }
  
  public void OrderlyInsert(int data){
    Node newNode=new Node(data);
    Node iter=root;
    if(root==null||root.data>=data)
      {
        newNode.next=root;
        root=newNode;
      }
    else{
      while(iter.next!=null&&iter.next.data<data){
        iter=iter.next;
      }
      newNode.next=iter.next;
      iter.next=newNode;
    }
   

  }

  public void del(int data){
    Node iter=root;
    if(iter==null){
      System.out.println("empty");
    }
    else if(iter.data==data){
      root=iter.next;
    }
    else{
      while(iter.next!=null&& iter.next.data!=data){
        iter=iter.next;
      }
      if(iter.next.data==data){
        iter.next=iter.next.next;
      }
    }
  }


  public void printAll(){
    Node iter=root;
    while(iter!=null){
      System.out.println(iter.data+" ");
      iter=iter.next;
    }
  }
  public static void main(String[] args) {
    
  }
}