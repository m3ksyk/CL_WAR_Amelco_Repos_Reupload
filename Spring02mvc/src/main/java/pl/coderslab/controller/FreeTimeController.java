package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class FreeTimeController {

    @GetMapping("/local")
    @ResponseBody
    public String local(){
        LocalDateTime local = (LocalDateTime.now());

        String day="";
        switch (local.getDayOfWeek()){
            case SATURDAY: day="Free";
                break;
            case SUNDAY: day="Free";
                break;
            default: day="";
                break;
        }
        String work = "";
        if (day.equals("") && local.getHour() < 17 && local.getHour() > 9){
            work = "I'm Working. Don't call";
        } else if(day.equals("") && (local.getHour() > 17 || local.getHour() < 9)){
            work = "After work";
        }

        return day +" "+ work;
    }
}
