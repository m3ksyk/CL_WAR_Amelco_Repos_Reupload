package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
//    @ResponseBody
    public String validateBook(Model model){
        Book book = new Book();
        book.setTitle("book");
        book.setDescription("description");
        book.setPages(0);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);

//        StringBuilder sb = new StringBuilder();
//        sb.append("<p> Errors: ");
//        if(!violations.isEmpty()){
//            for (ConstraintViolation<Book> error: violations) {
//                sb.append(error.getPropertyPath() + " :: " + error.getMessage());
//                sb.append("<hr/>");
//                System.out.println(error.getPropertyPath() + " :: " + error.getMessage());
//            }
//        }
//        sb.append("</p>");
//        return sb.toString();

        model.addAttribute("violations", violations);

        return "validation";
    }
}
