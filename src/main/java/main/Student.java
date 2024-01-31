package main;
import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name;
    private String studentNumber;
    private List<Grade> grades;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(String course, int grade) {
        grades.add(new Grade(course, grade));
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        return (double) sum / grades.size();
    }

    public double calculateMedianGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        List<Integer> sortedGrades = new ArrayList<>();
        for (Grade grade : grades) {
            sortedGrades.add(grade.getGrade());
        }

        Collections.sort(sortedGrades);

        int size = sortedGrades.size();
        if (size % 2 == 0) {
            int middle1 = sortedGrades.get(size / 2 - 1);
            int middle2 = sortedGrades.get(size / 2);
            return (double) (middle1 + middle2) / 2;
        } else {
            return (double) sortedGrades.get(size / 2);
        }
    }
}
