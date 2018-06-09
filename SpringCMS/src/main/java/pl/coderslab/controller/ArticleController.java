package pl.coderslab.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    ArticleRepository articleRepository;

    Faker faker = new Faker();


    @GetMapping("/article/form")
    public String articleForm(Model model){
        Article article = new Article();
        article.setCreated(Date.valueOf(LocalDate.now()));
        model.addAttribute("article", article);

        return "ArticleForm";
    }
    @PostMapping("/article/form")
    public String saveForm(@Valid @ModelAttribute Article article, BindingResult result){
        if(result.hasErrors()){
            return "ArticleForm";
        }
        articleRepository.save(article);
//        articleDao.saveArticle(article);
        return "redirect:/article/readall";
    }

    @GetMapping("/article/updateform/{id}")
    public String articleUpdateForm(@PathVariable long id, Model model){
        Article article = articleDao.findById(id);
        article.setUpdated(Date.valueOf(LocalDate.now()));

        model.addAttribute("article", article);
        return "ArticleUpdateForm";
    }
    @PostMapping("/article/updateform/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Article article, BindingResult result){
        if(result.hasErrors()){
            return "ArticleForm";
        }
        articleRepository.save(article);
//        articleDao.update(article);
        return "redirect:/article/readall";
    }
    @GetMapping("/article/deletearticle/{id}")
    public String deleteArticle(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "ArticleDecision";
    }
    @RequestMapping("/article/readall")
    public String readAll(Model model){
        model.addAttribute("articles", articleRepository.findAll());

//        model.addAttribute("articles", articleDao.readAll());
        return "articleList";
    }

    @RequestMapping("/article/add")
    @ResponseBody
    public String create(){

        Article article  = new Article();
        Author author = authorDao.findById(faker.number().numberBetween(1,10));
        article.setTitle(faker.book().title());
        article.setAuthor(author);
        article.setContent(faker.lorem().paragraph(100));
        Date date = Date.valueOf(LocalDate.now());
        article.setCreated(date);
        List<Category> category = new ArrayList<>();
        category.add(categoryDao.findById(faker.number().numberBetween(1,10)));
        articleDao.saveArticle(article);
        return "Article added on id:"
                +  article.getId();
    }

    @RequestMapping("/article/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return articleRepository.findOne(id).toString();

//        return (articleDao.findById(id)).toString();
    }

    @RequestMapping("/article/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Article article = articleDao.findById(id);
        Author author = authorDao.findById(faker.number().numberBetween(1,10));
        article.setTitle(faker.book().title());
        article.setAuthor(author);
        article.setContent(faker.lorem().paragraph(100));
        Date date = Date.valueOf(LocalDate.now());
        article.setUpdated(date);
        List<Category> category = new ArrayList<>();
        category.add(categoryDao.findById(faker.number().numberBetween(1,10)));
        articleDao.update(article);
        return "updated";
    }

    @RequestMapping("/article/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
//        articleDao.delete(id);
        articleRepository.delete(id);
        return "Article with id: " + id + " deleted";
    }
}
