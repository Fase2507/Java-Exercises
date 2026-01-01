package Collections;

import java.util.*;

public class StudentExam implements Comparable<StudentExam> {
    private Double ortalama;
    private Long ogrNo;
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
        System.out.println("How many students do you wanna add ?  ");
        int number = keyboard.nextInt();
        HashSet<StudentExam> ogrler2 = ogrListMake(number);
        showOgrler(ogrler2);
        HashMap<Long,StudentExam> ogrler = ogrListMakeMap(number,ogrler2);
        try{
            StudentExam aranan = searchStudent(ogrler,123L);
            System.out.println("aranan ogrenci "+aranan.getIsimSoy()+" ortalamasi "+aranan.getOrtalama());

        }catch (StudentNotFoundException e){
            e.printStackTrace();
        }
    }



    //Display Students by gpa
    public static void showOgrler(HashSet<StudentExam> ogrList){
        List<StudentExam> sortedOgrList = new ArrayList<>(ogrList);
        Collections.sort(sortedOgrList);
        for(StudentExam ogr:sortedOgrList){
            System.out.println(ogr);
        }
    }

    public static HashMap<Long,StudentExam> ogrListMakeMap(int n, HashSet<StudentExam> ogrList){
        HashMap<Long, StudentExam> ogrler = new HashMap<>();
        List<StudentExam> sortedOgrList = new ArrayList<>(ogrList);
        Collections.sort(sortedOgrList);
        for(StudentExam ogr:sortedOgrList){
            ogrler.put(ogr.getOgrNo(),ogr);
        }
        keyboard.close();

        return ogrler;
    }
    //Make Student List by HashSet
    public static HashSet<StudentExam> ogrListMake(int n){
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
        return ogrList;
    }

    //Search Student that you want
    public static StudentExam searchStudent(HashMap<Long, StudentExam> ogrler, Long ogrNo){
        StudentExam aranan = ogrler.get(ogrNo);
        if(aranan==null)
            throw new StudentNotFoundException(ogrNo);
        else
            return aranan;
    }
}