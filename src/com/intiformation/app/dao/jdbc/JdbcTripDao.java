package com.intiformation.app.dao.jdbc;

import com.intiformation.app.dao.TripDao;
import com.intiformation.app.model.Trip;

import java.util.ArrayList;

public class JdbcTripDao extends JdbcDao implements TripDao {
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
