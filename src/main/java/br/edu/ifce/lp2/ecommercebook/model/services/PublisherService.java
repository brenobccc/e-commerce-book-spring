package br.edu.ifce.lp2.ecommercebook.model.services;


import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import br.edu.ifce.lp2.ecommercebook.model.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    public Publisher create(Publisher publisher){

        //var allPublishers = repository.getAll();
        if(repository.existsByName(publisher.getName())){
            throw new RuntimeException("Nome já existe");
        }

        return repository.save(publisher);
    }



    public Publisher update(String id, Publisher publisher){
        var publisherDatabase = this.getById(id);
        //System.out.println("valorrr:"+canUpdate);

        //System.out.println("valor2"+!repository.existsByName(publisher.getName()));
        var p = repository.findByName(publisher.getName());
        if(p != null && !p.getId().equals(id)){
            throw new RuntimeException("Nome já existe");
        }
        publisherDatabase.setName(publisher.getName());
        publisherDatabase.setPhone(publisher.getPhone());

        return repository.save(publisherDatabase);
    }

    public Page<Publisher> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Publisher getById(String id) {

        return repository.findById(id).orElseThrow(()-> new RuntimeException("Publisher não existe"));
    }

    public void delete(String id) {
        repository.delete(getById(id));
    }
}
