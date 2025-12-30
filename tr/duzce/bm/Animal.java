package tr.duzce.bm;

public class Animal{

    public boolean isAlive;

    public Animal(){
        isAlive = true;
    }
    public void eat(){
        System.out.println("The Animalus is eating something...");
    }
    public void sleep(){
        System.out.println("The Animalus is sleeping zzz");
    }
}