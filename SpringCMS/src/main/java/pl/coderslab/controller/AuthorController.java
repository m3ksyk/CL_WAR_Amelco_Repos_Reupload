package pl.coderslab.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
public class AuthorController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    AuthorRepository authorRepository;
    Faker faker = new Faker();

    @GetMapping("/author/form")
    public String authorForm(Model model){
        model.addAttribute("author", new Author());
        return "AuthorForm";
    }
    @PostMapping("/author/form")
    public String saveForm(@Valid @ModelAttribute Author author, BindingResult result){
        if(result.hasErrors()){
            return "AuthorForm";
        }
        authorRepository.save(author);
//        authorDao.saveAuthor(author);
        return "redirect:/author/readall";
    }



    @GetMapping("/author/updateform/{id}")
    public String authorUpdateForm(@PathVariable long id, Model model){
        model.addAttribute("author", authorRepository.findOne(id));

//        model.addAttribute("author", authorDao.findById(id));
        return "AuthorUpdateForm";
    }
    @PostMapping("/author/updateform/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Author author, BindingResult result){
        if(result.hasErrors()){
            return "AuthorForm";
        }
        authorRepository.save(author);
        //        authorDao.update(author);
        return "redirect:/author/readall";
    }
    @GetMapping("/author/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "AuthorDecision";
    }
    @RequestMapping("/author/readall")
    public String readAll(Model model){
        model.addAttribute("authors", authorRepository.findAll());
//        model.addAttribute("authors", authorDao.readAll());
        return "AuthorList";
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
//        authorDao.delete(id);
        authorRepository.delete(id);
        return "Author with id: " + id + " deleted";
    }


    @RequestMapping("/author/add")
    @ResponseBody
    public String create(){

        Author author  = new Author();
        author.setFirstName(faker.name().firstName());
        author.setLastName(faker.name().lastName());
//        authorDao.saveAuthor(author);
        authorRepository.save(author);
        return "Author added on id:"
                +  author.getId();
    }

    @RequestMapping("/author/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return (authorRepository.findOne(id)).toString();

//        return (authorDao.findById(id)).toString();
    }

    @RequestMapping("/author/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Author author = authorDao.findById(id);
        author.setFirstName(faker.name().firstName());
        author.setLastName(faker.name().lastName());
        authorRepository.save(author);
//        authorDao.update(author);
        return "updated";
    }

}
