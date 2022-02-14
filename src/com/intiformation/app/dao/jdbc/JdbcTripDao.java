package com.intiformation.app.dao.jdbc;

import com.intiformation.app.dao.TripDao;
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
        String querySql = "insert into trip (depature, arrival, price) Values (?,?,?)";
        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setString(1, String.valueOf(trip.getDeparture()));
        preparedStatement.setLong(2, trip.getArrival());
        preparedStatement.setFloat(3, trip.getPrice());

        return preparedStatement.executeUpdate();
    }

    @Override
    public Trip findTripById(Long id) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "select * from trip where id = ?";

        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery(querySql);
        long depature = resultSet.getLong("depature");
        long arrival = resultSet.getLong("arrival");
        float price = resultSet.getFloat("price");

        Trip trip = new Trip();
        trip.setId(id);
        trip.setArrival(arrival);
        trip.setDeparture(depature);
        trip.setPrice(price);

        return trip;
    }

    @Override
    public boolean updateTrip(Trip trip) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "UPDATE trip SET departure = ?, arrival = ?, price = ?,  WHERE id = ?";
        boolean bool = true;

        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setLong(1, trip.getDeparture());
        preparedStatement.setLong(2, trip.getArrival());
        preparedStatement.setFloat(3, trip.getPrice());
        preparedStatement.setLong(2, trip.getId());
        long row = preparedStatement.executeUpdate();

        if (row == 0) {
            bool = false;
        }

        return bool;
    }

    @Override
    public boolean removeTrip(Trip trip) throws SQLException {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "delete  from trip WHERE id = ?";
        boolean bool = true;

        PreparedStatement preparedStatement = myConnection.prepareStatement(querySql);
        preparedStatement.setLong(1, trip.getId());
        long row = preparedStatement.executeUpdate();
        if (row == 0) {
            bool = false;
        }
        return bool;
    }

    @Override
    public ArrayList<Trip> findAllTrip() {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "select * from trip";
        ArrayList<Trip> trips = new ArrayList<>();
        try (PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {

            ResultSet resultSet = preparedStatement.executeQuery(querySql);

            while (resultSet.next()) {
                Trip trip = new Trip();
                trip.setId(resultSet.getLong("id"));
                trip.setArrival(resultSet.getLong("depature"));
                trip.setDeparture(resultSet.getLong("arrival"));
                trip.setPrice(resultSet.getFloat("price"));
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }
}
