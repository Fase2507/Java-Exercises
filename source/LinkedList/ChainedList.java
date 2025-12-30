

public class ChainedList {
  Node root = null; // initialized root to null
  public static void main(String[] args){
    
  }
  public void add(int data) {
    Node newNode = new Node(data);
    if (root == null) {
      root = newNode;
    } else {
      Node iter = root;
      while (iter.next != null) {
        iter = iter.next;
      }
      iter.next = newNode;
    }
  }
class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null; // added 'this' keyword
  }
}


  public void printValues() {
    Node iter = root;
    while (iter != null) {
      System.out.print(iter.data + " "); // changed println to print
      iter = iter.next;
    }
    System.out.println(); // added newline at the end
  }
  public void addFirst(int data) {
      Node newNode=new Node(data);
      newNode.next=root;
      root=newNode;
  }
  public void delete(int data) {
    Node iter=root;
    if(root.data==data)
      root=iter.next;
    
    else
    {  
      while(iter.next!=null&&iter.next.data!=data){
        iter=iter.next;
      }
      if(iter.next!=null){
        iter.next=iter.next.next;
      }
    }
  } 

}



// public class LinkedList{
//   Node root=null;
//   class Node{
//     int data;
//     Node next;

//     public Node(int data){
//       this.data=data;
//       this.next=null;
//     }
//   }

//   public void add(int data)
//   {
//     Node newNode=new Node(data);
//     if(root==null){
//       root=newNode;
//     }
//     else{
//       Node iter=root;
//       while(iter.next!=null)
//       {
//         iter=iter.next;
//       }
//       iter.next=newNode;
//     }
//   }
//   public void orderAdd(int data)
//   {
//     Node newNode = new Node(data);
//     Node iter = root;
//     if (root == null || root.data <= data) {
//         newNode.next = root;
//         root = newNode;
//     } else {
//         while (iter.next != null && iter.next.data > data) {
//             iter = iter.next;
//         }
//         newNode.next = iter.next;
//         iter.next = newNode;
//     }
//   }
//   public void ekleFirst(int data)
//   {
//     Node newNode=new Node(data);
//     newNode.next=root;
//     root=newNode;
//   }

//   public void delete(int data){
//     Node iter=root;

//     if(iter==null){
//       System.out.println("Liste bos ");
//     }
//     else if(iter.data==data){
//       root=iter.next;
//     }
//     else
//     {
//       while(iter.next!=null&&iter.next.data!=data)
//         iter=iter.next;
//       if(iter.next.data==data)
//         iter.next=iter.next.next;
//     }
//   }
//   public void pop()
//   {
//     Node iter=root;
//     while(iter.next.next!=null){
//       iter=iter.next;
//     }
//     iter.next=null;
//   }
//   public void printListe()
//   {
//     Node iter = root;
//     if(root==null)
//       System.out.print("liste bos");
//     while(iter!=null){
//       System.out.println(iter.data+" ");
//       iter=iter.next;
//     }
//     System.out.println();
//   }

//   public static void main(String[] args){

//   }
// }






// public class ChainedList {
//   Node root = null;

//   public void add(int data) {
//     Node newNode = new Node(data);
//     if (root == null) {
//       root = newNode;
//     } else {
//       Node iter = root;
//       while (iter.next != null) {
//         iter = iter.next;
//       }
//       iter.next = newNode;
//     }
//   }
//   class Node {
//     int data;
//     Node next;
  
//     public Node(int data) {
//       this.data = data;
//       this.next = null;
//     }
//   }
  
//   public void printValues() {
//     Node iter = root;
//     while (iter != null) {
//       System.out.print(iter.data + " ");
//       iter = iter.next;
//     }
//     System.out.println();
//   }

//   public static void main(String[] args) {
//     ChainedList list = new ChainedList();
//     list.add(1);
//     list.add(2);
//     list.add(3);
//     list.printValues();
//   }
// }