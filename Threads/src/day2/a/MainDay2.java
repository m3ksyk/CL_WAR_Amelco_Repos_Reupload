package day2.a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainDay2 {
    public static void main(String[] args) {

        BlockingQueue queue = new ArrayBlockingQueue(1024);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();

        while (true){
            System.out.println("Queue size: " + queue.size());
        }
    }
}

