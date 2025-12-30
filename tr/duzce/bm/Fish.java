package tr.duzce.bm;
public class Fish implements prey,Predator{
    @Override
    public void flee(){
        System.out.println("Fish is swimming");
    }

    public void hunt(){
        System.out.println("Fish is chasing and biting");
    }
}