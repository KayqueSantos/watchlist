/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wachlistapp.wachlistapp.imbdapi;
import com.wachlistapp.wachlistapp.model.Movie;
import info.movito.themoviedbapi.TmdbApi;
import java.util.ArrayList;

/**
 *
 * @author kayques
 */
public interface ImdbApi {
    
    TmdbApi connect();
    
    ArrayList<Movie> search(String query);
        
}
