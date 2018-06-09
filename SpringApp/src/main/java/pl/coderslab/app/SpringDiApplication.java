package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.EmailService;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;

public class SpringDiApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld hi = (HelloWorld) context.getBean("helloWorld");
        System.out.println(hi.getMessage());

        EmailService es = (EmailService) context.getBean("emailService");
        es.send();
        MessageSender ms = (MessageSender) context.getBean("messageSender");
        ms.sendMessage();
        ms.sendMessageFromProperty();
        context.close();
    }
}
