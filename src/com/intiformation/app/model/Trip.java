package com.intiformation.app.model;

import com.intiformation.app.dao.TripDao;

import java.io.Serializable;
import java.util.ArrayList;

public class Trip implements Serializable {

    private long id;
    private long departure;
    private long arrival;
    private float price;

    public Trip() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getDeparture() {
        return departure;
    }

    public void setDeparture(long departure) {
        this.departure = departure;
    }

    public Long getArrival() {
        return arrival;
    }

    public void setArrival(long arrival) {
        this.arrival = arrival;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
