/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wachlistapp.wachlistapp.controller;

import com.wachlistapp.wachlistapp.model.Movie;
import com.wachlistapp.wachlistapp.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author kayques
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();
    
    @GetMapping("/movies")
    public List<Movie> get(){
        return movieService.get();
    }
    
    @PostMapping("/search")
    public List<Movie> search(@RequestParam("query") String query){
        return movieService.search(query);
    }
    
    @GetMapping("/watchlist")
    public List<Movie> watchlist(){
        return movieService.getWatchlist();
    }
    
    @RequestMapping("/{movieId}/favorite/toggle")
    public Movie setFavorite(@PathVariable("movieId") String id){
        return movieService.favoriteToggle(id);
    }

}
