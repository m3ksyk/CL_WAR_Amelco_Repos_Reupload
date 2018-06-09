package day1.a;

////  task 6  ////
public class DaemonMain {
    public static void main(String[] args) {
        Thread thread =  new Thread(() -> {
            System.out.println("It's day1.a daemon");

        });
        thread.setDaemon(true);
        thread.start();
        System.out.println(thread.isDaemon());
    }
}
