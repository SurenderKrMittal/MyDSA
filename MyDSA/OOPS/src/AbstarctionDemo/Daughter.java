package AbstarctionDemo;

public class Daughter extends Parent{
    Daughter(int age){
        super(age);
    }

    @Override
    void career() {
        System.out.println("Doctor");
    }

}
