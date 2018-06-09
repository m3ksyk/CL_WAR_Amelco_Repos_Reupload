package pl.coderslab;

public class Train extends Vehicle {
    int trackWidth;

    public Train(String model, int maxSpeed,int trackWidth) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.trackWidth = trackWidth;

    }

    public int getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(int trackWidth) {
        this.trackWidth = trackWidth;
    }
}
