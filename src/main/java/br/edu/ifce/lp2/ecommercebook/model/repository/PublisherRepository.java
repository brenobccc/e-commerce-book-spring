package br.edu.ifce.lp2.ecommercebook.model.repository;

import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher, String>{

}
