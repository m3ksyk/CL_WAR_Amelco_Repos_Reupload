package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import pl.coderslab.bean.*;

@ComponentScan(basePackages = {"pl.coderslab.bean"})
public class AppConfig {

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
    @Bean
    public Captain jackSparrow() {
        return new Captain();
    }

    @Bean
    public Ship blackPearl() {
        return new Ship(jackSparrow());
    }
    @Bean
    public Scope1 scope1(){
        return new Scope1();
    }
    @Bean
    @Scope("prototype")
    public Scope2 scope2(){
        return new Scope2();
    }

}
