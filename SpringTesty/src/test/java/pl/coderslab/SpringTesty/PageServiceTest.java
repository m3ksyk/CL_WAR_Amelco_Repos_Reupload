package pl.coderslab.SpringTesty;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PageServiceTest {

    private static final Logger log =
            LoggerFactory.getLogger(PageServiceTest.class);

    private PageService service;
    private PageRepository repository;

    @Before
    public void setUp() {
        repository = mock(PageRepository.class);
        service = new PageServiceImpl(repository);
    }
    

    @Test
    public void findPageById() {
        // given
        Page page = new Page(1);
        when(repository.findOneById(1)).thenReturn(page);
        // when
        Page page1 = service.findPageById(1);
        // then
        assertEquals(page.getId(), 1);
    }

    @Test
    public void findAllPagesByTitleAndCreated() {
        //given
        List<Page> expected = new ArrayList<>();
        Date date = new Date(1980-10-10);
        Page page = new Page("title1", date);
        expected.add(page);
        Page page2 = new Page("title2", date);

        when(repository.findAllByTitleAndCreated("title1", date)).thenReturn(expected);
        //when
        List<Page> result = service.findAllPagesByTitleAndCreated("title1", date);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void findAllPagesCreatedAfter() {
        //given
        List<Page> expected = new ArrayList<>();
        Date date = new Date(1980-10-11);
        Date date2 = new Date(1982-10-10);
        Page page = new Page("title1", date);
        expected.add(page);
        Page page2 = new Page("title2", date2);
        expected.add(page2);
        Date date3 = new Date(1979-10-10);

        when(repository.findAllByCreatedAfter(date)).thenReturn(expected);
        //when
        List<Page> result = service.findAllPagesCreatedAfter(date3);
        //then
        assertEquals(expected, result);
    }
}