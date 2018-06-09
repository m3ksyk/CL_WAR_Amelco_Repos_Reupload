package pl.coderslab;

public class Car extends Vehicle{
    String type;

    public Car(String model, int maxSpeed, String type) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.setType(type);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
