package pl.coderslab.SpringTesty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findOneByFirstName(String firstName);

    @Query("Select s from Student s where s.firstName like ?1%")
    List<Student> findSome(String expression);
}
