package com.LLD.BookMyShow.classes;

import com.LLD.BookMyShow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheatreController {
    Map<City,List<Theatre>> cityVsTheatres;

    public TheatreController(){
        cityVsTheatres = new HashMap<>();
    }

    public void addTheatre(Theatre theatre, City city){
        List<Theatre> theatres = cityVsTheatres.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatres.put(city,theatres);
    }

    public List<Theatre> getTheatresByCity(City city){
        return cityVsTheatres.get(city);
    }

    public Map<Theatre, List<Show>> getAllShows(Movie interestedMovie, City city) {
        List<Theatre> theatres = getTheatresByCity(city);
        Map<Theatre,List<Show>> theatreVsShows = new HashMap<>();
        for(Theatre theatre : theatres){
            theatreVsShows.put(theatre,theatre.getShows().stream().filter(show -> show.getMovie().getName().equalsIgnoreCase(interestedMovie.getName())).collect(Collectors.toList()));
        }
        return theatreVsShows;
    }
}
