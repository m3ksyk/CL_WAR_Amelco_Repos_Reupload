package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String HelloWorld(){
        return "Hello world";
    }

    @GetMapping("/helloView")
    public String helloView(){
        return "home";
    }
}
