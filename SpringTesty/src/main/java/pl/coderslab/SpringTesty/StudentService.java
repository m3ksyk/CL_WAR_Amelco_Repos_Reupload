package pl.coderslab.SpringTesty;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> listAllStudents();

    public Student findByFirstName(String firstName);

    public Student addStudent(Student student);

    Optional<Student> findById(long id);
}
