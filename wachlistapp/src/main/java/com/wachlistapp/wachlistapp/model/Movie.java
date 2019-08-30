package com.wachlistapp.wachlistapp.model;

import info.movito.themoviedbapi.model.MovieDb;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kayques
 */
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="year")
    private String year;
    
    @Column(name="posterUrl")
    private String posterUrl;
    
    @Column(name="imdbRate")
    private String imdbRate;
        
    @Column(name="favorite")
    private boolean favorite;
    
    @Column(name="description")
    private String description;

    
    public Movie(String id, String title, String year, String posterUrl, String imdbRate, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.posterUrl = posterUrl;
        this.imdbRate = imdbRate;
        this.description = description;
        this.favorite = false;
    }

    public Movie() {
        
    }
    
    public Movie movieDbtoMovie(MovieDb apiMovie) {
        this.id = Integer.toString(apiMovie.getId());
        this.title = apiMovie.getTitle();
        this.year = apiMovie.getReleaseDate();
        if(this.year!=null|!this.year.equals("")){
            this.year = this.year.substring(0,4);
        } else {
            this.year = "Unknow Release Year";
        }
        this.posterUrl = apiMovie.getPosterPath();
        if (this.posterUrl!=null){
            this.posterUrl = "http://image.tmdb.org/t/p/w185//"+this.posterUrl;
        } else {
            this.posterUrl = "";
        }
        this.imdbRate = Float.toString(apiMovie.getVoteAverage());
        this.description = apiMovie.getOverview();

        return this;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", year=" + year + ", posterUrl=" + posterUrl + ", imdbRate=" + imdbRate + ", favorite=" + favorite + ", description=" + description + '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getimdbRate() {
        return imdbRate;
    }

    public String getposterUrl() {
        return posterUrl;
    }
    
    public boolean isFavorite() {
        return favorite;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    
    public void setposterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public void setimdbRate(String imdbRate) {
        this.imdbRate = imdbRate;
    }
    
    
}
