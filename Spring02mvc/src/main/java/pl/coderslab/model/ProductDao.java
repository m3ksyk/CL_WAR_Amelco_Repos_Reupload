package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<Product> getList(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("water", 1, 1));
        products.add(new Product("beer", 2, 2));
        products.add(new Product("bread", 3, 3));
        products.add(new Product("mutton", 12, 4));
        products.add(new Product("chips", 6, 5));
        return products;
    }
    public static Product getProduct(long id){
        List<Product> products = getList();
        return getList().get((int) id);
    }
}
