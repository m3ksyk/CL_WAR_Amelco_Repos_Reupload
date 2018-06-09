package day2.a;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {

        try {

//            queue.put("1");
//            Thread.sleep(1000);
//            queue.put("2");
//            Thread.sleep(2000);
//            queue.put("3");

            while (true){
                Random random = new Random();
                int e = random.nextInt(10) +1;
                queue.put(e);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
