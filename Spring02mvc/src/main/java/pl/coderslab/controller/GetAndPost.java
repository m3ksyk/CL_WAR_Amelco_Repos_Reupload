package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GetAndPost {

    @GetMapping("/form")
    public String getForm(){
    return "WEB-INF/form.jsp";
    }
    @PostMapping("/form")
    @ResponseBody
    public String postForm(@RequestParam String paramName){

        return paramName;
    }
}
