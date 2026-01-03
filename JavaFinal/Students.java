package JavaFinal;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Students implements Comparable<Students>, Serializable {

    private String name;
    private String surname;
    private long studentNum;
    private LocalDate birth;
    private Major major;

    @Serial
    private static final long serialVersionUID = 1L;

    private Map<Course, Double> courseScores;

    /* VALIDATION METHODS*/
    public void validateText(String val, String domain){
        if(val==null|!val.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ ]+$")){
            throw new IllegalArgumentException(
                    domain+ " sadece harflerden olusmalidir!"
            );
        }
    }

    /*GETTER-SETTER METHODS*/
    public String getName(){
        return name;
    }

    public void setName(String name){
        validateText(name, "isim");
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String sname){
        validateText(sname, "Soyisim");
        this.surname = sname;
    }

    public long getStudentNum(){
        return studentNum;
    }

    public void setStudentNum(long number){
        if(number<100_000_000L || number>999_999_999L){
            throw new IllegalArgumentException(
                    "Ogrenci numarasi 9 haneli ve pozitif olmalidir."
            );
        }
        this.studentNum = number;
    }

    public LocalDate getbirth() {
        return birth;
    }

    public void setbirth(LocalDate birth) {
        this.birth = birth;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major Major) {
        this.major = Major;
    }

    public Map<Course, Double> getCourseScores() {
        if(courseScores==null){
            courseScores = new HashMap<>();
        }
        return courseScores;
    }

//    /* ECTS CALCULATION*/
//    public double ectsCalc(){
//        double total = 0;
//        int totalEcts = 0;
//
//        for(Map.Entry<Course,Double> entry : courseScores.entrySet()){
//            total += entry.getKey().getEcts() * entry.getValue();
//            totalEcts += entry.getKey().getEcts();
//        }
//        return totalEcts == 0 ? 0: total/totalEcts;
//    }

    public double calculateGPA() {

        double totalWeightedScore = 0.0;
        int totalEcts = 0;

        for (Map.Entry<Course, Double> entry : getCourseScores().entrySet()) {

            Course course = entry.getKey();
            double gradeValue = entry.getValue();

            totalWeightedScore += course.getEcts() * gradeValue;
            totalEcts += course.getEcts();
        }

        if (totalEcts == 0) {
            return 0.0;
        }

        return totalWeightedScore / totalEcts;
    }

    //  Compare and sort
    @Override
    public int compareTo(Students others){
        return Double.compare(others.calculateGPA(),this.calculateGPA());
    }

    @Override
    public String toString(){
        return this.name + " " + this.surname + " "+ this.studentNum+" "+ String.format("%.2f", this.calculateGPA());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.studentNum,this.surname,this.calculateGPA());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Students)) {
            return false;
        }
        Students ogrenci = (Students) o;
        return Objects.equals(this.studentNum, ogrenci.getStudentNum()) && Objects.equals(this.name, ogrenci.getName());
    }

//    @Override
//    public int compareTo(Students o) {// Sort based on student numbers
//        if(this.studentNum>o.getStudentNum()){
//            return -1;
//        } else if (o.getStudentNum()>this.studentNum) {
//            return 1;
//        }
//        else
//            return 0;
//    }
}