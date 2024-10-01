package main;

import models.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Створення масиву студентів
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Іваненко", "Іван", "Іванович", LocalDate.of(2000, 5, 15), "Київ, вул. Шевченка 10", "123456789", "Фізико-математичний", 2, "ФМ-21"));
        students.add(new Student(2, "Петренко", "Петро", "Петрович", LocalDate.of(1998, 10, 22), "Львів, вул. Франка 20", "987654321", "Інформатика", 3, "ІН-31"));
        students.add(new Student(3, "Сидоренко", "Марія", "Сергіївна", LocalDate.of(2001, 3, 30), "Одеса, вул. Дерибасівська 1", "456789123", "Фізико-математичний", 1, "ФМ-11"));

        // Виведення студентів за факультетом
        System.out.println("Студенти факультету 'Фізико-математичний':");
        printStudentsByFaculty(students, "Фізико-математичний");

        // Виведення студентів, народжених після 1999 року
        System.out.println("\nСтуденти, які народились після 1999 року:");
        printStudentsBornAfterYear(students, 1999);

        // Виведення студентів певної групи
        System.out.println("\nСтуденти групи 'ФМ-21':");
        printStudentsByGroup(students, "ФМ-21");
        
    }

    // Метод для виведення студентів заданого факультету
    public static void printStudentsByFaculty(List<Student> students, String faculty) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
    }

    // Метод для виведення студентів, народжених після заданого року
    public static void printStudentsBornAfterYear(List<Student> students, int year) {
        for (Student student : students) {
            if (student.getBirthDate().getYear() > year) {
                System.out.println(student);
            }
        }
    }

    // Метод для виведення студентів певної групи
    public static void printStudentsByGroup(List<Student> students, String group) {
        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                System.out.println(student);
            }
        }
    }
}
