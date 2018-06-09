package pl.coderslab.service;

import pl.coderslab.dto.User;

import java.awt.print.Book;
import java.util.List;
import java.util.concurrent.Future;

public interface UserService {
    List<User> getUsers();

    void authorize();

    void doSth();

    Future<List<Book>> getBooks(int userId);
}
