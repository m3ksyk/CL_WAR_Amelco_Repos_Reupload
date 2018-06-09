package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.interfaces.BookGroupInterface;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PropositionController {

    @Autowired
    BookDao bookDao;

    @RequestMapping("/proposition/readall")
    public String readAll(Model model){
        model.addAttribute("props", bookDao.getAllpropositions());
        return "PropositionList";
    }

    @GetMapping("/proposition/form")
    public String propositionForm(Model model){
        model.addAttribute("book", new Book());
        return "PropositionForm";
    }

    @PostMapping("/proposition/form")
    public String saveForm(@Validated({Default.class}) @ModelAttribute Book book, BindingResult result){
        if(result.hasErrors()){
            return "PropositionForm";
        }
        bookDao.saveBook(book);
        return "redirect:/proposition/readall";
    }

    @GetMapping("/proposition/updateform/{id}")
    public String propositionUpdateForm(@PathVariable long id, Model model){

        model.addAttribute("book", bookDao.findById(id));
        return "propositionUpdateForm";
    }

    @PostMapping("/proposition/updateform/{id}")
    public String saveUpdateForm(@Validated({Default.class}) @ModelAttribute Book book, BindingResult result){
        if(result.hasErrors()){
            return "PropositionForm";
        }
        bookDao.update(book);
        return "redirect:/proposition/readall";
    }

    @GetMapping("/proposition/deleteProposition/{id}")
    public String deleteProposition(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "BookDecision";
    }

}
