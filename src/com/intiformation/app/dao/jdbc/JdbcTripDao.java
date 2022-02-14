package com.intiformation.app.dao.jdbc;

import com.intiformation.app.dao.TripDao;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;
import com.intiformation.app.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcTripDao extends JdbcDao implements TripDao {
    @Override
    public long createTrip(Trip trip) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "insert into trip (depature, arrival, price) Values(?,?,?)";
        long row=0;
        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setString(1, String.valueOf(trip.getDeparture()));
        preparedStatement.setString(2, String.valueOf(trip.getArrival()));
        preparedStatement.setString(3, String.valueOf(trip.getPrice()));
        row = preparedStatement.executeUpdate();

        return row;
    }

    @Override
    public Trip findTripById(Long id) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "select * from trip where id =(?)";
        long row=0;
        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery(querySql);
            Long depature = resultSet.getLong("depature");
            Long arrival = resultSet.getLong("arrival");
            float price = resultSet.getFloat("price");

            Trip trip = new Trip();
            trip.setId(id);
            trip.setArrival(arrival);
            trip.setDeparture(depature);
            trip.setPrice(price);

        return null;
    }



    @Override
    public boolean updateTrip(Trip trip) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "UPDATE trip SET depature = (?), arrival = (?), price = (?),  WHERE id = (?)";
           Boolean bool=true;

        long row=0;

        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setString(1, String.valueOf(trip.getDeparture()));
        preparedStatement.setString(2, String.valueOf(trip.getArrival()));
        preparedStatement.setString(3, String.valueOf(trip.getPrice()));
        preparedStatement.setString(2, String.valueOf(trip.getId()));
        row = preparedStatement.executeUpdate();
        if(row ==0)
        { bool=false;}

        return bool;
    }

    @Override
    public boolean removeTrip(Trip trip) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "delete  from trip WHERE id = (?)";
        Boolean bool=true;

        long row=0;
        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setString(1, String.valueOf(trip.getId()));
        row = preparedStatement.executeUpdate();
        if(row ==0)
        { bool=false;}
        return bool;
    }

    @Override
    public ArrayList<Trip> findAllTrip() {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "select * from trip";
        long row=0;
        ArrayList<Trip> trips = new ArrayList<>();
        try (PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {

            ResultSet resultSet = preparedStatement.executeQuery(querySql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long depature = resultSet.getLong("depature");
                Long arrival = resultSet.getLong("arrival");
                float price = resultSet.getFloat("price");


                Trip trip = new Trip();
                trip.setId(id);
                trip.setArrival(arrival);
                trip.setDeparture(depature);
                trip.setPrice(price);
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }
}
