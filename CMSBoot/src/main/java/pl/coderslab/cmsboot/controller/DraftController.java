package pl.coderslab.cmsboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.cmsboot.dao.ArticleDao;
import pl.coderslab.cmsboot.entity.Article;
import pl.coderslab.cmsboot.interfaces.ArticleGroupInterface;

@Controller
public class DraftController {
    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/draft/readall")
    public String readAll(Model model){
        model.addAttribute("props", articleDao.getAlldrafts());
        return "DraftList";
    }

    @GetMapping("/draft/form")
    public String draftForm(Model model){
        model.addAttribute("article", new Article());
        return "DraftForm";
    }

    @PostMapping("/draft/form")
    public String saveForm(@Validated({ArticleGroupInterface.class}) @ModelAttribute Article article, BindingResult result){
        if(result.hasErrors()){
            return "DraftForm";
        }
        articleDao.saveArticle(article);
        return "redirect:/draft/readall";
    }

    @GetMapping("/draft/updateform/{id}")
    public String draftUpdateForm(@PathVariable long id, Model model){

        model.addAttribute("article", articleDao.findById(id));
        return "draftUpdateForm";
    }

    @PostMapping("/draft/updateform/{id}")
    public String saveUpdateForm(@Validated({ArticleGroupInterface.class}) @ModelAttribute Article article, BindingResult result){
        if(result.hasErrors()){
            return "DraftForm";
        }
        articleDao.update(article);
        return "redirect:/draft/readall";
    }

    @GetMapping("/draft/deleteDraft/{id}")
    public String deleteDraft(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "ArticleDecision";
    }
}
