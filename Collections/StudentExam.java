package Collections;

import java.util.*;

public class StudentExam implements Comparable<StudentExam> {
    private Double ortalama;
    private long ogrNo;
    private String isimSoy;

    public StudentExam(String isimSoy, long ogrNo, Double ortalama){
        this.isimSoy = isimSoy;
        this.ogrNo = ogrNo;
        this.ortalama = ortalama;
    }

    public void setOrtalama(Double ort){
        ortalama = ort;
    }

    public Double getOrtalama(){return ortalama;}

    public void setOgrNo(long ogrNo) {
        this.ogrNo = ogrNo;
    }
    public void setIsimSoy(String isimsoy){
        this.isimSoy = isimsoy;
    }

    public long getOgrNo(){
        return ogrNo;
    }
    public String getIsimSoy(){
        return isimSoy;
    }



    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o == null ||   !(o  instanceof StudentExam)) {
            return false;
        }
        StudentExam ogrenci = (StudentExam) o;
        return Objects.equals(this.ogrNo, ogrenci.getOgrNo()) && Objects.equals(this.isimSoy,ogrenci.getIsimSoy());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.ogrNo,this.isimSoy,this.ortalama);
    }
    @Override
    public String toString(){
        return "{" +
                "ogrNo='" + ogrNo + '\'' +
                ", isimSoy='" + isimSoy + '\'' +
                ", ortalama='"+ortalama+'\''+
                '}'+"\n";
    }
    @Override
    public int compareTo(StudentExam o) {
        if(this.ortalama>o.getOrtalama()) return -1;
        else if(o.getOrtalama()>this.ortalama) return 1;
        else return 0;
    }

    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        HashSet<StudentExam> ogrler = new HashSet<>();
        StudentExam ali = new StudentExam("Ali hay",55,3.5);
        StudentExam veli = new StudentExam("Veli bekir",56,2.6);
        StudentExam ayse = new StudentExam("Aysenur kara",57,2.95);
        ogrler.add(ali);
        ogrler.add(veli);
        ogrler.add(ayse);
        ayse.setIsimSoy("Aysegul kara");
        ayse.setOgrNo(53);

        ogrler.add(new StudentExam("Hale soyca",59,4.0));
        System.out.println("How many students do you wanna add ?  ");
        int number = keyboard.nextInt();
        HashSet<StudentExam> ogrler2 = ogrListMake(number);
        List<StudentExam> sorted = new ArrayList<>(ogrler2);
        Collections.sort(sorted);
        for(StudentExam e:sorted){
            System.out.println(e);
        }
    }

    public static HashSet<StudentExam> ogrListMake(int n){
        System.out.printf("Enter %d students to add list",n);
        HashSet<StudentExam> ogrList = new HashSet<>(n);
        int sayac = 0;

        do{
            System.out.println("\nEnter Student number: ");
            long ogrno = keyboard.nextLong();
            keyboard.nextLine();
            System.out.println("Enter Student name-surname: ");
            String isimsoy = keyboard.nextLine();
//            keyboard.nextLine();
            System.out.print("Enter gpa: \n");
            Double ortalama = keyboard.nextDouble();
            StudentExam ogrenci = new StudentExam(isimsoy,ogrno,ortalama);
            ogrList.add(ogrenci);
            sayac++;
        }while (sayac<n);
        keyboard.close();
        return ogrList;
    }


}