package pl.coderslab.interfejsy;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Moveable> moveableList = new ArrayList<>();
        moveableList.add( new Car());
        moveableList.add( new Cat());
        moveableList.add( new Person());

        for (Moveable m : moveableList) {
            m.start();
        }

    }
}
