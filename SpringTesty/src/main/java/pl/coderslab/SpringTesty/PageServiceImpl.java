package pl.coderslab.SpringTesty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    PageRepository pageRepository;

    public PageServiceImpl(PageRepository repository) {
        this.pageRepository = repository;
    }

    @Override
    public Page findPageById(long id) {

        return pageRepository.findOneById(id);
    }

    @Override
    public List<Page> findAllPagesByTitleAndCreated(String title, Date created) {

        return pageRepository.findAllByTitleAndCreated(title, created);
    }

    @Override
    public List<Page> findAllPagesCreatedAfter(Date created) {

        return pageRepository.findAllByCreatedAfter(created);
    }

    @Override
    public Page addPage(Page page) {
        return pageRepository.save(page);
    }

    @Override
    public Page editPage(Long id) {
        Page page = pageRepository.findOneById(id);

        return pageRepository.save(page);
    }

    @Override
    public void deletePage(Long id) {
        Page page = pageRepository.findOneById(id);
        pageRepository.delete(page);
    }
}
