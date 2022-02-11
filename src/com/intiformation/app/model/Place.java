package com.intiformation.app.model;

import com.intiformation.app.dao.PlaceDao;

import java.io.Serializable;
import java.util.ArrayList;

public class Place implements Serializable, PlaceDao {

    private long id;
    private String name;

    public Place() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
