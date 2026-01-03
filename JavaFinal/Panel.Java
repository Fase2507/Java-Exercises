package JavaFinal;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Panel{

    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

         Major major = new Major();
         List<Students> students = new ArrayList<>();
         List<Course> courses = new ArrayList<>();

        System.out.println("\n----- RESULTS OBJECT READING -----");

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("results.dat"))) {

            List<Students> loadedStudents = (List<Students>) ois.readObject();

            System.out.println("Students successfully read from file.");

            for (Students student : loadedStudents) {
                System.out.println(student.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n -------RESULTS NORMAL READING-----------");
        try(BufferedReader br = new BufferedReader(new FileReader("results.txt"))){
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }


        try {

            System.out.println("Enter major informations");
            while (true) {
                try {
                    System.out.println("Major: ");
                    major.setName(keyboard.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                try {
                    System.out.print("Bolum web sayfasi: ");
                    major.setWebPage(keyboard.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                try {
                    System.out.print("Kurulus tarihi (YYYY-MM-DD): ");
                    major.setFoundingDate(LocalDate.parse(keyboard.nextLine()));
                    break;
                } catch (DateTimeParseException | IllegalArgumentException e) {
                    System.out.println("Gecersiz tarih girisi.");
                }
            }
        }finally {
            System.out.println("tamamlandı");
        }

            System.out.println("\nstudents bilgilerini giriniz");

            while (true) {
                System.out.print("Isim (bitirmek icin 'son'): ");
                String name = keyboard.nextLine();
                if (name.equalsIgnoreCase("son")) break;

                Students student = new Students();

                try {
                    student.setName(name);

                    System.out.print("Soyisim: ");
                    student.setSurname(keyboard.nextLine());

                    while (true) {
                        try {
                            System.out.print("students No (9 haneli): ");
                            student.setStudentNum(Long.parseLong(keyboard.nextLine()));
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Gecersiz students numarasi.");
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Dogum tarihi (YYYY-MM-DD): ");
                            student.setbirth(LocalDate.parse(keyboard.nextLine()));
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Tarih formati hatali.");
                        }
                    }

                    student.setMajor(major);
                    students.add(student);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("\nDers bilgilerini giriniz");

            while (true) {
                System.out.print("Ders adi (bitirmek icin 'son'): ");
                String name = keyboard.nextLine();
                if (name.equalsIgnoreCase("son")) break;

                Course course = new Course();

                try {
                    course.setName(name);

                    System.out.print("Ders kodu: ");
                    course.setCode(keyboard.nextLine());

                    while (true) {
                        try {
                            System.out.print("AKTS: ");
                            course.setEcts(Integer.parseInt(keyboard.nextLine()));
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Gecersiz AKTS degeri.");
                        }
                    }

                    courses.add(course);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());

                }
            }

        /*NOT GIRISLERI*/
        for(Students student: students){
            System.out.println("\n"+student.getName()+" "+student.getSurname()+" tum ders sonuclarini giriniz.");
            for (Course course : courses) {
                while (true) {
                    try {
                        System.out.print(course.getName()
                                + " dersi icin harf notu (AA, BA, ...): ");
                        LetterGrade letterGrade =
                                LetterGrade.valueOf(keyboard.nextLine().toUpperCase());

                        student.getCourseScores().put(course, letterGrade.getValue());

                        System.out.printf("Genel ortalama: %.2f \n",student.calculateGPA());


                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gecersiz harf notu.");
                    }
                }
            }
        }


        System.out.println("\n----- RESULTS NORMAL WRITING -----");
        try(BufferedWriter br = new BufferedWriter(new FileWriter("results.txt",true))){

            int rank = 1;
            for(Students student:students){
                String line = rank + ") "
                        + student.getName() + " "
                        + student.getSurname()
                        + " - GPA: "
                        + String.format("%.2f", student.calculateGPA());

                System.out.println(line);
                br.write(line);
                br.newLine();

                rank++;

            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }



        System.out.println("\n----- RESULTS OBJECT WRITING -----");

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("results.dat"))) {

            oos.writeObject(students);
            System.out.println("Students successfully written to file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



//        System.out.println("\n----- RESULTS OBJECT WRITING -----");
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("results.dat",true)))
//        {
//            int rank = 1;
//            for(Students student:students){
//                String line = rank + ") "
//                        + student.getName() + " "
//                        + student.getSurname()
//                        + " - GPA: "
//                        + String.format("%.2f", student.calculateGPA());
//
//                System.out.println(line);
//                oos.writeObject(students);
//                oos.writeObject("\n");
//                System.out.println("Students successfully written to file.");
//
//                rank++;
//
//            }
//
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }




    }


}