package day1.a;

public class Main2 {

    ////  task5  ////
    public static void main(String[] args) {
       Thread thread =  new Thread(() -> {
            System.out.println("Working");
            try {
                System.out.println("tryin to sleep for 5");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted at 5!!");
                e.printStackTrace();
            }
        });
        thread.start(); //my thread starts

        try {
            System.out.println("tryin to sleep for 2");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Thread interrupted at 2");
        }
        thread.interrupt();
    }
}
