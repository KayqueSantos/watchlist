/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wachlistapp.wachlistapp.imbdapi;
import com.wachlistapp.wachlistapp.model.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author kayques
 */
@Component
public class ImdbApiImpl implements ImdbApi{

    @Override
    public TmdbApi connect() {
        TmdbApi apiConnection = new TmdbApi("dd4c6206eceb30ab9704649faf2039f5");
        return apiConnection;
    }

    @Override
    public ArrayList<Movie> search(String query) {
        TmdbApi connection = this.connect();
        TmdbSearch search = connection.getSearch();
        List<MovieDb> results = search.searchMovie(query, null, "pt-BR", false, null).getResults();
        ArrayList<Movie> movieList = save_search(results);
        return movieList;
    }
    
    public ArrayList<Movie> save_search(List<MovieDb> movieSearchList) {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieSearchList.forEach((movie) -> {
            try {
                String movieId = Integer.toString(movie.getId());
                String movieTitle = movie.getTitle();
                String movieYear = movie.getReleaseDate();
                if(movieYear.length()>=4){
                    movieYear = movieYear.substring(0,4);
                }
                String posterUrl = movie.getPosterPath();
                String imdbRate = Float.toString(movie.getVoteAverage());
                String description = movie.getOverview();
                
                Movie nMovie = new Movie(movieId, movieTitle, movieYear, posterUrl, imdbRate, description);
                movieList.add(nMovie);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return movieList;       
    }    
}
