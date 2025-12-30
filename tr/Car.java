package tr;
public class Car {
    public String model;
    public int year;
    public Engine engine;

    public Car(String model, int year, String engineType){
        this.engine = new Engine(engineType);
        this.model = model;
        this.year = year;
    }

    public void start(){
        this.engine.start();
        System.out.println(this.model+" is running");
    }
}