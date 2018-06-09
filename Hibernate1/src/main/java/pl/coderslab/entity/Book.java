package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.interfaces.BookGroupInterface;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "books")
public class Book {
    @Id
    @NotNull(groups = {Default.class, BookGroupInterface.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(groups = {Default.class, BookGroupInterface.class})
    @Size(min = 5)
    private String title;

    @NotEmpty(groups = { BookGroupInterface.class})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();

    @Min(value = 1, groups = { BookGroupInterface.class})
    @Max(value = 10, groups = { BookGroupInterface.class})
    private int rating;

    @NotNull(groups = { BookGroupInterface.class})
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;

    @NotNull(groups = {Default.class, BookGroupInterface.class})
    @Size(max = 600)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Min(value = 1, groups = { BookGroupInterface.class})
    private int pages;

    @NotNull(groups = {Default.class, BookGroupInterface.class})
    boolean proposition;

    public Book() {
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", rating=" + rating +
                ", publisher=" + publisher +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                '}';
    }
}
