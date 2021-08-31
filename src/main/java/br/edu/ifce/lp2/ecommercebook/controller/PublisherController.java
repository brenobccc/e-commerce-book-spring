package br.edu.ifce.lp2.ecommercebook.controller;


import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
