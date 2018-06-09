package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.bean.HelloWorld;
import pl.coderslab.bean.Scope1;
import pl.coderslab.bean.Scope2;
import pl.coderslab.bean.Ship;

public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld = ctx.getBean("helloWorld", HelloWorld.class);
        helloWorld.hello();

        Ship ship = ctx.getBean("blackPearl", Ship.class);
        ship.getCaptain().startSailing();

        Scope1 scope1 = ctx.getBean(Scope1.class);
        System.out.println(scope1);
        Scope1 scope11 = ctx.getBean(Scope1.class);
        System.out.println(scope11);
        Scope2 scope2 = ctx.getBean(Scope2.class);
        System.out.println(scope2);
        Scope2 scope22 = ctx.getBean(Scope2.class);
        System.out.println(scope22);
    }
}
