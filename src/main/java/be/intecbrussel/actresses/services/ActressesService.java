package be.intecbrussel.actresses.services;

import be.intecbrussel.actresses.exceptions.NoActresFoundException;
import be.intecbrussel.actresses.model.Actresses;
import be.intecbrussel.actresses.model.Director;
import be.intecbrussel.actresses.model.Movies;

import java.util.List;

public interface ActressesService {

    List<Actresses> getAllActresses();

    Actresses getActres(Integer id) throws NoActresFoundException;

    void addActres(Actresses actres);

    public void updateActres(int id, String name, String surname, int age) throws NoActresFoundException;

    Movies getRandomMovie();

    Director getRandomDirector();


}
