package pl.coderslab.SpringTesty;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldReturnProductWithName(){
        Product product = new Product();
        product.setName("bread");
        entityManager.persist(product);
        Product actual = productRepository.findOneByName("bread");

        assertEquals("bread", actual.getName());
    }

    @Test
    public void shouldReturnAvailableProducts(){
        Product p1 = entityManager.persistAndFlush(new Product("bread", true));
        Product p2 = entityManager.persistAndFlush(new Product("butter", true));
        Product p3 = entityManager.persistAndFlush(new Product("liquor", false));
        List<Product> expected = new ArrayList<>();
        expected.add(p1);
        expected.add(p2);
        List<Product> actual = productRepository.findAvailable();

        assertEquals(expected, actual);

    }
}
