package pl.coderslab.HomeworkDay2;


import pl.coderslab.Train;
import pl.coderslab.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MainHW4 {
    public static void main(String[] args) {


        List<Car> carList = new ArrayList<>();
        Car car = new Car("GAZ 69", 80, "4x4");
        Car car1 = new Car("GAZ 67", 80, "4x4");
        Car car2 = new Car("KRAZ 255", 80, "4x4 truck");
        Car car3 = new Car("UAZ 469B", 80, "4x4");

        carList.add(car);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
            for (Car c : carList) {
            System.out.println(c.toString());
            c.createInspection();
        }
    }
}
