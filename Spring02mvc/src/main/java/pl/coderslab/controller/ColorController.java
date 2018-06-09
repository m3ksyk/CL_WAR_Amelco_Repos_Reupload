package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ColorController {

    @GetMapping("/home")
    public String setColors(Model model){

        String color = "white";
        String background = "black";
        LocalDateTime local = (LocalDateTime.now());
        int localHour = local.getHour();
        localHour = 1;
        if (localHour < 20 && localHour > 8){
            color = "black";
            background = "white";
        }

        model.addAttribute("color", color);
        model.addAttribute("background", background);
        return "home";
    }

}
