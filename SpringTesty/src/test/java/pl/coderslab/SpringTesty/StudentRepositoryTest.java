package pl.coderslab.SpringTesty;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void shouldFetchStudent() {
        Student student = new Student();
        student.setFirstName("Alice");
        entityManager.persist(student);
        Student actual = studentRepository.findOneByFirstName("Alice");
        assertEquals(actual.getFirstName(), ("Alice"));
    }

    @Test
    public void shouldNotFetchMissingStudent() {
        Student student = new Student();
        student.setFirstName("Bob");
        entityManager.persist(student);
        Student actual = studentRepository.findOneByFirstName("Alice");
        assertNull(actual);
    }

    @Test
    public void shouldFindSomeStudents() {
        Student jo = entityManager.persistAndFlush(new Student("jo"));
        Student john = entityManager.persistAndFlush(new Student("john"));
        List<Student> result = studentRepository.findSome("jo");
        assertThat(result).containsExactly(jo, john);
    }
    @Test
    public void shouldFindStudentsNamesStartingWithF(){
        Student f1 = entityManager.persistAndFlush(new Student("Fyodor"));
        Student f2 = entityManager.persistAndFlush(new Student("Fidol"));
        List<Student> result = studentRepository.findSome("F");
        assertThat(result).containsAnyOf(f1);
    }

    @Test
    public void shouldReturnEmptyList(){
        Student f1 = entityManager.persistAndFlush(new Student("Fyodor"));
        Student f2 = entityManager.persistAndFlush(new Student("Fidol"));

        List<Student> actual = studentRepository.findSome("Janusz");
        assertThat(actual).isEmpty();
      }
}