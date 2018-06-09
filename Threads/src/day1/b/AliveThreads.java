package day1.b;

import java.util.Random;
import java.util.concurrent.TimeUnit;


////  task 3 ////
public class AliveThreads extends Thread{

    @Override
    public void run(){
        System.out.println("Working " + Thread.currentThread().getName());
        Random random = new Random();
        int time = random.nextInt(10)+1;

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AliveThreads t1 = new AliveThreads();
        AliveThreads t2 = new AliveThreads();
        AliveThreads t3 = new AliveThreads();
        AliveThreads t4 = new AliveThreads();
        AliveThreads t5 = new AliveThreads();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        while (true){
            System.out.println(String.format("Thread %s isAlive - %s", t1.getName(), t1.isAlive()));
            System.out.println(String.format("Thread %s isAlive - %s", t2.getName(), t2.isAlive()));
            System.out.println(String.format("Thread %s isAlive - %s", t3.getName(), t3.isAlive()));
            System.out.println(String.format("Thread %s isAlive - %s", t4.getName(), t4.isAlive()));
            System.out.println(String.format("Thread %s isAlive - %s", t5.getName(), t5.isAlive()));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
