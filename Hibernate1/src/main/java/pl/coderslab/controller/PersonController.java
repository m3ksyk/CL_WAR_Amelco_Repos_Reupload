package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.Query;
import java.util.List;


@Controller
public class PersonController {

    @Autowired
    PersonDetailsDao personDetailsDao;

    @Autowired
    PersonDao personDao;

    @GetMapping("/person")
    public String add(Model model){
        model.addAttribute("person", new Person());

        return "PersonForm";
    }

    @PostMapping("/person")
    public String add(@ModelAttribute Person person){
        personDao.savePerson(person);

        return "PersonForm";
    }


    @RequestMapping("/person/readall")
    @ResponseBody
    public String readAll(){
        return personDao.readAll().toString();
    }

    @RequestMapping("/person/add")
    @ResponseBody
    public String create(){
        Person person  = new Person();
        person.setLogin("login1");
        person.setPassword("password");
        person.setEmail("email");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("John");
        personDetails.setLastName("Doe");
        personDetails.setCity("London");
        personDetails.setStreet("Fleet str");
        personDetails.setStreetNumber(13);
        personDetailsDao.savePersonDetails(personDetails);

        person.setDetails(personDetails);

        personDao.savePerson(person);
        return "Person added on id:"
                +  person.getId();
    }

    @RequestMapping("/person/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return (personDao.findById(id)).toString();
    }

    @RequestMapping("/person/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Person person = personDao.findById(id);
        PersonDetails personDetails = personDetailsDao.findById(id);
        person.setLogin("login1");
        person.setPassword("password");
        person.setEmail("email");
        person.setDetails(personDetails);
        personDao.update(person);
        return "updated";
    }

    @RequestMapping("/person/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        personDao.delete(id);
        return "Person with id: " + id + " deleted";
    }

}
