package pl.coderslab.interfejsy;

public class Main1 {
    public static void main(String[] args) {
        Moveable[] moveableTab = new Moveable[3];
        moveableTab[0] = new Car();
        moveableTab[1] = new Cat();
        moveableTab[2] = new Person();

        for (Moveable m : moveableTab) {
            m.start();
        }
    }
}
