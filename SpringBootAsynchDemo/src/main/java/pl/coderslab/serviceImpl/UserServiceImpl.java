package pl.coderslab.serviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.User;
import pl.coderslab.service.UserService;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<User> list = new ArrayList<>();
            User u1 = new User("John", "Doe", 25);
            User u2 = new User("Jane", "Doe", 25);
            list.add(u1);
            list.add(u2);

        return list;
    }
    @Async
    @Override
    public void authorize() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Async
    @Override
    public void doSth() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Async
    @Override
    public Future<List<Book>> getBooks(int userId) {
        List<Book> books = Collections.emptyList();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<List<Book>>(books);
    }
}
