import java.util.*;

public class Encapsulation {

    public static void main(String[] args) {
        Student s1 = new Student("Surender Kumar Mittal" , 465511);
        s1.marks[0] = 100;
        s1.marks[1] = 98;
        s1.marks[2] = 50;
        System.out.println(s1.name);
        System.out.println(s1.rollno);
        System.out.println(Arrays.toString(s1.marks));
        Student s2 = new Student(s1);
        s1.marks[2] = 99;
        System.out.println(s2.name);
        System.out.println(s2.rollno);
        System.out.println(Arrays.toString(s2.marks));
    }
    
}
class Student {
    String name;
    int rollno; 
    int[] marks = new int[3];

    Student() { // non parameterized constructor
         System.out.println ("Constuctor is called...");
    }

    // Student(Student s) {  // copy constructor (shallow copy)
    //     this.name = s.name;
    //     this.rollno = s.rollno;
    //     this.marks = s.marks;
    // }

    Student(Student s) { // deep copy
        this.name = s.name;
        this.rollno = s.rollno;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s.marks[i];
        }
    }

    Student(String name) { // parametrized constructor
        this.name = name;
    }

    Student(int rollno) { // parametrized constructor
        this.rollno = rollno;
    }

    Student(String name , int rollno) { // parametrized constructor
        this.name = name;
        this.rollno = rollno;
    }
}

class Pen {
    private String color;
    private int tip;

    String getColor(){
        return this.color; // this keywords refers to the current object
    }

    void setColor (String color) {
        this.color = color;
    }

    int getTip() {
        return this.tip;
    }

    void setTip (int tip) {
        this.tip = tip;
    }
}

class BankAccount {
    protected String username;
    private int password;

    public void changePassword (int newPassword) {
        password = newPassword;
    }
}
