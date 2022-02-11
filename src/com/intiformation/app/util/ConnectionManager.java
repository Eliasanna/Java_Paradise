package com.intiformation.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/java_paradise";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnection() {
        if(connection==null ){
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
