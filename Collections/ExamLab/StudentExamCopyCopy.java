package Collections.ExamLab;

import Collections.StudentNotFoundException;

import java.io.*;
import java.util.*;

public class StudentExamCopyCopy implements Comparable<StudentExamCopyCopy>, Serializable {
    private Double ortalama;
    private Long ogrNo;
    private String isimSoy;
    private static final long serialVersionUID = 1L;

    public StudentExamCopyCopy(String isimSoy, long ogrNo, Double ortalama) {
        this.isimSoy = isimSoy;
        setOrtalama(ortalama);
        this.ortalama = ortalama;
        this.ogrNo = ogrNo;
    }

    public void setOrtalama(Double ort) {
        if(ort>0 && ort<=4){
            ortalama = ort;
        }
        else{
            System.out.println("Gecersiz ortalama degeri!");
        }
    }

    public Double getOrtalama() {
        return ortalama;
    }

    public void setOgrNo(long ogrNo) {
        this.ogrNo = ogrNo;
    }

    public void setIsimSoy(String isimsoy) {
        this.isimSoy = isimsoy;
    }

    public long getOgrNo() {
        return ogrNo;
    }

    public String getIsimSoy() {
        return isimSoy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof StudentExamCopyCopy)) {
            return false;
        }
        StudentExamCopyCopy ogrenci = (StudentExamCopyCopy) o;
        return Objects.equals(this.ogrNo, ogrenci.getOgrNo()) && Objects.equals(this.isimSoy, ogrenci.getIsimSoy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ogrNo, this.isimSoy, this.ortalama);
    }

    @Override
    public String toString() {
        return "{" +
                "ogrNo='" + ogrNo + '\'' +
                ", isimSoy='" + isimSoy + '\'' +
                ", ortalama='" + ortalama + '\'' +
                '}' + "\n";
    }

    @Override
    public int compareTo(StudentExamCopyCopy o) {
        if (this.ortalama > o.getOrtalama()) return -1;
        else if (o.getOrtalama() > this.ortalama) return 1;
        else return 0;
    }

    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws StudentNotFoundException {
        String path = "C:\\Users\\User\\IdeaProjects\\JavaBM\\src\\Collections\\ExamLab\\deneme.txt";

        // Ask user what they want to do
        System.out.println("1. Yeni öğrenci ekle");
        System.out.println("2. Öğrenci ara");
        System.out.println("3. Öğrenci listesini goster");
        System.out.println("Seçim: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        switch (choice) {
            case 1:
                // Add new students (this will read existing ones and add new)
                writeStudentsToFile(path);
                break;

            case 2:
                // Search student
                System.out.print("Aranacak öğrenci numarası: ");
                long searchNo = keyboard.nextLong();

                // Read ALL students from file
                List<StudentExamCopyCopy> allStudents = readSilentlyStudentsFromFile(path);

                // Convert to HashMap for searching
                HashMap<Long, StudentExamCopyCopy> studentMap = ogrListMakeMap(allStudents);

                // Search
                try {
                    StudentExamCopyCopy found = searchStudent(studentMap, searchNo);
//                    System.out.println("Öğrenci bulundu: " + found.getIsimSoy());
                } catch (StudentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3 :
                readAllStudentsFromFile(path);
                break;

        }

        keyboard.close();
    }

    // Display Students by gpa
    public static void showOgrler(List<StudentExamCopyCopy> ogrList) {
//        List<StudentExamCopyCopy> sortedOgrList = new ArrayList<>(ogrList);
        Collections.sort(ogrList);
        for (StudentExamCopyCopy ogr : ogrList) {
            System.out.println(ogr);
        }
    }


    // Search Student that you want
    public static StudentExamCopyCopy searchStudent(HashMap<Long, StudentExamCopyCopy> ogrler, Long ogrNo) {
        StudentExamCopyCopy aranan = ogrler.get(ogrNo);
        if (aranan == null)
            throw new StudentNotFoundException(ogrNo);
        else {
            System.out.println("Aranan ogrenci "+aranan);
            return aranan;
        }
    }

    public static HashMap<Long, StudentExamCopyCopy> ogrListMakeMap(List<StudentExamCopyCopy> ogrList) {
        HashMap<Long, StudentExamCopyCopy> ogrler = new HashMap<>();
//        List<StudentExamCopyCopy> sortedOgrList = new ArrayList<>(ogrList);
        Collections.sort(ogrList);
        for (StudentExamCopyCopy ogr : ogrList) {
            ogrler.put(ogr.getOgrNo(), ogr);
        }
        keyboard.close();

        return ogrler;
    }

    // Make Student List by HashSet
    public static HashSet<StudentExamCopyCopy> ogrListMake() {
        System.out.println("=== Kayit paneli ===");
        System.out.print("Kaç öğrenci kaydedeceksiniz? ");
        int n = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline
        HashSet<StudentExamCopyCopy> ogrList = new HashSet<>(n);
        int sayac = 0;

        do {
            System.out.println("\nEnter Student number: ");
            long ogrno = keyboard.nextLong();
            keyboard.nextLine();
            System.out.println("Enter Student name-surname: ");
            String isimsoy = keyboard.nextLine();
            System.out.print("Enter gpa: \n");
            Double ortalama = keyboard.nextDouble();
            StudentExamCopyCopy ogrenci = new StudentExamCopyCopy(isimsoy, ogrno, ortalama);
            ogrList.add(ogrenci);
            sayac++;
        } while (sayac < n);
        return ogrList;
    }


    // WRITE - With FileOutputStream and ObjectOutputStream declared outside try
    public static HashSet<StudentExamCopyCopy> writeStudentsToFile(String path) {
        // Read existing students first
        List<StudentExamCopyCopy> existingStudents = new ArrayList<>();
        File file = new File(path);

        if (file.exists() && file.length() > 0) {
            existingStudents = readSilentlyStudentsFromFile(path);
        }

        // Get new students from user
        HashSet<StudentExamCopyCopy> newStudents = ogrListMake();

        // Combine existing and new students
        List<StudentExamCopyCopy> allStudents = new ArrayList<>(existingStudents);
        allStudents.addAll(new ArrayList<>(newStudents));

        // Remove duplicates (by student number)
        Map<Long, StudentExamCopyCopy> uniqueMap = new HashMap<>();
        for (StudentExamCopyCopy student : allStudents) {
            uniqueMap.put(student.getOgrNo(), student);
        }
        allStudents = new ArrayList<>(uniqueMap.values());

        // Sort
        Collections.sort(allStudents);

        // Write ALL students back to file (overwrite, not append)
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(path); // NO append=true
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allStudents);
            System.out.println("\n" + allStudents.size() + ". öğrenci başarıyla kaydedildi.");

        } catch (IOException e) {
            System.out.println("Kayıt hatası: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Stream kapatma hatası: " + e.getMessage());
            }
        }

        return new HashSet<>(allStudents);
    }
    //READ ALL
    public static List<StudentExamCopyCopy> readAllStudentsFromFile(String path) {
        System.out.println("\n=== Tüm Kayıtlı Öğrenciler ===");

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<StudentExamCopyCopy> allStudents = new ArrayList<>(); // Changed: Store ALL students

        try {
            fis = new FileInputStream(path);
            int totalStudents = 0;

            while (true) {
                try {
                    // Create new ObjectInputStream for each object/header
                    ois = new ObjectInputStream(fis);

                    // Read the list
                    List<StudentExamCopyCopy> students = (ArrayList<StudentExamCopyCopy>) ois.readObject();

                    // ADD ALL STUDENTS TO MAIN LIST
                    allStudents.addAll(students);

                    for (StudentExamCopyCopy student : students) {
                        totalStudents++;
                        System.out.printf("%d. Ad-Soyad: %s, No: %d, GPA: %.2f%n",
                                totalStudents, student.getIsimSoy(), student.getOgrNo(), student.getOrtalama());
                    }

                } catch (EOFException e) {
                    // End of file reached
                    break;
                } catch (StreamCorruptedException e) {
                    // This happens when multiple ObjectOutputStreams were used
                    // Reset stream and continue
                    continue;
                }
            }

            System.out.println("Toplam " + totalStudents + " öğrenci bulundu.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Okuma hatası: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Stream kapatma hatası: " + e.getMessage());
            }
        }
        return allStudents; // Return ALL students, not just last batch
    }

    //READ ALL
    public static List<StudentExamCopyCopy> readSilentlyStudentsFromFile(String path) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<StudentExamCopyCopy> allStudents = new ArrayList<>(); // Changed: Store ALL students

        try {
            fis = new FileInputStream(path);
            int totalStudents = 0;

            while (true) {
                try {
                    // Create new ObjectInputStream for each object/header
                    ois = new ObjectInputStream(fis);

                    // Read the list
                    List<StudentExamCopyCopy> students = (ArrayList<StudentExamCopyCopy>) ois.readObject();

                    // ADD ALL STUDENTS TO MAIN LIST
                    allStudents.addAll(students);



                } catch (EOFException e) {
                    // End of file reached
                    break;
                } catch (StreamCorruptedException e) {
                    // This happens when multiple ObjectOutputStreams were used
                    // Reset stream and continue
                    continue;
                }
            }


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Okuma hatası: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Stream kapatma hatası: " + e.getMessage());
            }
        }
        return allStudents; // Return ALL students, not just last batch
    }
}