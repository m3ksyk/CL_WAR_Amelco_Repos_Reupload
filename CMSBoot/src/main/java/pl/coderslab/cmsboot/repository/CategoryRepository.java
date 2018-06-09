package pl.coderslab.cmsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.cmsboot.entity.Category;

import javax.transaction.Transactional;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Object findOneById(long id);


}
