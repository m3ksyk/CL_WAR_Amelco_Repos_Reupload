package day1.b;

import java.util.concurrent.TimeUnit;

public class DaemonMain2 {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            System.out.println("I'm working...");

            try {
                TimeUnit.DAYS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
