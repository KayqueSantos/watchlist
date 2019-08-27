/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wachlistapp.wachlistapp.model;

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
    @Column
    private String id;
    
    @Column
    private String name;
    
    @Column
    private String year;
    
    @Column 
    private String poster_url;
    
    @Column
    private String imdb_rate;
        
    @Column  
    private boolean favorite;
    
    @Column
    private String description;

    
    public Movie(String id, String name, String year, String poster_url, String imdb_rate, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.poster_url = poster_url;
        this.imdb_rate = imdb_rate;
        this.description = description;
        this.favorite = false;
    }

    public Movie() {
        
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", year=" + year + ", poster_url=" + poster_url + ", imdb_rate=" + imdb_rate + ", favorite=" + favorite + ", description=" + description + '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getImdb_rate() {
        return imdb_rate;
    }

    public String getPoster_url() {
        return poster_url;
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
    
    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public void setImdb_rate(String imdb_rate) {
        this.imdb_rate = imdb_rate;
    }
    
    
}
