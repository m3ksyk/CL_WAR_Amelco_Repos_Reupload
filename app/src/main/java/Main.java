import pl.coderslab.Car;
import pl.coderslab.Train;
import pl.coderslab.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[2];
        Car car = new Car("UAZ 469B", 80, "4x4");
        Train train = new Train("EP-07", 160, 1435);
        vehicles[0] = car;
        vehicles[1] = train;

        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}
