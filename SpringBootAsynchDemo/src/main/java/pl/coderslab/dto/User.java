package pl.coderslab.dto;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String surname;
    int age;

    public User(String name, String surname, int age) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
