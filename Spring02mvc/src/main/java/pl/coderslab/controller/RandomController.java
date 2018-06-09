package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    @GetMapping("/random")
    @ResponseBody
    public String showRandom(){
        Random random = new Random();
        int rand = random.nextInt(100);
        return "Wylosowano liczbe " + rand;
    }

    @GetMapping("/random/{max}")
    @ResponseBody
    public String maxRandom(@PathVariable int max){
        Random random = new Random();

        int rand = random.nextInt(max)+1;
        return "Uzytkownik podal wartosc "+ max + ". Wylosowano liczbe " + rand;
    }
    @GetMapping("/random/{min}/{max}")
    @ResponseBody
    public String minMaxRandom(@PathVariable int max, @PathVariable int min){
        Random random = new Random();

        int rand = min + random.nextInt(max -min);
        return "Uzytkownik podal wartosc" +min+ " i "+ max + " . Wylosowano liczbe " + rand;
    }
}
