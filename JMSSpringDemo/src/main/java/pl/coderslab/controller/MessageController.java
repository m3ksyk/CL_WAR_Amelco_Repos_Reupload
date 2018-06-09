package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.MessageService;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/queue/{queueName}")
    ResponseEntity<?> sendPointToPointMessage(@PathVariable("queueName")
                                                      String queueName, @RequestParam("message") String msg){
        messageService.sendPointToPointMessage(queueName, msg);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/receive/{queueName}")
    public String receive(@PathVariable("queueName") String queueName){

        return messageService.receive(queueName);
    }

    @PostMapping("/publish/{topicName}")
    public void publish(@PathVariable("topicName")
                                    String topicName, @RequestParam("message") String msg){
        messageService.publishMessage(topicName, msg);
    }
}
