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
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    CategoryRepository categoryRepository;

    Faker faker = new Faker();


    @GetMapping("/category/form")
    public String categoryForm(Model model){
        model.addAttribute("category", new Category());
        return "CategoryForm";
    }
    @PostMapping("/category/form")
    public String saveForm(@Valid @ModelAttribute Category category, BindingResult result){
        if(result.hasErrors()){
            return "CategoryForm";
        }
        categoryRepository.save(category);
//        categoryDao.saveCategory(category);
        return "redirect:/category/readall";
    }

    @GetMapping("/category/updateform/{id}")
    public String categoryUpdateForm(@PathVariable long id, Model model){

//        model.addAttribute("category", categoryDao.findById(id));
        model.addAttribute("category", categoryRepository.findOne(id));
        return "CategoryUpdateForm";
    }
    @PostMapping("/category/updateform/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Category category, BindingResult result){
        if(result.hasErrors()){
            return "CategoryForm";
        }
        categoryRepository.save(category);
//        categoryDao.update(category);
        return "redirect:/category/readall";
    }
    @GetMapping("/category/deletecategory/{id}")
    public String deleteCategory(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "CategoryDecision";
    }
    @RequestMapping("/category/readall")
    public String readAll(Model model){
        model.addAttribute("categories", categoryRepository.findAll());

//        model.addAttribute("categories", categoryDao.readAll());
        return "CategoryList";
    }

    @RequestMapping("/category/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        categoryRepository.delete(id);
//        categoryDao.delete(id);
        return "Category with id: " + id + " deleted";
    }
}
