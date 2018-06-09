package pl.coderslab.SpringTesty;

import java.sql.Date;
import java.util.List;

public interface PageService {

    Page findPageById(long id);

    List<Page> findAllPagesByTitleAndCreated(String title, Date created);

    List <Page> findAllPagesCreatedAfter(Date created);

    Page addPage(Page page);
    Page editPage(Long id);
    void deletePage(Long id);
}
