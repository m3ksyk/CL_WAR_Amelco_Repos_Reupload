package pl.coderslab.SpringTesty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;


    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Student> listAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findByFirstName(String firstName) {
        return repository.findOneByFirstName(firstName);
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> findById(long id) {
        return repository.findById(id);
    }
}
