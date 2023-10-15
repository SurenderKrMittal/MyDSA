public class Polymorphism {
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(2,3));
        System.out.println(calc.sum(2.5f,3.5f));
        System.out.println(calc.sum(1,2,3));

        Deer d1 = new Deer();
        d1.eat();
    }
}

class Animal {
    void eat() {
        System.out.println("eats anything");
    }
}

class Deer {
    void eat() {
        System.out.println("eats grass"); // meathod overriding
    }
}

class Calculator {

    int sum(int a , int b) {  // method overloading
        return a + b;
    }

    float sum(float a , float b) {  // method overloading
        return a + b;
    }

    int sum (int a , int b , int c) {  // method overloading
        return a + b + c;
    }
}
