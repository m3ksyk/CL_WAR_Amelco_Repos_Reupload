package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String homeJsp(HttpServletResponse response, @PathVariable String value1, @PathVariable String value2){
        Cookie cookie1 =new Cookie("cookie1", value1);
        Cookie cookie2 =new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "Cookies added";
    }

    @GetMapping("/getcookies")
    @ResponseBody
    public String home(HttpServletRequest request){
        Cookie c1 = WebUtils.getCookie(request, "cookie1");
        Cookie c2 = WebUtils.getCookie(request, "cookie2");

        return "cookie1 " + c1.getValue() + " | cookie2 " + c2.getValue();
    }

    @RequestMapping("/getcookies2")
    @ResponseBody
    public String home(@CookieValue("cookie1") String cookie1, @CookieValue("cookie2") String cookie2){
        return "cookie1 " + cookie1 + " cookie2 " + cookie2 ;
    }
}

