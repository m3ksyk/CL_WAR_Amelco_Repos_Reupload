package pl.coderslab.cmsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.cmsboot.entity.Article;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {

//these methods are present by default
//    List findAll() - return all objects of the type
//    T findOne(ID id) - return object of the given id
//    S save(S entity) - save an object
//    void delete(T entity) - delete an object
//    void delete(ID id) - delete an object with given id
//    void deleteAll() - delete all objects
//    long count() - return count of objects

    @Query("SELECT a FROM Article a JOIN a.categories c where c.id = :id")
    List<Article> findWithCategory(@Param("id") Long id);


    @Query("Select a from Article a where a.draft = true ")
    List<Article> findDrafts();

}
