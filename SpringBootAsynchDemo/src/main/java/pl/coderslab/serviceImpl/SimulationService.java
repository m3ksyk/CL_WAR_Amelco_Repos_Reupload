package pl.coderslab.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.coderslab.service.UserService;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class SimulationService {
    @Autowired
    UserService userService;

//    @Scheduled(fixedRate =  1000)
    @Scheduled(cron = "*/6 * * 1/1 * ?")
    public void simulate(){
        System.out.println(LocalDateTime.now()  + " : " + Thread.currentThread().getName() + " " +  userService.getUsers().toString());
    }
}
