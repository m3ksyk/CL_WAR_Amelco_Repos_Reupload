package pl.coderslab.thdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.extras.java8time.expression.Temporals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/product")
    public String index(Model model){
        Product product = new Product();
        product.setPrice(10.20);
        product.setDescription("A simple product");
        product.setAvailableFrom(LocalDateTime.now());
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/products")
    public String list(Model model){
        LocalDateTime local = LocalDateTime.now();
        Product product = new Product();
        product.setPrice(1.20);
        product.setDescription("A simple product");
        product.setAvailableFrom(local);
        Product product1 = new Product();
        product1.setPrice(110.20);
        product1.setDescription("Another simple product");
        product1.setAvailableFrom(local);
        Product product2 = new Product();
        product2.setPrice(2.20);
        product2.setDescription("potatoe");
        product2.setAvailableFrom(local);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        products.add(product2);
        model.addAttribute("products", products);
        return "products";
    }
   }
