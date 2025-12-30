package Tutorial.hasAisA;
public class HesapMakine {
    private String brand;
    private String model;
    private String[] operators = {"+","-","/","*"};

    public int topla(int a , int b){
        return a+b;
    }

    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setOperators(String... newOperators){
        String[] combined = new String[operators.length+ newOperators.length];
        System.arraycopy(operators, 0, combined, 0, operators.length);
        System.arraycopy(newOperators, 0, combined, operators.length, newOperators.length);
        operators = combined;
    }

    public String[] getOperators(){
        return operators;
    }
}