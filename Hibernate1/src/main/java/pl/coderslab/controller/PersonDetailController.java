package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dto.PersonDto;
import pl.coderslab.entity.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class PersonDetailController {

    @ModelAttribute("skills")
    public Collection<String> skills() {
        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("Php");
        skills.add("python");
        skills.add("ruby");
        return skills;
    }

    @ModelAttribute("countryItems")
    public Collection<String> countryItems() {
        List<String> countryList = new ArrayList<>();
        countryList.add("Poland");
        countryList.add("UK");
        countryList.add("Germany");
        countryList.add("France");
        return countryList;
    }

    @ModelAttribute("hobbies")
    public Collection<String> hobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Hiking");
        hobbies.add("Biking");
        hobbies.add("Drinking");
        hobbies.add("Sleeping");
        return hobbies;
    }

    @GetMapping("/persondetail")
    public String add(Model model){
        model.addAttribute("person", new PersonDto());
        return "PersonDetailsForm";
    }

    @PostMapping("/persondetail")
    @ResponseBody
    public String save(@ModelAttribute PersonDto person){
        return person.toString();
    }

}
