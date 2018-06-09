package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;
import pl.coderslab.model.ProductDao;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private Cart cart;

    @RequestMapping("/addtocart/{id}/{quantity}")
    public String addtocart(Model model, @PathVariable long id, @PathVariable int quantity) {
//        Random rand = new Random();
        ProductDao.getList();
        CartItem cartItem = new CartItem(quantity, ProductDao.getProduct(id));
        //dodac warunek jesli produkt jest w koszyku, dokonczyc widok
        cart.addCartItem(cartItem);

        model.addAttribute("cartItem", cartItem);
        return "addtocart";
    }

    @GetMapping("/cart")
    public String showcart(Model model) {
        model.addAttribute("cart", cart);
//        cart.getCartItems();

        return "cart";
    }
}
