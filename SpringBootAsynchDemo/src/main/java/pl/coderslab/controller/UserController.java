package pl.coderslab.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.User;
import pl.coderslab.service.UserService;

import java.awt.print.Book;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class UserController {

    private final Gson gson = new Gson();
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getUsers(){
        List<User> list = userService.getUsers();
        final String result = gson.toJson(list);
        return result;
    }

    @GetMapping("/books")
    public String getBook(final @RequestParam("id") int userId){
        userService.authorize();
        userService.doSth();
        Future<List<Book>> future = userService.getBooks(userId);

        List<Book> books = null;
        try {
            books = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        final String result = "books " + gson.toJson(books);
        return result;

    }
}
