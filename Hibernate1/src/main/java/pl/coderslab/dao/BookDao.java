package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book entity) {

        entityManager.merge(entity);
    }
    public void delete(long id) {
        Book entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<Book> readAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b ");
        List<Book> books = query.getResultList();
        return books;
    }
    public List<Book> getRatingList(int rating){
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b where rating >:rating");
        queryp.setParameter("rating", rating);
        List<Book> booksp = queryp.getResultList();
        return booksp;
    }
    public List<Book> getAllpropositions(){
        List<Book> books = readAll();
        List<Book> props = new ArrayList<>();
        for (Book b : books) {
            if (b.isProposition()){
                props.add(b);
            }
        }
        return props;

    }
}