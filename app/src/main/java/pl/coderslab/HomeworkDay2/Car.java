package pl.coderslab.HomeworkDay2;

import pl.coderslab.interfejsy.Moveable;

public class Car implements Moveable, Inspectionable {
    String type;
    String model;
    int maxSpeed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String model, int maxSpeed, String type) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.setType(type);

    }
    @Override
    public void start() {
        System.out.println("Car drives");
    }

    @Override
    public void stop() {
        System.out.println("car stops");
    }

    @Override
    public void createInspection() {
        //Model: <nazwa modelu> - sprawdzony.
        System.out.println("Model: " + this.getModel() + " inspected");
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
