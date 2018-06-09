package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public void savePublisher(Publisher entity) {
        entityManager.persist(entity);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
    public void update(Publisher entity) {

        entityManager.merge(entity);
    }
    public void delete(long id) {
        Publisher entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<Publisher> readAll(){
        Query query = entityManager.createQuery("SELECT p FROM Publisher p ");
        List<Publisher> publishers = query.getResultList();
        return publishers;
    }
}
