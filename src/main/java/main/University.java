package main;

import java.io.*;
import java.util.*;

class University {
    private List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByNumber(String studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            @SuppressWarnings("unchecked")
            List<Student> loadedStudents = (List<Student>) ois.readObject();
    
            students.clear();
            students.addAll(loadedStudents); 
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
