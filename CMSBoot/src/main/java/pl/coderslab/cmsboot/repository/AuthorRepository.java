package pl.coderslab.cmsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.cmsboot.entity.Author;

import javax.transaction.Transactional;

@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
