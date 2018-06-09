package pl.coderslab.interfejsy;

public class Person implements Moveable {
    @Override
    public void start() {
        System.out.println("person walks");
    }

    @Override
    public void stop() {

    }
}
