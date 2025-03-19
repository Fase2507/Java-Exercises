public class DoubleListe {
  private class Node{
    int data;
    @SuppressWarnings("unused")
    Node prev;
    Node next;
    public Node(int data){
      this.data=data;
      this.next=null;
      this.prev=null;
    }
  }
  Node root=null;


  public void add(int data){
    Node newNode=new Node(data);
    if(root==null){
      root=newNode;
    }
    else{
      Node iter=root;
      while(iter.next!=null){
        iter=iter.next;
      }
      iter.next=newNode;
      newNode.prev=iter;

    }

  }

  public void OrderlyAdd(int data)
  {
    Node newNod=new Node(data);
    if(root==null||root.data>=data){
      newNod.next=root;
      root=newNod;
      if(root!=null)
        newNod.prev=root;
    }else{
      Node iter=root;
      while(iter.next!=null&&iter.next.data<data){
        iter=iter.next;
      }
      newNod.next=iter.next;
      iter.next=newNod;
      if(iter.next!=null)
        newNod.prev=iter;
    }
  }
  

  //DELETING
  public void pop(){
    Node iter=root;
    if(root==null)
      System.out.print("nnothing to remove");
    else if(root.next==null){
      root=null;
    }
    else{
      while(iter.next.next!=null){
        iter=iter.next;
      }
      // iter.next.prev=iter;
      iter.next=iter.next.next;
    }
  }
 
  public void del(int data){
    Node iter=root;
    if(root==null){
      return;
    }
    else if(root.data==data){
      root=root.next;
      if(root!=null)
        root.prev=null;
      return;
    }
    else{

      while(iter.next!=null&&iter.next.data!=data)
        iter=iter.next;
      if(iter.next==null)
        {
          System.out.println(0);
          return;
        }
      else{
        Node temp=iter.next;
        iter.next=temp.next;
        if(temp.next!=null){
          temp.next.prev=iter;
        }
      }  
    }
  
  }

  public void print(){
    Node iter=root;
    while(iter!=null){
      System.out.println(iter.data+" ");
      iter=iter.next;
    }
  }

  public static void main(String[] args) {
    
  }
}