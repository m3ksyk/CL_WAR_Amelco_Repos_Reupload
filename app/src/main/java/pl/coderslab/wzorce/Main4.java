package pl.coderslab.wzorce;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) {

        //ex 4 test
        ArrayList<Observer> list = new ArrayList<>();

        Post post = new Post(list);
        list.add(new SubscriberObserver());
        list.add(new FacebookObserver());
        list.add(new PublishSubscriber());

        post.notifyObservers();

        post.attach(new SubscriberObserver());
        post.dettach(new PublishSubscriber());
    }
}
