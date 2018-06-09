package pl.coderslab.cmsboot.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.cmsboot.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional

public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAuthor(Author entity) {
        entityManager.persist(entity);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
    public void update(Author entity) {

        entityManager.merge(entity);
    }
    public void delete(long id) {
        Author entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Author> readAll(){
        Query query = entityManager.createQuery("SELECT c FROM Author c");
        List<Author> authors = query.getResultList();
        return authors;
    }
}