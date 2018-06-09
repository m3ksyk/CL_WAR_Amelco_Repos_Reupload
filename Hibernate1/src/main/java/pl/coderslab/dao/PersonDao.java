package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePerson(Person entity) {
        entityManager.persist(entity);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person entity) {

        entityManager.merge(entity);
    }

    public void delete(long id) {
        Person entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Person> readAll(){
        Query query = entityManager.createQuery("SELECT p FROM Person p "); //add join to make authors and publishers work?
        List<Person> ppl = query.getResultList();
        return ppl;
    }
}


