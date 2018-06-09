package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloPersonController {
    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String HelloWorld(@PathVariable String firstName, @PathVariable String lastName){
        return "Hello " + firstName +" "+ lastName;
    }
}
