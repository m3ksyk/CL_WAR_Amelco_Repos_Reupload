package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("articles", articleDao.readLastFive());
        model.addAttribute("categories", categoryDao.readAll());


        return "homepage";
    }
    @RequestMapping("/category/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return categoryDao.findById(id).toString();
    }
}
