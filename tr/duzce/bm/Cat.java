package tr.duzce.bm;

public class Cat extends Animal{
    public final int dmg = 9;
    @Override
    public void eat(){
        System.out.println("Cat is eating and mewowing...\uD83D\uDC31");
    }

    public void eat(String smthing){
        System.out.println("%s \uD83D\uDC31 is eating %s".formatted("cat",smthing));
    }
}