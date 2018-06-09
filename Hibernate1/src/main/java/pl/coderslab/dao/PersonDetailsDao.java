package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePersonDetails(PersonDetails entity) {
        entityManager.persist(entity);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }
    public void update(PersonDetails entity) {

        entityManager.merge(entity);
    }
    public void delete(long id) {
        PersonDetails entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<PersonDetails> readAll(){
        Query query = entityManager.createQuery("SELECT d FROM PersonDetails d ");
        List<PersonDetails> personDetailss = query.getResultList();
        return personDetailss;
    }
}

