package com.intiformation.app.model;

import java.util.ArrayList;

public interface TripDao {
    long createTrip(Trip trip);
    Trip findTripById(Long id);
    boolean  updateTrip(Trip trip);
    boolean removeTrip(Trip trip);
    ArrayList<Trip> findAllTrip();
}
