package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import pl.coderslab.bean.Auto1;
import pl.coderslab.bean.Auto2;

@ComponentScan(basePackages = {"pl.coderslab.bean"})
public class AppConfig {
//    @Bean
//    public Auto1 auto1() {
//        return new Auto1(auto2());
//    }
//    @Bean
//    public Auto2 auto2() {
//        return new Auto2();
//    }
}
