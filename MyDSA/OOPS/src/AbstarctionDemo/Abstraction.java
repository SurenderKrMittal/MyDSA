import java.util.*;

public class Abstraction {
    public static void main(String[] args) {
        Horse myHorse = new Horse();
        System.out.println(myHorse.color);

        Chicken ch = new Chicken();
        ch.changeColor("Yellow");
        System.out.println(ch.color);

        Mustang mus = new Mustang();

        Bear b = new Bear();
        b.color = "Brown";
        System.out.println(b.color);
        b.eat();

        Student s1 = new Student();
        s1.schoolname = "DAV";
        float ans1 = s1.percentage(95 , 96 , 97);
        Student s2 = new Student();
        System.out.println(s2.schoolname);
        float ans2 = s2.percentage(99, 98, 97);
        System.out.println(ans2);

    }
}

class Student {
    String name;
    int rollno;
    static String schoolname;
    static float percentage(int math , int chem , int phy) {
        return (float)((math + chem + phy) / 3);
    }
}

interface Herbivore {
    void eat();
}

interface Carnivore {
    void eat();
}

class Bear implements Herbivore , Carnivore {
    String color;
    public void eat() {
        System.out.println("eats anything");
    } 
}

abstract class Animal {
    String color;
    Animal() {
        System.out.println("Animal constructor is called");
        color = "brown";
    }
    abstract void changeColor(String color);

}

class Horse extends Animal {
    Horse() {
        super.color = "White";
        System.out.println("Horse constructor is called");
    }
    void changeColor(String color) {
        this.color = color;
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor is called");
    }
}

class Chicken extends Animal {
    void changeColor(String color) {
        this.color = color;
    }
}
