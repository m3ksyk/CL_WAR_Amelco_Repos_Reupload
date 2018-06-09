package pl.coderslab.thdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "Hello Coderslab");
        model.addAttribute("now", LocalDate.now());
        return "hello";
    }

}
