package day1.c;

import java.util.concurrent.TimeUnit;
////  task 1  ////
public class CounterMain {
//threadlocal provides day1.a local copy of counter to each thread!!
    private static final ThreadLocal<Integer> COUNTER = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        new Thread(new Worker(), "thread1").start();
        new Thread(new Worker(), "thread2").start();
        new Thread(new Worker(), "thread3").start();
    }

    static class Worker implements Runnable{
        @Override
        public void run(){
            while(true){
                System.out.println(String.format("%s - counter before incrementation %day1.d ",
                        Thread.currentThread().getName(), COUNTER.get()));

                COUNTER.set(COUNTER.get()+1);

                System.out.println(String.format("%s - counter after incrementation %day1.d ",
                        Thread.currentThread().getName(), COUNTER.get()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
