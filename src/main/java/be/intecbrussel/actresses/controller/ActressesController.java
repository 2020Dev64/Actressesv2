package be.intecbrussel.actresses.controller;

import be.intecbrussel.actresses.exceptions.NoActresFoundException;
import be.intecbrussel.actresses.model.Actresses;
import be.intecbrussel.actresses.model.Movies;
import be.intecbrussel.actresses.services.ActressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/actresses")
public class ActressesController {

    private ActressesService actressesService;

    @Autowired
    public ActressesController(ActressesService actressesService) {
        this.actressesService = actressesService;
    }

    // Whats the difference between "ResponseEntity" and "ResponseEntity<List<Actresses>>" ??
    @GetMapping(value = "/allActresses")
    public ResponseEntity<List<Actresses>> getAllActresses(){
        return ResponseEntity.ok(actressesService.getAllActresses());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getActres(@PathVariable(value = "id", required = false) int actressesId){
        try {
            List someList = new ArrayList();
            someList.add(actressesService.getActres(actressesId));
            someList.add(actressesService.getRandomMovie());
            someList.add(actressesService.getRandomDirector());
            return ResponseEntity.ok(someList.toString());
        } catch (NoActresFoundException e) {
             //Waarom mag ik de printstacktrace niet doen ?
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping (value = "/addActres")
    public ResponseEntity addActres(@RequestBody Actresses actres){
        actressesService.addActres(actres);
        return ResponseEntity.ok().build();
    }

    // Can I use requestparam and requestbody, can I use them both ?
    @PutMapping (value = "/updateActres")
    public ResponseEntity updateActres(@RequestParam(value = "actresId", required = false, defaultValue = "1") Integer id,
                                       @RequestParam(value = "actresName", required = false, defaultValue = "noName") String name,
                                       @RequestParam(value = "actresSurname", required = false, defaultValue = "noName") String surname,
                                       @RequestParam(value = "age", required = false, defaultValue = "1") Integer age){
        try {
            actressesService.updateActres(id, name, surname, age);
            return ResponseEntity.ok("Updated actres with id: " + id);
        } catch (NoActresFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
