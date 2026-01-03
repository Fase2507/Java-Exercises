package JavaFinal;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Panel {
    static class ResultLine {
        String line;
        double gpa;

        ResultLine(String line, double gpa) {
            this.line = line;
            this.gpa = gpa;
        }
    }

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Major major = new Major();
        List<Students> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();


        registerMajor(major);
        registerStudents(students, major);
        registerCourses(courses);
        enterGrades(students, courses);

        normalWriting(students);
        objectWriting(students);


        objectReading();
        normalReading();

        searchStudent();
    }
    /*--OBJECT READING WITH SORTING ----*/
    static void objectReading(){
        System.out.println("\n----- RESULTS OBJECT READING (SORTED BY GPA & NAME) -----");

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("results.dat"))) {

            List<Students> loadedStudents =
                    (List<Students>) ois.readObject();

            loadedStudents.sort((s1, s2) -> {
                int gpaCompare = Double.compare(
                        s2.calculateGPA(),
                        s1.calculateGPA()
                );

                if (gpaCompare != 0)
                    return gpaCompare;

                // GPA eşitse alfabetik sıralama
                String fullName1 = s1.getName() + " " + s1.getSurname();
                String fullName2 = s2.getName() + " " + s2.getSurname();

                return fullName1.compareToIgnoreCase(fullName2);
            });

            int rank = 1;
            for (Students student : loadedStudents) {
                System.out.println(rank++ + ") "
                        + student.getName() + " "
                        + student.getSurname() + " "
                        + student.getStudentNum() + " "
                        + String.format("%.2f", student.calculateGPA()));
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }


    /*--Normal READING WITH SORTING ----*/
    static void normalReading(){
        System.out.println("\n----- RESULTS NORMAL READING (SORTED BY GPA) -----");

        List<ResultLine> resultLines = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("results.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (line.contains("GPA:")) {

                    // "GPA:" dan sonrasını al
                    String afterGpa = line.substring(line.indexOf("GPA:") + 4).trim();

                    // Sadece ilk token (GPA değeri)
                    String gpaStr = afterGpa.split("\\s+")[0];

                    gpaStr = gpaStr.replace(",", "."); // TR locale fix

                    double gpa = Double.parseDouble(gpaStr);

                    resultLines.add(new ResultLine(line, gpa));
                }
            }
            // GPA'ya göre AZALAN sıralama
            resultLines.sort((r1, r2) ->
                    Double.compare(r2.gpa, r1.gpa));

            int rank = 1;
            for (ResultLine r : resultLines) {
                System.out.println(rank++ + ") " + r.line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }



    /* ---------------- MAJOR REGISTRATION ---------------- */
    static void registerMajor(Major major) {

        System.out.println("Enter major informations");

        while (true) {
            try {
                System.out.print("Major: ");
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
    }

    /* ---------------- STUDENT REGISTRATION ---------------- */
    static void registerStudents(List<Students> students, Major major) {

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
    }

    /* ---------------- COURSE REGISTRATION ---------------- */
    static void registerCourses(List<Course> courses) {

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
    }

    /* ---------------- GRADE ENTRY ---------------- */
    static void enterGrades(List<Students> students, List<Course> courses) {

        for (Students student : students) {
            System.out.println("\n" + student.getName() + " " + student.getSurname()
                    + " tum ders sonuclarini giriniz.");

            for (Course course : courses) {
                while (true) {
                    try {
                        System.out.print(course.getName()
                                + " dersi icin harf notu (AA, BA, ...): ");

                        LetterGrade letterGrade =
                                LetterGrade.valueOf(keyboard.nextLine().toUpperCase());

                        student.getCourseScores().put(course, letterGrade.getValue());

                        System.out.printf("Genel ortalama: %.2f \n",
                                student.calculateGPA());
                        break;

                    } catch (IllegalArgumentException e) {
                        System.out.println("Gecersiz harf notu.");
                    }
                }
            }
        }
    }

    /* ---------------- NORMAL WRITING ---------------- */
    static void normalWriting(List<Students> students) {

        System.out.println("\n----- RESULTS NORMAL WRITING -----");

        try (BufferedWriter br =
                     new BufferedWriter(new FileWriter("results.txt", true))) {


            for (Students student : students) {

                String line =
                         student.getName() + " "
                        + student.getSurname()
                        + " - GPA: "
                        + String.format("%.2f", student.calculateGPA()) + " "
                        + student.getStudentNum();

                System.out.println(line);
                br.write(line);
                br.newLine();

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /* ---------------- OBJECT WRITING ---------------- */
    static void objectWriting(List<Students> students) {

        System.out.println("\n----- RESULTS OBJECT WRITING -----");

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("results.dat"))) {

            oos.writeObject(students);
            System.out.println("Students successfully written to file.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void searchStudent() {

        HashMap<Long, Students> studentMap = new HashMap<>();

        // 1️⃣ Dosyadan oku
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("results.dat"))) {

            List<Students> loadedStudents =
                    (List<Students>) ois.readObject();

            // 2️⃣ HashMap doldur
            for (Students student : loadedStudents) {
                studentMap.put(student.getStudentNum(), student);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Student data could not be loaded.");
            return;
        }

        // 3️⃣ Kullanıcıdan öğrenci numarası al
        System.out.print("Enter student number to search: ");

        try {
            long studentNumber = Long.parseLong(keyboard.nextLine());

            if (!studentMap.containsKey(studentNumber)) {
                throw new StudentNotFoundException(
                        "Student not found with number: " + studentNumber
                );
            }

            Students foundStudent = studentMap.get(studentNumber);

            System.out.println("\n--- STUDENT FOUND ---");
            System.out.println(foundStudent);

        } catch (NumberFormatException e) {
            System.out.println("Invalid student number format.");

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
