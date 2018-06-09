package pl.coderslab.wzorce;

public class PublishSubscriber implements Observer{
    public void update(){
        System.out.println("Blog post added. Like anybody is reading it...");
    }
}
