package com.hotel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    
    private static final String URL = "jdbc:h2:./data/hoteldb;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE";
    
  
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    
    public static Connection getConnection() throws SQLException {
        try {
           
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el Driver de H2. Revisa el pom.xml: " + e.getMessage());
        }
        
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}