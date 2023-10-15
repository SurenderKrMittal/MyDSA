import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student[] students = new Student[5];

        Student student1 = new Student(1 , "Titu" , 51.5f);
        System.out.println(student1.name);
        students[0] = student1;
        System.out.println(Arrays.toString(students));
    }
}

class Student {
    int rollno;
    String name;
    float marks;

    Student(int rollno , String name , float marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    Student(Student other) {
        this.rollno = other.rollno;
        this.name = other.name;
        this.marks = other.marks;
    }

    Student() {
        this (123 , "default name" , 12.0f);
    }
}
