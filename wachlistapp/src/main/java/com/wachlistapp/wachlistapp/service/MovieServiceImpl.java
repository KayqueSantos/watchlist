/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDAO movieDAO;
    
    @Autowired
    ImdbApi imdbApi;
    
    @Transactional
    @Override
    public List<Movie> get() {
        return movieDAO.get();
    }

    @Transactional
    @Override
    public Movie get(String id) {
        return movieDAO.get(id);
    }
    
    @Override
    public ArrayList<Movie> getWatchlist(){
        ArrayList<Movie> watchlist = new ArrayList<>();
        get().stream().filter((movie) -> (movie.isFavorite())).forEachOrdered((movie) -> {
            watchlist.add(movie);
        });
        return watchlist;
    }


    @Transactional
    @Override
    public void save(Movie movie) {
        movieDAO.save(movie);
    }

    @Transactional
    @Override
    public void delete(Movie movie) {
        movieDAO.delete(movie);
    }    
    
    @Transactional
    @Override
    public List<Movie> search(String query) {
        ArrayList<Movie> movieList = imdbApi.search(query);
        movieList.stream().filter((movie) -> (get(movie.getId())==null)).forEachOrdered((movie) -> {
            save(movie);
        });
        return movieList;
    }

    @Transactional
    @Override
    public void cleanDB() {
        List<Movie> current_list = get();
        current_list.stream().filter((movie) -> (!movie.isFavorite())).forEachOrdered((movie) -> {
            movieDAO.delete(movie);
        });
    }
 
    @Transactional
    @Override
    public void update(Movie movie){
        movieDAO.update(movie);
    }

    @Transactional
    @Override
    public Movie favoriteToggle(String id) {
        Movie movieObj = get(id);
        if (!movieObj.isFavorite()){
            movieObj.setFavorite(true);
            update(movieObj);
        } else {
            movieObj.setFavorite(false);
            update(movieObj);
        }
        movieObj = get(id);
        return movieObj;
    }
}
