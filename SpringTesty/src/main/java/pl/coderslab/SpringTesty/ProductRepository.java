package pl.coderslab.SpringTesty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findOneByName(String name);

    @Query("Select p from Product p where p.available = true")
    List<Product> findAvailable();
}
