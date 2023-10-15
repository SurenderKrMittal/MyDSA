package AbstarctionDemo;

public class Son extends Parent{

    Son(int age) {
        super( age);
    }

    @Override
    void career() {
        System.out.println("Engineer");
    }
}
