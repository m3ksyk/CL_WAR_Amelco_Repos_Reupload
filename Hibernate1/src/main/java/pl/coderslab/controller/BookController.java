package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.interfaces.BookGroupInterface;
import pl.coderslab.repository.BookRepository;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book/form")
    public String bookForm(Model model){
        model.addAttribute("book", new Book());
        return "BookForm";
    }
    @PostMapping("/book/form")
    public String saveForm(@Validated ({ BookGroupInterface.class}) @ModelAttribute Book book, BindingResult result){
        if(result.hasErrors()){
            return "BookForm";
        }

        bookDao.saveBook(book);
        return "redirect:/book/readall";
    }

    @GetMapping("/book/updateform/{id}")
    public String bookUpdateForm(@PathVariable long id, Model model){

        model.addAttribute("book", bookDao.findById(id));
        return "BookUpdateForm";
    }
    @PostMapping("/book/updateform/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Book book, BindingResult result){
        if(result.hasErrors()){
            return "BookForm";
        }
        bookDao.update(book);
        return "redirect:/book/readall";
    }
    @GetMapping("/book/deletebook/{id}")
    public String deleteBook(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "BookDecision";
    }
    @RequestMapping("/book/readall")
   // @ResponseBody
    public String readAll(Model model){
        model.addAttribute("books", bookDao.readAll());
        return "BookList";
        //return bookDao.readAll().toString();
    }

    @RequestMapping("/book/read-rating/{rating}")
    @ResponseBody
    public String readRating(@PathVariable int rating){
        return bookDao.getRatingList(rating).toString();
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String create(){
        Book book  = new Book();
        book.setTitle("Thinking in Java");
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(1));
        book.setAuthors(authors);
        book.setPublisher(publisherDao.findById(1));
        bookDao.saveBook(book);
        return "Book added on id:"
                +  book.getId();
    }

    @RequestMapping("/book/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
       return (bookDao.findById(id)).toString();
    }



    @RequestMapping("/book/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Book book = bookDao.findById(id);
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(1));
        book.setAuthors(authors);
        book.setTitle("Hobbit");
        book.setPublisher(publisherDao.findById(2));
        bookDao.update(book);
        return "updated";
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        bookDao.delete(id);
        return "Book with id: " + id + " deleted";
    }



    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.readAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.readAll();
    }


    @RequestMapping("/book/readtitle/{title}")
    @ResponseBody
    public String readByTitle(@PathVariable String title){
        return bookRepository.findAllByTitle(title).toString();
    }

    @RequestMapping("/book/readauthorid/{id}")
    @ResponseBody
    public String readByAuthorId(@PathVariable Long id){
        return bookRepository.findAllByAuthorId(id).toString();
    }

    @RequestMapping("/book/readauthor/{id}")
    @ResponseBody
    public String readByAuthor(@PathVariable Long id){
        return bookRepository.findAllByAuthorsId(id).toString();
    }

    @RequestMapping("/book/readpublisher/{id}")
    @ResponseBody
    public String readByPublisher(@PathVariable long id){
        return bookRepository.findAllByPublisherId(id).toString();
    }

    @RequestMapping("/book/readrating/{rating}")
    @ResponseBody
    public String readByRating(@PathVariable int rating){
        return bookRepository.findByRatingEquals(rating).toString();
    }

    @RequestMapping("/book/readtitlepart/{title}")
    @ResponseBody
    public String readByTitlePart(@PathVariable String title){
        return bookRepository.findBooksByTitlePart(title).toString();
    }

    @RequestMapping("/book/readratings/{rating1}/{rating2}")
    @ResponseBody
    public String readByRatings(@PathVariable int rating1, @PathVariable int rating2){
        return bookRepository.findWithRating(rating1,rating2).toString();
    }
    @RequestMapping("/book/readauthor2/{author}")
    @ResponseBody
    public String readByAuthor(@PathVariable Author author){
        return bookRepository.findAllByAuthor((List<Author>) author).toString();
    }

    @RequestMapping("/book/readpublisher/{publisher}")
    @ResponseBody
    public String readByPublisher(@PathVariable Publisher publisher){
        return bookRepository.findBooksByPublisher(publisher).toString();
    }

    @RequestMapping("/book/resetratings/{num}")
    @ResponseBody
    public String reset(@PathVariable int num){
        bookRepository.resetRating(num);
        return "All ratings set to " + num;
    }
}

