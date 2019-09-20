package com.wachlistapp.wachlistapp.rest;

import com.wachlistapp.wachlistapp.model.Movie;
import com.wachlistapp.wachlistapp.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author kayques
 */
@RestController
@RequestMapping("/api")
public class MovieRest {
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/movies/all")
    public List<Movie> getAll(){
        try {
            return movieService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Movie>();
        }
    }
    
    @GetMapping("/movies/{movieId}")
    public Movie getById(@PathVariable("movieId") String id){
        try {
            return movieService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @PostMapping("/search")
    public List<Movie> search(@RequestParam("movieTitleSearch") String movieTitle){
        try{
            return movieService.search(movieTitle);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Movie>();
        }
    }
    
    @GetMapping("/movies/favorites")
    public List<Movie> watchlist(){
        try{
            return movieService.getFavorites();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Movie>();
        }
    }
    
    
    @RequestMapping("/{movieId}/favorite/toggle")
    public Movie setFavorite(@PathVariable("movieId") String id){
        try {
            return movieService.favoriteToggle(id);        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
