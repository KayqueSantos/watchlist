package com.wachlistapp.wachlistapp.imbdapi;
import com.wachlistapp.wachlistapp.model.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author kayques
 */
@Component
public class ImdbApi {
    
    @Value("${app.imdbApiKey}")
    private String imdbApiKey;

    
    public TmdbApi connect() {
        TmdbApi apiConnection = new TmdbApi(imdbApiKey);
        return apiConnection;
    }

    
    public ArrayList<Movie> search(String movieTitle) {
        TmdbApi connection = this.connect();
        TmdbSearch search = connection.getSearch();
        List<MovieDb> results = search.searchMovie(movieTitle, null, "pt-BR", false, null).getResults();
        ArrayList<Movie> movieList = saveSearch(results);
        return movieList;
    }
    
    public ArrayList<Movie> saveSearch(List<MovieDb> movieSearchList) {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieSearchList.forEach((movie) -> {
        try {
            Movie nMovie = new Movie();
            nMovie = nMovie.movieDbtoMovie(movie);
            movieList.add(nMovie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        });
        return movieList;       
    }    
}
