package be.intecbrussel.actresses.services;

import be.intecbrussel.actresses.exceptions.NoActresFoundException;
import be.intecbrussel.actresses.model.Actresses;
import be.intecbrussel.actresses.model.Director;
import be.intecbrussel.actresses.model.Movies;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ActressesServiceImpl implements ActressesService {

    private List<Actresses> actressesList = new ArrayList<>();
    Random randy = new Random();

    public ActressesServiceImpl() {
        Actresses keira = new Actresses(1, "Keira", "Knightley", 34);
        Actresses emma = new Actresses(2, "Emma", "Stone", 31);
        Actresses natalie = new Actresses(3, "Natalie", "Portman", 38);
        Actresses jeniffer = new Actresses(4, "Jenifer", "Aniston", 51);
        Actresses megan = new Actresses(5, "Megan", "Fox", 33);
        Actresses marie = new Actresses(6, "Marie", "Vinck", 36);
        Actresses sarah = new Actresses(7, "Sarah", "Roemer", 35);
        Actresses emmaw = new Actresses(8, "Emma", "Watson", 29);
        Actresses margot = new Actresses (9, "Margot", "Robbie", 29);
        Actresses elodie = new Actresses (10, "Elodie", "Yung", 38);

        actressesList.add(keira);
        actressesList.add(emma);
        actressesList.add(natalie);
        actressesList.add(jeniffer);
        actressesList.add(megan);
        actressesList.add(marie);
        actressesList.add(sarah);
        actressesList.add(emmaw);
        actressesList.add(margot);
        actressesList.add(elodie);
    }

    @Override
    public List<Actresses> getAllActresses() {
        return actressesList;
    }

    @Override
    public Actresses getActres(Integer id) throws NoActresFoundException {
        for(int i = 0; i < actressesList.size(); i++){
            if(id == i){
                return actressesList.get(id);
            }
        }
        throw new NoActresFoundException();
    }

    @Override
    public void addActres(Actresses actres) {
        actressesList.add(actres);
    }

    public void updateActres(int id, String name, String surname, int age) throws NoActresFoundException{
        if (id == 0){
            throw new NoActresFoundException();
        } else {
            actressesList.get(id - 1).setAge(age);
            actressesList.get(id - 1).setName(name);
            actressesList.get(id - 1).setSurname(surname);
        }
    }

    @Override
    public Movies getRandomMovie(){
        int id = randy.nextInt(10) + 1;
        RestTemplate restTemplate = new RestTemplate();
        Movies movie = restTemplate.getForObject("http://192.168.30.77:8080/movie/" + id, Movies.class);
        return movie;
    }

    @Override
    public Director getRandomDirector() {
        int id = randy.nextInt(6) + 1;
        RestTemplate restTemplate = new RestTemplate();
        Director director = restTemplate.getForObject("http://192.168.30.106:8080/directors/director/" + id, Director.class);
        return director;
    }
}
