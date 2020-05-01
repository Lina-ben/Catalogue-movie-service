package com.example.catalogue;

import java.util.HashSet;
import java.util.Set;




public class Movie {
	

    private Integer id;
 	String title;
    String Desc ;
    int rating ;
    String director ;
    private Set<Genre> genres = new HashSet<>();
    
    
    public Movie() {
  		super();
  	}
    
    public Movie(String title,String Desc, int rating,String director ) {
    	
    	this.title = title ;
    	this.Desc = Desc ;
    	this.title = title ;
    	this.rating = rating ;
    	this.director = director ;
    }

    
    public Integer getMovie_id() {
        return id;
    }

    public void setMovie_id(int movie_id) {
        this.id = movie_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public Set<Genre> getGenres() {
        return genres;
    }
 
   
   /* public Set<Actor> getActors() {
        return actors;
    }*/
    

    @Override
    public String toString() {
        return "movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Desc='" + Desc + '\'' +
                ", rating=" + rating +
                '}';
    }
}

