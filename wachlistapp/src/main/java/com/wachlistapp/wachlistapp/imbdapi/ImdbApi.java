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
public class ImdbApi {

    
    public TmdbApi connect() {
        TmdbApi apiConnection = new TmdbApi("dd4c6206eceb30ab9704649faf2039f5");
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
