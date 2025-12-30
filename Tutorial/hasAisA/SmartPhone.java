package Tutorial.hasAisA;
//import Tutorial.hasAisA.HesapMakine;
public class SmartPhone{
    private String IsletimSistemi = "Android";
    private HesapMakine calculator = new HesapMakine();

    public void setCalculator(String IsletimSistemi,HesapMakine calculator){
        this.calculator = calculator;
        this.IsletimSistemi = IsletimSistemi;

    }

    public String toString(){
        calculator.setBrand("CasioPro");
        calculator.setModel("24s");
        return "Os: "+IsletimSistemi+" Brand: "+calculator.getBrand()+" Model: "+calculator.getModel();
    }
    public HesapMakine getCalculator() {
        return calculator;
    }

    public String[] getOperators() {
        return calculator.getOperators();
    }

    public int topla(int a, int b){
        return calculator.topla(a,b);
    }
}