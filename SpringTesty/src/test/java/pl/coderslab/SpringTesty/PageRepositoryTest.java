package pl.coderslab.SpringTesty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class PageRepositoryTest {


    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PageRepository pageRepository;

    @Test
    public void shouldFindOneById() {
        Page page = new Page();
        page.setId(1);
        entityManager.merge(page);
        Page actual = pageRepository.findOneById(1);

        assertEquals(1, actual.getId());
    }

    @Test
    public void shouldFindAllByTitleAndCreated() {
        Page p1 = entityManager.persistAndFlush(new Page("title1", Date.valueOf(LocalDate.now())));
        Page p2 = entityManager.persistAndFlush(new Page("title1", Date.valueOf(LocalDate.now())));
        Page p3 = entityManager.persistAndFlush(new Page("title2", Date.valueOf(LocalDate.now())));
        List<Page> expected = new ArrayList<>();
        expected.add(p1);
        expected.add(p2);
        List<Page> actual = pageRepository.findAllByTitleAndCreated("title1", Date.valueOf(LocalDate.now()));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllByCreatedAfter() {
        Page p1 = entityManager.persistAndFlush(new Page("title1", Date.valueOf(LocalDate.now())));
        Page p2 = entityManager.persistAndFlush(new Page("title1", Date.valueOf(LocalDate.now())));
        Page p3 = entityManager.persistAndFlush(new Page("title2", Date.valueOf(LocalDate.now())));
        List<Page> expected = new ArrayList<>();
        expected.add(p1);
        expected.add(p2);
        expected.add(p3);
        Date date = new Date(1980-10-10);
        List<Page> actual = pageRepository.findAllByCreatedAfter(date);

        assertEquals(expected, actual);
    }
    
}