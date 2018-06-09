package pl.coderslab.cmsboot.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.cmsboot.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article entity) {
        entityManager.persist(entity);
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }
    public void update(Article entity) {

        entityManager.merge(entity);
    }
    public void delete(long id) {
        Article entity = findById(id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
    public List<Article> readAll(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        List<Article> articles = query.getResultList();
        return articles;
    }
    public List<Article> readLastFive() {
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY created DESC ");
        query.setMaxResults(5);
        List<Article> articles = query.getResultList();
        return articles;

//        SELECT a FROM Article a JOIN a.categories c where c.id

    }
    public List<Article> getAlldrafts(){
        Query query = entityManager.
                createQuery("select a from articles a where draft=true");
        List<Article> drafts = query.getResultList();
        return drafts;
    }

}
