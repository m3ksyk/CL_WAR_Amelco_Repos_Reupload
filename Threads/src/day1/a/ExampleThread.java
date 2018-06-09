package day1.a;

import java.util.Random;

////  task 1 ////
public class ExampleThread extends Thread{

    @Override
    public void run(){
        boolean flag = true;
        while(flag == true) {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            Random random = new Random();
            int rand = random.nextInt(3000) + 2000;
                try {
                    Thread.sleep(rand);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("finish thread: " + Thread.currentThread().getName());
                flag = false;
            }
    }
}

