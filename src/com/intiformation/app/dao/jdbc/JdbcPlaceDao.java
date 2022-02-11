package com.intiformation.app.dao.jdbc;

import com.intiformation.app.dao.PlaceDao;
import com.intiformation.app.model.Place;

import java.util.ArrayList;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao {
    @Override
    public long createPlace(Place place) {
        return 0;
    }

    @Override
    public Place findPlaceById(Long id) {
        return null;
    }

    @Override
    public boolean updatePlace(Place place) {
        return false;
    }

    @Override
    public boolean removePlace(Place place) {
        return false;
    }

    @Override
    public ArrayList<Place> findAllPlace() {
        return null;
    }
}
