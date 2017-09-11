package stepik.exersices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.reverseOrder;

public class ComparatorAndComposition {
    public static Student createStudent(String name, int grade) {
        return new Student(name,grade);
    }

    public static List<Student> students() {
        List<Student> students = new ArrayList<>();
        students.add(createStudent("Mary", 82));
        students.add(createStudent("John", 100));
        students.add(createStudent("Alisa", 100));
        students.add(createStudent("Francis", 85));
        students.add(createStudent("Vladimir", 94));
        students.add(createStudent("Antonio", 85));
        students.add(createStudent("Elizabet", 97));

        return students;
    }

    public static void main(String[] args) {
        List<Student> list = students();
        System.out.println(list);
        list.sort(Comparator.comparing(Student::getCsGrade, reverseOrder()).thenComparing(Student::getName));
        System.out.println(list);
    }
}

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCsGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
