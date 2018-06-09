package pl.coderslab.wzorce;

public class FacebookObserver implements Observer {
    @Override
    public void update() {
        System.out.println("Oi! 'E's postin' stuff");
    }
}
