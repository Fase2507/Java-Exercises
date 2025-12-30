package Tutorial;
import java.util.Scanner;
// export PATH="/c/Program Files/Java/jdk-17/bin:$PATH" //to use cli

public class OgrKayit{
    static class Ogrenci{
        private String isim;
        private String  soyisim;
        private Long ogrenciNo;
        private Integer kredi=0;
        // constructor
        public Ogrenci(String s, String soy, Long ogrNo){
            isim =s;
            soyisim = soy;
            ogrenciNo = ogrNo;

//            System.out.println(isim+" "+soyisim+" "+ogrenciNo);
        }

        public void krediEkle(Integer k){
            this.kredi += k;
            System.out.println("Yeni toplam kredi: "+this.kredi);
        }

        //set methods
        public void setIsimSoy(String isim, String soyisim){
              if((isim == null || isim.trim().isEmpty())||(soyisim == null || soyisim.trim().isEmpty())){
                  System.out.println("Error: name cannot be empty!!");
              }
              else if((isim.matches("^[a-zA-Z]+$"))&&(soyisim.matches("^[a-zA-Z]+$"))){
                  this.isim = isim.trim().toLowerCase();
                  this.soyisim = soyisim.trim().toUpperCase();
                  System.out.println("Name set succesfully "+isim+" "+soyisim);
              }
              else
                  System.out.println("Error: Name contains invalid characters!!");
        }

        public String getIsimSoy(){
            return isim+" "+soyisim;
        }

        //override
        public String toString(){
            return this.getIsimSoy();
        }

    }

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Ogrenci ogr = new Ogrenci("ali","sever",221005002L);
        ogr.krediEkle(10);
        ogr.setIsimSoy("ayse","Koyun");
//        ogr.getIsimSoy();

        System.out.println(ogr);

    }


}