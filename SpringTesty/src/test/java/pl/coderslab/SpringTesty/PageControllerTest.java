package pl.coderslab.SpringTesty;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {PageController.class})
public class PageControllerTest {

    @MockBean
    private StudentService studentService;

    @MockBean
    private PageService pageService;

    private PageController pageController;


    @Before
    public void setUp(){

        pageController = new PageController(studentService, pageService);
    }

    @Test
    public void shouldReturnIndexPage() {
        String viewName = pageController.page();
        assertThat("page/index", is(viewName));
    }

    @Test
    public void shouldReturnHomePage() {
        String viewName = pageController.home();
        assertThat("page/home", is(viewName));
    }

    @Test
    public void shouldReturnAllStudents() throws Exception{
        // given
        List<Student> fakeStudents = new ArrayList<>();

        for (String name : Arrays.asList("Alice", "Bob", "Robert")) {
            Student student = new Student();
            student.setFirstName(name);
            fakeStudents.add(student);
        }

        when(studentService.listAllStudents()).thenReturn(fakeStudents);

        MockMvc mockMvc = standaloneSetup(pageController).build();

        // when, then
        mockMvc.perform(get("/students/list"))
                .andExpect(view().name("student/studentList"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("students"))
                .andExpect(model().attribute("students", fakeStudents));
    }

    @Test
    public void shouldReturnStudentWithFakeId() throws Exception{
        // given
        Student fakeStudent = new Student();
        studentService.addStudent(fakeStudent);

        when(studentService.findById(1L)).thenReturn(Optional.of(fakeStudent));

        MockMvc mockMvc = standaloneSetup(pageController).build();

        // when, then
        mockMvc.perform(get("/students/{id}/show", 1L))
                .andExpect(status().isOk())
                .andExpect(view().name("student/studentDetails"))
                .andExpect(model().attributeExists("student"))
                .andExpect(model().attribute("student", Optional.of(fakeStudent)));

    }
    @Test
    public void shouldAddPage() throws Exception{
        MockMvc mockMvc = standaloneSetup(pageController).build();

        mockMvc.perform(post("/page/add"))
                .andExpect(MockMvcResultMatchers.content().string("pageAdded"));

    }
    @Test
    public void shouldShowPagesWithTitleAndCreated() throws Exception{

        MockMvc mockMvc = standaloneSetup(pageController).build();

        mockMvc.perform(post("/pages/showTitleAndCrtd?created=16-05-2018&title=somepage"))
                .andExpect(MockMvcResultMatchers.content().string("somepage2018-05-16"));

    }


    @Test
    public void shouldShowPagesCreatedAfter() throws Exception{

        MockMvc mockMvc = standaloneSetup(pageController).build();

            mockMvc.perform(post("/pages?before=16-05-2018"))
                    .andExpect(MockMvcResultMatchers.content().string("2018-05-16"));
    }


    @Test
    public void shouldShowPage() throws Exception{
        Page fakePage = new Page();
        pageService.addPage(fakePage);

        when(pageService.findPageById(1L)).thenReturn(fakePage);

        MockMvc mockMvc = standaloneSetup(pageController).build();

        // when, then
        mockMvc.perform(get("/pages/{id}/show", 1L))
                .andExpect(status().isOk())
                .andExpect(view().name("page/pageDetails"))
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attribute("page", fakePage));


    }

    @Test
    public void shouldUpdatePage() throws Exception{
        MockMvc mockMvc = standaloneSetup(pageController).build();

        mockMvc.perform(post("/page/edit?id=1"))
                .andExpect(MockMvcResultMatchers.content().string("pageUpdated"));

    }
    @Test
    public void shouldDeletePage() throws Exception{

        MockMvc mockMvc = standaloneSetup(pageController).build();

        mockMvc.perform(post("/page/delete?id=1"))
                .andExpect(MockMvcResultMatchers.content().string("pageDeleted"));

    }


}
