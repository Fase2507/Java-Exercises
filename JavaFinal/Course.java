package JavaFinal;

import java.io.Serial;
import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private String code;
    private int ects;

    @Serial
    private static final long serialVersionUID = 1L;
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