package pl.coderslab.wzorce;

public class SubscriberObserver implements Observer{
    @Override
    public void update() {
        System.out.println("Oi! new stuff is out lads.");
    }
}
