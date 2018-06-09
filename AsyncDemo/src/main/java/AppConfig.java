import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AppConfig {

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean(name = "ziemniak")
    public Executor threadPoolTaskExecutor(){

        final ThreadPoolTaskExecutor executor = new  ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Custom-potato");
        executor.setDaemon(true);
        return executor;
    }
    @Bean(name = "burak")
    public Executor threadPoolTaskExecutor2(){

        final ThreadPoolTaskExecutor executor = new  ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Custom-beetroot");
        executor.setDaemon(true);
        return executor;
    }
}
