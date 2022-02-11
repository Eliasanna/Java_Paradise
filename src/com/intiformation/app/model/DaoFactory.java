package com.intiformation.app.model;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 11/02/2022
 * Time: 16:15
 */
public class DaoFactory {

    private JdbcTripDao jdbcTripDao;
    private JdbcPlaceDao jdbcPlaceDao;

    private DaoFactory() {
    }

    public static JdbcTripDao GetTripDao() {
         return new JdbcTripDao();
    }

    public static JdbcPlaceDao GetPlaceDao() {
        return new JdbcPlaceDao();
    }

}
