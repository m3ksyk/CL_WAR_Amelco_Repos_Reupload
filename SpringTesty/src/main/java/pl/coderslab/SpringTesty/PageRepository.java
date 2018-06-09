package pl.coderslab.SpringTesty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    @Query("Select p from Page p where p.id =:id")
    Page findOneById(@Param("id") long id);

    List<Page> findAllByTitleAndCreated(String title, Date created);


    List <Page> findAllByCreatedAfter(Date created);
}
