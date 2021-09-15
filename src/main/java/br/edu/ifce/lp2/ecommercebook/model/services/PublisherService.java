package br.edu.ifce.lp2.ecommercebook.model.services;


import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import br.edu.ifce.lp2.ecommercebook.model.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository repository;

    /*private boolean isExists(Publisher publisher) {
        if(repository.findAll() == null){
            return false;
        }
        return repository.findAll()
                    .stream()
                    .anyMatch(p -> p.getName().toLowerCase().trim().equals(publisher.getName().toLowerCase().trim()));


    }*/


    public void create(Publisher publisher){

        //var allPublishers = repository.getAll();
        if(!repository.existsByName(publisher.getName())){
            repository.save(publisher);
        }

    }



    public void update(String id, Publisher publisher){
        var canUpdate = this.getById(id) != null;
        System.out.println("valorrr:"+canUpdate);
        if(canUpdate){
            System.out.println("valor2"+!repository.existsByName(publisher.getName()));
            if(!repository.existsByName(publisher.getName())){
                repository.save(publisher);
            }
        }
    }

    public Collection<Publisher> getAll() {
        return repository.findAll();
    }

    public Publisher getById(String id) {
        return repository.findById(id).orElse(new Publisher());
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
