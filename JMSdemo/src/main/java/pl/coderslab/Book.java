package pl.coderslab;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1336618159361713256L;

    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "pl.coderslab.Book [title=" + title + ", author=" + author + "]";
    };
}