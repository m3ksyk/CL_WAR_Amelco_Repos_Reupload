package pl.coderslab.cmsboot.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.cmsboot.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;
    public void saveCategory(Category entity) {
        entityManager.persist(entity);
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }
    public void update(Category entity) {

        entityManager.merge(entity);
    }
    public void delete(long id) {
        Category entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<Category> readAll(){
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        List<Category> categories = query.getResultList();
        return categories;
    }


}