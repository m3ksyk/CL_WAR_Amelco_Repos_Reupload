package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class SessionController {
    @GetMapping("/loginStart")
    @ResponseBody
    public String checkLoginStart(HttpSession session){
        String loginStarted = (String) session.getAttribute("loginStart");
        if (loginStarted!=null){
            return loginStarted;
        }else{
            session.setAttribute("loginStart", LocalDateTime.now().toString());
            return "Session started";
        }
    }
}
