package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;


@Component
@Transactional
public class HomePageDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Article> getRatingList(Date date){
        Query query = entityManager.
                createQuery("SELECT a FROM article a where created >:created");
        query.setParameter("created", date);
        query.setMaxResults(5);
        List<Article> art = query.getResultList();
        return art;
    }
}
