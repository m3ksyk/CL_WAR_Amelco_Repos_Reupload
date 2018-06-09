package pl.coderslab.SpringTesty;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StudentServiceTest {

    private static final Logger log =
            LoggerFactory.getLogger(StudentServiceTest.class);

    private StudentService service;
    private StudentRepository repository;

    @Before
    public void setUp() {
        repository = mock(StudentRepository.class);
        service = new StudentServiceImpl(repository);
    }

    @Test
    public void when_searching_john_then_return_object() {
        // given
        Student john = new Student("John");
        when(repository.findOneByFirstName("John")).thenReturn(john);
        // when
        Student student = service.findByFirstName("John");
        // then
        assertEquals(student.getFirstName(), "John");
    }

    @Test
    public void when_save_student_then_it_is_returned_correctly() {
        // given
        Student student = new Student("John");
        when(repository.save(student)).thenReturn(student);
        // when
        Student result = service.addStudent(student);
        // then
        assertNotNull(result);
        assertEquals(student.getFirstName(), result.getFirstName());
    }

    @Test
    public void fetchAllStudents(){
        //given
        List<Student> expected = new ArrayList<>();
        Student student = new Student("John");
        expected.add(student);
        Student student2 = new Student("Jane");
        expected.add(student2);
        when(repository.findAll()).thenReturn(expected);
        //when
        List<Student> result = service.listAllStudents();
        //then
        assertEquals(expected, result);
    }
}
