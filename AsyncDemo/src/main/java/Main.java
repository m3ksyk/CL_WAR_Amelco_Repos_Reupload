import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()){

            context.register(AppConfig.class);
        context.refresh();


        final UserService userService = context.getBean(UserService.class);


        System.out.println("Start " + Thread.currentThread().getName());
        userService.returnUserInfo();

        final Future<List<Integer>> userIds = userService.getUserIds();
            try {
                final List<Integer> ids = userIds.get();
                ids.forEach(System.out::println);
            } catch (InterruptedException | ExecutionException  e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish " + Thread.currentThread().getName());

    }
}
