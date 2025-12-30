public class Trees{
  
  public static void main(String[] args){
    BinaryTree tree=new BinaryTree();
    tree.insert(5);
    tree.insert(6);
    tree.insert(3);
    tree.insert(15);
    tree.insert(2);
    tree.insert(4);
    tree.insert(444);
    tree.insert(41);
    tree.insert(12);

    tree.inOrder();

  }
}