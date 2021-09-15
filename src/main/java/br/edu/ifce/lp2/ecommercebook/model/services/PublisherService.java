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

    private boolean isExists(Publisher publisher) {
        var allPublishers = repository.findAll();
        if(allPublishers == null){
            return false;
        }
        return allPublishers
                    .stream()
                    .anyMatch(p -> publisher.getName().toLowerCase().trim().equals(publisher.getName().toLowerCase().trim()));


    }
    public void create(Publisher publisher){

        //var allPublishers = repository.getAll();
        if(!isExists(publisher)){
            repository.save(publisher);
        }

    }



    public void update(String id, Publisher publisher){
        var canUpdate = this.getById(id) != null;

        if(canUpdate){
            if(!isExists(publisher)){
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
