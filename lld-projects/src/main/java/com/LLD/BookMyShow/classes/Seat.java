package com.LLD.BookMyShow.classes;

import com.LLD.BookMyShow.enums.SeatCategory;

public class Seat {
    Integer id;
    String row;
    SeatCategory seatCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
