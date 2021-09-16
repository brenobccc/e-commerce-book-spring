package br.edu.ifce.lp2.ecommercebook.controller;


import br.edu.ifce.lp2.ecommercebook.controller.request.PublisherRequest;
import br.edu.ifce.lp2.ecommercebook.controller.response.PublisherResponse;
import br.edu.ifce.lp2.ecommercebook.model.entities.Publisher;
import br.edu.ifce.lp2.ecommercebook.model.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("publishers")
public class PublisherController {

    //private static PublisherRepository repository = new PublisherRepository();
    @Autowired
    private PublisherService service;

    @PostMapping
    public PublisherResponse post(@RequestBody PublisherRequest request){
        var publisher = request.toPublisher();

        return new PublisherResponse().fromPublisher(service.create(publisher));
       // System.out.println("POST");
    }
    @PutMapping("{id}")
    public PublisherResponse put(@PathVariable String id, @RequestBody PublisherRequest request){
        var publisher = request.toPublisher();

        return new PublisherResponse().fromPublisher(service.update(id,publisher));
    }

    @GetMapping
    public Page<PublisherResponse> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int linesPerPage,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy
            ){
        var pageable =  PageRequest.of(page,linesPerPage, Sort.Direction.fromString(direction), orderBy);
        return service.getAll(pageable).map(p-> new PublisherResponse().fromPublisher(p));
    }

    @GetMapping("{id}")
    public Publisher getById(@PathVariable String id){
        return service.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        service.delete(id);

    }

}
