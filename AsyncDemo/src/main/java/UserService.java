import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class UserService {

    @Async("burak")
    public void returnUserInfo(){
        System.out.println("User info: printing... " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("User info: Finished printing. " + Thread.currentThread().getName());

    }
    @Async("ziemniak")
    public Future<List<Integer>> getUserIds(){

        System.out.println("User ids: printing... " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final List<Integer> userIds = Arrays.asList(1,2,3,4,5,6,9);
        System.out.println("User ids: Finished printing. " + Thread.currentThread().getName());
        return new AsyncResult<List<Integer>>(userIds);
    }
}
