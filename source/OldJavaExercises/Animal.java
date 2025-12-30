package Java;
class oldMain {
  public static void main(String[] args) {
    Bee myBee=new Bee();
    Cat myCat=new Cat();

    myCat.animalSound();
    myBee.animalSound();
  }
}

class Animali {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}
class Bee extends Animali {
  public void animalSound(){
    System.out.println("Bee: Vızzz!!");
  }
}

class Cat extends Animali{
  public void animalSound(){
    System.out.println("Cat: Meeeooowww!");
  }
}