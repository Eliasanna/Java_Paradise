package com.intiformation.app.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;
    private static String url ;
    private static String user;
    private static String password;

    public static Connection getConnection() {
        if(connection==null ){
            try (InputStream input = new FileInputStream(".environnement")) {

                Properties prop = new Properties();
                // load a properties file
                prop.load(input);
                // get the property value and print it out
                url = prop.getProperty("db.url");
                user = prop.getProperty("db.user");
                password = prop.getProperty("db.password");

//                System.out.println(prop.getProperty("db.url"));
//                System.out.println(prop.getProperty("db.user"));
//                System.out.println(prop.getProperty("db.password"));

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                 connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void  close() throws SQLException {
        connection.close();
    }
}
