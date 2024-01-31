import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        boolean exit = false;

        while (!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            int choice = 0;
            if (scanner.hasNext()) {
                String stringInput = scanner.nextLine();
                try {
                    choice = Integer.parseInt(stringInput);
                } catch (NumberFormatException e) {
                    System.out.println("Virheellinen syöte. Anna numero.");
                    continue;  // Jatka takaisin valintaan
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String name = scanner.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = scanner.nextLine();
                    university.addStudent(new Student(name, studentNumber));
                    break;

                case 2:
                    System.out.println("Opiskelijat:");
                    List<Student> students = university.getStudents();
                    for (int i = 0; i < students.size(); i++) {
                        Student student = students.get(i);
                        System.out.println(student.getName());
                    }
                    break;

                case 3:
                    List<Student> studentsForAddGrade = university.getStudents();
                    for (int i = 0; i < studentsForAddGrade.size(); i++) {
                        Student student = studentsForAddGrade.get(i);
                        System.out.println(i + ": " + student.getName());
                    }
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    int studentIndex = scanner.nextInt();
                    scanner.nextLine();
                    Student selectedStudent = university.getStudents().get(studentIndex);

                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = scanner.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int grade = scanner.nextInt();
                    selectedStudent.addGrade(course, grade);
                    break;

                case 4:
                    List<Student> studentsForListGrades = university.getStudents();
                    for (int i = 0; i < studentsForListGrades.size(); i++) {
                        Student student = studentsForListGrades.get(i);
                        System.out.println(i + ": " + student.getName());
                    }

                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    int studentIndexForListGrades = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Student selectedStudentForListGrades = university.getStudents().get(studentIndexForListGrades);

                    List<Grade> grades = selectedStudentForListGrades.getGrades();
                    for (Grade gradeItem : grades) {
                        System.out.println(gradeItem.getCourse() + ": " + gradeItem.getGrade());
                    }
                    break;

                case 5:
                    List<Student> studentsForAvg = university.getStudents();
                    for (int i = 0; i < studentsForAvg.size(); i++) {
                        Student student = studentsForAvg.get(i);
                        System.out.println(i + ": " + student.getStudentNumber() + ": " + student.getName());
                    }
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    int studentIndexForAvg = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Student studentForAvg = university.getStudents().get(studentIndexForAvg);
                    double average = Calculator.getAverageGrade(studentForAvg);
                    System.out.println("Keskiarvo on " + average);
                    break;

                case 6:
                    System.out.println("Opiskelijat:");
                    List<Student> studentsForMedian = university.getStudents();
                    for (int i = 0; i < studentsForMedian.size(); i++) {
                        Student student = studentsForMedian.get(i);
                        System.out.println(i + ": " + student.getStudentNumber() + ": " + student.getName());
                    }

                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    int studentIndexForMedian = scanner.nextInt();
                    scanner.nextLine();
                    Student studentForMedian = university.getStudents().get(studentIndexForMedian);
                    double median = Calculator.getMedianGrade(studentForMedian);
                    System.out.println("Mediaani on " + median);
                    break;

                case 7:
                    university.saveToFile();
                    break;

                case 8:
                    university.loadFromFile();
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    break;

                default:
                    System.out.println("Syöte oli väärä.");
                    break;
            }
        }
        scanner.close();
    }
}
