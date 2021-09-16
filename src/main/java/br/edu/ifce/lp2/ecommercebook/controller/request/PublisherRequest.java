package br.edu.ifce.lp2.ecommercebook.controller.request;

import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import lombok.Setter;

@Setter
public class PublisherRequest {
    private String name;
    private String phone;

    public Publisher toPublisher(){
        var publisher = new Publisher();
        publisher.setName(name);
        publisher.setPhone(phone);
        return publisher;
    }
}
