package day1.a;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    ////  task 1 ////
//        Thread thread = new ExampleThread();
//	    thread.setName("myThread 1");
//	    thread.start();
//
//        Thread thread2 = new ExampleThread();
//        thread2.setName("myThread 2");
//        thread2.start();
//
//        Thread thread3 = new ExampleThread();
//        thread3.setName("myThread 3");
//        thread3.start();

        ////  task 2  ////
//        Thread anonThread = new Thread(){
//            @Override
//            public void run(){
//                boolean flag = true;
//                while(flag == true) {
//                    System.out.println("Thread name: " + Thread.currentThread().getName());
//                    Random random = new Random();
//                    int rand = random.nextInt(3000) + 2000;
//                    try {
//                        Thread.sleep(rand);
//                    } catch (InterruptedException day1.e) {
//                        day1.e.printStackTrace();
//                    }
//                    System.out.println("finish thread: " + Thread.currentThread().getName());
//                    flag = false;
//                }
//            }
//        };
//        anonThread.start();

        //task 4
        Runnable myRunnable = () -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            Random random = new Random();
            int rand = random.nextInt(3000) + 2000;
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish thread: " + Thread.currentThread().getName());

        };
        Thread thread = new Thread(myRunnable);
        thread.start();


    }
}
