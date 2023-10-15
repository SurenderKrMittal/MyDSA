public class Inheritance {

    public static void main (String[] args) {

        Dog tommy = new Dog();
        tommy.eat();
        tommy.legs = 4;
        System.out.println(tommy.legs);

        Bird sparrow = new Bird();
        sparrow.eat();
        
        Fish shark = new Fish();
        shark.breath();

        Human Titu = new Human();
        Titu.intellect();
    }
    
}

class Animal {
    String skinColor;

    void eat() {
        System.out.println("Eats");
    }

    void breath() {
        System.out.println("Breathes");
    }
}

class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("Flies");
    }
}

class Mammal extends Animal {
    int legs;
    void walk() {
        System.out.println("Walks");
    }
}

class Tuna extends Fish {
    int price;
}

class Whale extends Fish {
    int size;
} 

class Peacock extends Bird {
    int feathers;
    void dance() {
        System.out.println("Dances");
    }
}

class Dog extends Mammal {
    String breed;
}

class Cat extends Mammal {
    void nightvision() {
        System.out.println("Has night vision");
    }
}

class Human extends Mammal {
    void intellect() {
        System.out.println("Has intellect");
    }
}
