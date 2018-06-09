package pl.coderslab.sampleboot.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.sampleboot.entity.User;
import pl.coderslab.sampleboot.service.CurrentUser;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String index(){
//        return "Guten Tag Welt";
//    }

    @GetMapping("/testjsp")
    public String testJsp(){
        return "testjsp";
    }

    @GetMapping("/all")
    @ResponseBody
    public String all(){
        return "For all to see";
    }

    @GetMapping("/restricted")
    @ResponseBody
    public String restricted(){
        return "only for the worthy";
    }

//    @GetMapping("/")
//    @ResponseBody
//    public String home() {
//        return "Anyone can see this.";
//    }

    @GetMapping("/panel")
    @ResponseBody
    public String panel() {
        return "Hooray! Only logged-in users can see this.";
    }

    @GetMapping("/")
    public String index(){
        return "loginView";
    }

    //log!?
//    @GetMapping("/admin")
//    @ResponseBody
//    public String admin2(@AuthenticationPrincipal UserDetails customUser) {
//        log.info("customUSer class {} " , customUser.getClass());
//        return "this is user " + customUser;
//    }
    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "this is user id " +entityUser.getId() ;
    }
}
