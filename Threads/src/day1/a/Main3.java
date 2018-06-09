package day1.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

////  task 3  ////
public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of threads");
        int threadsNum = scanner.nextInt();
        List<MyRunnable> list = new ArrayList<>();
        for(int i = 0; i < threadsNum; i++){
            System.out.println("Input thread sleep time");
            int sleepTime = scanner.nextInt();

            System.out.println("Input name of thread");
            String threadName = scanner.next();

            list.add(new MyRunnable(threadName, sleepTime));
        }
        for (MyRunnable mr : list) {
            new Thread(new MyRunnable(mr.getName(), mr.getSleepTime()), mr.getName()).start();
        }

    }
}

class MyRunnable implements Runnable{
    int sleepTime;
    String name;

    public MyRunnable(String name, int sleepTime){
        this.name = name;
        this.sleepTime = sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        boolean flag = true;
        while(flag == true) {
            System.out.println("Thread name: " + name);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish thread: " + name);
            flag = false;
        }
    }
}
