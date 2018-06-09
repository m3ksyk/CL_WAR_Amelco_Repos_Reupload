package pl.coderslab.sampleboot.service;

import pl.coderslab.sampleboot.entity.User;

public interface UserService {
    public User findByUserName(String name);

    public void saveUser(User user);
}
