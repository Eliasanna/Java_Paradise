package com.intiformation.app.dao.jdbc;

import com.intiformation.app.dao.PlaceDao;
import com.intiformation.app.model.Place;
import com.intiformation.app.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao {
    @Override
    public long createPlace(Place place) {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "insert into place (name) Values(?)";
        long row = 0;
        try (
                PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {
            preparedStatement.setString(1, place.getName());
            // ResultSet resultSet = preparedStatement.executeQuery();
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Place findPlaceById(Long id) {

        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "select * from place where id = ?";
        try (PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(querySql);
            long idplace = resultSet.getLong("id");
            String name = resultSet.getString("name");

            Place place = new Place();
            place.setId(idplace);
            place.setName(name);
            return place;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Place();
    }

    @Override
    public boolean updatePlace(Place place) {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "UPDATE place SET name = ? WHERE id = ?";
        boolean bool = true;

        try (
                PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {
            preparedStatement.setString(1, place.getName());
            preparedStatement.setLong(2,  place.getId());
            // ResultSet resultSet = preparedStatement.executeQuery();
            long row = preparedStatement.executeUpdate();
            if (row == 0) {
                bool = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public boolean removePlace(Place place) {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "delete from place WHERE id = ?";
        boolean bool = true;

        try (PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {

            preparedStatement.setLong(1, place.getId());
            System.out.println(preparedStatement);
            // ResultSet resultSet = preparedStatement.executeQuery();
            long row = preparedStatement.executeUpdate();
            if (row == 0) {
                bool = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public ArrayList<Place> findAllPlace() {
        Connection myConnection = ConnectionManager.getConnection();
        String querySql = "select * from place";
        ArrayList<Place> places = new ArrayList<>();
        try (PreparedStatement preparedStatement = myConnection.prepareStatement(querySql)) {

            ResultSet resultSet = preparedStatement.executeQuery(querySql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");

                Place p = new Place();
                p.setName(name);
                p.setId(id);
                places.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return places;
    }
}
