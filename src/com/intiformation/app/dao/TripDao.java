package com.intiformation.app.dao;

import com.intiformation.app.model.Trip;

import java.util.ArrayList;

public interface TripDao {
    long createTrip(Trip trip);
    Trip findTripById(Long id);
    boolean  updateTrip(Trip trip);
    boolean removeTrip(Trip trip);
    ArrayList<Trip> findAllTrip();
}
