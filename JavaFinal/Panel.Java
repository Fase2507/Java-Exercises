package JavaFinal;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Panel{
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("=== Student Control Panel ===");
        System.out.println("What do you want to do ?");
        System.out.println("1. Add Student into system");
        System.out.println("2. Show Student list");
        System.out.println("3. Search Student name by number");

        Major major = new Major();
        List<Students> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

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

                        System.out.println("Genel ortalama: "+student.calculateGPA());


                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gecersiz harf notu.");
                    }
                }
            }
        }



    }
}