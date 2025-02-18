class Inner{
  public static void main(String[] args){
    Outer myOuter =new Outer();
    Outer.Inn myInner=new Outer.Inn();
    System.out.println(myInner.z-myOuter.x);
  }
}
class Outer{
  int x=9;
  static class Inn{
    int z=99;
  }
}
