package Collections;
public class StudentNotFoundException extends RuntimeException{
        public StudentNotFoundException(Long ogrNo){
            super(ogrNo+" numarali ogrenci sistemde yok!!");
        }
}