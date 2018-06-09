package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

import javax.validation.Valid;

@Controller
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    PublisherRepository publisherRepository;

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String create(){

        Publisher publisher  = new Publisher();
        publisher.setName("Penguin");
        publisherDao.savePublisher(publisher);
        return "Publisher added on id:"
                +  publisher.getId();
    }

    @GetMapping("/publisher/form")
    public String publisherForm(Model model){
        model.addAttribute("publisher", new Publisher());
        return "PublisherForm";
    }
    @PostMapping("/publisher/form")
    public String saveForm(@Valid@ModelAttribute Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "PublisherForm";
        }
        publisherDao.savePublisher(publisher);
        return "redirect:/publisher/readall";
    }

    @GetMapping("/publisher/updateform/{id}")
    public String publisherUpdateForm(@PathVariable long id, Model model){

        model.addAttribute("publisher", publisherDao.findById(id));
        return "PublisherUpdateForm";
    }
    @PostMapping("/publisher/updateform/{id}")
    public String saveUpdateForm(@Valid@ModelAttribute Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "PublisherForm";
        }
        publisherDao.update(publisher);
        return "redirect:/publisher/readall";
    }
    @GetMapping("/publisher/deletepublisher/{id}")
    public String deletePublisher(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        return "PublisherDecision";
    }
    @RequestMapping("/publisher/readall")
    public String readAll(Model model){
        model.addAttribute("publishers", publisherDao.readAll());
        return "PublisherList";
    }
    
//    @RequestMapping("/publisher/readall")
//    @ResponseBody
//    public String readAll(){
//        return publisherDao.readAll().toString();
//    }

    @RequestMapping("/publisher/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return (publisherDao.findById(id)).toString();
    }

    @RequestMapping("/publisher/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        publisher.setName("Black Library");
        publisherDao.update(publisher);
        return "updated";
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        publisherDao.delete(id);
        return "Publisher with id: " + id + " deleted";
    }


    @RequestMapping("/publisher/readregon/{regon}")
    @ResponseBody
    public String readByRegon(@PathVariable String regon){
        return publisherRepository.findByRegon(regon).toString();
    }

    @RequestMapping("/publisher/readnip/{nip}")
    @ResponseBody
    public String readByNip(@PathVariable String nip){
        return publisherRepository.findByNip(nip).toString();
    }
}
