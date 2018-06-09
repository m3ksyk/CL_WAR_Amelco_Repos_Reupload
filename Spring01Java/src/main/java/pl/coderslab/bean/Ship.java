package pl.coderslab.bean;

public class Ship {
    private Captain captain;

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public Ship(Captain captain) {

        this.captain = captain;
    }


}
