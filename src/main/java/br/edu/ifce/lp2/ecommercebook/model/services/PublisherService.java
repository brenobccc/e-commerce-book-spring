package br.edu.ifce.lp2.ecommercebook.model.services;


import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import br.edu.ifce.lp2.ecommercebook.model.repository.PublisherRepository;

import java.util.Collection;
import java.util.Locale;

public class PublisherService {
    private static PublisherRepository repository = new PublisherRepository();

    public void create(Publisher publisher){

        //var allPublishers = repository.getAll();
        if(!isExists(publisher)){
            repository.create(publisher);
        }

    }

    private boolean isExists(Publisher publisher) {
        return repository
                .getAll()
                .stream()
                .anyMatch(p -> publisher.getName().toLowerCase().trim().equals(publisher.getName().toLowerCase().trim()));
    }

    public void update(Long id, Publisher publisher){
        var canUpdate = this.getById(id) != null;

        if(canUpdate){
            if(!isExists(publisher)){
                repository.update(id, publisher);
            }
        }
    }

    public Collection<Publisher> getAll() {
        return repository.getAll();
    }

    public Publisher getById(Long id) {
        return repository.getById(id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
