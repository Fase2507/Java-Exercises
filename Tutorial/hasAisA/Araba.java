package Tutorial.hasAisA;

public class Araba{
	private Motor motor;
	private String brand;
	private String model;

	public Araba(){
		this.motor = new Motor();
		this.brand = "brand";
		this.model = "model";
	}
	public Araba(String brand, String model){
		motor = new Motor();
		this.brand = brand;
		this.model = model;
	}


	public void Durdur(){
		motor.Stop();
	}

	public void Calistir(){
		motor.Calistir();
	}

	public void Hizlandir(int v){
		motor.Hizlan(v);
	}
    public void geri(int v){
        motor.Hizlan(-v);
    }
    public void yavasla(int v){
        do{
            v--;
            motor.Hizlan(v);
            if (v==0)
                motor.Stop();
        }while (v!=0);
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModelBrand(){
        System.out.printf("%s-%s \n",brand,model);
        return brand+"-"+model;
    }

    public static void main(String[] args) {
        Araba car = new Araba("Audi","A6");
        car.Calistir();
        car.Hizlandir(23);
        car.Durdur();
        car.Calistir();
        car.yavasla(33);
        System.out.println(car.brand+" "+ car.model);
        System.out.println("--------------");
        car.setBrand("Volvo");
        car.setModel("s90");
    }

}

