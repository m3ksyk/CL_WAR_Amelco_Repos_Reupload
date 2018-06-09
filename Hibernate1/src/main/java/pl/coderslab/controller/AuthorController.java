package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/author/add")
    @ResponseBody
    public String create(){

        Author author  = new Author();
        author.setFirstName("Bruce");
        author.setLastName("GUY");
        authorDao.saveAuthor(author);
        return "Author added on id:"
                +  author.getId();
    }

    @GetMapping("/author/form")
    public String authorForm(Model model){
        model.addAttribute("author", new Author());
        return "AuthorForm";
    }
    @PostMapping("/author/form")
    public String saveForm(@Valid@ModelAttribute Author author, BindingResult result){
        if(result.hasErrors()){
            return "AuthorForm";
        }
        authorDao.saveAuthor(author);
        return "redirect:/author/readall";
    }

    @GetMapping("/author/updateform/{id}")
    public String authorUpdateForm(@PathVariable long id, Model model){

        model.addAttribute("author", authorDao.findById(id));
        return "AuthorUpdateForm";
    }
    @PostMapping("/author/updateform/{id}")
    public String saveUpdateForm(@Valid@ModelAttribute Author author, BindingResult result){
        if(result.hasErrors()){
            return "AuthorForm";
        }
        authorDao.update(author);
        return "redirect:/author/readall";
    }
    @GetMapping("/author/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "AuthorDecision";
    }
    @RequestMapping("/author/readall")
    public String readAll(Model model){
        model.addAttribute("authors", authorDao.readAll());
        return "AuthorList";
    }

//    @RequestMapping("/author/readall")
//    @ResponseBody
//    public String readAll(){
//        return authorDao.readAll().toString();
//    }


    @RequestMapping("/author/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return (authorDao.findById(id)).toString();
    }

    @RequestMapping("/author/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Author author = authorDao.findById(id);
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorDao.update(author);
        return "updated";
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        authorDao.delete(id);
        return "Author with id: " + id + " deleted";
    }

    @RequestMapping("/author/reademail/{email}")
    @ResponseBody
    public String readByEmail(@PathVariable String email){
        return authorRepository.findByEmail(email).toString();
    }

    @RequestMapping("/author/readpesel/{pesel}")
    @ResponseBody
    public String readByPesel(@PathVariable String pesel){
        return authorRepository.findByPesel(pesel).toString();
    }

    @RequestMapping("/author/readlastname/{lastname}")
    @ResponseBody
    public String readByLastName(@PathVariable String lastname){
        return authorRepository.findAllByLastName(lastname).toString();
    }

    @RequestMapping("/author/readwithmail/{mail}")
    @ResponseBody
    public String readWithEmail(@PathVariable String mail){
        return authorRepository.findAuthorWithEmailStart(mail).toString();
    }
    @RequestMapping("/author/readwithpesel/{pesel}")
    @ResponseBody
    public String readWithPesel(@PathVariable String pesel){
        return authorRepository.findAuthorWithPeselStart(pesel).toString();
    }
}
