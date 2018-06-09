package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.bean.Auto1;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Auto1 auto1 = context.getBean(Auto1.class);
        System.out.println(auto1.getAuto2().getClass().getName());
    }
}
