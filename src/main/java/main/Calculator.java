package main;

class Calculator {
    public static double getAverageGrade(Student student) {
        return student.calculateAverageGrade();
    }

    public static double getMedianGrade(Student student) {
        return student.calculateMedianGrade();
    }
}
