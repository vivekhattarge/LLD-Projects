package com.LLD.BookMyShow.classes;

import java.util.ArrayList;
import java.util.List;

public class Show {
    Integer id;
    Movie movie;
    Screen screen;
    Integer showStartTime;
    List<Integer> bookedSeats = new ArrayList<>();

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Integer getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(Integer showStartTime) {
        this.showStartTime = showStartTime;
    }
}
