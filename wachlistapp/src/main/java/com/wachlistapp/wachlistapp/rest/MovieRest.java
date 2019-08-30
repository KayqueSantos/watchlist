package com.wachlistapp.wachlistapp.rest;

import com.wachlistapp.wachlistapp.model.Movie;
import com.wachlistapp.wachlistapp.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();
    
    @GetMapping("/movies/all")
    public List<Movie> get(){
        return movieService.getAll();
    }
    
    @PostMapping("/search")
    public List<Movie> search(@RequestParam("movieTitleSearch") String movieTitle){
        return movieService.search(movieTitle);
    }
    
    @GetMapping("/movies/favorites")
    public List<Movie> watchlist(){
        return movieService.getFavorites();
    }
    
    @RequestMapping("/{movieId}/favorite/toggle")
    public Movie setFavorite(@PathVariable("movieId") String id){
        return movieService.favoriteToggle(id);
    }

}
