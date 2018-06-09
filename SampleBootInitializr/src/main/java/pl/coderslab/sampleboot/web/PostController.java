package pl.coderslab.sampleboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @RequestMapping("/remove")
    @ResponseBody
    public String remove(){
        return "removed";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(){
        return "updated";
    }

    @RequestMapping("/view")
    @ResponseBody
    public String view(){
        return "viewed";
    }

}
