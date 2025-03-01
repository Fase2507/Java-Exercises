

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