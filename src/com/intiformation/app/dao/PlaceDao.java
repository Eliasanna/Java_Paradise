package com.intiformation.app.dao;

import com.intiformation.app.model.Place;

import java.util.ArrayList;

public interface PlaceDao {
    long createPlace(Place place);
    Place findPlaceById(Long id);
    boolean  updatePlace(Place place);
    boolean removePlace(Place place);
    ArrayList<Place> findAllPlace();

}