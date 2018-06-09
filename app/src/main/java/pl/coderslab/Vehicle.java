package pl.coderslab;

public abstract class Vehicle {
    int maxSpeed;
    String model;

    @Override
    public String toString() {
        return " model: " + this.model + " maxSpeed: " + this.maxSpeed;

    }
}
