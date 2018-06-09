package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class MultiplyController {

    @RequestMapping("/multiply/{size}")
    public String multiply(Model model, @PathVariable int size){

        model.addAttribute("size", size);

        return "multiply";
    }
    @RequestMapping("/multiplyrc/{rows}/{cols}")
    public String multiplyRowsCols(Model model, @PathVariable int rows, @PathVariable int cols){

        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);

        return "multiplyrc";
    }

}
