package br.edu.ifce.lp2.ecommercebook.controller.response;

import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import lombok.Getter;

@Getter
public class PublisherResponse {
    private  String id;
    //private String name;
    public PublisherResponse fromPublisher(Publisher publisher) {
        this.id = publisher.getId();
        //this.name = publisher.getName();
        return this;
    }

}
