package com.intiformation.app.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Trip implements Serializable, TripDao {

    private long id;
    private String departure;
    private String arrival;
    private float price;

    public Trip() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public long createTrip(Trip trip) {
        return 0;
    }

    @Override
    public Trip findTripById(Long id) {
        return null;
    }

    @Override
    public boolean updateTrip(Trip trip) {
        return false;
    }

    @Override
    public boolean removeTrip(Trip trip) {
        return false;
    }

    @Override
    public ArrayList<Trip> findAllTrip() {
        return null;
    }
}
