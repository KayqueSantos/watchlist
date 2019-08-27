/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wachlistapp.wachlistapp.DAO;

import com.wachlistapp.wachlistapp.model.Movie;
import java.util.List;

/**
 *
 * @author kayques
 */
public interface MovieDAO {
        
    List<Movie> get();
    
    Movie get(String id);
    
    void save(Movie movie);
    
    void delete(Movie movie);
    
    void update(Movie movie);
}
