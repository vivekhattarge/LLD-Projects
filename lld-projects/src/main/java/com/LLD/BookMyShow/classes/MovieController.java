package com.LLD.BookMyShow.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.LLD.BookMyShow.enums.City;

public class MovieController {
    public Map<City,List<Movie>> cityVsMovies;
    public List<Movie> movies;

    public MovieController(){
        cityVsMovies = new HashMap<>();
        movies = new ArrayList<>();
    }

    public Map<City, List<Movie>> getCityVsMovies() {
        return cityVsMovies;
    }

    public void setCityVsMovies(Map<City, List<Movie>> cityVsMovies) {
        this.cityVsMovies = cityVsMovies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie, City city){
        movies.add(movie);

        List<Movie> movies = cityVsMovies.getOrDefault(city,new ArrayList<>());
        movies.add(movie);


        cityVsMovies.put(city,movies);
    }



    public List<Movie> getMoviesByCity(City city){
        return cityVsMovies.get(city);
    }

    public Movie getMovieByName(String name, City city){
        List<Movie> movies = cityVsMovies.get(city);
        return movies.stream().filter(movie -> name.equalsIgnoreCase(movie.getName())).findFirst().get();
    }

}
