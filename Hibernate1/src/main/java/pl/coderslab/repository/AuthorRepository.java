package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
    Author findByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);

    @Query("Select a from Author a where a.email like :email")
    List<Author> findAuthorWithEmailStart(@Param("email") String email);

    @Query("Select a from Author a where a.pesel like :pesel")
    List<Author> findAuthorWithPeselStart(@Param("pesel") String pesel);

}
