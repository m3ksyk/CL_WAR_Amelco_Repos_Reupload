package pl.coderslab.SpringTesty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
public class PageController {

    private final StudentService studentService;
    private final PageService pageService;

    @Autowired
    public PageController(StudentService studentService, PageService pageService) {

        this.studentService = studentService;
        this.pageService= pageService;
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @GetMapping("/page")
    public String page(){
        return "page/index";
    }
    @GetMapping("/")
    public String home(){
        return "page/home";
    }

    @GetMapping("students/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.listAllStudents());
        return "student/studentList";
    }

    @GetMapping("/students/{id}/show")
    public String showStudent(Model model, @PathVariable long id) {
        model.addAttribute("student", studentService.findById(id));
        return "student/studentDetails";
    }

    @GetMapping("/pages/{id}/show")
    public String showPageById(Model model, @PathVariable long id){
        model.addAttribute("page", pageService.findPageById(id));
        return "page/pageDetails";
    }

    @PostMapping("/pages/showTitleAndCrtd")
    @ResponseBody
    public String showPagesByTitleAndCreated(@RequestParam("created") String created,
                                             @RequestParam("title") String title) {
        try {
            LocalDate localDate = LocalDate.parse(created, formatter);
            String returnStr = title + localDate.toString();
            return returnStr;
        } catch (DateTimeParseException ex) {
            return "Getting errors";
        }
    }

    @PostMapping("/pages")
    @ResponseBody
    public String showPagesCreatedAfter(@RequestParam("before") String before) {
        try {
            LocalDate localDate = LocalDate.parse(before, formatter);
            return localDate.toString();
        } catch (DateTimeParseException ex) {
            return "Date must formatted as dd-MM-yyyy";
        }
    }

    @PostMapping("/page/add")
    @ResponseBody
    public String addPage(){
        pageService.addPage(new Page());
        return "pageAdded";
    }


    @PostMapping("/page/edit")
    @ResponseBody
    public String editPage(@RequestParam("id") long id){
//        Page page= pageService.findPageById(id);
        pageService.editPage(id);
        return "pageUpdated";
    }

    @PostMapping("/page/delete")
    @ResponseBody
    public String deletePage(@RequestParam("id") long id){
//        Page page= pageService.findPageById(id);
        pageService.deletePage(id);
        return "pageDeleted";
    }

}
