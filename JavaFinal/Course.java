package JavaFinal;

public class Course{
    private String name;
    private String code;
    private int ects;

    /*GETTER SETTER*/
    public String getName(){return name;}
    public String getCode(){return code;}
    public int getEcts() {
        return ects;
    }

    public void setName(String name){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException("Ders adi bos olamaz!!");
        }
        this.name = name;
    }

    public void setCode(String code){
        if(code==null||code.isBlank()){
            throw new IllegalArgumentException("Ders adi bos olamaz!!");
        }
        this.code = code;
    }

    public void setEcts(int ects) {
        if (ects <= 0) {
            throw new IllegalArgumentException("AKTS negatif veya sifir olamaz.");
        }
        this.ects = ects;
    }
}