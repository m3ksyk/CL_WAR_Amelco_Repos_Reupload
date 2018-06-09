package day1.b;

import java.util.concurrent.TimeUnit;

public class TimeUnitMain {
    public static void main(String[] args) {
        Thread thread = new Thread();
	    thread.setName("myThread 1");
        thread.setDaemon(true);
	    thread.start();
	    try {
            System.out.println("Going to sleep");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");

    }
}
