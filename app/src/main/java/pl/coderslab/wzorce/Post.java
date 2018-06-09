package pl.coderslab.wzorce;

import java.util.ArrayList;

public class Post implements pl.coderslab.wzorce.Subject {
    private ArrayList<pl.coderslab.wzorce.Observer> observers;


    public Post(ArrayList<pl.coderslab.wzorce.Observer> observers) {

        this.observers = observers;
    }

    @Override
    public void attach(pl.coderslab.wzorce.Observer observer) {

        observers.add(observer);
    }

    @Override
    public void dettach(pl.coderslab.wzorce.Observer observer) {

        observers.remove(observer);
    }

    @Override
        public void notifyObservers() {
            for (pl.coderslab.wzorce.Observer observer : observers) {
                observer.update();
            }
        }

}
