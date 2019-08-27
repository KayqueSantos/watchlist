/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wachlistapp.wachlistapp.service;

import com.wachlistapp.wachlistapp.model.Movie;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kayques
 */
public interface MovieService {
        
    List<Movie> get();
    
    Movie get(String id);
    
    void save(Movie movie);
    
    void delete(Movie movie);
    
    List<Movie> search(String query);
    
    Movie favoriteToggle(String id);
    
    void cleanDB();
    
    void update(Movie movie);
        
    ArrayList<Movie> getWatchlist();
}
