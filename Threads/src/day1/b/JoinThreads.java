package day1.b;

import java.util.concurrent.TimeUnit;

////  task 4  ////
public class JoinThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            System.out.println("t1. I'm working...");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {

            System.out.println("t2. I'm working...");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {

            System.out.println("t3. I'm working...");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t3.start();

        System.out.println("All threads done");
    }
}
