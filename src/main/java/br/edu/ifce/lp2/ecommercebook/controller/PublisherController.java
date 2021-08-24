package br.edu.ifce.lp2.ecommercebook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifce.lp2.model.entities.Publisher;

@RestController
@RequestMapping
public class PublisherController {
    @GetMapping
    public Publisher get(){
        var publisher = new Publisher();
        publisher.setId(1);
        publisher.setName("Elseiver");
        publisher.setPhone("(88)999999");
        return publisher;
    }

}
