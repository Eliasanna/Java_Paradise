package com.intiformation.app.dao;

import com.intiformation.app.model.Trip;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TripDao {
    long createTrip(Trip trip) throws SQLException;
    Trip findTripById(Long id) throws SQLException;
    boolean  updateTrip(Trip trip) throws SQLException;
    boolean removeTrip(Trip trip) throws SQLException;
    ArrayList<Trip> findAllTrip();
}
