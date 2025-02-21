
class App{
  //ENUM
    
    public static void main(String[] args){    
      Dog myDog=new Dog();
      myDog.animalSound();
      myDog.sleep();
    }
    
    
  
}
interface Animal{
  public void animalSound();
  public void sleep();
}
class Dog implements Animal{
  public void animalSound(){
    System.out.println("Dog barks as Hav hav!!");
  }
  public void sleep(){
    System.out.println("Zzz");
  }
}


// CASTING NUMBER 9
