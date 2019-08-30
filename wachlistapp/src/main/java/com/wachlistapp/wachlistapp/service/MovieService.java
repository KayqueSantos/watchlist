package com.wachlistapp.wachlistapp.service;

import com.wachlistapp.wachlistapp.DAO.MovieDAO;
import com.wachlistapp.wachlistapp.model.Movie;
import com.wachlistapp.wachlistapp.imbdapi.ImdbApi;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kayques
 */
@Transactional
@Service
public class MovieService  {

    @Autowired
    MovieDAO movieDAO;
    
    @Autowired
    ImdbApi imdbApi;
    
    public List<Movie> getAll() {
        return movieDAO.get();
    }

    public Movie getOne(String id) {
        return movieDAO.get(id);
    }
    
    public ArrayList<Movie> getFavorites(){
        ArrayList<Movie> favorites = new ArrayList<>();
        getAll().stream().filter((movie) -> (movie.isFavorite())).forEachOrdered((movie) -> {
            favorites.add(movie);
        });
        return favorites;
    }

    public void save(Movie movie) {
        movieDAO.save(movie);
    }

    public void delete(Movie movie) {
        movieDAO.delete(movie);
    }    
    
    public List<Movie> search(String movieTitle) {
        if (movieTitle.equals("")) {
        ArrayList<Movie> movieList = new ArrayList();
        return movieList;
    }
        ArrayList<Movie> movieList = imdbApi.search(movieTitle);
        movieList.stream().filter((movie) -> (getOne(movie.getId())==null)).forEachOrdered((movie) -> {
            save(movie);
        });
        return movieList;
    }


    public void update(Movie movie){
        movieDAO.update(movie);
    }

    public Movie favoriteToggle(String id) {
        Movie movieObj = getOne(id);
        System.out.println(movieObj);
        movieObj.setFavorite(!movieObj.isFavorite());
        update(movieObj);
        System.out.println(movieObj);
        return movieObj;
    }
    
}
 
