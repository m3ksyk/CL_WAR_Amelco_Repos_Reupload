package pl.coderslab.SpringTesty;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTestAnnotation {

    private StudentService service;

    @Mock
    private StudentRepository repository;

    @Before
    public void setUp() {
        service = new StudentServiceImpl(repository);
    }
}
